package com.crewmoo;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class CrewMooPluginTest {
    public static void main(String[] args) throws Exception {
        ExternalPluginManager.loadBuiltin(CrewMooPlugin.class);
        RuneLite.main(args);
    }
}