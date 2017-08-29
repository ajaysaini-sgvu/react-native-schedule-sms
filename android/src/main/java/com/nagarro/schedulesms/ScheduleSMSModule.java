package com.nagarro.schedulesms;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleSMSModule extends ReactContextBaseJavaModule {

    private Context context;

    public ScheduleSMSModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    @Override
    public String getName() {
        return "Scheduler";
    }

    @ReactMethod
    public void sendMessage(String receiptNumber, String message, String dateTime) {
        try {
            //Thu Aug 31 02:00:00 2017
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
            Date date = simpleDateFormat.parse(dateTime);
            long timeMills = date.getTime();

            Intent intent = new Intent(context, SMSDispatcherBroadcastReceiver.class);
            intent.putExtra("receiptNumber", receiptNumber);
            intent.putExtra("message", message);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 234, intent, 0);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

            if (Build.VERSION.SDK_INT >= 23) {
                // Wakes up the device in Doze Mode
                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, timeMills, pendingIntent);
            } else if (Build.VERSION.SDK_INT >= 19) {
                // Wakes up the device in Idle Mode
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeMills, pendingIntent);
            } else {
                // Old APIs
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeMills, pendingIntent);
            }
        } catch (Exception e) {
            Log.e(getClass().getName(), e.getMessage());
        }
    }
}
