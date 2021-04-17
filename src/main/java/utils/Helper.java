/**
 *@author: assem.said2010@gmail.com
 *@Date: 17/4/2021
 */
package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {


    public String getCurrentDateTimeNoSeconds() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH_mm a");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }
}
