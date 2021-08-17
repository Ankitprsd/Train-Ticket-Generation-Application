package com.ticket.model;

public class Passenger {

	private String name;
	private int age;
	private char gender;
	private double fare;
	public Passenger(String name, int age, char gender, double fare) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.fare=fare;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public double getFare() {
		return fare;
	}
	
	
}