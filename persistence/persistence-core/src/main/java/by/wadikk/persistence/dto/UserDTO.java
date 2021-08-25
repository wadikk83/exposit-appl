package by.wadikk.persistence.dto;


import by.wadikk.persistence.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO extends BaseEntity {

    private String login;
    private String fullName;
    private String email;
    private String address;
}
