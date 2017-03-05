package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler extends DefaultHandler {
	private StringBuffer sb=new StringBuffer();
	
	public String getsb()
	{
		return sb.toString();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		sb.append("<"+qName);
		if(attributes!=null)
		{
			for(int i=0;i<attributes.getLength();i++)
			{
				String name=attributes.getQName(i);
				
				String value=attributes.getValue(i);
				sb.append(" "+name+"=\""+value+"\"");
				
			}
		}
		
		sb.append(">");
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		String text=new String(ch,start,length);
		sb.append(text);
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		sb.append("</"+qName+">");
	}
}
