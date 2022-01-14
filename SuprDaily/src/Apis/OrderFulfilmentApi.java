package Apis;

import RequestModels.OrderFulfilmentResponse;
import RequestModels.OrderRequest;
import Services.OrderFulfilmentService;
import Services.OrderFulfilmentServiceImpl;

public class OrderFulfilmentApi {
    private OrderFulfilmentServiceImpl orderFulfilmentService;

    public OrderFulfilmentApi(OrderFulfilmentServiceImpl orderFulfilmentService) {
        this.orderFulfilmentService = orderFulfilmentService;
    }

    public OrderFulfilmentResponse canFulfillOrder(OrderRequest orderRequest){
        OrderFulfilmentResponse orderFulfilmentResponse=new OrderFulfilmentResponse();
        orderFulfilmentResponse.setCan_fulfil(orderFulfilmentService.canFulfilOrder(orderRequest));
        return orderFulfilmentResponse;
    }

    public void reserveOrder(OrderRequest orderRequest) throws Exception{
        orderFulfilmentService.reserveOrder(orderRequest);
    }
}
