package seol.study.message.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnsSubscribeMessageDto implements Serializable {

	@JsonProperty("Type")
	private String type = "Notification";

	@JsonProperty("Message")
	private String message;

}
