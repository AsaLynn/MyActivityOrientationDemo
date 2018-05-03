package com.think.orientation;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private String TAG = this.getClass().getName();
    private String strTag = "***--->***";

    //创建activity时调用。设置在该方法中，还以Bundle中可以提出用于创建该 Activity 所需的信息。
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: " + strTag);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"222 222",Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        findViewById(R.id.tv3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this,OrientationActivity.class));
            }
        });
    }

    //activity变为在屏幕上对用户可见时，即获得焦点时，会调用。
    @Override
    protected void onStart() {
        Log.i(TAG, "onStart: "+strTag);
        super.onStart();
    }

    //activity开始与用户交互时调用（无论是启动还是重新启动一个活动，该方法总是被调用的）。
    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: "+strTag);
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.i(TAG, "onSaveInstanceState: "+strTag);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    //activity被暂停或收回cpu和其他资源时调用，该方法用于保存活动状态的。
    @Override
    protected void onPause() {
        Log.i(TAG, "onPause: "+strTag);
        super.onPause();
    }

    //activity被停止并转为不可见阶段及后续的生命周期事件时，即失去焦点时调用。
    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: "+strTag);
        super.onStop();
    }

    //activity被完全从系统内存中移除时调用，该方法被调用可能是因为有人直接调用 finish()方法 或者系统决定停止该活动以释放资源。
    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: "+strTag);
        super.onDestroy();
    }

    //屏幕方向切换后,回调此函数.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState: "+strTag);
        super.onRestoreInstanceState(savedInstanceState);
    }

    //指定属性,会回调.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i(TAG, "onConfigurationChanged: "+strTag);
        super.onConfigurationChanged(newConfig);
    }


    private void show() {
        //弹出对话框.
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("列表对话框!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(new String[]{"0111111"

        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        Toast.makeText(MainActivity.this,"123",Toast.LENGTH_LONG).show();
                        break;
//

                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: "+strTag);
    }
}
