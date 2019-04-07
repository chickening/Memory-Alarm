package com.example.memoryalarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {
    public MenuFragment() {
        // Required empty public constructor
    }
    private int current_button_id;
    private MainActivity mainActivity;
    final int[] menuButtonIds = {R.id.button_menu_new_memory, R.id.button_menu_list_memory, R.id.button_menu_setting};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        mainActivity = (MainActivity)getActivity();
        current_button_id = menuButtonIds[0];
        View.OnClickListener menuOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if(current_button_id != id) {   //누른 메뉴가 현재 콘텐트 프래그먼트와 같으면 안바꿈
                    if (id == menuButtonIds[0]) {  // new
                        mainActivity.changeContent(new NewMemoryFragment());
                    } else if (id == menuButtonIds[1]) {    //list
                        mainActivity.changeContent(new ListMemoryFragment());
                    } else if (id == menuButtonIds[2]) {    //setting
                        mainActivity.changeContent(new SettingFragment());
                    }
                }
                current_button_id = id;
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
