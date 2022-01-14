package Services;

import Daos.ItemDao;
import Daos.WareHouseDao;
import Models.Customer;
import Models.Item;
import Models.WareHouse;

import java.util.List;
import java.util.Map;

public class WareHouseService {
    private WareHouseDao wareHouseDao;

    public WareHouseService() {
        this.wareHouseDao = new WareHouseDao();
    }

    public WareHouse createWareHouse(String name, Map<Item,Integer> items){
        WareHouse wareHouse=new WareHouse(name,items);
        wareHouseDao.createWareHouse(wareHouse);
        return wareHouseDao.getWareHouse(wareHouse.getId());
    }

    public WareHouse getWareHouse(String id){
        return wareHouseDao.getWareHouse(id);
    }

    public WareHouse updateWareHouse(String id,WareHouse wareHouse){
        return wareHouseDao.setWareHouse(id,wareHouse);
    }

    public List<WareHouse> getAll(){
        return wareHouseDao.getAll();
    }
}
