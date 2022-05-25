package seol.study.message.pub;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;
import seol.study.message.dto.MessageDto;
import seol.study.message.dto.SnsSubscribeMessageDto;

@Slf4j
@Component
@RequiredArgsConstructor
public class SnsPublisher {

	private final NotificationMessagingTemplate messagingTemplate;

	public void publish(final MessageDto message) {
		final Map<String, Object> headers = Map.of("SERVICE_CODE", message.getServiceType().name());
		final var destinationName = "seolys-test";
		messagingTemplate.convertAndSend(destinationName, message, headers);
	}

	public void publishHttp(final SnsSubscribeMessageDto snsSubscribeMessageDto) {
		final Map<String, Object> headers = Map.of("SERVICE_CODE", "TEST");
		final var destinationName = "seolys-test";
		messagingTemplate.convertAndSend(destinationName, snsSubscribeMessageDto, headers);
	}

}
