import Apis.OrderFulfilmentApi;
import Services.*;

public class SuprDailyApplication {

    public static void main(String[] args) {
	// write your code here
        CustomerService customerService=new CustomerService();
        ItemService itemService=new ItemService();
        WareHouseService wareHouseService=new WareHouseService();
        OrderService orderService=new OrderService(wareHouseService,customerService,itemService);
        OrderFulfilmentServiceImpl orderFulfilmentService =new OrderFulfilmentServiceImpl(orderService);
        OrderFulfilmentApi orderFulfilmentApi=new OrderFulfilmentApi(orderFulfilmentService);

        //Inputs
        //customerService.createCustomer();
        //itemService.addItem();
        //wareHouseService.createWareHouse();


        //APi call
        //orderFulfilmentApi.canFulfillOrder();
        //orderFulfilmentApi.reserveOrder();
    }
}
