/**
 *@author: assem.said2010@gmail.com
 *@Date: 17/4/2021
 */
package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Logs {
    public static String logPath = "";
    private Helper helper;

    public Logs() {
        helper = new Helper();
    }

    public void createLogFile() {
        logPath = "logs/Log " + helper.getCurrentDateTimeNoSeconds() + ".txt";
        try {
            File file = new File(logPath);
            if (file.createNewFile()) {
                System.out.println("Log file is created: " + file.getName() + " in the following path: " + logPath);
            } else {
                System.out.println("Log file already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the log file");
            e.printStackTrace();
        }
    }

    public void addLog(String logMessage) {
        String message = getCurrentDateTimeWithSeconds() + ": " + logMessage;
        try {
            FileWriter fileWriter = new FileWriter(logPath, true);
            fileWriter.write(message);
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing in the log file");
            e.printStackTrace();
        }
    }

    private String getCurrentDateTimeWithSeconds() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }

    public String getLogPath() {
        return logPath;
    }
}