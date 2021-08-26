package com.scheduletasktimer;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleTask extends TimerTask {
    public static void main(String[] args){
        TimerTask fetchMail = new ScheduleTask();
        // perform the task once a day at 4 a.m., starting tomorrow morning
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(fetchMail, getTomorrowMorning4am(), fONCE_PER_DAY);
    }

    @Override
    public void run() {
        System.out.println("doing");
    }
    private final static long fONCE_PER_DAY = 1000 * 60 * 60 * 24;

    private final static int fONE_DAY = 1;
    private final static int fFOUR_AM = 4;
    private final static int fZERO_MINUTES = 0;

    private static Date getTomorrowMorning4am() {
        Calendar tomorrow = new GregorianCalendar();
        tomorrow.add(Calendar.DATE, fONE_DAY);
        Calendar result = new GregorianCalendar(tomorrow.get(Calendar.YEAR),
                tomorrow.get(Calendar.MONTH), tomorrow.get(Calendar.DATE), fFOUR_AM,
                fZERO_MINUTES);
        return result.getTime();
    }
}
