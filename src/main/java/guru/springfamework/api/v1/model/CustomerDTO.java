package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by jt on 9/24/17.
 */
@Data
public class CustomerDTO {
    private String firstName;
    private String lastName;
    @JsonProperty("customer_url")
    private String customerURL;
}
