package com.justin.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasswordActivity extends AppCompatActivity {

    private EditText editPassword;
    private Button button;
    private String dataPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        editPassword = findViewById(R.id.edit2);
        button = findViewById(R.id.button2);
        dataPassword = editPassword.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataPassword = editPassword.getText().toString();
                SharedPreferences sp =getSharedPreferences("text",MODE_PRIVATE);
                sp.edit()
                        .putString("password",dataPassword)
                        .commit();
                Intent intent =new Intent(PasswordActivity.this,MailActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
