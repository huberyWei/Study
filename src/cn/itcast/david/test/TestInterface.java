package cn.itcast.david.test;

import java.util.Calendar;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.Test;

import cn.com.david.model.Item;

/**
 * 
 * @author David
 *
 */
public class TestInterface {

	public static void main(String[] args) {

		String mobileDownloadLink = "https://www.baidu.com/s?kk";
		String padDownloadLink ="https://www.baidu.com/s?kk";
		String desktopDownloadLink ="https://www.baidu.com/s?kk";
		String mzParams ="mz_ca=2026530&mz_sp=71ZKY";
		if (!"#".equals(mobileDownloadLink) && !mobileDownloadLink.contains("?") && mobileDownloadLink.split("\\?").length==1) {
			mobileDownloadLink +=  "?" + mzParams;
		}else if (!"#".equals(mobileDownloadLink) &&  mobileDownloadLink.contains("?") && mobileDownloadLink.split("\\?").length==1) {
			mobileDownloadLink += mzParams;
		}else if (!"#".equals(mobileDownloadLink) && mobileDownloadLink.split("\\?").length>=2) {
			mobileDownloadLink +=  "&" + mzParams;
		}
		
		if (!"#".equals(padDownloadLink) && !padDownloadLink.contains("?") && padDownloadLink.split("\\?").length==1) {
			padDownloadLink +=  "?" + mzParams;
		}else if (!"#".equals(padDownloadLink) &&  padDownloadLink.contains("?") && padDownloadLink.split("\\?").length==1) {
			padDownloadLink += mzParams;
		}else if (!"#".equals(padDownloadLink) && padDownloadLink.split("\\?").length>=2) {
			padDownloadLink +=  "&" + mzParams;
		}
		
		if (!"#".equals(desktopDownloadLink) && !desktopDownloadLink.contains("?") && desktopDownloadLink.split("\\?").length==1) {
			desktopDownloadLink +=  "?" + mzParams;
		}else if (!"#".equals(desktopDownloadLink) &&  desktopDownloadLink.contains("?") && desktopDownloadLink.split("\\?").length==1) {
			desktopDownloadLink += mzParams;
		}else if (!"#".equals(desktopDownloadLink) && desktopDownloadLink.split("\\?").length>=2) {
			desktopDownloadLink +=  "&" + mzParams;
		}
		
		System.out.println("mobileDownloadLink  "+mobileDownloadLink);
		System.out.println("padDownloadLink  "+mobileDownloadLink);
		System.out.println("desktopDownloadLink  "+desktopDownloadLink);
	}
	
	@Test
	public void LinkedListTest(){
		List<String> aList = new LinkedList<>();
		aList.add("Amy");
		aList.add("Carl");
		aList.add("Erica");
		
		List<String> bList = new LinkedList<>();
		bList.add("Bob");
		bList.add("Doug");
		bList.add("Frances");
		bList.add("Gloria");
		
		ListIterator<String> aIterator = aList.listIterator();
		Iterator<String> bIterator = bList.iterator();
		while (bIterator.hasNext()) {
			if (aIterator.hasNext()) {
				aIterator.next();
			}
			aIterator.add(bIterator.next());
			
		}
		System.out.println(aList);
		
		bIterator = bList.iterator();
		while (bIterator.hasNext()) {
			bIterator.next();
			if (bIterator.hasNext()) {
				bIterator.next();
				bIterator.remove();
			}
			
		}
		System.out.println(bList);
		
		aList.removeAll(bList);
		System.out.println(aList);
		System.out.println("------顺序 --------");
		aIterator = aList.listIterator();
		while (aIterator.hasNext()) {
			String aContent = aIterator.next();
			System.out.println(aContent);
		}
		System.out.println("------逆序---------");
		while (aIterator.hasPrevious()) {
			String aContent = aIterator.previous();
			System.out.println(aContent);
		}
	}
	
	@Test
	public void VectorTest(){
		Vector<String> vector =  new Vector<>();
		vector.add("A");
		vector.add("C");
		vector.add("D");
		vector.add("B");
		System.out.println(vector);
	}
	
	@Test
	public void treeSetTest(){
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("Widget", 4562));
		parts.add(new Item("Modem", 2912));
		System.out.println(parts);
		
		SortedSet<Item> sortByDescription = new TreeSet<>(
				new Comparator<Item>() {
					@Override
					public int compare(Item a, Item b) {
						String descA = a.getDescription();
						String descB = b.getDescription();
						return descA.compareTo(descB);
					}
				});
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
		System.out.println(sortByDescription.first());
		System.out.println(sortByDescription.last());
	}
	
	@Test
	public void priorityQueueTest(){
		PriorityQueue<GregorianCalendar> pqCalendars = new PriorityQueue<>();
		pqCalendars.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
		pqCalendars.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10));
		pqCalendars.add(new GregorianCalendar(1903, Calendar.DECEMBER, 2));
		pqCalendars.add(new GregorianCalendar(1910, Calendar.JUNE, 22));
		System.out.println("Iterationg over elements....");
		for (GregorianCalendar dateCalendar : pqCalendars) {
			System.out.println(dateCalendar.get(Calendar.YEAR));
		}
		
		System.out.println("removing elements...");
		while (!pqCalendars.isEmpty()) {
			System.out.println(pqCalendars.remove().get(Calendar.YEAR));
			
		}
	}
	class Employee{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Employee(String name) {
			super();
			this.name = name;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + "]";
		}
		
		
	}
	@Test
	public void mapTest(){
		/*
		Set<String> set = new HashSet<>();
		set.add(null);
		set.add("s");
		int count = 0;
		for (String s : set) {
			count++;
		}
		System.out.println(count);
		*/
		Map<String, Employee> staff = new HashMap<String, TestInterface.Employee>();
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hacker"));
		staff.put("157-62-7935", new Employee("Gary Cooper"));
		staff.put("456-62-5527", new Employee("Francesca Cruz"));
		
		System.out.println(staff);
		
		staff.remove("567-24-2546");
		staff.put("456-62-5527", new Employee("Francesca Miller"));
		System.out.println(staff.get("157-62-7935"));
		staff.put(null, null);
		staff.put(null, null);
		for (Map.Entry<String, Employee> entry:staff.entrySet()) {
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key = " + key +", value = " + value);
		}

		
	}
	enum Weekday{MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY};
	@Test
	public void enumTest(){
		EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
		EnumSet<Weekday> never = EnumSet.noneOf(Weekday.class);
		EnumSet<Weekday> workday = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
		EnumSet<Weekday> mwf = EnumSet.of(Weekday.MONDAY,Weekday.WEDNESDAY,Weekday.FRIDAY);
		System.out.println(always);
		System.out.println(never);
		System.out.println(workday);
		System.out.println(mwf);
	}
	
	@Test
	public void test(){
//		AbstractSet<String> abstractSet = new HashSet<>();
//		abstractSet.add("hello");
//		abstractSet.add("world");
//		System.out.println(abstractSet);
	}
}
