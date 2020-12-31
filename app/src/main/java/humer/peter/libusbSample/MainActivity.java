package humer.peter.libusbSample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private UsbManager usbManager;
    private UsbDevice usbDevice;
    private UsbDeviceConnection usbDeviceConnection;

    private static final String ACTION_USB_PERMISSION = "humer.uvc_camera.USB_PERMISSION";


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("usb1.0");
        System.loadLibrary("unRootedAndroid");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);

        usbManager = (UsbManager) getSystemService(Context.USB_SERVICE);




    }

    public void log(String msg) {
        Log.i("Libusb_Sample", msg);
    }

    public void findDevice (View v) {

        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        log("USB devices count = " + deviceList.size());
        for (UsbDevice usbDevice : deviceList.values()) {
            log("USB device \"" + usbDevice.getDeviceName() + "\": " + usbDevice);

            PendingIntent permissionIntent = PendingIntent.getBroadcast(this, 0, new Intent(ACTION_USB_PERMISSION), 0);
            // IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);
            // registerReceiver(mUsbReceiver, filter);
            usbManager.requestPermission(usbDevice, permissionIntent);


            this.usbDevice = usbDevice;


        }
    }

    public void JNA (View v) {

        usbDeviceConnection = usbManager.openDevice(usbDevice);
        unRootedSample.INSTANCE.main(usbDeviceConnection.getFileDescriptor());

    }


        /**
         * A native method that is implemented by the 'native-lib' native library,
         * which is packaged with this application.
         */
    //public native String stringFromJNI();
}