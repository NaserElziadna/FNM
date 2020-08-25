package com.nmmsoft.tasks.Fragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.nmmsoft.tasks.R;

public class EditNoteFragment extends DialogFragment implements View.OnClickListener {


    public EditNoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_edit_note, container, false);

        ImageButton close = view.findViewById(R.id.fullscreen_dialog_close);

        close.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {

            case R.id.fullscreen_dialog_close:
                dismiss();
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                break;

        }

    }
}