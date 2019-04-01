package com.example.memoryalarm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListMemoryFragment extends Fragment {


    public ListMemoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content_list_memory, container, false);
        final String testsets[] = {"마인크래프트", "치킨", "피자"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.fragment_content_list_memory, testsets);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recylerview_list_memory_list);
        recyclerView.setAdapter(adapter);
        return view;
    }

}
