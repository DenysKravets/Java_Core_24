package ua.lviv.lgs;

public class Time 
{
	
	private int min;
	private int hours;
	
	final static int minMin = 0;
	final static int minMax = 60;
	
	final static int hoursMin = 0;
	final static int hoursMax = 24;
	
	public Time(int hours, int min) 
	{
		super();
		this.min = min;
		this.hours = hours;
	}
	
	public Time addTime(Time time)
	{
		int min;
		int hours;
		
		min = this.min + time.getMin();
		hours = this.hours + time.getHours();
		
		if(min > minMax)
		{
			hours += min / minMax;
			min = (int) (minMax * (((double) min / (double) minMax) - (double) (min / minMax) ));
		}
		
		if(hours > hoursMax)
		{
			System.out.println(hours + " is too many hours");
			return null;
		}
		
		return new Time(hours, min);
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return this.hours + ":" + this.min;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hours;
		result = prime * result + min;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hours != other.hours)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	

	
	
	
	
}
