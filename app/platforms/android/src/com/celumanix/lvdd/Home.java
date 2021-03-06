package com.celumanix.lvdd;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.util.Log;

public class Home extends CordovaPlugin {

    private static final String LOG_TAG = "HomePlugin";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("goHome".equals(action)) {
            try {               
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                this.cordova.getActivity().startActivity(i);

            } catch (Exception e) {
                Log.e(LOG_TAG, "Exception occurred: ".concat(e.getMessage()));
                return false;
            }
            callbackContext.success();
            return true;
        }
        Log.e(LOG_TAG, "Called invalid action: "+action);
        return false;  
    }
}