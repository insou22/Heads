package co.insou.heads.items;

import co.insou.heads.Heads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadItems {

    private static final Map<HeadCategory, List<HeadItem>> items = new HashMap<>();

    public static void load(Heads heads) {
        List<String> lines = loadFile(heads);
        int count = 0;
        for (int i = 0; i < lines.size(); i += 4) {
            HeadItem item = new HeadItem(
                    lines.get(i),
                    HeadCategory.valueOf(lines.get(i + 1).replace("-", "_").replace("&", "and").replaceAll("\\s", "_").toUpperCase()),
                    lines.get(i + 2)
            );
            item.load();
            if (!items.containsKey(item.getCategory())) {
                items.put(item.getCategory(), new ArrayList<HeadItem>());
            }
            List<HeadItem> list = items.get(item.getCategory());
            list.add(item);
            items.put(item.getCategory(), list);
            count++;
        }
        heads.getLogger().info(String.format("Loaded %d heads", count));
    }

    private static List<String> loadFile(Heads heads) {
        List<String> lines = new ArrayList<>();
        InputStream stream = heads.getResource("items.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line); // Add Line in the list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<HeadItem> getItems(HeadCategory category) {
        return new ArrayList<>(items.get(category));
    }

}
