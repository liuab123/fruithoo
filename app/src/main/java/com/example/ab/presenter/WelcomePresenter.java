package com.example.ab.presenter;

import com.example.ab.base.Common;
import com.example.ab.model.IWelcomeModel;
import com.example.ab.model.WelcomeModel;
import com.example.ab.ui.viewinterface.IWelcomeView;
import com.example.ab.utils.SharedPreferenceUtils;

public class WelcomePresenter {
    private IWelcomeModel mWelcomeModel;
    private IWelcomeView mWelcomeView;
    public WelcomePresenter(IWelcomeView mWelcomeView){
        mWelcomeModel = new WelcomeModel();
        this.mWelcomeView = mWelcomeView;
    }
    public void initfruit() {
        mWelcomeModel.initFruits();
    }
}
