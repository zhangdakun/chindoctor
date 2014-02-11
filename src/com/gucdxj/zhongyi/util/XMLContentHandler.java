// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.gucdxj.zhongyi.util;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// Referenced classes of package com.gucdxj.zhongyi.util:
//            Joke

public class XMLContentHandler extends DefaultHandler
{

    public XMLContentHandler()
    {
        sb = new StringBuffer();
    }

    public void characters(char ac[], int i, int j)
        throws SAXException
    {
        sb.append(ac, i, j);
    }

    public void endElement(String s, String s1, String s2)
        throws SAXException
    {
//        if(joke == null) goto _L2; else goto _L1
//_L1:
//        String s3 = sb.toString();
//        if(!"name".equals(tempString)) goto _L4; else goto _L3
//_L3:
//        joke.setName(s3);
//_L2:
//        if("joke".equals(s1) && joke != null)
//        {
//            jokes.add(joke);
//            joke = null;
//        }
//        tempString = null;
//        return;
//_L4:
//        if("content".equals(tempString))
//            joke.setContent(s3);
//        if(true) goto _L2; else goto _L5
//_L5:
    	if(null == joke) {

          tempString = null; 		
    	}else {
    		String s3 = sb.toString();
    		if(!"name".equals(tempString)) {
    	        if("content".equals(tempString))
    	        	joke.setContent(s3);
    		} else {
    			joke.setName(s3);
    		}
    		
          if("joke".equals(s1) && joke != null)
          {
              jokes.add(joke);
              joke = null;
          }
          tempString = null;
    	}
    }

    public List getJokes()
    {
        return jokes;
    }

    public void startDocument()
        throws SAXException
    {
        jokes = new ArrayList();
    }

    public void startElement(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        sb.delete(0, sb.length());
        if("joke".equals(s1))
        {
            joke = new Joke();
            joke.setId((new Integer(attributes.getValue("id"))).intValue());
        }
        tempString = s1;
    }

    private static final String CONTENTSTRING = "content";
    private static final String IDSTRING = "id";
    private static final String JOKESTRING = "joke";
    private static final String NAMESTRING = "name";
    private Joke joke;
    private List jokes;
    StringBuffer sb;
    private String tempString;
}
