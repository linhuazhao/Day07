package xml;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Demo4 {
	static Document document;
	public static void main(String[] args) throws Exception
	{
		//����һ��xml�ļ�
		creatdocument();
		//����ѧ��id���޸�����
		reviseid("2","����");
		//����ѧ��id��ɾ����ѧ��
		//deleted("2");
		OutputFormat format=OutputFormat.createPrettyPrint();
		FileOutputStream outputStream =new FileOutputStream("e:/student.xml");
		XMLWriter writer=new XMLWriter(outputStream,format);

		writer.write(document);
		writer.close();
	}



	public static void creatdocument() throws IOException
	{

		document=DocumentHelper.createDocument();
		Element rootelem=document.addElement("Students");

		Element st1=rootelem.addElement("Student").addAttribute("id", "1");
		st1.addElement("name").addText("����");
		st1.addElement("gender").addText("��");
		st1.addElement("grade").addText("�����1��");
		st1.addElement("address").addText("�������");

		Element st2=rootelem.addElement("Student").addAttribute("id", "2");
		st2.addElement("name").addText("����");
		st2.addElement("gender").addText("Ů");
		st2.addElement("grade").addText("�����2��");
		st2.addElement("address").addText("����Խ��");


	}
	public static void reviseid(String id,String name)
	{
		
//		List<Element> list=document.getRootElement().elements("Student");
//		for(Element st:list)
//		{
//			if(st.attributeValue("id")==id)
//			{	
//				st.element("name").setText(name);
//				break;
//			}
//		}
		String path="//Student[@id=\'"+id+"\']/name";
		Element st=(Element)document.selectSingleNode(path);
		st.setText(name);
		
	}
	private static void deleted(String id) {
		//ʹ��document���ķ�����ɾ��
//		List<Element> list=document.getRootElement().elements("Student");
//		String st1=document.getRootElement().element("Student").attributeValue("id");
//		for(Element st:list)
//		{
//			if(st.attributeValue("id")==id)
//				st.detach();
//		}

		
		
		//ʹ��xpath����ɾ��
				Element stuelem=(Element)document.selectSingleNode("//Student[@id='2']");
				
				stuelem.detach();
	}
} 
