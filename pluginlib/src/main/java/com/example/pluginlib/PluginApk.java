package com.example.pluginlib;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

public class PluginApk {

    //插件APK的实体对象
    public DexClassLoader mClassLoader;
    public Resources mResource;
    public PackageInfo mPackageInfo;
    public AssetManager mAssetManager;

    public PluginApk(DexClassLoader mClassLoader, Resources mResource, PackageInfo mPackageInfo, AssetManager mAssetManager){
        this.mClassLoader = mClassLoader;
        this.mResource = mResource;
        this.mPackageInfo = mPackageInfo;
        this.mAssetManager = mAssetManager;
    }
}
