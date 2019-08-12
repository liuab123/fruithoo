package com.example.ab.ui.viewinterface;

public interface ILoginView {
    boolean checkInput();  //检查输入的合法性
    void onLoginSucceed();     //登录成功
    void onLoginFaild(); //登录失败
}
