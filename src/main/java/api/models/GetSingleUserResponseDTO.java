package api.models;

import lombok.Data;

@Data
public class GetSingleUserResponseDTO {
    private UserDataDTO data;
    private SupportDTO support;

    @Data
    public static class UserDataDTO {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @Data
    public static class SupportDTO {
        private String url;
        private String text;
    }
}