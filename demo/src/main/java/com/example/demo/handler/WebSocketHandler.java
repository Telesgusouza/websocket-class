package com.example.demo.handler;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// é quivalente a um controller Rest http
@Component
public class WebSocketHandler extends TextWebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("[afterConnectionEstablished] session id " + session.getId());

		// a titulo de teste criaremos um loop infinito pra mais testes
		new Timer().scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				try {
					session.sendMessage(new TextMessage("Ola > " + UUID.randomUUID()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}, 2000L, 2000L);

	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println("[handleMessage] message " + message.getPayload());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("[afterConnectionClosed] session id " + session.getId());

	}

}
