package com.ccs.cybernotice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextTitle, editTextContent;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String content = editTextContent.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("title", title);
                resultIntent.putExtra("content", content);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}