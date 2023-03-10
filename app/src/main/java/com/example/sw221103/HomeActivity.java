package com.example.sw221103;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private Button buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button TODO = (Button) findViewById(R.id.todo);
        TODO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TodoActivity.class);
                startActivity(intent);
            }
        });

/*
        Button butstudy = (Button) findViewById(R.id.butstudy);
        butstudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), study_activity2.class);
                startActivity(intent);
            }
        });
 */

        Button board = (Button) findViewById(R.id.board);
        board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Test.class);
                startActivity(intent);
            }
        });

        Button draw = (Button) findViewById(R.id.draw);
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DrawActivity.class);
                startActivity(intent);
            }
        });



        Button buttonMy = (Button) findViewById(R.id.buttonMy);
        buttonMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MyActivity.class);
                startActivity(intent);
            }
        });
/*
        Button map = (Button) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

 */

        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

/*
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        buttonLogout.setOnClickListener(this);


*/

        Button logoutButton = (Button) findViewById(R.id.buttonLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                finish();
            }

        });

    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}

