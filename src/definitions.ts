// export interface MyOneWelcomePluginPlugin {
//   echo(options: { value: string }): Promise<{ value: string }>;
// }

declare module '@capacitor/core' {
  interface PluginRegistry {
    MyOneWelcomePlugin: MyOneWelcomePluginPlugin;
  }
}

export interface MyOneWelcomePluginPlugin {
  authenticateUserWith(options: { userId: string }): Promise<void>;
}

