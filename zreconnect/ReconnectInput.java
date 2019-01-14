/*
 * THIS SOFTWARE WRITTEN BY A KEYBOARD-WIELDING MONKEY BOI
 * No rights reserved. Use, redistribute, and modify at your own discretion,
 * and in accordance with Yagex and RuneLite guidelines.
 * However, aforementioned monkey would prefer if you don't sell this plugin for profit.
 */
 
 package net.runelite.client.plugins.zreconnect;

import java.awt.event.KeyEvent;
import javax.inject.Inject;
import net.runelite.client.input.KeyListener;

public class ReconnectInput implements KeyListener
{
    private static final int HOTKEY1 = KeyEvent.VK_CONTROL;
    private static final int HOTKEY2 = KeyEvent.VK_SHIFT;
    private static final int HOTKEY3 = KeyEvent.VK_D;

    @Inject
    private ReconnectPlugin plugin;

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case HOTKEY1:
                plugin.updateHotkey1(true);
                break;
            case HOTKEY2:
                plugin.updateHotkey2(true);
                break;
            case HOTKEY3:
                plugin.updateHotkey3(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case HOTKEY1:
                plugin.updateHotkey1(false);
                break;
            case HOTKEY2:
                plugin.updateHotkey2(false);
                break;
            case HOTKEY3:
                plugin.updateHotkey3(false);
                break;
        }
    }
}
