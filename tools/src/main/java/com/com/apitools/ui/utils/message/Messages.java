package com.com.apitools.ui.utils.message;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {

    private static final String         BUNDLE_NAME     = "org.joy.util.messgae.messages";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private Messages(){
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    public static String getString(String key, String parm1) {
        try {
            return MessageFormat.format(RESOURCE_BUNDLE.getString(key), new Object[] { parm1 });
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    public static String getString(String key, String parm1, String parm2) {
        try {
            return MessageFormat.format(RESOURCE_BUNDLE.getString(key), new Object[] { parm1, parm2 });
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    public static String getString(String key, String parm1, String parm2, String parm3) {
        try {
            return MessageFormat.format(RESOURCE_BUNDLE.getString(key), new Object[] { parm1, parm2, parm3 });
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
