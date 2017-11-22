package com.danirg10000gmail.weatherapp.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by dr9874 on 22/11/2017.
 */

public class DialogUtils {

    public static void showAlertDialog(Context context, String title , String message)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        // Alert dialog button
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> {
                    // Alert dialog action goes here
                    // onClick button code here
                    dialog.dismiss();// use dismiss to cancel alert dialog
                });
        alertDialog.show();
    }
}
