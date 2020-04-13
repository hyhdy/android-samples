package com.hyh.android_samples.fragment;

import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.hyh.android_samples.R;
import com.hyh.annotation.InjectFragment;
import com.hyh.base_lib.BaseFragment;
import com.hyh.base_lib.annotation.FindViewByIdAno;

/**
 * created by curdyhuang on 2020-04-13
 */
@InjectFragment()
public class GlideFragment extends BaseFragment {
    @FindViewByIdAno(R.id.iv_show)
    private ImageView mIvImg;

    @Override
    protected int getResId() {
        return R.layout.fragment_glide;
    }

    @Override
    protected void initViews(View rootView) {
        Glide.with(getActivity()).load(R.drawable.animated_flag_france).into(mIvImg);
    }
}
