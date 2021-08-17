package com.ticket.service;


public interface ITrainService {
	String calculatePnr(String source,String destination,String travelDate,int counter);
	
	double calculateFare(int age, char gender, double ticketPrice);
}