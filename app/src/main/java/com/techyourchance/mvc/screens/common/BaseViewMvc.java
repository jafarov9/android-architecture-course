package com.techyourchance.mvc.screens.common;

import android.content.Context;
import android.view.View;

public abstract class BaseViewMvc implements ViewMvc {

    private View mRootView;

    protected  <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    protected Context getContext() {
        return getRootView().getContext();
    }

    @Override
    public View getRootView() {
        return  mRootView;
    }

    protected void setRootView(View mRootView) {
        this.mRootView = mRootView;
    }
}
