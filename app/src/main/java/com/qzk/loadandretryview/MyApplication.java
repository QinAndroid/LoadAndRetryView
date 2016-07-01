package com.qzk.loadandretryview;

import android.app.Application;

import com.qzk.loadandretryview.loadandretry.LoadingAndRetryManager;

/**
 * 类名：MyApplication
 * 描述：
 * 包名： com.qzk.loadandretryview
 * 项目名：LoadAndRetryView
 * Created by qinzongke on 7/1/16.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LoadingAndRetryManager.BASE_RETRY_LAYOUT_ID = R.layout.base_retry;
        LoadingAndRetryManager.BASE_LOADING_LAYOUT_ID = R.layout.base_loading;
        LoadingAndRetryManager.BASE_EMPTY_LAYOUT_ID = R.layout.base_empty;
    }
}
