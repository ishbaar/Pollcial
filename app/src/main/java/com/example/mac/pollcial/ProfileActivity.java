package com.example.mac.pollcial;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    private String username;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        username = mFirebaseUser.getDisplayName();
        email = mFirebaseUser.getEmail();

        // fill in username
        EditText usernameText = (EditText) findViewById(R.id.txt_profile_username);

        if(username != null) {
            usernameText.setText(username);
        }
        else {
            TextView usernameGuestView= (TextView) findViewById(R.id.txt_profile_username_guest);
            usernameGuestView.setVisibility(View.VISIBLE);

            usernameText.setVisibility(View.GONE);

            EditText saveUsernameBtn = (EditText) findViewById(R.id.btn_save_username_change);
            saveUsernameBtn.setVisibility(View.GONE);

        }

        // fill in email
        TextView emailView = (TextView) findViewById(R.id.txt_email);

        if(email != null) {
            emailView.setText(email);
        }
        else {
            emailView.setText("Guest");
        }

        //this block adds a back button to the upper left of screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        EditText saveUsernameChange = (EditText) findViewById(R.id.btn_save_username_change);
        saveUsernameChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username == null) {
                    CharSequence guestInfo = "You cannot do this as a guest.";

                    Toast displayGuestInfo = Toast.makeText(getApplicationContext(), guestInfo, Toast.LENGTH_SHORT);
                    displayGuestInfo.show();
                }
                else {
                    changeUsername();
                }
            }
        });


        Button changePasswordBtn = (Button) findViewById(R.id.btn_change_password);
        changePasswordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email == null) {
                    CharSequence guestInfo = "You cannot do this as a guest.";

                    Toast displayGuestInfo = Toast.makeText(getApplicationContext(), guestInfo, Toast.LENGTH_SHORT);
                    displayGuestInfo.show();
                }
                else {
                    //render a new activity here
                    startActivity(new Intent(ProfileActivity.this, ChangePasswordActivity.class));
                    finish();
                }
            }
        });
    }

    private void changeUsername() {
        EditText usernameText = (EditText) findViewById(R.id.txt_profile_username);
        String newUsername = usernameText.getText().toString();

        if(TextUtils.isEmpty(newUsername)) {
            usernameText.setError(getString(R.string.error_field_required));
        }
        else {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(newUsername).build();

            mFirebaseUser.updateProfile(profileUpdates)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("Update username", "User profile updated.");
                            }
                        }
                    });

            Context context = getApplicationContext();
            CharSequence text = "Name change saved";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    //this block clear focus when touch somewhere else
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

}
