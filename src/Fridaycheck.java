import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fridaycheck {

	public static String checkForFriday(String string) throws ParseException {
		Date date=new SimpleDateFormat("yyyy-MM-dd").parse(string); 
		
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
        String s = simpleDateformat.format(date);
        String s1=  "Fr";
        String s2 = "Mo";
        String s3 = "Di";
        if (s.equals(s1)) {
        	return s1;
        }
        if (s.equals(s2)) {
        	return s2;
        }
        if (s.equals(s3)) {
        	return s3;
        }
		return "no Fr/Mo";
	}

}
