package seol.study.message.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import seol.study.message.dto.MessageDto;
import seol.study.message.pub.SqsProducer;

@Controller
@RequiredArgsConstructor
public class SqsController {

	private final SqsProducer sqsProducer;

	@PostMapping("/sqs/standard/publish")
	public String sendStandard(@RequestBody final MessageDto messageDto) {
		sqsProducer.sendStandard(messageDto);
		return "ok";
	}

	@PostMapping("/sqs/fifo/publish")
	public String sendFifo(@RequestBody final MessageDto messageDto) {
		sqsProducer.sendFifo(messageDto);
		return "ok";
	}

}
