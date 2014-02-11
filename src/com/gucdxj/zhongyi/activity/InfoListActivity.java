// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.gucdxj.zhongyi.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.android.adlib.AD;
import com.android.adlib.ADbaseActivity;
import com.android.myappzhongyi.R;
import com.gucdxj.zhongyi.WpHm;
import com.gucdxj.zhongyi.util.*;
import java.util.*;

import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;

// Referenced classes of package com.gucdxj.zhongyi.activity:
//            MyApplication, ContentActivity

public class InfoListActivity extends ADbaseActivity
{

    public InfoListActivity()
    {
    }

    private List getData(int i)
    {
        ArrayList arraylist = null;
        java.io.InputStream inputstream;
        arraylist = new ArrayList();
        inputstream = getResources().openRawResource(Util.getRaw(i));
        int j = 0;
        try {
			listJoke = SaxReadxml.readXml(inputstream);
			for (j=0;j<listJoke.size();j++) {
		        Joke joke = (Joke)listJoke.get(j);
		        HashMap hashmap = new HashMap();
		        hashmap.put("img", Integer.valueOf(0x7f02000c));
		        hashmap.put("info", joke.getName());
		        arraylist.add(hashmap);	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        j = 0;
//_L1:
//        if(j >= listJoke.size())
//            break MISSING_BLOCK_LABEL_122;
//        Joke joke = (Joke)listJoke.get(j);
//        HashMap hashmap = new HashMap();
//        hashmap.put("img", Integer.valueOf(0x7f02000c));
//        hashmap.put("info", joke.getName());
//        arraylist.add(hashmap);
//        j++;
//          goto _L1
//        Exception exception;
//        exception;
//        exception.printStackTrace();
        return arraylist;
        
        
    }

    private String getTitle(int i)
    {
        String s;
        if(i == 0)
            s = "\u4E2D\u533B\u5B9D\u5178\uFF1A\u540D\u533B\u4F20\u8BB0";
        else
        if(i == 1)
            s = "\u4E2D\u533B\u5B9D\u5178\uFF1A\u7F8E\u5BB9\u517B\u751F";
        else
        if(i == 2)
            s = "\u4E2D\u533B\u5B9D\u5178\uFF1A\u4E2D\u533B\u4FDD\u5065";
        else
        if(i == 3)
            s = "\u4E2D\u533B\u5B9D\u5178\uFF1A\u5947\u65B9\u5999\u836F";
        else
        if(i == 4)
            s = "\u4E2D\u533B\u5B9D\u5178\uFF1A\u4E2D\u533B\u57FA\u7840";
        else
        if(i == 5)
            s = "\u4E2D\u533B\u5B9D\u5178\uFF1A\u4E2D\u533B\u8BCA\u7597";
        else
        if(i == 6)
            s = "\u4E2D\u533B\u5B9D\u5178\uFF1A\u7ECF\u7EDC\u7406\u8BBA";
        else
            s = "\u4E2D\u533B\u5B9D\u5178";
        return s;
    }

    public void onAttachedToWindow()
    {
        getWindow().setType(2004);
        super.onAttachedToWindow();
    }
private Context context;
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030002);
        MyApplication.getInstance().addActivity(this);
        
        RelativeLayout adLayout = (RelativeLayout) findViewById(R.id.adLayout);
        AdView adView = new AdView(this, AdSize.FIT_SCREEN);
        adLayout.addView(adView);
        
        context = this;
        Button button = (Button)findViewById(0x7f060005);
        Button button1 = (Button)findViewById(0x7f060007);
        Button button2 = (Button)findViewById(0x7f060006);
        final ListView view = (ListView)findViewById(0x7f060009);
        number = getIntent().getIntExtra("number", 0);
        List list = getData(number);
        String as[] = new String[2];
        as[0] = "img";
        as[1] = "info";
        int ai[] = new int[2];
        ai[0] = 0x7f06000a;
        ai[1] = 0x7f06000b;
        view.setAdapter(new SimpleAdapter(this, list, 0x7f030003, as, ai));
        view.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
            	if(i>18) {
            		if(!AD.i().haveOffers(context)) {
            			return;
            		}
            	}
                Intent intent = new Intent();
                intent.putExtra("id", i);
                intent.putExtra("number", InfoListActivity.number);
                intent.setClass(getApplicationContext(), ContentActivity.class);
                startActivity(intent);
            }

//            final InfoListActivity this$0;
//
//            
//            {
//                this$0 = InfoListActivity.this;
//                super();
//            }
        }
);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view1)
            {
                if(InfoListActivity.number == 0)
                {
                    Toast.makeText(getApplicationContext(), "\u60A8\u597D\uFF0C\u73B0\u5728\u5DF2\u7ECF\u662F\u7B2C\u4E00\u90E8\u5206\u4E86", 0).show();
                } else
                {
                    InfoListActivity.number = -1 + InfoListActivity.number;
                    android.content.Context context = getApplicationContext();
                    List list1 = getData(InfoListActivity.number);
                    String as1[] = new String[2];
                    as1[0] = "img";
                    as1[1] = "info";
                    int ai1[] = new int[2];
                    ai1[0] = 0x7f06000a;
                    ai1[1] = 0x7f06000b;
                    SimpleAdapter simpleadapter = new SimpleAdapter(context, list1, 0x7f030003, as1, ai1);
                    view.setAdapter(simpleadapter);
                }
                setTitle(getTitle(InfoListActivity.number));
            }

//            final InfoListActivity this$0;
//            private final ListView val$view;
//
//            
//            {
//                this$0 = InfoListActivity.this;
//                view = listview;
//                super();
//            }
        }
);
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view1)
            {
                if(InfoListActivity.number == 6)
                {
                    Toast.makeText(getApplicationContext(), "\u60A8\u597D\uFF0C\u73B0\u5728\u5DF2\u7ECF\u662F\u6700\u540E\u4E00\u90E8\u5206\u4E86", 0).show();
                } else
                {
                    InfoListActivity.number = 1 + InfoListActivity.number;
                    android.content.Context context = getApplicationContext();
                    List list1 = getData(InfoListActivity.number);
                    String as1[] = new String[2];
                    as1[0] = "img";
                    as1[1] = "info";
                    int ai1[] = new int[2];
                    ai1[0] = 0x7f06000a;
                    ai1[1] = 0x7f06000b;
                    SimpleAdapter simpleadapter = new SimpleAdapter(context, list1, 0x7f030003, as1, ai1);
                    view.setAdapter(simpleadapter);
                }
                setTitle(getTitle(InfoListActivity.number));
            }

//            final InfoListActivity this$0;
//            private final ListView val$view;
//
//            
//            {
//                this$0 = InfoListActivity.this;
//                view = listview;
//                super();
//            }
        }
);
        button2.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view1)
            {
//                Intent intent = new Intent();
//                intent.setClass(getApplicationContext(), WpHm.class);
//                startActivity(intent);
            	finish();
            }

//            final InfoListActivity this$0;
//
//            
//            {
//                this$0 = InfoListActivity.this;
//                super();
//            }
        }
);
        setTitle(getTitle(number));
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag;
        if(i==3 || i==4) {
        	finish();
        	flag = true;
        }else 
        if(i == 4 && keyevent.getRepeatCount() == 0)
        {
            finish();
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), WpHm.class);
            startActivity(intent);
            flag = super.onKeyDown(i, keyevent);
        } else
        if(3 == i)
        {
            MyApplication.getInstance().AppExit();
            flag = true;
        } else
        {
            flag = super.onKeyDown(i, keyevent);
        }
        return flag;
    }

    private static List listJoke;
    private static int number = 0;





}
