package com.justin.afinally;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MailActivity extends AppCompatActivity {

    private EditText editMail;
    private Button final_button;
    private Button final_button1;
    private String dataMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        editMail = findViewById(R.id.editMail);
        dataMail = editMail.getText().toString();
        final_button = findViewById(R.id.button_final);
        final_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp =getSharedPreferences("text",MODE_PRIVATE);
                sp.edit()
                        .putString("mail", dataMail)
                        .commit();
                Intent intent =new Intent(MailActivity.this,MainActivity.class);
                setResult(RESULT_OK);
            }
        });
    }
}
