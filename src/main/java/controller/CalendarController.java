package controller;

import model.Event;
import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.property.*;
import utils.conf.ConfigHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author trafalgar
 */
public class CalendarController {

    private static final String calendarPath = ConfigHelper.getCalendarPath();
    private static File calendarFile;

    static {
        calendarFile = new File(calendarPath);
    }


    public void createCalendar() throws IOException{
        if (!calendarFile.exists()) {
            calendarFile.createNewFile();
        }
    }

    public void deleteCalendar() {
        if(calendarFile.exists()){
            calendarFile.delete();
        }
        return;
    }

    public void updateCalendar(Event event) throws IOException, ParserException {

        FileInputStream fin = new FileInputStream(calendarPath);
        CalendarBuilder builder = new CalendarBuilder();
        net.fortuna.ical4j.model.Calendar calendar = builder.build(fin);

        if (calendarFile.exists() && calendarFile.length() == 0) {
            calendar.getProperties().add(new ProdId("-//Events Calendar//iCal4j 1.0//EN"));
            calendar.getProperties().add(CalScale.GREGORIAN);
            calendar.getProperties().add(Version.VERSION_2_0);
        }

        calendar.getComponents().add(event.getActivity());

        FileOutputStream fileOutputStream = new FileOutputStream(calendarFile);
        CalendarOutputter outputter = new CalendarOutputter();
        outputter.output(calendar, fileOutputStream);
    }

    public void readCalendar() {

    }


}
