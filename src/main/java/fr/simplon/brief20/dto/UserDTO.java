package fr.simplon.brief20.dto;

import fr.simplon.brief20.model.User;
import lombok.Data;

@Data
@lombok.Builder
@lombok.AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private String photoUrl;
    private boolean available;
    private Integer maxCustomers;
    private String profileInfo;
    private User.Role role;
}
