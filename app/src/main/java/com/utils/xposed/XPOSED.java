package com.utils.xposed;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.lang.reflect.Field;
import java.util.List;

/**
 * author   : kevin.bai
 * date      : 2020-03-03 22:33
 * qq        :904869397@qq.com
 */
public class XPOSED {

    /**
     * 包检测
     * @param context
     * @return
     */
    public static boolean installXposed(Context context){
        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> applicationInfoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo applicationInfo: applicationInfoList) {
            if (applicationInfo.packageName.equals("de.robv.android.xposed.installer")) {
                return true;
            }
         }
        return false;
    }

    /**
     * Crash 检测
     * @return
     */
    public static boolean crashXposed(){
        try {
            throw new Exception("blah");
        } catch(Exception e) {
            for (StackTraceElement stackTraceElement: e.getStackTrace()) {
                if(stackTraceElement.getClassName().contains("Xposed")||stackTraceElement.getMethodName().contains("Xposed")){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 反射修改hook 开关变量
     * @return
     */
    public static boolean disabledHook(){
            try {
                ClassLoader classLoader=ClassLoader.getSystemClassLoader();
                Class clazz=classLoader.loadClass("de.robv.android.xposed.XposedBridge");
                Field field=clazz.getDeclaredField("disableHooks");
                field.setAccessible(true);
                field.set(null, Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
    }
}
