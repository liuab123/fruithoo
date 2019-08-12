package com.example.ab.presenter;

import com.example.ab.model.IRegisterModel;
import com.example.ab.model.RegisterModel;
import com.example.ab.ui.viewinterface.IRegisterView;

public class RegisterPresenter {
    private IRegisterModel mRegisterModel;
    private IRegisterView mRegisterView;

    public RegisterPresenter(IRegisterView mRegisterView) {
        mRegisterModel = new RegisterModel();
        this.mRegisterView = mRegisterView;
    }
    public void registercheck(long id, String password) {
        boolean isRegister = mRegisterModel.onRegister(id, password);
        if (isRegister) {
            mRegisterView.register();
        } else {
            mRegisterView.repeat();
        }
    }
}
