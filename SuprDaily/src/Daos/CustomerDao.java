package Daos;

import Models.Customer;
import Models.Order;

import java.util.HashMap;

public class CustomerDao {
    HashMap<String, Customer> customerMap;

    public CustomerDao() {
        this.customerMap = new HashMap<>();
    }

    public void createCustomer(Customer customer){
        if(customerMap.containsKey(customer.getId())){
            throw new RuntimeException("Customer with this name already exists");
        }
        customerMap.put(customer.getId(),customer);
    }

    public Customer getCustomer(String id){
        if(customerMap.get(id)==null){
            throw new RuntimeException("No Cusotmer with the id exists");
        }
        return customerMap.get(id);
    }
}
