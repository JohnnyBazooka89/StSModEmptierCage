package emptierCage;

import basemod.BaseMod;
import basemod.ModPanel;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class EmptierCageMod implements PostInitializeSubscriber, EditStringsSubscriber {

    public static final Logger logger = LogManager.getLogger(EmptierCageMod.class.getName());

    //Mod metadata
    private static final String MOD_NAME = "Emptier Cage";
    private static final String AUTHOR = "JohnnyBazooka89";
    private static final String DESCRIPTION = "";

    //Localization strings
    private static final String RELIC_STRINGS_PATH = "emptierCage/localization/RelicStrings.json";

    //Badge
    private static final String BADGE_IMG = "emptierCage/img/ModBadge.png";

    public EmptierCageMod() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        logger.info("======================= EMPTIER CAGE INIT =======================");

        new EmptierCageMod();

        logger.info("====================================================================");
    }

    @Override
    public void receivePostInitialize() {
        // Mod badge
        Texture badgeTexture = ImageMaster.loadImage(BADGE_IMG);
        ModPanel settingsPanel = new ModPanel();
        BaseMod.registerModBadge(badgeTexture, MOD_NAME, AUTHOR, DESCRIPTION, settingsPanel);
    }

    @Override
    public void receiveEditStrings() {
        logger.info("Begin editing strings");

        //Relic Strings
        BaseMod.loadCustomStringsFile(RelicStrings.class, RELIC_STRINGS_PATH);

        logger.info("Done editing strings");
    }

}
