import { WebPlugin } from '@capacitor/core';

import type { MyOneWelcomePluginPlugin } from './definitions';

export class MyOneWelcomePluginWeb extends WebPlugin implements MyOneWelcomePluginPlugin {
  constructor() {
    super({
      name: 'MyOneWelcomePlugin',
      platforms: ['web'],
    });
  }

  async authenticateUserWith(_options: { userId: string }): Promise<void> {
    console.warn('Web platform does not support the oneWelcome SDK.');
  }
}
