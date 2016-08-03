package cn.com.david.model;

import java.util.Objects;

public class Item implements Comparable<Item>{
	
	private String description;
	private int partNumer;
	
	public Item(String description, int partNumer) {
		this.description = description;
		this.partNumer = partNumer;
	}

	public String getDescription() {
		return description;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + partNumer;
		return result;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass())
			return false;
		Item other = (Item) otherObject;
		return Objects.equals(description, other.description) && partNumer == other.partNumer;
	}

	@Override
	public String toString() {
		return "Item [description=" + description + ", partNumer=" + partNumer
				+ "]";
	}

	@Override
	public int compareTo(Item other) {
		return Integer.compare(partNumer, other.partNumer);
	}

}
