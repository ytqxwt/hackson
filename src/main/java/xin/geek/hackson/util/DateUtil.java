package xin.geek.hackson.util;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DateUtil {

    public static Date stringToDate(String str_date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return (Date) sdf.parse(str_date);
    }

}
