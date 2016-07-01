package com.qzk.loadandretryview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    private List<String> mDatas = Arrays.asList("LoadingAndRetry in Activity", "LoadingAndRetry in Fragment", "LoadingAndRetry in Any View");

    private Class[] mClazz = new Class[]{MainMariActivity.class, FragmentTestActivity.class,AnyViewTestActivity.class};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = (ListView) findViewById(R.id.id_listview_category);

        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.item_category, R.id.id_title, mDatas));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position + 1 > mClazz.length) return;
                Intent intent = new Intent(MainActivity.this, mClazz[position]);
                startActivity(intent);
            }
        });

    }

}
