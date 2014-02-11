// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.gucdxj.zhongyi.activity;

import android.app.Activity;
import android.app.Application;
import java.util.Iterator;
import java.util.Stack;

public class MyApplication extends Application
{

    public MyApplication()
    {
    }

    public static MyApplication getInstance()
    {
        return singleton;
    }

    public void AppExit()
    {
        finishAllActivity();
//_L2:
//        return;
//        Exception exception;
//        exception;
//        if(true) goto _L2; else goto _L1
//_L1:
    }

    public void addActivity(Activity activity)
    {
        if(activityStack == null)
            activityStack = new Stack();
//        activityStack.add(activity);
    }

    public Activity currentActivity()
    {
        return (Activity)activityStack.lastElement();
    }

    public void finishActivity()
    {
        finishActivity((Activity)activityStack.lastElement());
    }

    public void finishActivity(Activity activity)
    {
        if(activity != null)
        {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    public void finishActivity(Class class1)
    {
        Iterator iterator = activityStack.iterator();
        do
        {
            Activity activity;
            do
            {
                if(!iterator.hasNext())
                    return;
                activity = (Activity)iterator.next();
            } while(!activity.getClass().equals(class1));
            finishActivity(activity);
        } while(true);
    }

    public void finishAllActivity()
    {
        int i = 0;
        int j = activityStack.size();
        do
        {
            if(i >= j)
            {
                activityStack.clear();
                return;
            }
            if(activityStack.get(i) != null)
                ((Activity)activityStack.get(i)).finish();
            i++;
        } while(true);
    }

    public void onCreate()
    {
        super.onCreate();
        singleton = this;
    }

    private static Stack activityStack;
    private static MyApplication singleton;
}
