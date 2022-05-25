package seol.study.message.pub;

import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.SqsMessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import seol.study.message.dto.MessageDto;

@Slf4j
@Component
@RequiredArgsConstructor
public class SqsProducer {

	private final QueueMessagingTemplate queueMessagingTemplate;

	@PostMapping("/sqs/standard/publish")
	public void sendStandard(final MessageDto messageDto) {
		final var destinationName = "seolys-test01";
		queueMessagingTemplate.convertAndSend(destinationName, messageDto);
	}

	public void sendFifo(final MessageDto messageDto) {
		final var destinationName = "seolys-test03.fifo";
		final Map<String, Object> sqsGroupIdHeader = Map.of(
				SqsMessageHeaders.SQS_GROUP_ID_HEADER, "PK",
				SqsMessageHeaders.SQS_DEDUPLICATION_ID_HEADER, UUID.randomUUID().toString());
		queueMessagingTemplate.convertAndSend(destinationName, messageDto, sqsGroupIdHeader);
	}

}