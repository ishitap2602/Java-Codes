package com.FileStream;

import java.io.Serializable;

public class PlayersData implements Serializable {
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	public String type;
	public transient String city;
	
	public PlayersData(int id, String name, String type, String city) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.city=city;
	}

	
	@Override
	public String toString() {
		return "PlayersData [id=" + id + ", name=" + name + ", type=" + type + ", city=" + city + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
