package com.showcal.push.android;


import com.showcal.push.AndroidNotification;

public class AndroidUnicast extends AndroidNotification {
    public AndroidUnicast() {
        try {
            this.setPredefinedKeyValue("type", "unicast");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}