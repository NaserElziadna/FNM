package com.nmmsoft.tasks.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.nmmsoft.tasks.R;

public class ShowNoteFragment extends DialogFragment implements View.OnClickListener {

    public ShowNoteFragment() {
        // Required empty public constructor
    }

    @Override
    public int getTheme() {
//        return super.getTheme();
        return R.style.FullScreenDialog;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_note, container, false);

//        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

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