package com.crewmoo;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(name = "CrewMoo")
public class CrewMooPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private CrewMooConfig config;

    private DialogueConfigs dialogueConfigs;

    @Override
    protected void startUp() throws Exception {
        log.debug("CrewMoo started!");
        dialogueConfigs = new DialogueConfigs(config);
    }

    @Override
    protected void shutDown() throws Exception {
        log.debug("CrewMoo stopped!");
    }

    private boolean isMatchingNPC(Actor actor) {
        if (actor instanceof NPC) {
            return true;
        }
        return false;
    }

    private boolean isValidText(String text) {
        return text != null && !text.isEmpty();
    }

    private void handleOverheadText(NPC npc, String text) {
        DialogueTransformer transformer = dialogueConfigs.getTransformerForNPC(npc, config);
        String transformed = transformer.transform(text);
        npc.setOverheadText(transformed);
    }

    @Subscribe
    public void onOverheadTextChanged(OverheadTextChanged event) {
        Actor actor = event.getActor();
        String overheadText = event.getOverheadText();
        // log.debug("Overhead text changed: {} -> {}", overheadText, actor.getName());
        if (isMatchingNPC(actor) && isValidText(overheadText)) {
            NPC npc = (NPC) actor;
            log.debug("The text is from an npc!");
            handleOverheadText(npc, overheadText);
        }

    }

    @Provides
    CrewMooConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(CrewMooConfig.class);
    }
}
