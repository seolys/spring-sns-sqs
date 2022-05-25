package seol.study.message.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import seol.study.message.dto.MessageDto;
import seol.study.message.dto.SnsSubscribeMessageDto;
import seol.study.message.pub.SnsPublisher;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SnsController {

	private final SnsPublisher snsPublisher;

	@PostMapping("/sns/publish")
	public String publish(@RequestBody final MessageDto message) {
		snsPublisher.publish(message);
		return "ok";
	}

	@PostMapping("/sns/http/publish")
	public String publish(@RequestBody final SnsSubscribeMessageDto snsSubscribeMessageDto) {
		snsPublisher.publishHttp(snsSubscribeMessageDto);
		return "ok";
	}

}
