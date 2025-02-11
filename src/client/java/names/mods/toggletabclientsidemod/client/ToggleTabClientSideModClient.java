package names.mods.toggletabclientsidemod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class ToggleTabClientSideModClient implements ClientModInitializer {
    private static KeyBinding toggleTabModeKey;
    private static boolean isToggleMode = false;
    private static boolean tabListVisible = false;

    @Override
    public void onInitializeClient() {
        toggleTabModeKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Toggle Tab Mode",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "Names's Toggle Tab"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(ToggleTabClientSideModClient::onClientTick);
    }

    public static void onClientTick(MinecraftClient client) {
        if (toggleTabModeKey.wasPressed()) {
            isToggleMode = !isToggleMode;
            if (client.player != null) {
                client.player.sendMessage(
                        Text.literal("Tab list mode: " + (isToggleMode ? "Toggle" : "Hold")),
                        false
                );
            }
        }

        if (isToggleMode) {
            if (client.options.playerListKey.wasPressed()) {
                tabListVisible = !tabListVisible;
            }
        } else {
            tabListVisible = client.options.playerListKey.isPressed();
        }

        client.options.playerListKey.setPressed(tabListVisible);
    }
}
