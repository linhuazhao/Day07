package xml;
import org.dom4j.*;
import org.dom4j.io.*;

import java.io.*;
public class Demo2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Document document=new SAXReader().read(new File("./src/firstxml.xml"));
		FileOutputStream out =new FileOutputStream("e:/contact.xml");
		//1.ָ��д���ĸ�ʽ
		OutputFormat format=OutputFormat.createCompactFormat();
		OutputFormat format2=OutputFormat.createPrettyPrint();
		//2.ָ�����������ɵı�����ʹ�����ֱ������
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		
		writer.write(document);
		writer.close();
		
		
	}

}
