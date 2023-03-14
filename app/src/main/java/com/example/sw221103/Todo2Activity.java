package com.example.sw221103;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Todo2Activity extends AppCompatActivity {
    ArrayList<String> toDoList;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo2_main);

        toDoList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, R.layout.todo2_list, toDoList);
        listView = findViewById(R.id.list_View);
        editText = findViewById(R.id.edit_text);

        listView.setAdapter(adapter);

        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addItemToList();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;

                textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
    }
    public void addItemToList(){
        toDoList.add(editText.getText().toString());
        adapter.notifyDataSetChanged();
        editText.setText("");
    }
}
