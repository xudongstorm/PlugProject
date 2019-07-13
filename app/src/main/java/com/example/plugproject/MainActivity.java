package com.example.plugproject;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pluginlib.ICallback;
import com.example.pluginlib.PluginActivity;
import com.example.pluginlib.PluginManager;
import com.example.pluginlib.ProxyActivity;

import static com.example.plugproject.MainModuleConst.DATA_BACK;
import static com.example.plugproject.MainModuleConst.REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    private TextView tvPlugMsg;
    private Button loadApk;
    private Button jumpActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadApk = findViewById(R.id.load_apk);
        jumpActivity = findViewById(R.id.jump_activity);
        tvPlugMsg = findViewById(R.id.msg_plug);

        loadApk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String apkPath = null;
                try {
                    apkPath = Utils.copyAssetAndWrite(MainActivity.this, "net.apk");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                PluginManager.getInstance().init(MainActivity.this);
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
