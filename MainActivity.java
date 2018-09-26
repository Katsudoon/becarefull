package com.example.bauwensn.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView explication;
    Button button;
    ImageView logo;
    int mainLogo = R.drawable.logo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.main_editText);
        explication = findViewById(R.id.main_explanation);
        button = findViewById(R.id.main_button);
        logo = findViewById(R.id.main_logo);
        logo.setImageResource(mainLogo);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (!text.equals("")){
                    Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                    intent.putExtra("adress", editText.getText().toString());
                    startActivity(intent);
                }else {
                   // explication.setText("N'entrez pas un champ vide !");
                    Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                    intent.putExtra("adress", editText.getText().toString());
                    startActivity(intent);
                }

            }
        });
    }

}
