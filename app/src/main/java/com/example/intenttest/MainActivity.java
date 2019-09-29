package com.example.intenttest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//MainActivity显示跳转到SecondActivity,SecondActivity隐士跳转到ThirdActivity，按下返回时回退到MainActivity
public class MainActivity extends AppCompatActivity {

    //成员变量，方法体外，类的内部定义的变量，一般会自动初始化，而局部变量不会进行初始化
    private Button loginbutton;
    private TextView text_ID;
    private TextView text_pwd;
    private EditText edit_ID;
    private EditText edit_pwd;
    private static String TAG = "MainActivity";
    private boolean isresult = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //变量的实例化
        loginbutton = (Button) findViewById(R.id.button);
        text_ID = (TextView) findViewById(R.id.textView);
        edit_ID = (EditText) findViewById(R.id.editText);
        text_pwd = (TextView) findViewById(R.id.textView1);
        edit_pwd = (EditText) findViewById(R.id.editText1);

        //触发点击click事件后，此方法被调用
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_ID.getText().toString().equals("admin") && edit_pwd.getText().toString().equals("123456"))
                {
                    Log.i(TAG,"ID id right,login success!");
                    Log.i(TAG,"id = "+edit_ID.getText().toString());
                    Log.i(TAG,"pwd = "+edit_pwd.getText().toString());
                }else{
                    Log.i(TAG,"ID id error,login fail!");
                    Log.i(TAG,"id = "+edit_ID.getText().toString());
                    Log.i(TAG,"pwd = "+edit_pwd.getText().toString());
                }

                //显示跳转Activity，并使用putExtra发送数据给跳转的Activity
                Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                String data = "I am SecondActivity";
                intent.putExtra("extra_data",data);

                if(isresult) {
                    startActivityForResult(intent, 1);//有结果返回的，具体需要返回的内容在OnActivityResult中定义
                }else {
                    startActivity(intent);//启动Activity后无结果返回
                    Log.i(TAG, "onclick listener!");
                }

            }
        };

        //设置一个监听器
        loginbutton.setOnClickListener(onClickListener);

        Log.i(TAG,"onCreate ");
    }

    //调用startActivityForResult会返回对应的结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case 1:
                if(resultCode == RESULT_OK)
                {
                    String returndata = data.getStringExtra("data_return");
                    Log.i(TAG,"returndata = "+returndata);
                }
                break;
            default:
        }
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




