package SAX;

import java.io.File;

import javax.xml.parsers.*;



/*
 * ��ȡxml�ļ�����������ĵ�������
 * 
 */
public class Demo1 {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, Exception {
		// TODO Auto-generated method stub
		
		SAXParser parser=SAXParserFactory.newInstance().newSAXParser();
		
		MyDefaultHandler handeler=new MyDefaultHandler();
		parser.parse(new File("./src/firstxml.xml"), handeler);
		System.out.println(handeler.getsb());
	}

}
