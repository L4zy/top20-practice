package top20.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getFirstDayOfLastWeek() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.WEEK_OF_YEAR, -1);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		return c.getTime();
	}

	public static Date getLastDayOfLastWeek() {
		Calendar c = Calendar.getInstance();
		c.setTime(getFirstDayOfLastWeek());
		c.add(Calendar.DATE, 6);
		return c.getTime();
	}
}
