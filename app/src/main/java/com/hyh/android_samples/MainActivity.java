package com.hyh.android_samples;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.hyh.android_samples.fragment.FragmentRepotity;
import com.hyh.base_lib.BaseFragment;
import com.hyh.base_lib.BaseFragmentFactory;
import com.hyh.base_lib.adapter.DataListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView rvList = findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);
        DataListAdapter dataListAdapter = new DataListAdapter(this, new DataListAdapter.OnClickCallBack() {
            @Override
            public void onClick(BaseFragmentFactory baseFragmentFactory) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                BaseFragment fragment = baseFragmentFactory.createFragment();
                fragment.setOnDestroyCallBack(new BaseFragment.OnDestroyCallBack() {
                    @Override
                    public void onDestroy() {
                        rvList.setVisibility(View.VISIBLE);
                    }
                });
                transaction.replace(R.id.fl_fragment_container, fragment);
                //添加到返回栈中，使得点击返回键会回到当前activity
                transaction.addToBackStack(null);
                transaction.commit();
                Log.d("hyh", "MainActivity: onClick ");
                rvList.setVisibility(View.GONE);
            }
        }, FragmentRepotity.sDataList);
        rvList.setAdapter(dataListAdapter);
    }
}
