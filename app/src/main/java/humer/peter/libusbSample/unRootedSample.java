package humer.peter.libusbSample;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface unRootedSample extends Library {
    public static final unRootedSample INSTANCE = Native.load("unrooted_android", unRootedSample.class);
    public int unrooted_usb_description (int fileDescriptor);
}
