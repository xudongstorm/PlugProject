package com.example.neplugin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pluginlib.BasePluginActivity;

public class MyPluginActivity extends BasePluginActivity {

 //   private Button btPlugMsg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ne_plugin);
        /*btPlugMsg = findViewById(R.id.bt_plug_msg);
        btPlugMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.sendResult("msg form Plug");
            }
        });*/
    }
}
