// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.gucdxj.zhongyi.util;

import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

// Referenced classes of package com.gucdxj.zhongyi.util:
//            XMLContentHandler

public class SaxReadxml
{

    public SaxReadxml()
    {
    }

    public static List readXml(InputStream inputstream)
        throws Exception
    {
        SAXParser saxparser = SAXParserFactory.newInstance().newSAXParser();
        XMLContentHandler xmlcontenthandler = new XMLContentHandler();
        saxparser.parse(inputstream, xmlcontenthandler);
        return xmlcontenthandler.getJokes();
    }
}
