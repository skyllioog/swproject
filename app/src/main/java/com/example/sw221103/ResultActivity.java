package com.example.sw221103;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        String id = "";
        String title = "";
        String content = "";

        Bundle extras = getIntent().getExtras();

        id = extras.getString("id");
        title = extras.getString("title");
        content = extras.getString("content");


        /*
        TextView textView = (TextView) findViewById(R.id.textView_result);

        String str = id + '\n' + title + '\n' + content;
        textView.setText(str);

         */
        TextView textView1 = (TextView) findViewById(R.id.textView_result1);
        TextView textView2 = (TextView) findViewById(R.id.textView_result2);
        TextView textView3 = (TextView) findViewById(R.id.textView_result3);

        String str1 = id;
        textView1.setText(str1);

        String str2 = title;
        textView2.setText(str2);

        String str3 = content;
        textView3.setText(str3);

    }

}
