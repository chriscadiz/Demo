package com.nimblinteractive.demo;

import android.content.pm.ShortcutManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        // Here we could read the username from the bundle and report the custom user's profile shortcut as used
        (getSystemService(ShortcutManager.class)).reportShortcutUsed("username" + "profile");
    }
}
