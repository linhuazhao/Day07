package SAX;

import java.io.File;

import javax.xml.parsers.*;



/*
 * 读取xml文件，完整输出文档的内容
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
