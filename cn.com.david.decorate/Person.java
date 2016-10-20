
public class Person {
	private Integer id;
	private Integer currentSeq;
	private Person prePerson;
	private Person nextPerson;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCurrentSeq() {
		return currentSeq;
	}
	public void setCurrentSeq(Integer currentSeq) {
		this.currentSeq = currentSeq;
	}
	public Person getPrePerson() {
		return prePerson;
	}
	public void setPrePerson(Person prePerson) {
		this.prePerson = prePerson;
	}
	public Person getNextPerson() {
		return nextPerson;
	}
	public void setNextPerson(Person nextPerson) {
		this.nextPerson = nextPerson;
	}
	

}
