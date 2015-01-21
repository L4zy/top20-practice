package top20.util;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

	
	
	@Test
	public void testgetFirstDayOfLastWeek(){
		Date date= DateUtil.getFirstDayOfLastWeek();
		
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date);
		//first day of the week
		Assert.assertEquals(1, calendar.get(Calendar.DAY_OF_WEEK));
		
		//test is last week
		Assert.assertEquals(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - 1, calendar.get(Calendar.WEEK_OF_YEAR));
		
	}
	
	
	@Test
	public void testgetLastDayOfLastWeek(){
		
		Date date= DateUtil.getLastDayOfLastWeek();
		
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(date);
		
		//last day of the week
		Assert.assertEquals(7, calendar.get(Calendar.DAY_OF_WEEK));
		//test is last week
		Assert.assertEquals(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR) - 1, calendar.get(Calendar.WEEK_OF_YEAR));
		
	}
}
