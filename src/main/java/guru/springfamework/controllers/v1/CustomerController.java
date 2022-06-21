package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CategoryListDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

/**
 * Created by jt on 9/26/17.
 */
@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers(){

        return new ResponseEntity<CustomerListDTO>(
                new CustomerListDTO(customerService.getAllCustomers()), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CustomerDTO> getCustomerByFirstName( @PathVariable String name) {
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerByFirstName(name), HttpStatus.OK
        );
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById( @PathVariable Long id){
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerById(id), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO)
    {
        return new ResponseEntity<CustomerDTO>(customerService.createNewCustomer(customerDTO), HttpStatus.CREATED);
    }
}
