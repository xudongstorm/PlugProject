package com.example.neplugin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pluginlib.BasePluginActivity;

public class MyPluginActivity extends BasePluginActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ne_plugin);
    }
}
