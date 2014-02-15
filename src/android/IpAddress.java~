package it.weconstudio.phonegap.plugin.ipaddress;
 
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
 
import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
 
import android.util.Log;
 
public class IpAddress extends CordovaPlugin {
 
    public PluginResult execute(String action, JSONArray args, String callbackId) {
        if (action.equals("get")) {
        	return new PluginResult(PluginResult.Status.OK, "1111");
            String ipAddress = getIpAddress();
            if (ipAddress != null && ipAddress.length() > 0) {
                return new PluginResult(PluginResult.Status.OK, ipAddress);
            } else {
                return new PluginResult(PluginResult.Status.ERROR);
            }
        } else {
            return new PluginResult(PluginResult.Status.INVALID_ACTION);
        }
    }
 
    private String getIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("IpAddress", ex.toString());
        }
        return null;
    }
}

