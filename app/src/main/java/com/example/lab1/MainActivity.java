package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
/*
 * Лабораторна робота №1
 * З дисципліни "Розробка мобільних застосувань під Android"
 * Виконав студент групи ІО-21 Крохун Богдан
 * Варіант: 4
 */
public class MainActivity extends AppCompatActivity {

    private String text;
    private String selected_language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Spinner spinner_languages = findViewById(R.id.spinner_languages);
        Button btn_ok = findViewById(R.id.btn_ok);
        Button btn_cancel = findViewById(R.id.btn_cancel);
        TextView text_select = findViewById(R.id.text_select);
        TextView text_language = findViewById(R.id.text_language);

        // Отримання списку мов з strings.xml та його запис у Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.language_list,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_languages.setAdapter(adapter);

        // Введення обраної мови програмування при натисканні на кнопку "OK"
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "Selected programming language";
                text_select.setText(text);

                selected_language = spinner_languages.getSelectedItem().toString();
                text_language.setText(selected_language);
            }
        });

        // Очищення обраної мови програмування при натисканні на кнопку "Cancel"
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "Select programming language:";
                text_select.setText(text);

                selected_language = "";
                text_language.setText(selected_language);
            }
        });
    }
}