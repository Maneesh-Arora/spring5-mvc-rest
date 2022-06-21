package guru.springfamework.api.v1.model;

import lombok.Data;

/**
 * Created by jt on 9/24/17.
 */
@Data
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String customerURL;
}
