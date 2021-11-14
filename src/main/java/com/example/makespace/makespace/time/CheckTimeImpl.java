package com.example.makespace.makespace.time;

import java.util.ArrayList;
import java.util.List;

public class CheckTimeImpl implements CheckTime {

	@Override
	public boolean checkTime(String startTime, String endTime)
	{
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
		 * startTime =  12:15 - > s1 = 12  s2 = 15
		 * endtime = 13:15
		 *
		 * */

		char [] charStartTime = startTime.toCharArray();
		char [] charEndTime = endTime.toCharArray();

		Integer hoursPartStartTime = Integer.valueOf(hoursParts(charStartTime));
		Integer minPartStartTime = Integer.valueOf(minsParts(charStartTime));

		Integer hoursPartEndTime = Integer.valueOf(hoursParts(charEndTime));;
		Integer minPartEndTime=Integer.valueOf(minsParts(charEndTime));

		boolean checkForTime = checkForTime(hoursPartStartTime,minPartStartTime, hoursPartEndTime,minPartEndTime);
		boolean checkForBufferTime = checkForBufferTime(hoursPartStartTime,minPartStartTime,hoursPartEndTime,minPartEndTime);
		boolean checkForTimeRestriction = checkForTimeRestriction(hoursPartStartTime,minPartStartTime,hoursPartEndTime,minPartEndTime);
		boolean checkForMinute = checkForMinute(minPartStartTime,minPartEndTime);
		if(checkForTime||checkForBufferTime||checkForTimeRestriction||checkForMinute)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	private boolean checkForTime(Integer hoursPartStartTime, Integer minPartStartTime ,Integer hoursPartEndTime , Integer minPartEndTime ) {
		if(hoursPartStartTime==hoursPartEndTime)
		{
			if(minPartEndTime<minPartStartTime)
			{
				return true;
			}
		}
		return hoursPartEndTime < hoursPartStartTime;
	}

	private String hoursParts(char[] charTime)
	{
		if (charTime.length == 0||charTime.length<2)
		{
			throw new RuntimeException("INCORRECT_INPUT");
		}
		else {
			String result = null;
			//add an exception to throw <incorrect input>
			StringBuilder hoursPart = new StringBuilder();
			hoursPart.append(charTime[0]);
			hoursPart.append(charTime[1]);
			result = hoursPart.toString();
			return result;
		}
	}

	private String minsParts(char[] charTime)
	{
		if (charTime.length == 0||charTime.length<2)
		{
			throw new RuntimeException("INCORRECT_INPUT");
		}
		else{
			StringBuilder minPart = new StringBuilder();
			minPart.append(charTime[3]);
			minPart.append(charTime[4]);
			String result = minPart.toString();
			return result;
		}
	}

	private boolean checkForBufferTime(int hs,int ms, int he, int me)
	{
		List<Integer> getbufferTime = getBufferTime();
		if(getbufferTime.contains(hs) || getbufferTime.contains(he))
			if(hs==9||he==9)
			{
				if((ms>=0)&&(me<15))
					return true;
			}
			if(hs==13||he==13)
			{
				if((ms>15)&&(me<45))
					return true;
			}
			if(hs==18||he==18)
			{
				return (ms > 45) && (me < 0);
			}
		return false;
	}
	private boolean checkForTimeRestriction(int hs,int ms, int he, int me)
	{
		return he > 23 || me > 45;
	}

	private boolean checkForMinute(int ms, int me)
	{
		List<Integer> getbufferTime = getMinuteTime();
		return !getbufferTime.contains(ms) && !getBufferTime().contains(me);
	}

	private List<Integer> getBufferTime() {
		List<Integer> bufferTime = new ArrayList<>();
		bufferTime.add(9);
		bufferTime.add(13);
		bufferTime.add(18);
		bufferTime.add(19);
		return  bufferTime;
	}

	private List<Integer> getMinuteTime() {
		List<Integer> bufferTime = new ArrayList<>();
		bufferTime.add(00);
		bufferTime.add(15);
		bufferTime.add(30);
		bufferTime.add(45);
		return  bufferTime;
	}
}
