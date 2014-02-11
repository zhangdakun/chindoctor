// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.gucdxj.zhongyi.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.android.adlib.ADbaseActivity;
import com.android.myappzhongyi.R;
import com.gucdxj.zhongyi.util.*;
import java.util.ArrayList;
import java.util.List;

import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;

// Referenced classes of package com.gucdxj.zhongyi.activity:
//            MyApplication, InfoListActivity

public class ContentActivity extends ADbaseActivity
{

    public ContentActivity()
    {
    }

    public void onAttachedToWindow()
    {
        getWindow().setType(2004);
        super.onAttachedToWindow();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        RelativeLayout adLayout = (RelativeLayout) findViewById(R.id.adLayout);
        AdView adView = new AdView(this, AdSize.FIT_SCREEN);
        adLayout.addView(adView);
        
        MyApplication.getInstance().addActivity(this);
        Intent intent = getIntent();
        number = intent.getIntExtra("number", 0);
        countNumber = intent.getIntExtra("id", 0);
        java.io.InputStream inputstream = getResources().openRawResource(Util.getRaw(number));
        Button button;
        Button button1;
        Button button2;
        final ScrollView scroll;
        final TextView textContent;
        final TextView textTitle;
        try
        {
            listJoke = SaxReadxml.readXml(inputstream);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        button = (Button)findViewById(0x7f060006);
        button1 = (Button)findViewById(0x7f060005);
        button2 = (Button)findViewById(0x7f060007);
        scroll = (ScrollView)findViewById(0x7f060000);
        textContent = (TextView)findViewById(0x7f060003);
        textTitle = (TextView)findViewById(0x7f060002);
        textTitle.setText(((Joke)listJoke.get(countNumber)).getName());
        textContent.setText(((Joke)listJoke.get(countNumber)).getContent());
        button.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
//                Intent intent1 = new Intent();
//                intent1.putExtra("number", ContentActivity.number);
//                intent1.setClass(getApplicationContext(), InfoListActivity.class);
//                startActivity(intent1);
            	finish();
            }

//            final ContentActivity this$0;
//
//            
//            {
//                this$0 = ContentActivity.this;
//                super();
//            }
        }
);
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                if(ContentActivity.countNumber == 0)
                {
                    Toast.makeText(getApplicationContext(), "\u60A8\u597D\uFF0C\u73B0\u5728\u662F\u7B2C\u4E00\u7BC7", 0).show();
                } else
                {
                    ContentActivity.countNumber = -1 + ContentActivity.countNumber;
                    textTitle.setText(((Joke)ContentActivity.listJoke.get(ContentActivity.countNumber)).getName());
                    textContent.setText(((Joke)ContentActivity.listJoke.get(ContentActivity.countNumber)).getContent());
                    scroll.scrollTo(0, 0);
                }
            }

//            final ContentActivity this$0;
//            private final ScrollView val$scroll;
//            private final TextView val$textContent;
//            private final TextView val$textTitle;
//
//            
//            {
//                this$0 = ContentActivity.this;
//                textTitle = textview;
//                textContent = textview1;
//                scroll = scrollview;
//                super();
//            }
        }
);
        button2.setOnClickListener(new android.view.View.OnClickListener() {

            public void onClick(View view)
            {
                if(ContentActivity.countNumber == -1 + ContentActivity.listJoke.size())
                {
                    Toast.makeText(getApplicationContext(), "\u60A8\u597D\uFF0C\u5DF2\u7ECF\u662F\u6700\u540E\u4E00\u7BC7\u4E86", 0).show();
                } else
                {
                    ContentActivity.countNumber = 1 + ContentActivity.countNumber;
                    textTitle.setText(((Joke)ContentActivity.listJoke.get(ContentActivity.countNumber)).getName());
                    textContent.setText(((Joke)ContentActivity.listJoke.get(ContentActivity.countNumber)).getContent());
                    scroll.scrollTo(0, 0);
                }
            }

//            final ContentActivity this$0;
//            private final ScrollView val$scroll;
//            private final TextView val$textContent;
//            private final TextView val$textTitle;
//
//            
//            {
//                this$0 = ContentActivity.this;
//                textTitle = textview;
//                textContent = textview1;
//                scroll = scrollview;
//                super();
//            }
        }
);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if(i==3 || i==4) {
        	finish();
        	flag=true;
        }else
        if(i == 4 && keyevent.getRepeatCount() == 0)
        {
            finish();
            Intent intent = new Intent();
            intent.setClass(getApplicationContext(), InfoListActivity.class);
            startActivity(intent);
            flag = super.onKeyDown(i, keyevent);
        } else
        if(3 == i)
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

    private static int countNumber = 0;
    private static List listJoke = new ArrayList();
    private static int number = 0;





}
