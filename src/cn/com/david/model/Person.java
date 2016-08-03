package cn.com.david.model;

import javax.swing.Timer;


public class Person implements Cloneable{
	private String name;
	private String sex;
	private User user = new User(20000);
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Person() {
		super();
	}

	public Person(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}
	
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", user salary=" + user.getSalary() + "]";
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Person original = new Person("david", "nan");
		System.out.println(original);
		Person copy = (Person) original.clone();
		copy.setName("json");
		User user = new User(30000);
		copy.setUser(user);
		System.out.println(original);
		System.out.println(copy);
	}
	
}
