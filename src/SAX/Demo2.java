package SAX;

import java.io.File;

import javax.xml.parsers.*;

import org.dom4j.*;
import org.dom4j.io.*;
import org.xml.sax.SAXException;


public class Demo2 {
	public static void main(String[] args) throws Exception, SAXException
	{
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		
		MyDefaultHandler2 handler=new MyDefaultHandler2(); 
		parser.parse(new File("./src/firstxml.xml"), handler);
		System.out.println(handler.getlist());
	}
}
