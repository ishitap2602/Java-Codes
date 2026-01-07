package com.test;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@DiscriminatorValue("Tennis_Player")
@Table(name="Tennis_Player")

public class TennisPlayer extends Player {
	private int noOfMathes;
	private int wonMatches;
	
	public TennisPlayer() {
		super();
	}
	public TennisPlayer(int id, String name) {
		super(id, name);
	}
	public TennisPlayer(int id, String name, int noOfMatches, int wonMatches) {
		super(id, name);
		
		this.noOfMathes=noOfMatches;
		this.wonMatches=wonMatches;
	}
	@Override
	public String toString() {
		return "TennisPlayer [noOfMathes=" + noOfMathes + ", wonMatches=" + wonMatches + "]";
	}
	public int getNoOfMathes() {
		return noOfMathes;
	}
	public void setNoOfMathes(int noOfMathes) {
		this.noOfMathes = noOfMathes;
	}
	public int getWonMatches() {
		return wonMatches;
	}
	public void setWonMatches(int wonMatches) {
		this.wonMatches = wonMatches;
	}
}
