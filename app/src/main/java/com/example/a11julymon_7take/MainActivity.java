package com.example.a11julymon_7take;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username = (TextView) findViewById(R.id.txtUsername);
        TextView password = (TextView) findViewById(R.id.txtPassword);

        Button login_button = (Button) findViewById(R.id.button);
        Button continue_button = (Button) findViewById(R.id.continue_button);


        continue_button.setEnabled(false);

        login_button.setOnClickListener(view -> {
            if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                //correct
                Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                continue_button.setEnabled(true);
            } else {
                //incorrect
                Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();

            }
        });

        continue_button.setOnClickListener( view -> {
            Intent intent_startAuthentication = new Intent(MainActivity.this, AuthenticationPage.class);
            startActivity(intent_startAuthentication);
            startActivity(new Intent(MainActivity.this, AuthenticationPage.class));
        });



    }
}