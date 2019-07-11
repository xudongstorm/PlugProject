package com.example.plugproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pluginlib.PluginActivity;
import com.example.pluginlib.PluginManager;
import com.example.pluginlib.ProxyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loadApk = findViewById(R.id.load_apk);
        Button jumpActivity = findViewById(R.id.jump_activity);

        loadApk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apkPath = Utils.copyAssetAndWrite(MainActivity.this, "apk");
                PluginManager.getInstance().loadApk(apkPath);
            }
        });

        jumpActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProxyActivity.class);
                intent.putExtra("className", "com.example.neplugin.NePluginActivity");
                startActivity(intent);
            }
        });
    }
}
