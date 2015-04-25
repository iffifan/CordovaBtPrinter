package com.webdone.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;


import android.widget.Toast;

import com.zj.btsdk.BluetoothService;


public class zjiangprinter extends CordovaPlugin {
    BluetoothService mService = null;

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("list")) {

            list(callbackContext);
            return true;

        } else {
            
            return false;

        }
    }

    void list(CallbackContext callbackContext) {
        mService = new BluetoothService(CallbackContext, null);
        String errMsg = null;
        try {
            if( mService.isAvailable() == false ){
                Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "Bluetooth is available", Toast.LENGTH_LONG).show();

            }
            String message = mService.isAvailable();
            callbackContext.success(message);

        } catch (Exception e) {
            errMsg = e.getMessage();
            callbackContext.error(errMsg);
        }
    }
}
