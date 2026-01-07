package com.test;
 
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
 
@Entity
@Table(name="player_1")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.JOINED)

//@DiscriminatorColumn(name="player_type",discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue(value="player")
public class Player {
 
	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	public Player() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
 
 
 