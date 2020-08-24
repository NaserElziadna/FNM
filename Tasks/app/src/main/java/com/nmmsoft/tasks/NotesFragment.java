package com.nmmsoft.tasks;

import android.os.Bundle;
import android.renderscript.RenderScript;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import com.nmmsoft.tasks.Model.Task;

import java.util.ArrayList;

public class NotesFragment extends Fragment {
    ListView listView;

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        listView = view.findViewById(R.id.listView);

        //create data
        ArrayList<Task> arrayList = new ArrayList<>();

        arrayList.add(new Task(0,"work","turn off computer",R.drawable.ic_done_all,Priority.EASY_PRIORITY));
        arrayList.add(new Task(1,"nothing","turn off no no no no",R.drawable.ic_done_all, Priority.HARD_PRIORITY));
        arrayList.add(new Task(2,"todo","turn off 132 ♥",R.drawable.ic_done_all,Priority.MEDIUM_PRIORITY));

        //custom adapter
        final TaskAdapter taskAdapter = new TaskAdapter(getActivity(), R.layout.list_row, arrayList);

        listView.setAdapter(taskAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task =taskAdapter.getItem(position);
                Toast.makeText(getActivity(), ""+task.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}