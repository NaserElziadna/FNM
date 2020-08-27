package com.nmmsoft.tasks.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.nmmsoft.tasks.Fragment.EditNoteFragment;
import com.nmmsoft.tasks.Fragment.ShowNoteFragment;
import com.nmmsoft.tasks.R;

public class DashBoardActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        intent = getIntent();
        String fragName = intent.getStringExtra("fragName");
        switch (fragName) {
            case "Edit":
                setFragmentIntoContent(new EditNoteFragment());
                break;
            case "Show":
                setFragmentIntoContent(new ShowNoteFragment());
                break;
        }

    }

    private void setFragmentIntoContent(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.dashboardContent, fragment, "").commit();
    }
}