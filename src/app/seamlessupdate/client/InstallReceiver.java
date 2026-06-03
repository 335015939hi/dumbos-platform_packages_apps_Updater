package app.seamlessupdate.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;

public class InstallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, final Intent intent) {
        final ConnectivityManager connectivityManager =
                context.getSystemService(ConnectivityManager.class);
        final Network network = connectivityManager.getActiveNetwork();
        final Intent service = new Intent(context, Service.class);
        service.putExtra(Service.INTENT_EXTRA_NETWORK, network);
        service.putExtra(Service.INTENT_EXTRA_USER_REQUESTED_INSTALL, true);
        service.putExtra(Service.INTENT_EXTRA_IS_USER_INITIATED, true);
        context.startForegroundService(service);
    }
}
