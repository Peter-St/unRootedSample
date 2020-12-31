/*
 *  libusb example program for reading out the usb device specifications for unRooted Android Devices based of testlibusb.c
 *  Copyright 2019 Peter Stoiber
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *  Please contact the author if you need another license.
 *  This Repository is provided "as is", without warranties of any kind.
*/

/*
 * Todo:
 * First you have to connect your Usb Device from the Java side.
 * Use the android.hardware.usb class for finding the USB Device, claiming the interfaces and open the UsbDeviceConnection.
 * Obtain the native File Descriptor --> UsbDeviceConnection.getFileDescriptor()
 * Pass the received int Value to one of the two "extern Methods" at the bottom of this code (first one over JNI, second one over JNA)
 */


#include <jni.h>
#include <string>
#ifdef __ANDROID__
#include <android/log.h>
#define  LOG_TAG    "LibUsb"
#define  LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#endif

