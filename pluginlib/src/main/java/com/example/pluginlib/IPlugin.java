package com.example.pluginlib;

import android.app.Activity;
import android.os.Bundle;

public interface IPlugin {

    int FROM_INTERNAL = 0;
    int FORM_EXTERNAL = 1;

    void attach(Activity proxyActivity);    //把上下文传给插件APP

    void onCreate(Bundle saveInstanceState);

 //   void register(ICallback callback);
}
