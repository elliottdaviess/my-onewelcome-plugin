package com.admiral.nextgen;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.example.onewelcome.sdk.UserClient; // Import the oneWelcome SDK
import com.example.onewelcome.sdk.UserProfile;
import com.example.onewelcome.sdk.AuthenticationDelegate;

@CapacitorPlugin(name = "MyOneWelcomePlugin")
public class MyOneWelcomePluginPlugin extends Plugin implements OneWelcomeAuthenticationListener {

    @PluginMethod()
    public void authenticateUserWith(PluginCall call) {
        String userId = call.getString("userId");
        if (userId == null) {
            call.reject("userId is required");
            return;
        }
        
        // Get the UserProfile instance for the given userId
        // Replace the following line with the actual implementation to get the UserProfile for the userId
        UserProfile userProfile = /* ... */;
        
        UserClient userClient = UserClient.getInstance();
        userClient.authenticateUserWith(userProfile, null, new AuthenticationDelegate() {
            // Implement the AuthenticationDelegate methods and call the corresponding methods in OneWelcomeAuthenticationListener
        });
        call.resolve();
    }

    @Override
    public void onAuthenticationStarted(String userId) {
        JSObject data = new JSObject();
        data.put("userId", userId);
        notifyListeners("didStartAuthentication", data);
    }

    // Implement other OneWelcomeAuthenticationListener methods, similar to the one
    // above, and call notifyListeners for each method to emit events to the
    // front-end.
}
