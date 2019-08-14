package com.example.pluginlib;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

//代理Activity，管理插件Activity的生命周期
public class ProxyActivity extends AppCompatActivity {

    private static final String TAG = "ProxyActivity";

    private String mClassName;
    private PluginApk mPluginApk;
    private IPlugin mIPlugin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClassName = getIntent().getStringExtra("className");
        mPluginApk = PluginManager.getInstance(this).getPluginApk();
        launchPluginActivity();
    }

    private void launchPluginActivity() {
        if(mPluginApk == null){
            return;
        }
        try {
            Class<?> clazz = mPluginApk.getClassLoader().loadClass(mClassName);
            Object objetc = clazz.newInstance();
            if(objetc instanceof IPlugin){
                mIPlugin = (IPlugin) objetc;
                mIPlugin.attach(this);
                Bundle bundle = new Bundle();
                bundle.putInt("FROM", IPlugin.FORM_EXTERNAL);
                mIPlugin.onCreate(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Resources getResources() {
        return mPluginApk != null ? mPluginApk.getResource() : super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return mPluginApk != null ? mPluginApk.getAssetManager() : super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mPluginApk != null ? mPluginApk.getClassLoader(): super.getClassLoader();
    }
}
