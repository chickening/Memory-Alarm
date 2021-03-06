package com.example.memoryalarm;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.joda.time.DateTime;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListMemoryFragment extends Fragment {


    public ListMemoryFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content_list_memory, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recylerview_list_memory_list);
        ArrayList<ListMemoryItem> items = new ArrayList<>();

        items.add(new ListMemoryItem("밥먹으러가자", DateTime.now()));
        items.add(new ListMemoryItem("치진 먹으러 가자", DateTime.now()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ListMemoryAdapter(items));
        return view;
    }

}
class ListMemoryItem
{
    String title;
    DateTime start;
    ListMemoryItem(String title, DateTime start)
    {
        this.title = title;
        this.start = start;
    }
}
class ListMemoryAdapter extends RecyclerView.Adapter<ListMemoryAdapter.ViewHolder> {

    private ArrayList<ListMemoryItem> mData = null ;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        TextView start;
        TextView remain;
        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            title = itemView.findViewById(R.id.textview_content_list_memory_element_title) ;
            start = itemView.findViewById(R.id.textview_content_list_memory_element_start) ;
            remain = itemView.findViewById(R.id.textview_content_list_memory_element_remain) ;
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    ListMemoryAdapter(ArrayList<ListMemoryItem> list) {
        mData = list ;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public ListMemoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.content_list_memory_element, parent, false) ;
        ListMemoryAdapter.ViewHolder vh = new ListMemoryAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(ListMemoryAdapter.ViewHolder holder, int position) {
        ListMemoryItem item = mData.get(position) ;
        holder.title.setText(item.title) ;
        holder.start.setText(item.start.toString());
        int remainedHour = DateTime.now().getHourOfDay() - item.start.getHourOfDay();
        holder.remain.setText(remainedHour + " 시간후");
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}