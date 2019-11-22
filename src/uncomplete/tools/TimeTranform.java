package uncomplete.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTranform {

    public static void main(String[] args) {


        System.out.println(transferLongToDate("yyyy-MM-dd", 1557214594000l));
    }

    public static String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }
}
