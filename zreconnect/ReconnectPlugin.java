/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 * Credit to lyzrds for input on creating this plugin.
 */

package net.runelite.client.plugins.zreconnect;

import javax.inject.Inject;
import java.lang.reflect.Method;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(
        name = "xz_Reconnect",
        description = "Control Shift D to disconnect and reconnect",
        tags = {"CoX"},
        enabledByDefault = false
)

public class ReconnectPlugin extends Plugin
{
    private boolean hotkey1;
    private boolean hotkey2;
    private boolean hotkey3;

    @Inject
    private Client client;

    @Inject
    private ReconnectInput inputListener;

    @Inject
    private KeyManager keyManager;

    @Override
    protected void startUp()
    {
        hotkey1 = false;
        hotkey2 = false;
        hotkey3 = false;
        keyManager.registerKeyListener(inputListener);
    }

    @Override
    protected void shutDown()
    {
        keyManager.unregisterKeyListener(inputListener);
    }

    void updateHotkey1(boolean pressed)
    {
        hotkey1 = pressed;
    }

    void updateHotkey2(boolean pressed)
    {
        hotkey2 = pressed;
    }
    void updateHotkey3(boolean pressed)
    {
        hotkey3 = pressed;
        if (hotkey1 && hotkey2)
        {
            System.out.println("dcing");
            if ((client.getGameState() == GameState.LOGGED_IN))
            {
                System.out.println("Disconnecting and Reconnecting.");
                try
                {
                    Method m = client.getClass().getClassLoader().loadClass("t").getDeclaredMethod("fp", int.class);
                    m.setAccessible(true);
                    m.invoke(null, -904767418);
                }
                catch (ReflectiveOperationException f)
                {
                    throw new RuntimeException(f);
                }
            }
            else
            {
                //User is still in a dc, or not logged in. Possibly provide a meaningful message somewhere.
            }

        }
    }
}
