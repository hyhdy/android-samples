package com.hyh.android_samples.fragment;

import android.util.Log;
import android.view.View;

import com.hyh.android_samples.R;
import com.hyh.android_samples.event.MessageEvent;
import com.hyh.annotation.InjectFragment;
import com.hyh.base_lib.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@InjectFragment()
public class EventBusFragment extends BaseFragment {
    @Override
    protected int getResId() {
        return R.layout.fragment_event_bus;
    }

    @Override
    protected void initViews(View rootView) {

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new MessageEvent());
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {
        Log.d("hyh","EventBusFragment: onMessageEvent: ");
    };
}
