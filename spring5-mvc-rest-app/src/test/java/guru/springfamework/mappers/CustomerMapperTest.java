package guru.springfamework.mappers;


import gur.springframework.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void customerToCustomerDto() {
        Customer customer = new Customer();
        customer.setFirstName("Joe");
        customer.setId(2L);

        CustomerDTO customerDTO = customerMapper.customerToCustomerDto(customer);

        assertEquals("Joe",customerDTO.getFirstName());

    }
}