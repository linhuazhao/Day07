package SAX;

public class Contact {
	private String id;
	private String age;
	private String name;
	private String qq;
	private String email;
	private String iphone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", age=" + age + ", name=" + name
				+ ", qq=" + qq + ", email=" + email + ", iphone=" + iphone
				+ "]";
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIphone() {
		return iphone;
	}
	public void setIphone(String iphone) {
		this.iphone = iphone;
	}
	
}
