package com.example.atmMachine;
import java.util.Random;
import java.util.UUID;

public class User {
	private int uuid;
	
	private String name;

	public User(String name) {
		this.uuid = new Random().nextInt(100);
		this.name = name;
	}
	
}
