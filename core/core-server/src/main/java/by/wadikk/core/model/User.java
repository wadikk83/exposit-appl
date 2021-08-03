package by.wadikk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    private @NonNull String login;
    private @NonNull String password;
    private String fullName;
    private @NonNull String email;
    private String address;

    @Override
    public String toString() {

        return "User ID->" + id +
                ", login->" + login +
                ", password->" + password +
                ", firstName->" + fullName +
                ", email->" + email +
                ",address->" + address + "\n";
    }
}
