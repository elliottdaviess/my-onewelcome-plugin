import Foundation

@objc public class MyOneWelcomePlugin: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
