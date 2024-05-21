package lk.ijse.gdse.HelloShoeShopManagementSystem.repository.request;

import jakarta.validation.constraints.*;
import lk.ijse.gdse.HelloShoeShopManagementSystem.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    @Null(message = "Id generate by  program")
    private String id;
    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotNull(message = "Role cannot be null")
    private Role role;
}
