package com.nimblinteractive.demo;

import android.content.pm.ShortcutManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class NewMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        setTitle("New Message");

        (getSystemService(ShortcutManager.class)).reportShortcutUsed("new_message");
    }
}
