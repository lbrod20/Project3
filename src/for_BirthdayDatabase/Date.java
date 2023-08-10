package for_BirthdayDatabase;

import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable{

	private Month month;
	private int day;
	private int year;
	
	public Date(Month theMonth, int theDay, int theYear) {
		if(!Month.isValidDay(theMonth, theDay) || theYear < 0) {
			throw new IllegalArgumentException();
		}else {
			month = theMonth;
			day = theDay;
			year = theYear;
		}
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		if(!Month.isValidDay(month, day)) {
			throw new IllegalArgumentException();
		}else {
			this.month = month;
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(!Month.isValidDay(month, day)) {
			throw new IllegalArgumentException();
		}else {
			this.day = day;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		
		if(year < 0) {
			throw new IllegalArgumentException();
		}else {
			this.year = year;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}

	@Override
	public String toString() {
		return month + " " + day + ", " + year;
	}


	
}
