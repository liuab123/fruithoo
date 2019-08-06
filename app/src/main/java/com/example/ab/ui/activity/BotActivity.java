package com.example.ab.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ab.ui.fragment.AllFragment;
import com.example.ab.ui.fragment.LikeFragment;
import com.example.ab.ui.fragment.UserFragment;
import com.example.ab.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BotActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private AllFragment AllFragment;
    private LikeFragment LikeFragment;
    private UserFragment UserFragment;
    private Fragment[] fragments;
    private int lastfragment;//用于记录上个选择的Fragment


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot);


        initFragment();
    }
    private void initFragment()
    {
        AllFragment = new AllFragment();
        LikeFragment = new LikeFragment();
        UserFragment = new UserFragment();
        fragments = new Fragment[]{AllFragment, LikeFragment, UserFragment};
        lastfragment=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.mainview, AllFragment).show(AllFragment).commit();
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }
    //判断选择的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.id1:
                {
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;
                    }
                    return true;
                }
                case R.id.id2:
                {
                    if(lastfragment!=1)
                    {
                        switchFragment(lastfragment,1);
                        lastfragment=1;

                    }
                    return true;
                }
                case R.id.id3:
                {
                    if(lastfragment!=2)
                    {
                        switchFragment(lastfragment,2);
                        lastfragment=2;
                    }
                    return true;
                }
            }
            return false;
        }
    };
    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.mainview,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();

    }

}
