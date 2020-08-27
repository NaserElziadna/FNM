package com.nmmsoft.tasks.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.nmmsoft.tasks.R;

public class LoginActivity extends AppCompatActivity {

    EditText mEmailEt, mPasswordEt;
    Button mLoginBtn, mGoogleLoginBtn;
    TextView mNotHaveAccount, mRecoverPassTv;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //action bar adn its title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Log In");
        //enable back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //init views
        mEmailEt = (EditText) findViewById(R.id.emailEt);
        mPasswordEt = (EditText) findViewById(R.id.passwordEt);
        mLoginBtn = (Button) findViewById(R.id.loginBtn);
        mGoogleLoginBtn = (Button) findViewById(R.id.googleLogInBtn);
        mNotHaveAccount = (TextView) findViewById(R.id.notHaveAccountTv);
        mRecoverPassTv = (TextView) findViewById(R.id.recoverPassTv);


        //handle not having an account textview click
        mNotHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        //recover password textview click
        mRecoverPassTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecoverPasswordDialog();
            }
        });

        //init progressDialog
        progressDialog = new ProgressDialog(this);

    }

    private void showRecoverPasswordDialog() {
        //alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");

        //set linear layout
        LinearLayout linearLayout = new LinearLayout(this);
        //views to set in dialog
        final EditText emailEt = new EditText(this);
        emailEt.setHint("Email");
        emailEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        emailEt.setMinEms(16);

        linearLayout.addView(emailEt);
        linearLayout.setPadding(10, 10, 10, 10);

        builder.setView(linearLayout);
        //buttons recover
        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email = emailEt.getText().toString().trim();
            }
        });

        //buttons cancel
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        //show dialog
        builder.create().show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();//go previous button
        return super.onSupportNavigateUp();
    }

}

