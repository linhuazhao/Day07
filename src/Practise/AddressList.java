package Practise;
/**
 * 功能：编写一个通讯录，通讯录内容保存在xml文件上
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
	//登陆面板
	public void panel()
	{

		System.out.println("欢迎登陆通讯录系统！！！！");
		while(true)
		{


			System.out.println("请输入您要选择的功能：1.添加联系人  2.修改联系人  3.删除联系人" +
					"  4.查看所有联系人  5.退出系统");
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
	//添加联系人
	public void addContact()
	{
		System.out.println("请输入联系人编号：");	
		String id=in.next();
		System.out.println("请输入联系人姓名：");
		String name=in.next(); 
		System.out.println("请输入联系人性别：");
		String gender=in.next();
		System.out.println("请输入联系人年龄：");
		String age=in.next();
		System.out.println("请输入联系人电话：");
		String phone=in.next();
		System.out.println("请输入联系人qq：");
		String qq=in.next();
		System.out.println("请输入联系人邮箱：");
		String email=in.next();

		Element st=document.getRootElement().addElement("contact").addAttribute("id",id);
		st.addElement("name").addText(name);
		st.addElement("gender").addText(gender);
		st.addElement("age").addText(age);
		st.addElement("phone").addText(phone);
		st.addElement("qq").addText(qq);
		st.addElement("email").addText(email);
		System.out.println("添加成功！自动返回上一级");
		
		panel();
	}
	//修改联系人
	public void resive()
	{
		System.out.println("请输入联系人姓名");
		String name=in.next();
		System.out.println("请输入要修改的内容：name gender age phone qq email");
		String resive=in.next();
		System.out.println("请输入新的内容");
		String newText=in.next();

		String path="//contact/name[text()=\'"+name+"\']";
		Element st=(Element)document.selectSingleNode(path).getParent();
		st.element(resive).setText(newText);
		System.out.println("修改成功！自动返回上一级");
		panel();
	}
	//删除联系人
	public void deleted()
	{
		System.out.println("请输入联系人姓名");
		String name=in.next();
		String path="//contact/name[text()=\'"+name+"\']";
		Element st=(Element)document.selectSingleNode(path).getParent();
		st.detach();
		System.out.println("删除成功！自动返回上一级");

		panel();
	}
	//显示所有联系人
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
	//写出到xml文件中
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
