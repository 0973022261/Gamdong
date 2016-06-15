package com.example.inhm.gamdong;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
public class GamDong extends AppWidgetProvider {


    private static final String TAG = "GAMDONG";
    private Context context;

    private static final int requestCode = 0;

//    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
//                                int appWidgetId) {
//
//        CharSequence widgetText = "GAMDONG";
//        // Construct the RemoteViews object
//        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.gam_dong);
//        views.setTextViewText(R.id.button, widgetText);
//
//        // Instruct the widget manager to update the widget
//        appWidgetManager.updateAppWidget(appWidgetId, views);
//    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        Intent intent = new Intent(context,UpdateService.class);
        context.startActivity(intent);

        this.context = context;

        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for (int i=0; i<appWidgetIds.length;i++) {
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.gam_dong);
            appWidgetManager.updateAppWidget(appWidgetId,views);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        // Enter relevant functionality for when the last widget is disabled
    }

    public void initUI(Context context,AppWidgetManager appWidgetManager, int[] appWidgetIds) {


        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.gam_dong);

        Intent gamdongIntent = new Intent(Const.ACTION_GAMDONG);

        PendingIntent gamdongPIntent = PendingIntent.getBroadcast(context, requestCode, gamdongIntent, 0);

        views.setOnClickPendingIntent(R.id.button, gamdongPIntent);

        Toast.makeText(context,"hi",Toast.LENGTH_LONG).show();

        for (int appWidgetId : appWidgetIds) {
            appWidgetManager.updateAppWidget(appWidgetIds, views);
        }


    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
        super.onEnabled(context);
    }



    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context,intent);

        String action = intent.getAction();


        /** Default Recevier
         */
        if(AppWidgetManager.ACTION_APPWIDGET_ENABLED.equals(action)) {

        }
        else if(AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action)) {
            AppWidgetManager manager = AppWidgetManager.getInstance(context);
            initUI(context, manager, manager.getAppWidgetIds(new ComponentName(context, getClass())));
            //moveButton();
        }
        else if(AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(action)) {

        }
        else if(AppWidgetManager.ACTION_APPWIDGET_DISABLED.equals(action)) {

        }

        /**Custom Recevier
         */

        else if(Const.ACTION_GAMDONG.equals(action)) {
            callActivity(context);
        }
    }

    private void callActivity(Context context) {

        Intent intent = new Intent("com.example.inhm.ACTION_GAMDONG");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}


