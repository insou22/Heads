package co.insou.heads.gui;

import co.insou.colorchar.ColorChar;
import co.insou.gui.GUIPlayer;
import co.insou.gui.page.GUIInventory;
import co.insou.gui.page.GUIPage;
import co.insou.gui.page.PageInventory;
import co.insou.heads.Heads;
import co.insou.heads.items.HeadCategory;
import co.insou.heads.items.HeadItem;
import co.insou.heads.items.HeadItems;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public class HeadListPage extends GUIPage<Heads> {

    public HeadListPage(Heads plugin, GUIPlayer player, HeadCategory category) {
        super(plugin, player, ColorChar.color("&aHeads"), category);
    }

    @Override
    protected GUIInventory loadInventory() {
        PageInventory inventory = new PageInventory(player, title);
        List<HeadItem> items = HeadItems.getItems((HeadCategory) params[0]);
        for (HeadItem item : items) {
            inventory.addItem(item.getItem());
        }
        return inventory;
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        player.closeGUI(true);
        player.player().getLocation().getWorld().dropItem(player.player().getEyeLocation(), event.getInventory().getItem(event.getSlot()));
        player.player().sendMessage(ColorChar.color(String.format("&aYou were given skull \"%s\"", ColorChar.strip(event.getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName()))));
    }

}
