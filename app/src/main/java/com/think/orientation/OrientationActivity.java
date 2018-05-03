package com.think.orientation;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class OrientationActivity extends AppCompatActivity implements View.OnClickListener {

    protected TextView tv1;
    protected TextView tv2;
    private String TAG = this.getClass().getName();
    private String strTag = "***--->***" + TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_orientation);
        initView();
        Log.i(TAG, "onCreate: " + strTag);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv1) {
            //1横屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else if (view.getId() == R.id.tv2) {
            //2竖屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(OrientationActivity.this);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv2.setOnClickListener(OrientationActivity.this);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart: " + strTag);
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: " + strTag);
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.i(TAG, "onSaveInstanceState: " + strTag);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    //activity被暂停或收回cpu和其他资源时调用，该方法用于保存活动状态的。
    @Override
    protected void onPause() {
        Log.i(TAG, "onPause: " + strTag);
        super.onPause();
    }

    //activity被停止并转为不可见阶段及后续的生命周期事件时，即失去焦点时调用。
    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: " + strTag);
        super.onStop();
    }

    //activity被完全从系统内存中移除时调用，该方法被调用可能是因为有人直接调用 finish()方法 或者系统决定停止该活动以释放资源。
    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: " + strTag);
        super.onDestroy();
    }

    //屏幕方向切换后,回调此函数.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState: " + strTag);
        super.onRestoreInstanceState(savedInstanceState);
    }

    //指定属性,会回调.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i(TAG, "onConfigurationChanged: " + strTag);
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //横屏--->2
            Log.i(TAG, "onConfigurationChanged: 横屏" + newConfig.orientation + strTag);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            //竖屏--->1
            Log.i(TAG, "onConfigurationChanged: 竖屏" + newConfig.orientation + strTag);
        } else if (newConfig.orientation == Configuration.ORIENTATION_UNDEFINED) {
            //默认--->0
            Log.i(TAG, "onConfigurationChanged: 默认" + newConfig.orientation + strTag);
        }
    }

}
