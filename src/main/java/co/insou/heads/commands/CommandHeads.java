package co.insou.heads.commands;

import co.insou.colorchar.ColorChar;
import co.insou.commands.CommandConsumer;
import co.insou.gui.GUIPlayer;
import co.insou.heads.Heads;
import co.insou.heads.gui.CategorySelectPage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeads extends CommandConsumer {

    private final Heads plugin;

    public CommandHeads(Heads plugin) {
        super("heads", true);
        this.plugin = plugin;
    }

    @Override
    public void onCommand(CommandSender sender, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("heads.use")) {
            player.sendMessage(ColorChar.color("&cYou don't have permission to do this!"));
            return;
        }
        GUIPlayer guiPlayer = plugin.getGuiManager().getPlayer(player);
        guiPlayer.openPage(new CategorySelectPage(plugin, guiPlayer), true);
    }

}
