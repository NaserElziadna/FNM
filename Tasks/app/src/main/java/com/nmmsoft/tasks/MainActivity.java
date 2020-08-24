package com.nmmsoft.tasks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //action bar and its title
        actionBar = getSupportActionBar();
        actionBar.setTitle("Notes");

        //bottom navigation
        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.setSelectedItemId(R.id.nav_notes);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);


        //default fragment (on start)
        NotesFragment fragment1 = new NotesFragment();
        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
        ft1.replace(R.id.content, fragment1, "");
        ft1.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.nav_notes:
                            actionBar.setTitle("Notes");
                            setFragmentIntoContent(new NotesFragment());
                            return true;
                        case R.id.nav_add_note:
                            actionBar.setTitle("Add Note");
                            setFragmentIntoContent(new AddNoteFragment());
                            return true;
                        case R.id.nav_done:
                            actionBar.setTitle("Done");
                            setFragmentIntoContent(new DoneFragment());
                            return true;
                    }
                    return false;
                }
            };

    private void setFragmentIntoContent(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment, "").commit();
    }

}