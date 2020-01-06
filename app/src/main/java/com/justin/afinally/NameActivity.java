package com.justin.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {

    private EditText editName;
    public String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        editName = findViewById(R.id.edit1);
        userName = editName.getText().toString();
    }

    public void Next(View view) {
        userName = editName.getText().toString();
        SharedPreferences sp =getSharedPreferences("text",MODE_PRIVATE);
        sp.edit()
                .putString("user",userName)
                .commit();
        Intent intent=new Intent(NameActivity.this,PasswordActivity.class);
        startActivity(intent);
        setResult(RESULT_OK);
        finish();
    }
}
