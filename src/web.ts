import { WebPlugin } from '@capacitor/core';

import type { MyOneWelcomePluginPlugin } from './definitions';

export class MyOneWelcomePluginWeb
  extends WebPlugin
  implements MyOneWelcomePluginPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
