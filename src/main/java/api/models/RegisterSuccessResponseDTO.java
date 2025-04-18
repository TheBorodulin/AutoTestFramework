package api.models;

import lombok.Data;

@Data
public class RegisterSuccessResponseDTO {
    private int id;
    private String token;
}