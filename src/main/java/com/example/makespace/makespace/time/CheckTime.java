package com.example.makespace.makespace.time;

public interface CheckTime 
{
	public boolean checkTime(String startTime, String endTime);
	
	/*
	 * The conditions required by the program for timing.
	 * 
	 * The startTime and endTime should not be in buffer time
	 * 
	 * endtime>startTime
	 * 
	 * The startTime and endTime should always be in the form of HH:MM
	 * 
	 * MM should be multiples of 15 like 15 , 30 , 45 , 00
	 * 
	 * HH - > [00,23]
	 * MM - > [00,45]
	 * 
	 * */
}
