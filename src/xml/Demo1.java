package xml;
import org.dom4j.*;
import org.dom4j.io.*;

import java.io.*;
public class Demo1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Document doc=new SAXReader().read(new File("./src/firstxml.xml"));
		
		FileOutputStream out=new FileOutputStream("e:/contact.xml");
		XMLWriter writer=new XMLWriter(out);
		
		writer.write(doc);
		writer.close();
	}

}
