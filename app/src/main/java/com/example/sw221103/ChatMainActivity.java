package com.example.sw221103;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class ChatMainActivity extends AppCompatActivity {
    private EditText mNicknameEditText;
    private Button mJoinButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_main);

        mNicknameEditText = findViewById(R.id.nickname_edittext);
        mJoinButton = findViewById(R.id.join_button);

        mAuth = FirebaseAuth.getInstance();

        mJoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = mNicknameEditText.getText().toString().trim();
                if (TextUtils.isEmpty(nickname)) {
                    Toast.makeText(ChatMainActivity.this, "Please enter a nickname", Toast.LENGTH_SHORT).show();
                } else {
                    joinChatRoom(nickname);
                }
            }
        });
    }

    private void joinChatRoom(final String nickname) {
        mAuth.signInAnonymously().addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                FirebaseUser user = mAuth.getCurrentUser();
                String uid = user.getUid();

                DatabaseReference chatRef = FirebaseDatabase.getInstance().getReference("chats");
                String chatId = chatRef.push().getKey();
                DatabaseReference userRef = chatRef.child(chatId).child("users").child(uid);
                userRef.setValue(nickname).addOnSuccessListener(new OnSuccessListener<Void>() {

                    @Override
                    public void onSuccess(Void aVoid) {
                        Intent intent = new Intent(ChatMainActivity.this, ChatRoomActivity.class);
                        intent.putExtra("chat_id", chatId);
                        intent.putExtra("nickname", nickname);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ChatMainActivity.this, "Failed to join chat room", Toast.LENGTH_SHORT).show();
            }
        });
    }
}