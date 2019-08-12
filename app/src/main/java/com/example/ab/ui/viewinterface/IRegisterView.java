package com.example.ab.ui.viewinterface;

public interface IRegisterView {
    boolean checkInput();  //检查输入的合法性
    void repeat();  //id重复
    void register(); //登录成功
}
