package com.crewmoo;

import java.util.Map;
import java.util.function.Supplier;

import com.crewmoo.DialogueTransformer.FallbackBehavior;

import net.runelite.api.NPC;
import net.runelite.client.plugins.Plugin;

public class DialogueConfigs {

    private Map<PluginNPCs.NPC, DialogueTransformer> npcTransformers;
    private CrewMooConfig pluginConfig;
    private DialogueTransformer defaultTransformer;
    private Supplier<FallbackBehavior> fallbackBehaviorSupplier;

    public DialogueConfigs(CrewMooConfig config) {
        this.pluginConfig = config;
        this.fallbackBehaviorSupplier = () -> pluginConfig.mooMania() ? FallbackBehavior.MOO_ALL
                : FallbackBehavior.ORIGINAL;
        this.defaultTransformer = new DialogueTransformer(fallbackBehaviorSupplier);

        this.npcTransformers = Map.of(
                PluginNPCs.NPC.JOBLESS_JIM, buildJoblessJimTransformations(),
                PluginNPCs.NPC.EX_CAPTAIN_SIAD, buildExCaptainSiadTransformations(),
                PluginNPCs.NPC.ADVENTURER_ADA, buildAdventurerAdaTransformations(),
                PluginNPCs.NPC.CABIN_BOY_JENKINS, buildCabinBoyJenkinsTransformations(),
                PluginNPCs.NPC.OARSWOMAN_OLGA, buildOarswomanOlgaTransformations(),
                PluginNPCs.NPC.JITTERY_JIM, buildJitteryJimTransformations(),
                PluginNPCs.NPC.BOSUN_ZARAH, buildBosunZarahTransformations(),
                PluginNPCs.NPC.JOLLY_JIM, buildJollyJimTransformations(),
                PluginNPCs.NPC.SPOTTER_VIRGINIA, buildSpotterVirginiaTransformations(),
                PluginNPCs.NPC.SAILOR_JAKOB, buildSailorJakobTransformations());
    }

    public boolean isNPCEnabled(PluginNPCs.NPC npc) {
        switch (npc) {
            case JOBLESS_JIM:
                return pluginConfig.joblessJim();
            case EX_CAPTAIN_SIAD:
                return pluginConfig.exCaptainSiad();
            case ADVENTURER_ADA:
                return pluginConfig.adventurerAda();
            case CABIN_BOY_JENKINS:
                return pluginConfig.cabinBoyJenkins();
            case OARSWOMAN_OLGA:
                return pluginConfig.oarswomanOlga();
            case JITTERY_JIM:
                return pluginConfig.jitteryJim();
            case BOSUN_ZARAH:
                return pluginConfig.bosunZarah();
            case JOLLY_JIM:
                return pluginConfig.jollyJim();
            case SPOTTER_VIRGINIA:
                return pluginConfig.spotterVirginia();
            case SAILOR_JAKOB:
                return pluginConfig.sailorJakob();
            default:
                return false;
        }
    }

    public DialogueTransformer getTransformerForNPC(NPC npc, CrewMooConfig config) {
        PluginNPCs.NPC pluginNPC = PluginNPCs.NPC.fromID(npc.getId());
        if (!isNPCEnabled(pluginNPC)) {
            return defaultTransformer;
        }
        return npcTransformers.getOrDefault(pluginNPC, defaultTransformer);
    }

    private DialogueTransformer buildJoblessJimTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        // TODO: Add specific transformations for Jobless Jim's dialogue here.
        return transformer;
    }

    private DialogueTransformer buildExCaptainSiadTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        // TODO: Add specific transformations for Ex-Captain Siad's dialogue here.
        return transformer;
    }

    private DialogueTransformer buildAdventurerAdaTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        // TODO: Add specific transformations for Adventurer Ada's dialogue here.
        return transformer;
    }

    private DialogueTransformer buildCabinBoyJenkinsTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        return transformer;
    }

    private DialogueTransformer buildOarswomanOlgaTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        // TODO: Add specific transformations for Oarswoman Olga's dialogue here.
        return transformer;
    }

    private DialogueTransformer buildJitteryJimTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        // TODO: Add specific transformations for Jittery Jim's dialogue here.
        return transformer;
    }

    private DialogueTransformer buildBosunZarahTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        // TODO: Add specific transformations for Bosun Zarah's dialogue here.
        return transformer;
    }

    private DialogueTransformer buildJollyJimTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        // TODO: Add specific transformations for Jolly Jim's dialogue here.
        return transformer;
    }

    private DialogueTransformer buildSpotterVirginiaTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        // TODO: Add specific transformations for Spotter Virginia's dialogue here.
        return transformer;
    }

    private DialogueTransformer buildSailorJakobTransformations() {
        DialogueTransformer transformer = new DialogueTransformer(FallbackBehavior.MOO_ALL);
        // TODO: Add specific transformations for Sailor Jakob's dialogue here.
        return transformer;
    }

}
