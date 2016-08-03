package cn.itcast.david.test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import cn.com.david.model.Item;

/**
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
	}
	
}
