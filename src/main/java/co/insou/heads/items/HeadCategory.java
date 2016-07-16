package co.insou.heads.items;

import co.insou.colorchar.ColorChar;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum HeadCategory {

    FOOD_AND_DRINKS(Material.COOKED_BEEF),
    DECORATION(Material.RED_ROSE),
    MINECRAFT_BLOCKS(Material.STONE),
    ANIMALS(Material.LEATHER),
    MONSTERS(Material.ROTTEN_FLESH),
    HUMANS(Material.SKULL_ITEM),
    ALPHABET(Material.SIGN),
    PLANTS(Material.SEEDS),
    MISCELLANEOUS(Material.LAVA_BUCKET);

    private final ItemStack item;

    HeadCategory(Material material) {
        item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorChar.color("&b" + getFormattedCategory()));
        item.setItemMeta(meta);
    }

    public ItemStack getItem() {
        return item.clone();
    }

    public String getFormattedCategory() {
        char[] chars = toString().replace("_", " ").toLowerCase().toCharArray();
        chars[0] = ((Character) chars[0]).toString().toUpperCase().charAt(0);
        return new String(chars);
    }

}
