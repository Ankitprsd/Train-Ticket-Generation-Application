package com.ticket.client;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

import com.ticket.dao.TrainDao;
import com.ticket.dao.TrainDaoImpl;
import com.ticket.model.Passenger;
import com.ticket.model.Ticket;
import com.ticket.model.Train;
import com.ticket.service.ITrainService;
import com.ticket.service.ITrainServiceImpl;

public class TicketGenerationApplication {

	static int counter = 100;

	public static void main(String[] args) {

		TrainDao trainDao = new TrainDaoImpl();
		ITrainService service = new ITrainServiceImpl();

		TreeMap<Passenger, Integer> passengersMap = new TreeMap<Passenger, Integer>();

		Ticket ticket = new Ticket();

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter The Train number ");
			int trainNo = scanner.nextInt();

			Train train = trainDao.findTrain(trainNo);

			System.out.println("Enter The number of Passengers ");
			int passengers = scanner.nextInt();

			double totalFare = 0;
			for (int i = 0; i < passengers; i++) {
				System.out.println("Enter the name of " + (i + 1) + " passenger");
				String name = scanner.nextLine();
				name = scanner.nextLine();

				System.out.println("Enter the age of " + name);
				int age = scanner.nextInt();

				System.out.println("Enter the gender (M/F) of " + name);
				char gender = scanner.next().charAt(0);

				System.out.println("Enter the travel date in this format (DD/MM/YYYY)");
				String date = scanner.next();
                
			
			LocalDate traveldate = LocalDate.now();
			System.out.println(date);
			
				String pnr=train.getSource().charAt(0)+""+train.getDestination().charAt(0)+""+date+"_"+counter;
				

				double fare = service.calculateFare(age, gender, train.getTicketPrice());
    
	
				ticket.addPassenger(name, age, gender,fare);

				totalFare += fare;

			}
			ticket.totalFarePrice(totalFare);
			ticket.generateTicket(train);
			

	

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
