package com.example.lab2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lab2.Adapter.MainListAdapter;
import com.example.cource_project.R;

import org.json.JSONArray;

public class MainListFragment extends Fragment {
    // Класс статического фрагмента, отображающего список технологий

    private RecyclerView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View view =  inflater.inflate(R.layout.main_list, container, false);

        DataHolder dataHolder = DataHolder.getInstance();
        JSONArray data = dataHolder.getData();
        System.out.println(data.toString());

        Context context = getActivity();

        list = view.findViewById(R.id.card);
        MainListAdapter adapter = new MainListAdapter(data.length()-1, context);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(context));

        return view;
    }

}
