package com.huruwo.hposed;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;


public class MainHookLoader implements IXposedHookLoadPackage {

    public static String MAIN_APP = "com.huruwo.hposed";

    private static String INTERCEPTORPATH = "/storage/emulated/0/cookie.txt";


    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {




    }

}
