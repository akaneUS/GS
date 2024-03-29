package com.example.sleepapp_v1;


import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;


public class EveningAlarm extends Activity {
	  private static final int mId = 44;

	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    NotificationCompat.Builder mBuilder =
	            new NotificationCompat.Builder(this)
	            .setSmallIcon(R.drawable.ic_launcher)
	            .setContentTitle("Evening Questionnaire")
	            .setContentText("Time to take the evening questionnaire!");
	    Intent resultIntent = new Intent(this, EveningQuestionnaire.class);

	    // The stack builder object will contain an artificial back stack for the
	    // started Activity.
	    // This ensures that navigating backward from the Activity leads out of
	    // your application to the Home screen.
	    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
	    // Adds the back stack for the Intent (but not the Intent itself)
	    stackBuilder.addParentStack(MainActivity.class);
	    // Adds the Intent that starts the Activity to the top of the stack
	    stackBuilder.addNextIntent(resultIntent);
	    PendingIntent resultPendingIntent =
	            stackBuilder.getPendingIntent(
	                0,
	                PendingIntent.FLAG_UPDATE_CURRENT
	            );
	    mBuilder.setContentIntent(resultPendingIntent);
	    NotificationManager mNotificationManager =
	        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	    // mId allows you to update the notification later on.
	    mNotificationManager.notify(mId, mBuilder.build());
	  }

	
	  
	} 