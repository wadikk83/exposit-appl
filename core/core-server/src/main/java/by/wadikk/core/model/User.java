package by.wadikk.core.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Сущность пользователя")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    @Column(unique = true)
    @Schema(description = "Логин")
    private @NonNull String login;
    @Schema(description = "Пароль")
    private @NonNull String password;
    @Schema(description = "ФИО")
    private String fullName;
    @Column(unique = true)
    @Schema(description = "E-mail")
    private @NonNull @Email String email;
    @Schema(description = "Адрес")
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
