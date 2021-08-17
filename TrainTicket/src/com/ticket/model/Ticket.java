package com.ticket.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Ticket {

	private static int counter;
	private String pnr;
	private String travelDate;
	private Train train;
	private Map<Passenger, Integer> passengers = new HashMap<Passenger, Integer>();
    private double totalFare;


	String generatePNR() {
		return "";
	}

	double calculatePassengerFare(Passenger passenger) {
		return 0.0;
	}

	public void addPassenger(String name, int age, char gender, double fare) {
		Passenger passenger = new Passenger(name, age, gender,fare);
		this.passengers.put(passenger, this.counter);
	}

	double calculateTotalTicketPrice() {
		return 0.0;
	}

	public void writeTicket() {

	}

	public static int getCount() {
		return counter;
	}

	public static void setCount(int count) {
		Ticket.counter = count;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}


	public void totalFarePrice(double totalFare) {
		// TODO Auto-generated method stub
		this.totalFare=totalFare;
		
	}
	
	
	public void generateTicket(Train trainDetails) throws IOException {
		FileWriter writer = new FileWriter("PNR_ticket.txt");
		BufferedWriter buffer = new BufferedWriter(writer);

		String LineOne = "PNR           : " + getPnr();
		String LineTwo = "Train no      : " + trainDetails.getTrainNo();
		String LineThree ="Train name   : " + trainDetails.getTrainName();
		String LineFour = "\nFrom       : " + trainDetails.getSource();
		String LineFive = "To           : " + trainDetails.getDestination();
		String LineSix ="Travel Date    : "+this.travelDate;
		String LineSeven ="\n\nPassengers  ";
		
		buffer.newLine();
		
		String LineEight="Name		Age		Gender		Fare  ";
		buffer.newLine();
		String LineNine ="";
		for(Entry<Passenger, Integer>  p:passengers.entrySet())
		{
			LineNine=LineNine+p.getKey().getName()+"	"+p.getKey().getAge()+"			"+p.getKey().getGender()+"			"+p.getKey().getFare()+"\n";
		}
		
		
		
		buffer.write(LineOne + "\n" + LineTwo + "\n" + LineThree + "\n" + LineFour +
				"\n" + LineFive+"\n"+LineSix+"\n"+LineSeven+"\n"+LineEight+"\n"+LineNine+"\nTotal Fare : "+totalFare);

		buffer.close();
		System.out.println("==========Success Generated Ticket==========");
	}

	

}