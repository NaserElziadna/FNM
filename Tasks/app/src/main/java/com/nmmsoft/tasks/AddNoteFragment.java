package com.nmmsoft.tasks;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import android.view.ViewGroup;

import com.nmmsoft.tasks.Model.Task;


public class AddNoteFragment extends Fragment {

    Button mAddBtn;
    EditText mSubjectEt;
    EditText mDescriptionEt;
    RadioGroup mRg;
    Task task;

    public AddNoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_add_note, container, false);
        mAddBtn = view.findViewById(R.id.addNote);
        mSubjectEt = view.findViewById(R.id.subjectEt);
        mDescriptionEt = view.findViewById(R.id.descriptionEt);
        mRg = view.findViewById(R.id.RG);

        task = new Task();

        view.findViewById(R.id.addNote).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                task.setId(0);
                if (!TextUtils.isEmpty(mSubjectEt.getText().toString())) {
                    task.setSubject(mSubjectEt.getText().toString());
                } else {
                    Toast.makeText(getActivity(), "null subject", Toast.LENGTH_SHORT).show();
                }
                if (!TextUtils.isEmpty(mDescriptionEt.getText().toString())) {
                    task.setDescription(mDescriptionEt.getText().toString());
                } else {
                    Toast.makeText(getActivity(), "null description", Toast.LENGTH_SHORT).show();
                }
                if (mRg.getCheckedRadioButtonId() != -1) {
//                    task.setPriority(mRg.getCheckedRadioButtonId() == 0 ? Priority.HARD_PRIORITY : mRg.getCheckedRadioButtonId() == 1 ? Priority.MEDIUM_PRIORITY : Priority.EASY_PRIORITY);
                } else {
                    Toast.makeText(getActivity(), "choose priority", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getActivity(), task.getPriority().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}