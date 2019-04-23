package com.hyh.android_samples.fragment;

import android.view.View;

import com.hyh.android_samples.R;
import com.hyh.annotation.InjectFragment;
import com.hyh.base_lib.BaseFragment;

@InjectFragment()
public class DispatchFragment extends BaseFragment {
    @Override
    protected int getResId() {
        return R.layout.fragment_dispatch;
    }

    @Override
    protected void initViews(View rootView) {

    }
}
