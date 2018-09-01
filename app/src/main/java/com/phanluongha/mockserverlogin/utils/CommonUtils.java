package com.phanluongha.mockserverlogin.utils;

import android.text.TextUtils;

/**
 * Created by phanluongha on 3/14/18.
 */

public class CommonUtils {

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
