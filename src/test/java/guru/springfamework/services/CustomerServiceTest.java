package guru.springfamework.services;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.mappers.CategoryMapper;
import guru.springfamework.mappers.CustomerMapper;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {

    public static final Long ID = 2L;
    public static final String NAME = "Jimmy";
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getAllCustomers() throws Exception {

        //given
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then
        assertEquals(3, customerDTOS.size());

    }

    @Test
    public void getCustomerByName() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(NAME);

        when(customerRepository.findByFirstNameContainsIgnoreCase(anyString())).thenReturn(customer);

        //when
        CustomerDTO customerDTO = customerService.getCustomerByFirstName(NAME);

        //then
      //  assertEquals(ID, customerDTO.getId());
        assertEquals(NAME, customerDTO.getFirstName());

    }

    @Test
    public void getCustomerById() throws Exception {

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(NAME);
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        //then
        assertEquals(NAME, customerDTO.getFirstName());

    }
    @Test
    public void createNewCustomer() throws Exception {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());
        savedCustomer.setId(1l);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDTO savedDto = customerService.createNewCustomer(customerDTO);

        //then
        assertEquals(customerDTO.getFirstName(), savedDto.getFirstName());
        assertEquals("/api/v1/customer/1", savedDto.getCustomerURL());
    }

    @Test
    public void saveCustomer() throws Exception{
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());
        savedCustomer.setId(1l);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        CustomerDTO savedDto = customerService.saveCustomer(1L,customerDTO);

        assertEquals(customerDTO.getFirstName(), savedDto.getFirstName());
        assertEquals(customerDTO.getLastName(), savedDto.getLastName());
    }

    @Test
    public void deleteCustomerById() throws Exception
    {
        Long id = 1L;
        customerRepository.deleteById(id);
        verify(customerRepository,times(1)).deleteById(anyLong());
    }
}