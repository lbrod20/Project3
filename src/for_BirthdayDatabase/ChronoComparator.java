package for_BirthdayDatabase;

import java.util.Comparator;

public class ChronoComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		Date o1D = o1.getDate();
		Date o2D = o2.getDate();
		
		if(Integer.compare(o1D.getYear(), o2D.getYear()) == 0) {
			if(Integer.compare(o1D.getMonth().getNum(), o2D.getMonth().getNum()) == 0) {
				return Integer.compare(o1D.getDay(), o2D.getDay());
			}else {
				return Integer.compare(o1D.getMonth().getNum(), o2D.getMonth().getNum());
			}
		}else {
			return Integer.compare(o1D.getYear(), o2D.getYear());
		}
	}

	
	
}
