package com.example.pluginlib;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

//代理Activity，管理插件Activity的生命周期
public class ProxyActivity extends AppCompatActivity {

    private String mClassName;
    private PluginApk mPluginApk;
    private IPlugin mIPlugin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mClassName = getIntent().getStringExtra("className");
        mPluginApk = PluginManager.getInstance().getPluginApk();
        launchPluginActivity();
    }

    private void launchPluginActivity() {
        if(mPluginApk == null){
            Log.e("zxd", "loading your apk first please.");
            return;
        }
        try {
            Class<?> clazz = mPluginApk.mClassLoader.loadClass(mClassName);
            Object object = clazz.newInstance();
            if(object instanceof IPlugin){
                mIPlugin = (IPlugin) object;
                mIPlugin.attach(this);  //把上下文传给插件APP
                Bundle bundle = new Bundle();
                bundle.putInt("FROM", IPlugin.FORM_EXTERNAL);
                mIPlugin.onCreate(bundle);
                /*ICallback<String> callback = new ICallback<String>() {
                    @Override
                    public void sendResult(String s) {

                    }
                };
                mIPlugin.register(callback);*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //特别注意
    @Override
    public Resources getResources() {
        return mPluginApk != null ? mPluginApk.mResource : super.getResources();
    }

    @Override
    public AssetManager getAssets() {
        return mPluginApk != null ? mPluginApk.mAssetManager : super.getAssets();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mPluginApk != null ? mPluginApk.mClassLoader: super.getClassLoader();
    }
}
