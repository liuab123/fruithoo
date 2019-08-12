package com.example.ab.presenter;

import com.example.ab.model.ILoginModel;
import com.example.ab.model.LoginModel;
import com.example.ab.ui.viewinterface.ILoginView;

public class LoginPresenter {
    private ILoginModel mLoginModel;
    private ILoginView mLoginView;

    public LoginPresenter(ILoginView mLoginView) {
        mLoginModel = new LoginModel();
        this.mLoginView = mLoginView;
    }
    public void logincheck(long id, String password) {
        boolean isLogin = mLoginModel.onLogin(id, password);
        if (isLogin) {
            mLoginView.onLoginSucceed();
        } else {
            mLoginView.onLoginFaild();

        }
    }
}
