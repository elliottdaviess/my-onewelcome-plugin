import Foundation
import Capacitor
import OneWelcomeSDK // Import the oneWelcome SDK

@objc(MyOneWelcomePluginPlugin)
public class MyOneWelcomePluginPlugin: CAPPlugin {
    
    @objc func authenticateUserWith(_ call: CAPPluginCall) {
        guard let userId = call.getString("userId") else {
            call.reject("userId is required")
            return
        }
        let userProfile = UserProfile(identifier: userId)

        //ensures that the oneWelcome SDK's authenticateUserWith(profile:authenticator:delegate:) method and its delegate methods are executed on the main thread, preventing any potential issues related to UI updates or responsiveness.
        DispatchQueue.main.async {
            // Get the UserProfile instance for the given userId
            // Replace the following line with the actual implementation to get the UserProfile for the userId
            
            SharedUserClient.instance.authenticateUserWith(profile: userProfile, authenticator: nil, delegate: self)
            call.resolve()
        }
    }
}

// MARK: - AuthenticationDelegate methods
extension MyOneWelcomePluginPlugin: AuthenticationDelegate {
    public func userClient(_ userClient: UserClient, didStartAuthenticationForUser user: UserProfile, authenticator: Authenticator) {
        notifyListeners("didStartAuthentication", data: ["userId": user.identifier])
    }
    
    // Implement other AuthenticationDelegate methods, similar to the one above, and call notifyListeners for each method to emit events to the front-end.
}
