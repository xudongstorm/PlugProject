package com.example.pluginlib;

import android.app.Activity;
import android.os.Bundle;

public class BasePluginActivity extends Activity implements IPlugin {

    private int mFrom = FROM_INTERNAL;
    private Activity mProxyActivity;

    @Override
    public void attach(Activity proxyActivity) {
        this.mProxyActivity = proxyActivity;
    }

    @Override
    public void onCreate(Bundle saveInstanceState) {
        if(saveInstanceState != null){
            mFrom = saveInstanceState.getInt("FROM");
        }
        if(mFrom == FROM_INTERNAL){
            super.onCreate(saveInstanceState);
            mProxyActivity = this;
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if(mFrom == FORM_EXTERNAL){
            mProxyActivity.setContentView(layoutResID);
        }else{
            super.setContentView(layoutResID);
        }
    }
}
