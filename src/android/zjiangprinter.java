package com.webdone.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.UUID;
import android.widget.Toast;

public class zjiangprinter extends CordovaPlugin {
//    BluetoothService mService = null;
//    mService = new BluetoothService(this, null);

    private final BluetoothAdapter mAdapter;
    private int mState;

    public zjiangprinter ()
    {
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        this.mState = 0;
    }
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
        String errMsg = null;
        try {
            if( this.isAvailable() == false ){
                String message = "Bluetooth is NOT available";
            } else {
                String message = "Bluetooth is available";
            }

            callbackContext.success(message);

        } catch (Exception e) {
            errMsg = e.getMessage();
            callbackContext.error(errMsg);
        }
    }

    public boolean isAvailable(){
        if (this.mAdapter == null) {
            return false;
        }
        return true;
    }

//    private final  Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case BluetoothService.MESSAGE_STATE_CHANGE:
//                    switch (msg.arg1) {
//                        case BluetoothService.STATE_CONNECTED:   //������
//                            Toast.makeText(getApplicationContext(), "Connect successful",
//                                    Toast.LENGTH_SHORT).show();
//                            btnClose.setEnabled(true);
//                            btnSend.setEnabled(true);
//                            btnSendDraw.setEnabled(true);
//                            break;
//                        case BluetoothService.STATE_CONNECTING:  //��������
//                            Log.d("��������","��������.....");
//                            break;
//                        case BluetoothService.STATE_LISTEN:     //�������ӵĵ���
//                        case BluetoothService.STATE_NONE:
//                            Log.d("��������","�ȴ�����.....");
//                            break;
//                    }
//                    break;
//                case BluetoothService.MESSAGE_CONNECTION_LOST:    //�����ѶϿ�����
//                    Toast.makeText(getApplicationContext(), "Device connection was lost",
//                            Toast.LENGTH_SHORT).show();
//                    btnClose.setEnabled(false);
//                    btnSend.setEnabled(false);
//                    btnSendDraw.setEnabled(false);
//                    break;
//                case BluetoothService.MESSAGE_UNABLE_CONNECT:     //�޷������豸
//                    Toast.makeText(getApplicationContext(), "Unable to connect device",
//                            Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
//
//    };
}
