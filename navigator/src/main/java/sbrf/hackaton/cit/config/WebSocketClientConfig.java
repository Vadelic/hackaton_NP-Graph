package sbrf.hackaton.cit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import sbrf.hackaton.cit.component.WebSocketHandler;
import sbrf.hackaton.cit.service.SomeService;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.concurrent.ExecutionException;

/**
 * Created by GreenNun on 24.10.2019.
 */
@Configuration
@EnableWebSocket
public class WebSocketClientConfig {

    @PostConstruct
    public void connect() throws ExecutionException, InterruptedException {
        client().doHandshake(new WebSocketHandler(), new WebSocketHttpHeaders(), URI.create("ws://echo.websocket.org")) // todo change url
                .get();
    }

    @Bean
    public WebSocketClient client() {
        return new StandardWebSocketClient();
    }
}
