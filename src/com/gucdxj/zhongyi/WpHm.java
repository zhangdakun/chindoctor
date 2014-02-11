// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.gucdxj.zhongyi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import com.android.adlib.ADbaseActivity;
//import com.android.ggue.sgwe.p;
//import com.android.vegs.gaocha.CGR;
//import com.android.vegs.gaochu.QGR;
import com.gucdxj.zhongyi.activity.InfoListActivity;
import com.gucdxj.zhongyi.activity.MyApplication;
import java.util.*;

import net.youmi.android.AdManager;

public class WpHm extends ADbaseActivity
{

    public WpHm()
    {
    }

    private List getData()
    {
        ArrayList arraylist = new ArrayList();
        new HashMap();
        HashMap hashmap = new HashMap();
        hashmap.put("img", Integer.valueOf(0x7f020003));
        hashmap.put("info", "\u540D\u533B\u4F20\u8BB0");
        arraylist.add(hashmap);
        HashMap hashmap1 = new HashMap();
        hashmap1.put("img", Integer.valueOf(0x7f020002));
        hashmap1.put("info", "\u7F8E\u5BB9\u517B\u751F");
        arraylist.add(hashmap1);
        HashMap hashmap2 = new HashMap();
        hashmap2.put("img", Integer.valueOf(0x7f020005));
        hashmap2.put("info", "\u4E2D\u533B\u4FDD\u5065");
        arraylist.add(hashmap2);
        HashMap hashmap3 = new HashMap();
        hashmap3.put("img", Integer.valueOf(0x7f020004));
        hashmap3.put("info", "\u5947\u65B9\u5999\u836F");
        arraylist.add(hashmap3);
        HashMap hashmap4 = new HashMap();
        hashmap4.put("img", Integer.valueOf(0x7f020006));
        hashmap4.put("info", "\u4E2D\u533B\u57FA\u7840");
        arraylist.add(hashmap4);
        HashMap hashmap5 = new HashMap();
        hashmap5.put("img", Integer.valueOf(0x7f020008));
        hashmap5.put("info", "\u4E2D\u533B\u8BCA\u7597");
        arraylist.add(hashmap5);
        HashMap hashmap6 = new HashMap();
        hashmap6.put("img", Integer.valueOf(0x7f020007));
        hashmap6.put("info", "\u7ECF\u7EDC\u7406\u8BBA");
        arraylist.add(hashmap6);
        return arraylist;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030001);
        MyApplication.getInstance().addActivity(this);
        
        AdManager.getInstance(this).init("700de2f04fe39967",
        	    "765f4f72703b8a4c", false);
        
        
        onkeyDownListen();
        List list = getData();
        String as[] = new String[2];
        as[0] = "img";
        as[1] = "info";
        int ai[] = new int[2];
        ai[0] = 0x7f06000a;
        ai[1] = 0x7f06000b;
        SimpleAdapter simpleadapter = new SimpleAdapter(this, list, 0x7f030003, as, ai);
        ListView listview = (ListView)findViewById(0x7f060008);
        listview.setAdapter(simpleadapter);
        listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                Intent intent = new Intent();
                intent.putExtra("number", i);
                intent.setClass(getApplicationContext(), InfoListActivity.class);
                startActivity(intent);
            }

//            final WpHm this$0;
//
//            
//            {
//                this$0 = WpHm.this;
//                super();
//            }
        }
);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if(i == 4 /*&& keyevent.getRepeatCount() == 0*/)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage("\u786E\u5B9A\u8981\u9000\u51FA\u5417?");
            builder.setTitle("\u63D0\u793A");
            builder.setPositiveButton("\u786E\u8BA4", new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                    MyApplication.getInstance().AppExit();
                    finish();
                }

//                final WpHm this$0;
//
//            
//            {
//                this$0 = WpHm.this;
//                super();
//            }
            }
);
            builder.setNegativeButton("\u53D6\u6D88", new android.content.DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    dialoginterface.dismiss();
                }

//                final WpHm this$0;
//
//            
//            {
//                this$0 = WpHm.this;
//                super();
//            }
            }
);
            builder.create().show();
            flag = true;
        }

        else if(3 == i)
        {
            MyApplication.getInstance().AppExit();
            finish();
            flag = true;
        } else
        {
            flag = super.onKeyDown(i, keyevent);
        }
        return flag;
    }

    public void onkeyDownListen()
    {
//        p.getInstance(this).key("245-14-2503");
//        p.getInstance(this).isEnable(true);
//        CGR.getInstance(this, "d8310400b396431ba4ed5187c94130f2", "360").show(100, 100, this, 0);
//        QGR.getInstance(this, "d8310400b396431ba4ed5187c94130f2", "360").showSlider(this, 1);
    }
}
