package cn.com.david.model;

import cn.com.david.service.Comparable;

public class Employee implements Comparable {
	private double salary ;
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public Employee(double salary) {
		super();
		this.salary = salary;
	}

	@Override
	public int compareTo(Object other) {
		Employee otherObj = (Employee)other;
		return Double.compare(salary, otherObj.salary);
	}
public static void main(String[] args) {
	System.out.println(1%5);
}

}
