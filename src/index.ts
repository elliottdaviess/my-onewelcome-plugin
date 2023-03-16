import { registerPlugin } from '@capacitor/core';

import type { MyOneWelcomePluginPlugin } from './definitions';

const MyOneWelcomePlugin = registerPlugin<MyOneWelcomePluginPlugin>(
  'MyOneWelcomePlugin',
  {
    web: () => import('./web').then(m => new m.MyOneWelcomePluginWeb()),
  },
);

export * from './definitions';
export { MyOneWelcomePlugin };
