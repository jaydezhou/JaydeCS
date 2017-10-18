package net.jayde.app.calendar;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IcsImport {
    public static String filename = "C:\\Users\\zhouyj\\iCloudDrive\\文档集\\3.技术文档集\\3.1）个人项目\\日历MAC.ics";

    public static void main(String[] args) throws IOException, ParserException {
        FileInputStream fin = new FileInputStream(filename);

        CalendarBuilder builder = new CalendarBuilder();

        Calendar calendar = builder.build(fin);
    }
}
