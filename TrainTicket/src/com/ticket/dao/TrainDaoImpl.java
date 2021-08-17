package com.ticket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ticket.model.Train;

public class TrainDaoImpl implements TrainDao {

	@Override
	public Train findTrain(int trainNo) {


		try {
			Train train=null;
			Class.forName(TrainDao.DRIVER_NAME);
			System.out.println("class loaded");
			Connection con = DriverManager.getConnection(TrainDao.URL,TrainDao.USERNAME,TrainDao.PASSWARD);
			System.out.println("Connected");
			PreparedStatement ps = con.prepareStatement("select * from trains where trainNo =?");
			ps.setInt(1, trainNo);
			ResultSet rs =ps.executeQuery();
			
		
			
			while(rs.next())
			{
				
				train = new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
				
				
			}
			
			
			return train;
			
			
		}catch(Exception err)
		{
			System.out.println(err);
		}
		
		return null;
	}

	
}
