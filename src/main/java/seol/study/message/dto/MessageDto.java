package seol.study.message.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import seol.study.message.common.ServiceType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto implements Serializable {


	private ServiceType serviceType;

	private String message;

}
