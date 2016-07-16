package co.insou.heads.items;

import co.insou.colorchar.ColorChar;
import co.insou.skulls.SkullMaker;
import org.bukkit.inventory.ItemStack;

public class HeadItem {

    private String name;
    private HeadCategory category;
    private String texture;

    private ItemStack item;

    public HeadItem(String name, HeadCategory category, String texture) {
        this.name = name;
        this.category = category;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public HeadCategory getCategory() {
        return category;
    }

    public String getTexture() {
        return texture;
    }

    public void load() {
        item = new SkullMaker()
                .withSkinUrl(texture)
                .withName(ColorChar.color("&a" + name))
                .withLore(ColorChar.color("&b" + category.getFormattedCategory()))
                .build();
    }

    public ItemStack getItem() {
        if (item == null) {
            load();
        }
        return item.clone();
    }

    @Override
    public String toString() {
        return String.format("HeadItem[name=\"%s\",category=\"%s\",texture=\"%s\"]", name, category.toString(), texture);
    }
}
