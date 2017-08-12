package com.andy.practice1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindWords(View view){
        Spinner language = (Spinner) findViewById(R.id.spinner);
        int selection = (int)language.getSelectedItemId();
        List<String> wordsList = getWords(selection);
        String wordsFormatted = "";
        Intent intent = new Intent(this, SecondActivity.class);

        for (String word:wordsList) {
            wordsFormatted += word + '\n';
        }
        wordsFormatted = wordsFormatted.substring(0, wordsFormatted.length()-1);
        intent.putExtra("words", wordsFormatted);
        //unused TextView
       /* TextView words = (TextView) findViewById(R.id.words);
       words.setText(wordsFormatted); */
        startActivity(intent);
        }

    public List<String> getWords(int id){
        List<String> words = new ArrayList<>();
        if (id == 0){
            words.add("Hello!");
            words.add("Hi!");
        }
        if (id == 1){
            words.add("Hallo");
        }
        return words;
    }
}
