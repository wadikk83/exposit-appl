package by.wadikk.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;

/**
 * Entity class user
 *
 * @author Wadikk
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private @NonNull String login;
    private @NonNull String password;
    private String fullName;
    @Column(unique = true)
    private @NonNull @Email String email;
    private String address;

    public User(@NonNull String login, @NonNull String password, @NonNull String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

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
