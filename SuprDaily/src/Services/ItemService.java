package Services;

import Daos.ItemDao;
import Models.Item;

public class ItemService {
    ItemDao itemDao;

    public ItemService() {
        this.itemDao = new ItemDao();
    }

    public Item getItem(Integer id){
        return itemDao.getItem(id);
    }

    public void addItem(Item item){
        itemDao.createItem(item);
    }
}
