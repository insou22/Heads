package co.insou.heads.gui;

import co.insou.colorchar.ColorChar;
import co.insou.gui.GUIPlayer;
import co.insou.gui.page.GUIInventory;
import co.insou.gui.page.GUIPage;
import co.insou.gui.page.PageInventory;
import co.insou.heads.Heads;
import co.insou.heads.items.HeadCategory;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CategorySelectPage extends GUIPage<Heads> {

    public CategorySelectPage(Heads plugin, GUIPlayer player) {
        super(plugin, player, ColorChar.color("&aCategories"));
    }

    @Override
    protected GUIInventory loadInventory() {
        PageInventory inventory = new PageInventory(player, title);
        for (HeadCategory category : HeadCategory.values()) {
            inventory.addItem(category.getItem());
        }
        return inventory;
    }

    @Override
    protected void onInventoryClick(InventoryClickEvent event) {
        for (HeadCategory category : HeadCategory.values()) {
            if (ColorChar.equalsNoColor(
                    event.getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName(),
                    category.getFormattedCategory()
            )) {
                player.openPage(new HeadListPage(plugin, player, category), true);
                return;
            }
        }
        plugin.getLogger().severe(String.format("Could not find clicked category \"%s\"", event.getInventory().getItem(event.getSlot()).getItemMeta().getDisplayName()));
    }

}
