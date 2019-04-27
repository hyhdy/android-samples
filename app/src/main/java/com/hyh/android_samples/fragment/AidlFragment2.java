package com.hyh.android_samples.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.hyh.android_samples.R;
import com.hyh.android_samples.ipc.Book;
import com.hyh.android_samples.ipc.BookManagerService;
import com.hyh.android_samples.ipc.IBookManager;
import com.hyh.annotation.InjectFragment;
import com.hyh.base_lib.BaseFragment;

import java.util.List;

@InjectFragment()
public class AidlFragment2 extends BaseFragment {
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager iBookManager = IBookManager.Stub.asInterface(service);
            try {
                List<Book> list = iBookManager.getBookList();
                Log.d("hyh","AidlFragment2: onServiceConnected: list type="+list.getClass().getCanonicalName());
                Log.d("hyh","AidlFragment2: onServiceConnected: list="+list.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected int getResId() {
        return R.layout.fragment_aidl_2;
    }

    @Override
    protected void initViews(View rootView) {
        Intent intent = new Intent(getActivity(), BookManagerService.class);
        getActivity().bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onDestroy() {
        getActivity().unbindService(mServiceConnection);
        super.onDestroy();
    }
}
