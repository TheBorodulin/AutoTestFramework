package api.models;

import lombok.Data;

@Data
public class RegisterResponseDTO {
    private int id;
    private String token;
}