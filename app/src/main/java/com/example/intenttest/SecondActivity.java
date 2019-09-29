package com.example.intenttest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static String TAG = "SecondActivity";;
    private Button button_send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        //使用getStringExtra获取前一个Activity传递过来的数据
        Intent getintent = getIntent();
        String getdata = getintent.getStringExtra("extra_data");
        Log.i(TAG,"getdata = "+getdata);

        //设置监听器
        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //隐式意图实现，设置Intent的一些属性，如果隐士启动的是Activity,则必须在AndroidMainfest中增加
                //<category android:name="android.intent.category.DEFAULT"/>
                Intent intent = new Intent();
                intent.setAction("com.example.IntentTest.ACTION_TEST");
                intent.addCategory("aaa");
                Uri uri = Uri.parse("baidu://www.baidu.com/nihaonihao");
                intent.setData(uri);
                startActivity(intent);

                // 按下自定义的button，使用putExtra返回数据给上一个Activity
                Intent result_intent = new Intent();
                result_intent.putExtra("data_return","I am MainActivity");
                setResult(RESULT_OK,result_intent);
                //如下finish代码会跳转到其他Activity后，此Activity会销毁，不加此行代码，仅仅会OnStop,待被启动的Activity销毁后，此Activity会重新On
                //finish();
            }
        };

        button_send = (Button)findViewById(R.id.bt1);
        button_send.setOnClickListener(onClickListener);

        Log.i(TAG,"onCreate ");
    }

    //实际测试过程中未生效
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        //按下back键
//        Intent backintent = new Intent();
//        backintent.putExtra("data_return","hello MainActivity");
//        setResult(RESULT_OK,backintent);
//        finish();
//        Log.i(TAG,"onBackPressed");
//    }

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
