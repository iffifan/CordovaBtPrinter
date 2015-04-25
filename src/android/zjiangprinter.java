package com.webdone.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class zjiangprinter extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("list")) {

            listBT(callbackContext);
            return true;

        } else {
            
            return false;

        }
    }

    void listBT(CallbackContext callbackContext) {

        try {
            String message = "Hello, Worldy";
            callbackContext.success(message);

        } catch (Exception e) {
            errMsg = e.getMessage();
            Log.e(LOG_TAG, errMsg);
            callbackContext.error(errMsg);
        }
    }
}
