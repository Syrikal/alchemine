package syric.alchemine.util;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ChatPrint {

    public static void chatPrint(String input, Entity entity) {
        if (entity instanceof Player player) {
            String[] outputSplit = input.split("\n");
            for (String i : outputSplit) {
                player.displayClientMessage(Component.literal(i), false);
            }
        }
    }
}
