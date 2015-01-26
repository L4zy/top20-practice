package top20.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getFirstDayOfPreviouseWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.WEEK_OF_YEAR, -1);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		return c.getTime();
	}

	public static Date getLastDayOfPreviouseWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(getFirstDayOfPreviouseWeek(date));
		c.add(Calendar.DATE, 7);
		return c.getTime();
	}
}
