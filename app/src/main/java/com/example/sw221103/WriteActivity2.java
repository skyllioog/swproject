package com.example.sw221103;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WriteActivity2 extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    String uid;

    EditText write_title , write_content; // 제목 , 내용

    ArrayList<String> writeKey = null;
    ArrayList<String> writeValue = null;

    ArrayAdapter<String> adapter = null;

    ArrayList<String> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        uid = user.getUid();

        write_title = (EditText) findViewById(R.id.editText_write_title);
        write_content = (EditText) findViewById(R.id.editText_writeContent);

        writeKey = new ArrayList<>();
        writeValue = new ArrayList<>();


        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(write_title.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext() , "제목을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(write_content.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext() , "내용을 입력하세요" , Toast.LENGTH_SHORT).show();
                    return;
                }
                //Intent intent = new Intent(WriteActivity.this, study_activity.class);
                //startActivity(intent);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

                Date time = new Date();

                String today = dateFormat.format(time);
                String order_today = dateFormat2.format(time);

                Board board= new Board();
                board.setTitle(write_title.getText().toString());
                board.setContent(write_content.getText().toString());
                board.setUid(uid);
                //board.setName(user.getName());
                board.setDate(today);
                board.setOrder_date(order_today);

                mDatabase.child("board").child(uid).push().setValue(board); //push 는 FireBase에서 제공하는 api 로 여러명이 동시에 클라이언트를 이용할때 어떤 값에 대해서 독립을 보장하는 프라이머리 key 입니다

                Intent i = new Intent(WriteActivity2.this , study_activity2.class);
                startActivity(i);
                finish();
                //Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_SHORT).show();
            }
        });
/*
        Button list = (Button) findViewById(R.id.list);
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WriteActivity2.this, study_activity2.class);
                startActivity(intent);
            }
        });

 */

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}


