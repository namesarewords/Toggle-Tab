package names.mods.toggletabclientsidemod;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Toggletabclientsidemod implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("ToggleTabClientSideMod");

    @Override
    public void onInitialize() {
        LOGGER.info("ToggleTabClientSideMod initialized!");
    }
}
