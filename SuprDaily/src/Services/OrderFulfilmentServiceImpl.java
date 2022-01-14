package Services;

import RequestModels.OrderRequest;

public class OrderFulfilmentServiceImpl implements OrderFulfilmentService{
    private OrderService orderService;

    public OrderFulfilmentServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Boolean canFulfilOrder(OrderRequest orderRequest) {
        return orderService.canFulfilOrder(orderRequest);
    }

    @Override
    public void reserveOrder(OrderRequest orderRequest) throws Exception {
        orderService.reserveOrder(orderRequest);
    }
}
