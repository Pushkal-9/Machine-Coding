package Daos;

import Models.Customer;
import Models.Item;

import java.util.HashMap;

public class ItemDao {
    HashMap<Integer, Item> itemMap;

    public ItemDao() {
        this.itemMap = new HashMap<>();
    }

    public void createItem(Item item){
        if(itemMap.containsKey(item.getId())){
            throw new RuntimeException("Item with this name already exists");
        }
        itemMap.put(item.getId(),item);
    }

    public Item getItem(Integer id){
        if(itemMap.get(id)==null){
            throw new RuntimeException("No item with the id exists");
        }
        return itemMap.get(id);
    }
}
