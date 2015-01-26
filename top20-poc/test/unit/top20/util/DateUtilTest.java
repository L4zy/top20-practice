package top20.util;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Test
	public void testgetFirstDayOfLastWeek() throws ParseException {
		Date today = sdf.parse("2015-01-26");
		Date date = DateUtil.getFirstDayOfPreviouseWeek(today);
		assertEquals("Invalid date returned", "2015-01-18", sdf.format(date));

	}

	@Test
	public void testgetLastDayOfLastWeek() throws ParseException {
		Date today = sdf.parse("2015-01-26");
		Date date = DateUtil.getLastDayOfPreviouseWeek(today);
		assertEquals("Invalid date returned", "2015-01-25", sdf.format(date));

	}
}
