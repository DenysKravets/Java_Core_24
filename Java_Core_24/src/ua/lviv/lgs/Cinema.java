package ua.lviv.lgs;

import java.lang.reflect.*;
import java.util.*;
import java.util.Map.*;

public class Cinema 
{

	public TreeMap<Days, Schedule> schedules = new TreeMap<>();
	ArrayList<Movie> movieLibrary = new ArrayList<>();
	
	Time open;
	Time close;
	
	Cinema()
	{
		Field[] fields = Days.class.getFields();
		
		for(Field field: fields)
		{
			schedules.put(Days.valueOf(field.getName()), new Schedule());
		}
	}
	
	public void addMovie(Movie movie)
	{
		movieLibrary.add(movie);
	}
	
	public void addSceance(Seance seance, String string)
	{
		string = string.toUpperCase();
		Days day = Days.valueOf(string);
		schedules.entrySet().stream().filter(b -> b.getKey().equals(day)).findFirst().get().getValue().addSeance(seance);
	}
	
	public void removeMovie(Movie movie)
	{
		/*
		movieLibrary.remove(movie);
		schedules.entrySet().stream().forEach(b -> b.getValue().getSeances().stream().forEach(a -> {
			if(a.getMovie().equals(movie))
				b.getValue().removeSeance(a);
		}));
		*/
		
		movieLibrary.remove(movie);
		
		Schedule scheduleToRemoveFrom = null;
		Seance seanceToRemove = null;
		
		Iterator<Entry<Days, Schedule>> interator1 = schedules.entrySet().iterator();
		while(interator1.hasNext())
		{
			Entry<Days, Schedule> entry = interator1.next();
			
			Iterator<Seance> iterator2 = entry.getValue().getSeances().iterator();
			while(iterator2.hasNext())
			{
				Seance seance = iterator2.next();
				
				if(seance.getMovie().equals(movie))
				{
					scheduleToRemoveFrom = entry.getValue();
					seanceToRemove = seance;
				}
			}
		}
		
		scheduleToRemoveFrom.removeSeance(seanceToRemove);
	}
	
	public void removeSeance(Seance seance, String string)
	{
		/*
		string = string.toUpperCase();
		Days day = Days.valueOf(string);
		schedules.entrySet().stream().forEach(b -> b.getValue().getSeances().stream().forEach(a -> {
			if(a.equals(seance) && b.getKey().equals(day))
				b.getValue().removeSeance(a);
		}));
		*/
		Schedule scheduleToRemoveFrom = null;
		Seance seanceToRemove = null;
		
		string = string.toUpperCase();
		Days day = Days.valueOf(string);
		
		Iterator<Entry<Days, Schedule>> interator1 = schedules.entrySet().iterator();
		while(interator1.hasNext())
		{
			Entry<Days, Schedule> entry = interator1.next();
			
			Iterator<Seance> iterator2 = entry.getValue().getSeances().iterator();
			while(iterator2.hasNext())
			{
				Seance seanceInner = iterator2.next();
				
				if(seanceInner.equals(seance) && entry.getKey().equals(day))
				{
					scheduleToRemoveFrom = entry.getValue();
					seanceToRemove = seanceInner;
				}	
			}
			
		}
		
		scheduleToRemoveFrom.removeSeance(seanceToRemove);
	}

	@Override
	public String toString() {
		
		StringBuilder returnString = new StringBuilder();
		
		for(Entry<Days, Schedule> entry: schedules.entrySet())
		{
			returnString.append("\n\n" + entry.getKey() + entry.getValue().toString());
		}
			
		
		return returnString.toString();
	}
	
	
	
}
