package Services;

import RequestModels.OrderRequest;

public interface OrderFulfilmentService {
    Boolean canFulfilOrder(OrderRequest orderRequest);
    void reserveOrder(OrderRequest orderRequest) throws Exception;
}
