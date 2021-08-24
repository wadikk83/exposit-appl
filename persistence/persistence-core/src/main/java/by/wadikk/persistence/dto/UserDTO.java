package by.wadikk.persistence.dto;


import by.wadikk.persistence.entities.BaseEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO extends BaseEntity {

    private String login;
    private String fullName;
    private String email;
    private String address;
}
