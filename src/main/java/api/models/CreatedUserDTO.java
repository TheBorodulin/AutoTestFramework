package api.models;

import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedUserDTO {
	private String name;
	private String job;
	private String id;
	private String createdAt;
}
