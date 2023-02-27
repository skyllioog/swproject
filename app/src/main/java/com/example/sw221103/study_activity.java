package com.example.sw221103;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/*
public class study_activity extends AppCompatActivity {
    DatabaseReference mDatabase;
    ArrayList<Board> arrayList = new ArrayList<>();
    ArrayAdapter<Board> adapter;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_main);

        FloatingActionButton fab;

        fab = (FloatingActionButton)findViewById(R.id.fab_btn);

        //플로팅 버튼
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), floating.class); //그룹 만들기 화면으로 연결
                startActivity(intent); //액티비티 열기
            }
        });

        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(study_activity.this, WriteActivity.class);
                startActivity(intent);
            }
        });

    }
}
*/

