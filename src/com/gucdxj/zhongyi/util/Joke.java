// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.gucdxj.zhongyi.util;


public class Joke
{

    public Joke()
    {
    }

    public Joke(int i, String s, String s1)
    {
        id = i;
        name = s;
        content = s1;
    }

    public String getContent()
    {
        return content;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setContent(String s)
    {
        content = s;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setName(String s)
    {
        name = s;
    }

    private String content;
    private int id;
    private String name;
}
