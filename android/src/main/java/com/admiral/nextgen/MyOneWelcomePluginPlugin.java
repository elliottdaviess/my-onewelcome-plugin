package com.admiral.nextgen;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.example.onewelcome.sdk.UserClient; // Import the oneWelcome SDK
import com.example.onewelcome.sdk.UserProfile;
import com.example.onewelcome.sdk.OneginiAuthenticationHandler;
import com.example.onewelcome.sdk.OneginiAuthenticationError;
import com.example.onewelcome.sdk.CustomInfo;
import com.example.onewelcome.sdk.OneginiAuthenticator;

@CapacitorPlugin(name = "MyOneWelcomePlugin")
public class MyOneWelcomePluginPlugin extends Plugin {

    @PluginMethod
    public void authenticateUser(PluginCall call) {
        String userId = call.getString("userId");
        if (userId == null) {
            call.reject("userId is required");
            return;
        }

        // Get the UserProfile instance for the given userId
        // Replace the following line with the actual implementation to get the UserProfile for the userId
        UserProfile userProfile = /* ... */;

        UserClient userClient = OneginiSDK.getOneginiClient(getContext()).getUserClient();
        userClient.authenticateUser(userProfile, new OneginiAuthenticationHandler() {
            @Override
            public void onSuccess(UserProfile userProfile, CustomInfo customInfo) {
                JSObject data = new JSObject();
                data.put("userId", userProfile.getUserId());
                data.put("customInfo", customInfo != null ? customInfo.toJson() : null);
                notifyListeners("didAuthenticateUser", data);
                call.resolve(data);
            }

            @Override
            public void onError(OneginiAuthenticationError error) {
                call.reject(error.getMessage());
            }
        });
    }

    @PluginMethod
    public void logoutUser(PluginCall call) {
        UserClient userClient = OneginiSDK.getOneginiClient(getContext()).getUserClient();
        userClient.logout(new OneginiLogoutHandler() {
            @Override
            public void onSuccess() {
                JSObject data = new JSObject();
                data.put("message", "User logged out");
                notifyListeners("didLogoutUser", data);
                call.resolve(data);
            }

            @Override
            public void onError(LogoutError error) {
                call.reject(error.getMessage());
            }
        });
    }
}
