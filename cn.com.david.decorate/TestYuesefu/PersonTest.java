package TestYuesefu;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;


public class PersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		List<Person> listPersons = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			Person person = new Person();
			person.setId(new Integer(i));
			listPersons.add(person);
		}
		for (int i = 0; i < listPersons.size(); i++) {
			Person person = listPersons.get(i);
			Person personNext = listPersons.get(i+1);
		}
		
	}

}
