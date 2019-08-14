package com.example.androidtodoapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.SliceItem;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private String[] tasks;
            // = {"Study","Playing","Work","Sleep"};
    private TextView textview;
    int currentIndex= 0;
    Resources res;
    private static final String TODO_INDEX="todoindex";

    public void next_click(View view){
        currentIndex++;
        textview.setText(tasks[currentIndex]);
    }
    public void prev_click(View view){
        currentIndex--;
        textview.setText(tasks[currentIndex]);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle onSaveInstanceState) {
        super.onSaveInstanceState(onSaveInstanceState);
        onSaveInstanceState.putInt("tasks", currentIndex);
        Log.d("MainActivity", "onSaveInstanceState");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState !=null){
            currentIndex= savedInstanceState.getInt("tasks", 0);
        }
        Resources res =getResources();
        tasks =res.getStringArray(R.id.textView);

        textview = findViewById(R.id.textView);
        textview.setText(tasks[currentIndex]);
    }
}
