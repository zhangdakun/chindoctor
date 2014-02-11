// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.gucdxj.zhongyi.util;

import java.io.*;

public final class Util
{

    public Util()
    {
    }

    public static String getContent(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        stringbuilder = new StringBuilder();
        bufferedreader = null;
        BufferedReader bufferedreader1;
		try {
			bufferedreader = new BufferedReader(new InputStreamReader(inputstream, "GBK"));
			

			String s = bufferedreader.readLine();
			if(null !=s ) {
		        stringbuilder.append("        ");
		        stringbuilder.append(s);
		        stringbuilder.append("\n");
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			try {
				bufferedreader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return stringbuilder.toString();
//        bufferedreader = bufferedreader1;
//_L3:
//        String s = bufferedreader.readLine();
//        if(s != null) goto _L2; else goto _L1
//_L1:
//        bufferedreader.close();
//_L4:
//        return stringbuilder.toString();
//        UnsupportedEncodingException unsupportedencodingexception;
//        unsupportedencodingexception;
//        unsupportedencodingexception.printStackTrace();
//          goto _L3
//_L2:
//        stringbuilder.append("        ");
//        stringbuilder.append(s);
//        stringbuilder.append("\n");
//          goto _L3
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//          goto _L4
    }

    public static int getRaw(int i)
    {
        int j = 0x7f040000;
        if(i == 0) //goto _L2; else goto _L1
        	j = 0x7f040000;
//_L1:
//        return j;
//_L2:
        else if(i == 1)
            j = 0x7f040001;
        else
        if(i == 2)
            j = 0x7f040002;
        else
        if(i == 3)
            j = 0x7f040003;
        else
        if(i == 4)
            j = 0x7f040004;
        else
        if(i == 5)
            j = 0x7f040005;
        else
        if(i == 6)
            j = 0x7f040006;
//        if(true) goto _L1; else goto _L3
//_L3:
        return j;
    }
}
