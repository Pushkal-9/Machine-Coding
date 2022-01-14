package Services;

import Daos.CustomerDao;
import Models.Customer;

public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService() {
        this.customerDao = new CustomerDao();
    }

    public Customer createCustomer(String name,String phone,String email){
        Customer customer=new Customer(name,phone,email);
        customerDao.createCustomer(customer);
        return customerDao.getCustomer(customer.getId());
    }

    public Customer getCustomer(String id){
        return customerDao.getCustomer(id);
    }
}
