package com.webdone.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.widget.Toast;

public class zjiangprinter extends CordovaPlugin {
//    BluetoothService mService = null;
//    mService = new BluetoothService(this, null);

    private final BluetoothAdapter mAdapter;
    this.mAdapter = BluetoothAdapter.getDefaultAdapter();
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
                Toast.makeText(this, "Bluetooth is not available", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "Bluetooth is available", Toast.LENGTH_LONG).show();

            }
            String message = this.isAvailable();
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
