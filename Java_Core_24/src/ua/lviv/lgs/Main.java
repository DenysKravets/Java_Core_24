package ua.lviv.lgs;

import java.util.Scanner;

public class Main
{
	
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws java.util.ConcurrentModificationException
	{

		Cinema cinema = new Cinema();
		
		int decision;
		
		boolean key = true;
		while(key)
		{
			System.out.println("\nWelcome to the Cinema."
					+ "\nto add a seance enter 1"
					+ "\nto remove a seance enter 2"
					+ "\nto remove a movie enter 3"
					+ "\nto see the schedule enter 4"
					+ "\nto stop the program enter 0");
			
			decision = scan.nextInt();
			
			switch(decision)
			{
			case 1:
			{
				addSeance(cinema);
				break;
			}
			case 2:
			{
				removeSeance(cinema);
				break;
			}
			case 3:
			{
				removeMovie(cinema);
				break;
			}
			case 4:
			{
				System.out.println(cinema);
				break;
			}
			case 0:
			{
				key = false;
				System.out.println("Program closed");
				break;
			}
			
			}
		}
		
		closeScanner();
	}
	
	private static void closeScanner()
	{
		scan.close();
	}
	
	private static Seance makeSeance()
	{
		System.out.println("Enter time: ");
		System.out.println("hours");
		int timeHours = scan.nextInt();
		System.out.println("minutes");
		int timeMin = scan.nextInt();
		System.out.println("Enter duration: ");
		System.out.println("hours");
		int durationsHours = scan.nextInt();
		System.out.println("minutes");
		int durationMin = scan.nextInt();
		System.out.println("Enter name of the movie: ");
		String name = scan.next();
		
		return new Seance(new Movie(name, new Time(durationsHours, durationMin)), new Time(timeHours, timeMin));
	}
	
	private static Movie makeMovie()
	{
		System.out.println("Enter duration: ");
		System.out.println("hours");
		int durationsHours = scan.nextInt();
		System.out.println("minutes");
		int durationMin = scan.nextInt();
		System.out.println("Enter name of the movie: ");
		String name = scan.next();
		
		return new Movie(name, new Time(durationsHours, durationMin));
	}
	
	private static Days makeDay()
	{
		System.out.println("Enter day of the week: ");
		String dayString = scan.next();
		dayString = dayString.toUpperCase();
		
		return Days.valueOf(dayString);
	}
	
	private static void addSeance(Cinema cinema)
	{
		System.out.println("Adding a seance");
		Days day = makeDay();
		cinema.addSceance(makeSeance(), day.name());
	}
	
	private static void removeSeance(Cinema cinema)
	{
		System.out.println("Removing a seance");
		Days day = makeDay();
		cinema.removeSeance(makeSeance(), day.name());
	}
	
	private static void removeMovie(Cinema cinema)
	{
		System.out.println("Removing a movie");
		cinema.removeMovie(makeMovie());
	}

}
