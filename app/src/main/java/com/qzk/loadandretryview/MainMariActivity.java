package com.qzk.loadandretryview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.qzk.loadandretryview.loadandretry.LoadingAndRetryManager;
import com.qzk.loadandretryview.loadandretry.OnLoadingAndRetryListener;


public class MainMariActivity extends Activity
{
    LoadingAndRetryManager mLoadingAndRetryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLoadingAndRetryManager = LoadingAndRetryManager.generate(this, new OnLoadingAndRetryListener()
        {
            @Override
            public void setRetryEvent(View retryView)
            {
                MainMariActivity.this.setRetryEvent(retryView);
            }
        });

        loadData();

    }

    private void loadData()
    {
        mLoadingAndRetryManager.showLoading();

        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                mLoadingAndRetryManager.showRetry();
//                double v = Math.random();
//                if (v > 0.8)
//                {
//                    mLoadingAndRetryManager.showContent();
//                } else if (v > 0.4)
//                {
//                    mLoadingAndRetryManager.showRetry();
//                } else
//                {
//                    mLoadingAndRetryManager.showEmpty();
//                }
            }
        }.start();


    }


    public void setRetryEvent(View retryView)
    {
        View view = retryView.findViewById(R.id.id_btn_retry);
        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainMariActivity.this, "retry event invoked", Toast.LENGTH_SHORT).show();
                loadData();
            }
        });
    }
}
