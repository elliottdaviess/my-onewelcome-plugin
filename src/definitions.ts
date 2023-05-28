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

  addListener(
    eventName: 'didStartAuthentication',
    listenerFunc: (data: { userId: string }) => void,
  ): Promise<{ destroy: () => void }>;
}

