package xml;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.*;
import org.dom4j.io.*;
import java.io.*;
public class Demo3 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Document doc=DocumentHelper.createDocument();
		
		Element rootelem=doc.addElement("contactList");
		
		Element contactelem=rootelem.addElement("contact");
		contactelem.addAttribute("id", "001");
		
		Element name=contactelem.addElement("name").addText("�ֻ���");
		name.detach();
		
		//Document document=new SAXReader().read(new File("./src/firstxml.xml"));
		FileOutputStream out =new FileOutputStream("e:/contact.xml");
		//1.ָ��д���ĸ�ʽ
		OutputFormat format=OutputFormat.createCompactFormat();
		//OutputFormat format2=OutputFormat.createPrettyPrint();
		//2.ָ�����������ɵı�����ʹ�����ֱ������
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		
		writer.write(doc);
		writer.close();
	}

}
