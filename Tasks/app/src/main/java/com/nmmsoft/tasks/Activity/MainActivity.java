package com.nmmsoft.tasks.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nmmsoft.tasks.Fragment.AddNoteFragment;
import com.nmmsoft.tasks.Fragment.DoneFragment;
import com.nmmsoft.tasks.Fragment.NotesFragment;
import com.nmmsoft.tasks.R;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //action bar and its title
        actionBar = getSupportActionBar();
        actionBar.setTitle("Notes");

        firebaseAuth = FirebaseAuth.getInstance();

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

    private void setFragmentIntoContent(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment, "").commit();
    }

    private void checkUserStatus() {
        //get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            //user is signed in stay here
//            mProfileTv.setText(user.getEmail());
        } else {
            //user not signed in , go to main activity
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        //check on start of app
        checkUserStatus();
        super.onStart();
    }

    //inflate options menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //handle menu item click
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //get item id
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            firebaseAuth.signOut();
            checkUserStatus();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}