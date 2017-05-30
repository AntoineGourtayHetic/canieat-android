package com.hetic.antoinegourtay.canieat;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
/**
 * Created by antoinegourtay on 30/05/2017.
 */

public class CanIEatApp extends Application {

    private RequestQueue requestQueue;

    // Singleton
    private static CanIEatApp sharedInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        // On assigne notre singleton au démarrage
        CanIEatApp.sharedInstance = this;

        // 1 queue par application (pour l'exemple ici)
        // mais possibilité d'en avoir plusieurs
        requestQueue = Volley.newRequestQueue(this);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static CanIEatApp getSharedInstance() {
        return sharedInstance;
    }


}
