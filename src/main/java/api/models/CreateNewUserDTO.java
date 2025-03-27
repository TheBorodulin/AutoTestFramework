package api.models;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateNewUserDTO {
	private String name;
	private String job;
}
