package Daos;

import Models.WareHouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WareHouseDao {
    HashMap<String, WareHouse> wareHouseMap;

    public WareHouseDao() {
        this.wareHouseMap = new HashMap<>();
    }

    public void createWareHouse(WareHouse wareHouse){
        if(wareHouseMap.containsKey(wareHouse.getId())){
            throw new RuntimeException("Warehouse with this name already exists");
        }
        wareHouseMap.put(wareHouse.getId(),wareHouse);
    }

    public WareHouse getWareHouse(String id){
        if(wareHouseMap.get(id)==null){
            throw new RuntimeException("No warehouse with the id exists");
        }
        return wareHouseMap.get(id);
    }

    public WareHouse setWareHouse(String id,WareHouse wareHouse){
        if(wareHouseMap.get(id)==null){
            throw new RuntimeException("No warehouse with the name exists");
        }
        wareHouseMap.put(id,wareHouse);
        return wareHouseMap.get(id);
    }

    public List<WareHouse> getAll(){
        List<WareHouse> values = new ArrayList<>(wareHouseMap.values());
        return values;
    }
}
