package sbrf.hackaton.cit.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import sbrf.hackaton.cit.service.SomeService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private static final Logger log = LoggerFactory.getLogger(WebSocketHandler.class);
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    private final SomeService service;

    public WebSocketHandler(SomeService service) {
        this.service = service;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("CONNECTED");
    }

//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//        super.handleMessage(session, message);
//    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("message: {}", new String(message.asBytes()));
        final String sessionId = session.getId();
        sessions.putIfAbsent(sessionId, session); // save session

        session.sendMessage(message); // echo message

        // or

        final String parse = new String(message.asBytes()); // parse
        if (parse.equals("123"))
            service.print(parse); // invoke service
    }

//    @Override
//    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
//        super.handlePongMessage(session, message);
//    }
//
//    @Override
//    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
//        super.handleTransportError(session, exception);
//    }
//
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("CLOSED");
        sessions.remove(session.getId());
    }
//
//    @Override
//    public boolean supportsPartialMessages() {
//        return super.supportsPartialMessages();
//    }
}