package com.justin.afinally;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText name;
    boolean isTrue=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edit_name);
        button = findViewById(R.id.summit_button);
        name.setText("on");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,NameActivity.class);
                startActivityForResult(intent,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==10) {
            if (resultCode !=RESULT_OK) {
               finish();
            }else{
                String nameId = getSharedPreferences("text", MODE_PRIVATE)
                        .getString("user", "userName");
                name.setText(nameId);
            }
        }
    }
}
