package Models;

import java.util.Map;

public class WareHouse {
    String id;
    String name;
    Map<Item,Integer> items;

    public WareHouse(String name, Map<Item,Integer> items) {
        this.name = name;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Item,Integer> getItems() {
        return items;
    }

    public void setItems(Map<Item,Integer> items) {
        this.items = items;
    }
}
