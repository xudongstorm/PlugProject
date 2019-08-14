package com.example.plugproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

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
                try {
                    String apkPath = LoadUtils.copyAssetAndWrite(MainActivity.this, "zxd.apk");
                    PluginManager.getInstance(MainActivity.this).loadApk(apkPath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        jumpActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProxyActivity.class);
                intent.putExtra("className", "com.example.neplugin.MyPluginActivity");
                startActivity(intent);
            }
        });
    }
}
