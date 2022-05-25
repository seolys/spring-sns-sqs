package seol.study.message.sub;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import seol.study.message.dto.MessageDto;

/**
 * Standard 방식
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SqsConsumer {

	@SqsListener(value = "seolys-test01", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
	public void listener01(@Headers final Map<String, String> headers, @Payload final MessageDto message, final Acknowledgment ack) {
		log.info("[test01][standard] message={}", message);
		log.info("[test01][standard] headers={}", headers);
		log.info("[test01][standard] ack={}", ack != null);
//		throw new RuntimeException("야호");
		ack.acknowledge();
	}

	@SqsListener(value = "seolys-test02", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
	public void listener02(@Headers final Map<String, String> headers, @Payload final MessageDto message, final Acknowledgment ack) {
		log.info("[test02][standard] message={}", message);
		log.info("[test02][standard] headers={}", headers);
		log.info("[test02][standard] ack={}", ack != null);
//		throw new RuntimeException(message.getMessage());
		ack.acknowledge();
	}

	@SqsListener(value = "seolys-test03.fifo", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
	public void fifo(@Headers final Map<String, String> headers, @Payload final MessageDto message, final Acknowledgment ack) {
		log.info("[test03][fifo] message={}", message);
		log.info("[test03][fifo] headers={}", headers);
		log.info("[test03][fifo] ack={}", ack != null);
		ack.acknowledge();
	}

	@SqsListener(value = "seolys-test04-dlx", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
	public void deadLetterListener(@Headers final Map<String, String> headers, @Payload final String message, final Acknowledgment ack) {
		log.info("[deadLetterListener] message={}", message);
		log.info("[deadLetterListener] headers={}", headers);
		log.info("[deadLetterListener] ack={}", ack != null);
		ack.acknowledge();
	}

}