package com.example.memoryalarm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

import net.danlew.android.joda.JodaTimeAndroid;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeMenu(new MenuFragment());
        changeContent(new NewMemoryFragment());
        JodaTimeAndroid.init(this);
    }
    public void changeMenu(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_menu, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void changeContent(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}