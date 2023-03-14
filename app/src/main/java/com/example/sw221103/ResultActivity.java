package com.example.sw221103;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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


        TextView textView = (TextView) findViewById(R.id.textView_result);

        String str = id + '\n' + title + '\n' + content;
        textView.setText(str);

    }
}
