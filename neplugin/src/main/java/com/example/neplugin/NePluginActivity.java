package com.example.neplugin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pluginlib.PluginActivity;

public class NePluginActivity extends PluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ne_plugin);
    }
}
