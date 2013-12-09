package com.uncc.gameday.alerts;

import com.uncc.gameday.R;
import com.uncc.gameday.activities.Home;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

public class Alert {
        
        private Long alarmDate;
        private String message;
        private int shown;
        private String type;
        
        // Default constructor
        public Alert(){}
        
        public Alert(Long alarmDate, String message, int shown, String type) {
                this.setAlarmDate(alarmDate);
                this.setMessage(message);
                this.setShown(shown);
                this.setType(type);
        }
        
        public void setType(String type) {
                this.type = type;
        }

        public String getType() {
                return type;
        }
        public Long getAlarmDate() {
                return alarmDate;
        }
        public void setAlarmDate(Long alarmDate) {
                this.alarmDate = alarmDate;
        }
        public String getMessage() {
                return message;
        }
        public void setMessage(String message) {
                this.message = message;
        }
        public int isShown() {
                return shown;
        }
        public void setShown(int i) {
                this.shown = i;
        }
        
        public String toString() {
                return this.message;
        }
        
        /**
         * Helper method to make displaying an alert on the statusbar easy
         *
         * @param ctx - The context needed to display the alert.
         */
        public void displayNotification(Context ctx) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle(ctx.getString(R.string.app_name))
                        .setContentText(this.getMessage());
                
                Intent resultIntent = new Intent(ctx, Home.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(ctx);
                stackBuilder.addParentStack(Home.class);
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent =        stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(resultPendingIntent);
                
                NotificationManager notificationManager = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, builder.setAutoCancel(true).build());
        }

}
