package SAX;

import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler2 extends DefaultHandler {
	private List<Contact> list=new  ArrayList<Contact>();

	private Contact contact;
	private String qName;
	public List<Contact> getlist()
	{
		return list;
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		this.qName=qName;
		if(qName.equals("contact"))
		{
			contact=new Contact();
			int len=attributes.getLength();
			for(int i=0;i<len;i++)
			{
				if("id".equals(attributes.getQName(i)))
				{
					contact.setId(attributes.getValue(i));
				}
			}
		}
		
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
			
			String text=new String(ch,start,length);
			if("name".equals(qName))
			{
				contact.setName(text);
			}else if("age".equals(qName))
			{
				contact.setAge(text);
				
			}else if("iphone".equals(qName))
			{
				contact.setIphone(text);
				
			}else if("email".equals(qName))
			{
				contact.setEmail(text);
				
			}else if("qq".equals(qName))
			{
				contact.setQq(text);
			}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		this.qName=null;
		if(qName.equals("contact"))
		{
			list.add(contact);
		}
	}
}
