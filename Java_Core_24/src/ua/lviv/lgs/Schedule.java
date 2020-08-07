package ua.lviv.lgs;

import java.util.*;

public class Schedule 
{

	Set<Seance> seances = new TreeSet<>(new SeanceComparator());
	
	public void addSeance(Seance seance)
	{
		seances.add(seance);
	}
	
	public void removeSeance(Seance seance)
	{
		seances.remove(seance);
	}

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	@Override
	public String toString() {
		
		StringBuilder returnString = new StringBuilder();
		
		for(Seance seance: seances)
		{
			returnString.append("\n---" + seance.toString());
		}
		
		return returnString.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seances == null) ? 0 : seances.hashCode());
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
		Schedule other = (Schedule) obj;
		if (seances == null) {
			if (other.seances != null)
				return false;
		} else if (!seances.equals(other.seances))
			return false;
		return true;
	}
	
	
	
	
	
}

class SeanceComparator implements Comparator<Seance>
{

	@Override
	public int compare(Seance arg0, Seance arg1) 
	{
		int min1 = arg0.getStartTime().getMin() + arg0.getStartTime().getHours() * Time.minMax;
		int min2 = arg1.getStartTime().getMin() + arg1.getStartTime().getHours() * Time.minMax;
		
		if(min1 > min2)
		{
			return 1;
		}
		
		if(min1 < min2)
		{
			return -1;
		}
		
		return arg0.getMovie().getTitle().compareTo(arg1.getMovie().getTitle());
	}


	
	
}