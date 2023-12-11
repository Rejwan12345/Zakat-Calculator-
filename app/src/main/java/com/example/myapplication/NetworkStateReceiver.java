package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class NetworkStateReceiver extends BroadcastReceiver {

    private final String TAG = "NetworkStateReceiver";
    protected final List<NetworkStateReceiverListener> listeners;
    protected Boolean connected;

    public NetworkStateReceiver() {
        listeners = new ArrayList<>();
        connected = null;
    }

    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Intent broadcast received");
        if (intent == null || intent.getExtras() == null) return;

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
        } else if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, Boolean.FALSE)) {    //Boolean that indicates whether there is a complete lack of connectivity
            connected = false;
        }

        notifyStateToAll();
    }

    private void notifyStateToAll() {
        Log.i(TAG, "Notifying state to " + listeners.size() + " listener(s)");
        for (NetworkStateReceiverListener eachNetworkStateReceiverListener : listeners)
            notifyState(eachNetworkStateReceiverListener);
    }

    private void notifyState(NetworkStateReceiverListener networkStateReceiverListener) {
        if (connected == null || networkStateReceiverListener == null) return;

        if (connected) {
            networkStateReceiverListener.networkAvailable();
        } else {
            networkStateReceiverListener.networkUnavailable();
        }
    }

    public void addListener(NetworkStateReceiverListener networkStateReceiverListener) {
        Log.i(TAG, "addListener() - listeners.add(networkStateReceiverListener) + notifyState(networkStateReceiverListener);");
        listeners.add(networkStateReceiverListener);
        notifyState(networkStateReceiverListener);
    }

// --Commented out by Inspection START (১১/১২/২৩ ৪:২০ PM):
//    public void removeListener(NetworkStateReceiverListener networkStateReceiverListener) {
//        listeners.remove(networkStateReceiverListener);
//    }
// --Commented out by Inspection STOP (১১/১২/২৩ ৪:২০ PM)

    public interface NetworkStateReceiverListener {
        void networkAvailable();

        void networkUnavailable();
    }
}