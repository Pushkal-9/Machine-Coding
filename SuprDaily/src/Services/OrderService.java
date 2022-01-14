package Services;

import Daos.OrderDao;
import Models.Item;
import Models.Order;
import Models.WareHouse;
import RequestModels.ItemRequest;
import RequestModels.OrderRequest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderService {
    private OrderDao orderDao;
    private WareHouseService wareHouseService;
    private CustomerService customerService;
    private ItemService itemService;

    public OrderService(WareHouseService wareHouseService, CustomerService customerService,ItemService itemService) {
        this.wareHouseService = wareHouseService;
        this.customerService = customerService;
        this.itemService=itemService;
    }

    public Boolean canFulfilOrder(OrderRequest orderRequest){
        long millis=System.currentTimeMillis();
        Date date=new Date(millis);
        if(orderRequest.getDeliveryDate().compareTo(date)>0){
            return false;
        }
        WareHouse wareHouse=wareHouseService.getWareHouse(orderRequest.getWarehouseId());
        Map<Item,Integer> itemsAvailableInWareHouse=wareHouse.getItems();
        List<ItemRequest> itemsRequired=orderRequest.getItems();
        for(ItemRequest itemRequest:itemsRequired){
            Item item=itemService.getItem(itemRequest.getItemId());
            if(itemsAvailableInWareHouse.containsKey(item)){
                if(itemsAvailableInWareHouse.get(item)<itemRequest.getQuantity()){
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public void reserveOrder(OrderRequest orderRequest){
        if(!canFulfilOrder(orderRequest)){
            return;
        }
        WareHouse wareHouse=wareHouseService.getWareHouse(orderRequest.getWarehouseId());
        Map<Item,Integer> itemsAvailableInWareHouse=wareHouse.getItems();
        List<ItemRequest> itemsRequired=orderRequest.getItems();
        for(ItemRequest itemRequest:itemsRequired){
            Item item=itemService.getItem(itemRequest.getItemId());
            if(itemsAvailableInWareHouse.containsKey(item)){
                return;
            }
            int remaining =itemsAvailableInWareHouse.get(item)-itemRequest.getQuantity();
            if(remaining<0){
                return;
            }
            itemsAvailableInWareHouse.put(item,remaining);
        }
        wareHouse.setItems(itemsAvailableInWareHouse);
        orderDao.createOrder(new Order(0,orderRequest.getCustomerId(),orderRequest.getWarehouseId(),orderRequest.getDeliveryDate(),orderRequest.getItems()));
        wareHouseService.updateWareHouse(wareHouse.getId(),wareHouse);
    }


}
