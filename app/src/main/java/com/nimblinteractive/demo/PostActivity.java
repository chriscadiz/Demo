package com.nimblinteractive.demo;

import android.content.pm.ShortcutManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        setTitle("Post");

        (getSystemService(ShortcutManager.class)).reportShortcutUsed("post");
    }
}
