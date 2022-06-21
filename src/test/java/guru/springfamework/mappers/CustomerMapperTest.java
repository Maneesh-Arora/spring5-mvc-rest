package guru.springfamework.mappers;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Category;
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

        assertEquals(Long.valueOf(2L),customerDTO.getId());
        assertEquals("Joe",customerDTO.getFirstName());

    }
}