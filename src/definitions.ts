export interface MyOneWelcomePluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
