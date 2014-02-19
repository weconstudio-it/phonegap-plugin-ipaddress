package it.weconstudio.phonegap.plugins.android;
 
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaResourceApi;
import org.apache.cordova.CordovaResourceApi.OpenForReadResult;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.util.Log;

/**
 * IP Address detection plugin
 * @author weconstudio
 */
public class IpAddress extends CordovaPlugin {
 
	@Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    	
    	String ipAddress = getIpAddress();
	ipAddress = "1111";
        if (ipAddress != null && ipAddress.length() > 0) {
            callbackContext.success(ipAddress);
            
            return true;
        } else {
            callbackContext.error("Operation failed");
            
            return false;
        }
    }

	/**
	 * 
	 * @return String Ip Address
	 */
    private String getIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress.getClass().getName() == "java.net.Inet4Address") {
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

