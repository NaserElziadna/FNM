package com.nmmsoft.tasks;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import java.util.Arrays;

public class NotesFragment extends Fragment {
    ListView listView;
    String[] value = new String[]{
            "Edit",
            "Show",
            "Share"
    };

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

        arrayList.add(new Task(0, "work", "turn off computer", ImagesPriority.EASY.getAction(), Priority.EASY_PRIORITY, ""));
        arrayList.add(new Task(1, "nothing", "turn off no no no no", ImagesPriority.HARD.getAction(), Priority.HARD_PRIORITY, ""));
        arrayList.add(new Task(2, "todo", "turn off 132 ♥", ImagesPriority.MEDIUM.getAction(), Priority.MEDIUM_PRIORITY, ""));

        //custom adapter
        final TaskAdapter taskAdapter = new TaskAdapter(getActivity(), R.layout.list_row, arrayList);

        listView.setAdapter(taskAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task task = taskAdapter.getItem(position);

                Toast.makeText(getActivity(), "" + task.getId(), Toast.LENGTH_SHORT).show();

                //build a dialog
                final AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(getActivity());

                alertdialogbuilder.setTitle("Select A action ");

                alertdialogbuilder.setItems(value, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectedText = Arrays.asList(value).get(which);

                        switch (selectedText) {
                            case "Edit":
                                setFragmentIntoContent(new EditNoteFragment());
                                Toast.makeText(getActivity(), "Edit", Toast.LENGTH_SHORT).show();
                                break;
                            case "Show":
                                setFragmentIntoContent(new ShowNoteFragment());
                                Toast.makeText(getActivity(), "Show", Toast.LENGTH_SHORT).show();
                                break;
                            case "Share":
                                Toast.makeText(getActivity(), "Share", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Toast.makeText(getActivity(), "nothing choosed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                alertdialogbuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog dialog = alertdialogbuilder.create();
                dialog.setCancelable(false);
                dialog.show();
            }
        });
        return view;
    }

    private void setFragmentIntoContent(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment, "").commit();
    }

}