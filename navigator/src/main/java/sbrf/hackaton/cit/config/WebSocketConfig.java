//package sbrf.hackaton.cit.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//import sbrf.hackaton.cit.component.WebSocketHandler;
//
//import javax.validation.constraints.NotNull;
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//    private final WebSocketHandler webSocketHandler;
//
//    @Autowired
//    public WebSocketConfig(WebSocketHandler webSocketHandler) {
//        this.webSocketHandler = webSocketHandler;
//    }
//
//    @Override
//    public void registerWebSocketHandlers(@NotNull WebSocketHandlerRegistry registry) {
//        registry
//                .addHandler(webSocketHandler, "/race")
//                .setAllowedOrigins("*");
//    }
//}