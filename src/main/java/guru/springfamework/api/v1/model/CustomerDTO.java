package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by jt on 9/24/17.
 */
@Data
public class CustomerDTO {
    @ApiModelProperty(value = "This is the first name", required = true)
    private String firstName;
    @ApiModelProperty(value = "This is the last name", required = true)
    private String lastName;
    @JsonProperty("customer_url")
    private String customerURL;
}
