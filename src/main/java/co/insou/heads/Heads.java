package co.insou.heads;

import co.insou.commands.CommandManager;
import co.insou.gui.GUIManager;
import co.insou.heads.commands.CommandHeads;
import co.insou.heads.items.HeadItems;
import org.bukkit.plugin.java.JavaPlugin;

public class Heads extends JavaPlugin {

    private GUIManager guiManager;

    @Override
    public void onEnable() {
        HeadItems.load(this);
        guiManager = new GUIManager(this);
        CommandManager manager = new CommandManager(this);
        manager.register(new CommandHeads(this));
    }

    public GUIManager getGuiManager() {
        return guiManager;
    }

}
