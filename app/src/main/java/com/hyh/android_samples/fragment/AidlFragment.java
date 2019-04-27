package com.hyh.android_samples.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hyh.android_samples.R;
import com.hyh.android_samples.ipc.ICalculator;
import com.hyh.android_samples.ipc.RemoteService;
import com.hyh.annotation.InjectFragment;
import com.hyh.base_lib.BaseFragment;
import com.hyh.base_lib.annotation.FindViewByIdAno;

@InjectFragment()
public class AidlFragment extends BaseFragment {
    @FindViewByIdAno(R.id.tv_result)
    private TextView mTvResult;
    @FindViewByIdAno(R.id.btn_add)
    private Button mBtnAdd;
    private ICalculator mICalculator;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("hyh","AidlFragment: onServiceConnected: pid="+android.os.Process.myPid());
            mICalculator = ICalculator.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("hyh","AidlFragment: onServiceDisconnected: ");
        }
    };

    @Override
    protected int getResId() {
        return R.layout.fragment_aidl;
    }

    @Override
    protected void initViews(View rootView) {
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int result = mICalculator.add(1,1);
                    mTvResult.setText(String.valueOf(result));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        Intent intent = new Intent(getActivity(), RemoteService.class);
        getActivity().bindService(intent,mServiceConnection, Context.BIND_AUTO_CREATE);
    }
}
