package fabiorosario.ime.pgsc.broadcastchangewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

public class WifiChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            if (wifiManager.isWifiEnabled()) {
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ssid = wifiInfo.getSSID();
                String ssid_esperado = MainActivity.ssid.getText().toString();
                if (ssid.equals("\""+ssid_esperado+"\""))
                    Toast.makeText(context, "Conectado na Rede Esperada: " + ssid, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Conectado em Rede Desconhecida", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(context, "Desconectado", Toast.LENGTH_SHORT).show();
        }
    }
}