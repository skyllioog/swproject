package com.example.sw221103;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class ChatRoomActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private EditText mMessageEditText;
    private Button mSendButton;
    private DatabaseReference mChatRef;
    private FirebaseRecyclerAdapter<ChatMessage, ChatViewHolder> mAdapter;
    private String mChatId;
    private String mNickname;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        Button draw_button = (Button) findViewById(R.id.draw_button);
        draw_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), DrawActivity.class);
                startActivity(intent);
            }
        });

        mChatId = getIntent().getStringExtra("chat_id");
        mNickname = getIntent().getStringExtra("nickname");

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMessageEditText = findViewById(R.id.message_edittext);
        mSendButton = findViewById(R.id.send_button);

        mChatRef = FirebaseDatabase.getInstance().getReference("chats").child(mChatId).child("messages");

        FirebaseRecyclerOptions<ChatMessage> options =
                new FirebaseRecyclerOptions.Builder<ChatMessage>()
                        .setQuery(mChatRef, ChatMessage.class)
                        .build();
        mAdapter = new FirebaseRecyclerAdapter<ChatMessage, ChatViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ChatViewHolder holder, int position, @NonNull ChatMessage model) {
                holder.bind(model);
            }

            @NonNull
            @Override
            public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_message, parent, false);
                return new ChatViewHolder(view);
            }
        };


        mRecyclerView.setAdapter(mAdapter);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mMessageEditText.getText().toString().trim();
                if (!TextUtils.isEmpty(message)) {
                    ChatMessage chatMessage = new ChatMessage(mNickname, message);
                    mChatRef.push().setValue(chatMessage);
                    mMessageEditText.setText("");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        private TextView mNicknameTextView;
        private TextView mMessageTextView;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            mNicknameTextView = itemView.findViewById(R.id.nicknameTextView);
            mMessageTextView = itemView.findViewById(R.id.messageTextView);
        }

        public void bind(ChatMessage chatMessage) {
            mNicknameTextView.setText(chatMessage.getNickname());
            mMessageTextView.setText(chatMessage.getMessage());
        }
    }
}