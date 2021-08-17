package com.ticket.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ITrainServiceImpl implements ITrainService {

	@Override
	public String calculatePnr(String source, String destination, String travelDate, int counter) {
		// TODO Auto-generated method stub

		String pnr = Character.toString(source.charAt(0));
		pnr = Character.toString(destination.charAt(0));
	
		pnr = String.valueOf(counter);
         // System.out.println(source+" from service");

		return pnr;
	}

	@Override
	public double calculateFare(int age, char gender, double ticketPrice) {

		if (age <= 12)
			return ticketPrice / 2;
		else if (age >= 60)
			return ticketPrice * 0.6;
		else if (gender == 'F' || gender == 'f')
			return ticketPrice * 0.75;
		else
			return ticketPrice;

	}

	
}