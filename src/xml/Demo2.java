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
		//1.指定写出的格式
		OutputFormat format=OutputFormat.createCompactFormat();
		OutputFormat format2=OutputFormat.createPrettyPrint();
		//2.指定保存与生成的编码是使用哪种编码规则
		format.setEncoding("utf-8");
		
		XMLWriter writer=new XMLWriter(out,format);
		
		writer.write(document);
		writer.close();
		
		
	}

}
