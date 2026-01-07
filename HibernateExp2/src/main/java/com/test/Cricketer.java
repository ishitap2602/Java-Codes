package com.test;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
//@DiscriminatorValue("cricketer")
@Table(name="cricketer")
public class Cricketer extends Player {
	private String type;
	private String jerseyNumber;
	
	@Override
	public String toString() {
		return "Cricketer [type=" + type + ", jerseyNumber=" + jerseyNumber + "]";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(String jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public Cricketer() {
		super();
	}
	public Cricketer(int id, String name, String type, String jerseyNumber) {
		super(id,name);
		
		this.type=type;
		this.jerseyNumber=jerseyNumber;
	}
	public Cricketer(int id, String name) {
		super(id, name);
	}
}
