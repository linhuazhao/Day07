package Practise;
/**
 * ���ܣ���дһ��ͨѶ¼��ͨѶ¼���ݱ�����xml�ļ���
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
public class AddressList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		address address=new address();
		address.panel();
	}

}
class address
{
	private Document document=null;
	private Scanner in=new Scanner(System.in);
	public address()
	{
		File file=new File("e:/student.xml");
		if(!file.exists())
		{

			document=DocumentHelper.createDocument();
			Element rootelem=document.addElement("ContactList");
		}else
		{
			try {
				document=new SAXReader().read(file);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//��½���
	public void panel()
	{

		System.out.println("��ӭ��½ͨѶ¼ϵͳ��������");
		while(true)
		{


			System.out.println("��������Ҫѡ��Ĺ��ܣ�1.�����ϵ��  2.�޸���ϵ��  3.ɾ����ϵ��" +
					"  4.�鿴������ϵ��  5.�˳�ϵͳ");
			String input=in.next();
			if("1".equals(input))
			{
				addContact();
			}else if("2".equals(input))
			{
				resive();
			}else if("3".equals(input))
			{
				deleted();
			}else if("4".equals(input))
			{
				showAllcontact();
			}else if("5".equals(input))
			{
				System.exit(0);
			}
			output();
		}
	}
	//�����ϵ��
	public void addContact()
	{
		System.out.println("��������ϵ�˱�ţ�");	
		String id=in.next();
		System.out.println("��������ϵ��������");
		String name=in.next(); 
		System.out.println("��������ϵ���Ա�");
		String gender=in.next();
		System.out.println("��������ϵ�����䣺");
		String age=in.next();
		System.out.println("��������ϵ�˵绰��");
		String phone=in.next();
		System.out.println("��������ϵ��qq��");
		String qq=in.next();
		System.out.println("��������ϵ�����䣺");
		String email=in.next();

		Element st=document.getRootElement().addElement("contact").addAttribute("id",id);
		st.addElement("name").addText(name);
		st.addElement("gender").addText(gender);
		st.addElement("age").addText(age);
		st.addElement("phone").addText(phone);
		st.addElement("qq").addText(qq);
		st.addElement("email").addText(email);
		System.out.println("��ӳɹ����Զ�������һ��");
		
		panel();
	}
	//�޸���ϵ��
	public void resive()
	{
		System.out.println("��������ϵ������");
		String name=in.next();
		System.out.println("������Ҫ�޸ĵ����ݣ�name gender age phone qq email");
		String resive=in.next();
		System.out.println("�������µ�����");
		String newText=in.next();

		String path="//contact/name[text()=\'"+name+"\']";
		Element st=(Element)document.selectSingleNode(path).getParent();
		st.element(resive).setText(newText);
		System.out.println("�޸ĳɹ����Զ�������һ��");
		panel();
	}
	//ɾ����ϵ��
	public void deleted()
	{
		System.out.println("��������ϵ������");
		String name=in.next();
		String path="//contact/name[text()=\'"+name+"\']";
		Element st=(Element)document.selectSingleNode(path).getParent();
		st.detach();
		System.out.println("ɾ���ɹ����Զ�������һ��");

		panel();
	}
	//��ʾ������ϵ��
	public void showAllcontact()
	{
		SAXReader reader=new SAXReader();
		Document document1 = null;
		File file=new File("e:/student.xml");
		if(!file.isFile())
		{
			output();
		}
		try {
			document1 = reader.read(new File("e:/student.xml"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Contact> list=new ArrayList<Contact>();
		Iterator<Element> it=document1.getRootElement().elementIterator();
		while(it.hasNext())
		{
			Element elem=it.next();
			Contact contact=new Contact();
			contact.setId(elem.attributeValue("id"));
			contact.setAge(elem.elementText("age"));
			contact.setEmail(elem.elementText("email"));
			contact.setPhone(elem.elementText("phone"));
			contact.setName(elem.elementText("name"));
			contact.setQq(elem.elementText("qq"));
			contact.setGender(elem.elementText("gender"));
			list.add(contact);
		}

		for(Contact contact:list)
		{
			System.out.println(contact);
		}
	}
	//д����xml�ļ���
	public void output()
	{
		OutputFormat format=OutputFormat.createPrettyPrint();
		try {
			FileOutputStream outputStream =new FileOutputStream("e:/student.xml");
			XMLWriter writer=new XMLWriter(outputStream,format);

			writer.write(document);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
