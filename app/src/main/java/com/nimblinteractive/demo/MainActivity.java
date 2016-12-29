package com.nimblinteractive.demo;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button add = (Button) findViewById(R.id.add_button);
        Button clear = (Button) findViewById(R.id.clear_button);

        setSupportActionBar(toolbar);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
                Intent profileIntent = new Intent("com.nimblinteractive.demo.action.PROFILE");
                Intent messageIntent = new Intent("com.nimblinteractive.demo.action.MESSAGE");

                ShortcutInfo messageShortcut = new ShortcutInfo.Builder(MainActivity.this, "kim_message")
                        .setShortLabel("@kimk")
                        .setIcon(Icon.createWithResource(MainActivity.this, R.drawable.new_message))
                        .setLongLabel("Message @kimk")
                        .setIntents(new Intent[]{profileIntent, messageIntent})
                        .build();

                ShortcutInfo profileShortcut = new ShortcutInfo.Builder(MainActivity.this, "kim_profile")
                        .setShortLabel("@kimk")
                        .setLongLabel("@kimk's Profile")
                        .setIntents(new Intent[]{profileIntent})
                        .build();

                shortcutManager.setDynamicShortcuts(Arrays.asList(messageShortcut, profileShortcut));

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
                shortcutManager.removeAllDynamicShortcuts();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
