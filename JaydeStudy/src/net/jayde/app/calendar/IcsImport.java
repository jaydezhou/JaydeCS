package net.jayde.app.calendar;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.*;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;

import java.io.FileInputStream;
import java.io.IOException;

public class IcsImport {
    public static String filename = "C:\\Program Files (x86)\\ideaIU\\IdeaProjects\\日历MAC.ics";

    public static void main(String[] args) throws IOException, ParserException {
        FileInputStream fin = new FileInputStream(filename);

        CalendarBuilder builder = new CalendarBuilder();

        Calendar calendar = builder.build(fin);
//        calendar.validate();
        ComponentList<CalendarComponent> cl = calendar.getComponents(Component.VEVENT);
        for (CalendarComponent cc : cl) {
            System.out.println("------------------------" + cc.getName() + "--------------------------------");
            System.out.println(cc.getProperties());
            PropertyList<Property> pl = cc.getProperties();
//            for (Property p:pl) {
//                System.out.println("【"+p.getName()+"】"+p.getValue());
//            }
//            if(cc.getName().equals(Component.VEVENT)){
//                VEvent ce = (VEvent) cc;
//                System.out.println(cc);
//                System.out.println("\n\n");
//                System.out.println(ce);
//                System.out.println(ce.getSummary());
//
        }
    }
}
