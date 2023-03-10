package com.example.sw221103;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    TextView detail_uid_text, detail_name_text, detail_content_text;
    String uid, name, content;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detail_uid_text = findViewById(R.id.detail_uid_text);
        detail_name_text = findViewById(R.id.detail_name_text);
        detail_content_text = findViewById(R.id.detail_content_text);

        Intent intent = getIntent();

        uid = intent.getExtras().getString("uid");
        name = intent.getExtras().getString("name");
        content = intent.getExtras().getString("content");

        detail_uid_text.setText(uid);
        detail_name_text.setText(name);
        detail_content_text.setText(content);

    }
}
