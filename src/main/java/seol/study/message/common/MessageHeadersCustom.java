package seol.study.message.common;

import java.util.HashMap;
import org.springframework.messaging.MessageHeaders;

public class MessageHeadersCustom extends MessageHeaders {
    public MessageHeadersCustom() {
        super(new HashMap<String, Object>(), ID_VALUE_NONE, null);
    }
}