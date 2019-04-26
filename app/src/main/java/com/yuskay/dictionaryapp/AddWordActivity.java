package com.yuskay.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Savepoint;

public class AddWordActivity extends AppCompatActivity {
EditText etWord, etDefinition;
Button btnAddword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etWord = findViewById(R.id.etWord);
        etDefinition = findViewById(R.id.etMeaning);
        btnAddword = findViewById(R.id.btnaddWord);

        btnAddword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save() ;
            }
        });

    }

    private void Save() {
        try {
            PrintStream printStream = new PrintStream(openFileOutput( "words.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println (etWord.getText().toString() + "->" + etDefinition.getText().toString());
            Toast.makeText( this,  "saved to" +getFilesDir(), Toast.LENGTH_SHORT). show();

        } catch (IOException e){
            Log.d( "Dictionary app", "Error:" + e.toString());
            e.printStackTrace();     }
    }
}

