package engine.api.dto;

import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
public class UserDTO {
    @Pattern(regexp = "^(.+)@(.+)\\.(.+)$")
    private String email;
    @Size(min = 5)
    private String password;
}
