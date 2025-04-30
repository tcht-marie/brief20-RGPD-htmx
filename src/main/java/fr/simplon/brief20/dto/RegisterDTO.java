package fr.simplon.brief20.dto;

import lombok.Data;

@Data
@lombok.Builder
@lombok.AllArgsConstructor
public class RegisterDTO {
    private String username;
    private String fullName;
    private String email;
    private String password;
}
