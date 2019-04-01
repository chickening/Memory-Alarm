package com.example.memoryalarm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {
    public MenuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        final int[] menuButtonIds = {R.id.button_menu_new_memory, R.id.button_menu_list_memory, R.id.button_menu_setting};
        final MainActivity mainActivity = (MainActivity)getActivity();
        View.OnClickListener menuOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(id == menuButtonIds[0]){  // new
                    mainActivity.changeContent(new NewMemoryFragment());
                }
                else if(id == menuButtonIds[1]){    //list
                    mainActivity.changeContent(new ListMemoryFragment());
                }
                else if(id == menuButtonIds[2]){    //setting
                    mainActivity.changeContent(new SettingFragment());
                }
            }
        };
        for(int id : menuButtonIds)
        {
            Button button = view.findViewById(id);
            button.setOnClickListener(menuOnClickListener);
        }
        return view;
    }
}
