package com.example.ab.ui.fragment;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ab.R;
import com.example.ab.ui.activity.BotActivity;

import static android.content.Context.MODE_PRIVATE;

public class UserFragment extends Fragment {
    TextView Account;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_userfragment,container,false);
        SharedPreferences pref = getContext().getSharedPreferences("data",MODE_PRIVATE);
        String account=pref.getString("account","id");

        Account = (TextView) view.findViewById(R.id.tv_account);
        Account.setText(account);
        return view;
    }
}
