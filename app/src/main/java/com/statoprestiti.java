package com;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by elisaboninella on 20/06/18.
 */

public class statoprestiti {
    public class DemotimerActivity extends Activity {
        /**
         * Called when the activity is first created.
         */
        TextView tv;
        long diff;
        long oldLong;
        long NewLong;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            tv = new TextView(this);
            this.setContentView(tv);
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
            String oldTime = "19.02.2018, 12:00";//Timer date 1
            String NewTime = "20.02.2018, 14:00";//Timer date 2
            Date oldDate, newDate;
            try {
                oldDate = formatter.parse(oldTime);
                newDate = formatter.parse(NewTime);
                oldLong = oldDate.getTime();
                NewLong = newDate.getTime();
                diff = NewLong - oldLong;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //MyCount counter = new MyCount(diff, 1000);
            //counter.start();
        }

    }
}
