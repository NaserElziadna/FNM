package com.nmmsoft.tasks;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import android.view.ViewGroup;

import com.nmmsoft.tasks.Model.Task;

import java.util.Calendar;


public class AddNoteFragment extends Fragment {

    Button mAddBtn;
    EditText mSubjectEt;
    EditText mDescriptionEt;
    RadioGroup mRg;
    Button mDatePickeBtm;
    Button mTimePickerBtm;
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

        mDatePickeBtm = view.findViewById(R.id.datePickerBtn);
        mTimePickerBtm = view.findViewById(R.id.timePickerBtn);


        task = new Task();

        view.findViewById(R.id.addNote).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                task.setId(0);
                if (!TextUtils.isEmpty(mSubjectEt.getText().toString())) {
                    task.setSubject(mSubjectEt.getText().toString());
                    if (!TextUtils.isEmpty(mDescriptionEt.getText().toString())) {
                        task.setDescription(mDescriptionEt.getText().toString());
                        if (mRg.getCheckedRadioButtonId() != -1) {
                            RadioButton radioButton = view.findViewById(mRg.getCheckedRadioButtonId());
                            switch (radioButton.getId()) {
                                case R.id.easyRB:
                                    task.setPriority(Priority.EASY_PRIORITY);
                                    break;
                                case R.id.mediumRB:
                                    task.setPriority(Priority.MEDIUM_PRIORITY);
                                    break;
                                case R.id.hardRB:
                                    task.setPriority(Priority.HARD_PRIORITY);
                                    break;
                            }
                            // TODO: 8/24/2020
                            //save task to database
                        } else {
                            Toast.makeText(getActivity(), "choose priority", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "null description", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "null subject", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mDatePickeBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                Toast.makeText(getActivity(), ""+c.get(Calendar.YEAR)+"\n"+c.get(Calendar.MONTH)+"\n"+c.get(Calendar.DAY_OF_MONTH), Toast.LENGTH_SHORT).show();
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                Toast.makeText(getActivity(), dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, Toast.LENGTH_SHORT).show();
                            }
                        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
                datePickerDialog.setCancelable(false);

            }
        });

        mTimePickerBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                Toast.makeText(getActivity(), c.get(Calendar.HOUR_OF_DAY) + " " + c.get(Calendar.MINUTE), Toast.LENGTH_SHORT).show();
                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                Toast.makeText(getActivity(), hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();

                            }
                        }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false);
                timePickerDialog.show();
                timePickerDialog.setCancelable(false);
            }
        });

        return view;
    }


//    public void onClick(View v) {
//
//        if (v == mDatePickeBtm) {
//
//            // Get Current Date
//            final Calendar c = Calendar.getInstance();
//            Toast.makeText(getActivity(), ""+c.get(Calendar.YEAR)+"\n"+c.get(Calendar.MONTH)+"\n"+c.get(Calendar.DAY_OF_MONTH), Toast.LENGTH_SHORT).show();
//            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
//                    new DatePickerDialog.OnDateSetListener() {
//
//                        @Override
//                        public void onDateSet(DatePicker view, int year,
//                                              int monthOfYear, int dayOfMonth) {
//                            Toast.makeText(getActivity(), dayOfMonth + "-" + (monthOfYear + 1) + "-" + year, Toast.LENGTH_SHORT).show();
//                        }
//                    }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
//            datePickerDialog.show();
//        }
//        if (v == mTimePickerBtm) {
//
//            // Get Current Time
//            final Calendar c = Calendar.getInstance();
//            Toast.makeText(getActivity(), c.get(Calendar.HOUR_OF_DAY) + " " + c.get(Calendar.MINUTE), Toast.LENGTH_SHORT).show();
//            // Launch Time Picker Dialog
//            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
//                    new TimePickerDialog.OnTimeSetListener() {
//
//                        @Override
//                        public void onTimeSet(TimePicker view, int hourOfDay,
//                                              int minute) {
//
//                            Toast.makeText(getActivity(), hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
//
//                        }
//                    }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false);
//            timePickerDialog.show();
//        }
//    }
}