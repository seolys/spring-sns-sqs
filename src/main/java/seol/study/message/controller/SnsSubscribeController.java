package seol.study.message.controller;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationSubject;
import org.springframework.cloud.aws.messaging.endpoint.NotificationStatus;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationMessageMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationUnsubscribeConfirmationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SNS 직접구독하기.
 * https://cloud.spring.io/spring-cloud-static/spring-cloud-aws/2.0.0.RELEASE/multi/multi__messaging.html#_annotation_driven_http_notification_endpoint
 */
@Slf4j
@Controller
@RequestMapping("/seolys-test")
public class SnsSubscribeController {

	@NotificationSubscriptionMapping
	public void handleSubscriptionMessage(final NotificationStatus status) throws IOException {
		log.info("[handleSubscriptionMessage] status={}", status);
		status.confirmSubscription();
	}

	@NotificationMessageMapping
	public void handleNotificationMessage(@NotificationSubject final String subject, @NotificationMessage final String message) {
		log.info("[handleNotificationMessage] subject={}, message={}", subject, message);
	}

	@NotificationUnsubscribeConfirmationMapping
	public void handleUnsubscribeMessage(final NotificationStatus status) {
		log.info("[handleUnsubscribeMessage] status={}", status);
		status.confirmSubscription();
	}

}
