package by.wadikk.persistence.dto;


import by.wadikk.persistence.entities.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDto extends AbstractDto {

    @NotNull(message = "The field cannot be empty")
    @Size(min = 2, max = 30, message = "Username should be between 2 and 30 characters")
    private String login;

    @Size(min = 2, max = 30, message = "Password should be between 2 and 30 characters")
    private String password;

    @NotNull(message = "The field cannot be empty")
    @Size(min = 2, max = 30, message = "First name should be between 2 and 30 characters")
    private String fullName;

    @Email(message = "The field email cannot be empty")
    private String email;

    @Size(min = 5, max = 100, message = "Address should be between 5 and 100 characters")
    private String address;
}
