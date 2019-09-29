package com.example.intenttest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ThirdActivity extends AppCompatActivity {
    private static String TAG = "ThirdActivity";
    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_third);
        text = (TextView) findViewById(R.id.textView_third);

        Log.i(TAG,"text = "+text.getText().toString());
        Log.i(TAG,"onCreate ");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG,"onStart ");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG,"onPause ");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG,"onResume ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart ");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG,"onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG,"onDestroy ");
    }
}
