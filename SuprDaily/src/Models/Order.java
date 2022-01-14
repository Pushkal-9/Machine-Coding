package Models;

import RequestModels.ItemRequest;

import java.util.Date;
import java.util.List;

public class Order {
    Integer id;
    String customerId;

    public Order(Integer id, String customerId, String warehouseId, Date deliveryDate, List<ItemRequest> items) {
        this.id = id;
        this.customerId = customerId;
        this.warehouseId = warehouseId;
        this.deliveryDate = deliveryDate;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }

    String warehouseId;
    Date deliveryDate;
    List<ItemRequest> items;
}
