package com.crewmoo;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("crewmoo")
public interface CrewMooConfig extends Config {

    @ConfigSection(name = "Crew Members", description = "Toggles to include individual crew members.", position = 100, closedByDefault = false)
    String SECTION_CREW_MEMBERS = "crew_members";

    @ConfigItem(keyName = "joblessJim", name = "Jobless Jim", description = "Mooify Jobless Jim's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean joblessJim() {
        return false;
    }

    @ConfigItem(keyName = "exCaptainSiad", name = "Ex-Captain Siad", description = "Mooify Ex-Captain Siad's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean exCaptainSiad() {
        return false;
    }

    @ConfigItem(keyName = "adventurerAda", name = "Adventurer Ada", description = "Mooify Adventurer Ada's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean adventurerAda() {
        return false;
    }

    @ConfigItem(keyName = "cabinBoyJenkins", name = "Cabin Boy Jenkins", description = "Mooify Cabin Boy Jenkins's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean cabinBoyJenkins() {
        return true;
    }

    @ConfigItem(keyName = "oarswomanOlga", name = "Oarswoman Olga", description = "Mooify Oarswoman Olga's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean oarswomanOlga() {
        return false;
    }

    @ConfigItem(keyName = "jitteryJim", name = "Jittery Jim", description = "Mooify Jittery Jim's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean jitteryJim() {
        return false;
    }

    @ConfigItem(keyName = "bosunZarah", name = "Bosun Zarah", description = "Mooify Bosun Zarah's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean bosunZarah() {
        return false;
    }

    @ConfigItem(keyName = "jollyJim", name = "Jolly Jim", description = "Mooify Jolly Jim's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean jollyJim() {
        return false;
    }

    @ConfigItem(keyName = "spotterVirginia", name = "Spotter Virginia", description = "Mooify Spotter Virginia's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean spotterVirginia() {
        return false;
    }

    @ConfigItem(keyName = "sailorJakob", name = "Sailor Jakob", description = "Mooify Sailor Jakob's dialogue", section = SECTION_CREW_MEMBERS)
    default boolean sailorJakob() {
        return false;
    }

    @ConfigSection(name = "Moo Mania", description = "Enter at your own risk.", position = 200, closedByDefault = true)
    String SECTION_MOO_MANIA = "moo_mania";

    @ConfigItem(keyName = "moo_mania", name = "Moo Mania", description = "For only the truest moo degenerates.", section = SECTION_MOO_MANIA)
    default boolean mooMania() {
        return false;
    }

}
