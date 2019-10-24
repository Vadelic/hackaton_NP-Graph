package sbrf.hackaton.cit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import sbrf.hackaton.cit.component.WebSocketHandler;
import sbrf.hackaton.cit.service.SomeService;

import java.net.URI;
import java.util.concurrent.ExecutionException;

/**
 * Created by GreenNun on 24.10.2019.
 */
@Configuration
@EnableWebSocket
public class WebSocketClientConfig {

    @Bean
    public WebSocketClient client(SomeService someService) throws ExecutionException, InterruptedException {
        final StandardWebSocketClient standardWebSocketClient = new StandardWebSocketClient();

        standardWebSocketClient
                .doHandshake(new WebSocketHandler(someService), new WebSocketHttpHeaders(), URI.create("ws://echo.websocket.org")) // todo change url
                .get();

        return standardWebSocketClient;
    }
}
