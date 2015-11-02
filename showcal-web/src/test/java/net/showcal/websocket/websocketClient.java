package net.showcal.websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * ***************************************************************
 * <p/>
 * <pre>
 * Copyright (c) 2014 –苏州犀牛网络科技有限公司
 *  Title: net.showcal.websocket
 *  Description:
 * ***************************************************************
 *  10/12 0012  V1.0  xiniu    New Files for net.showcal.websocket
 * </pre>
 */
public class websocketClient {
    public static void main(String[] args) throws URISyntaxException {
        String url = "ws://localhost/chat/message/8889199919991" ;
        WebSocketClient wc = new WebSocketClient(new URI(url), new Draft_17()) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                System.out.println(handshakedata.getHttpStatusMessage());
            }

            @Override
            public void onMessage(String message) {
                System.out.println(message);
            }

            @Override
            public void onError(Exception ex) {
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
            }
        };

        wc.connect();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            if (message.equals("q")) {
                wc.close();
                break;
            }
            scanner.close();
            wc.send(message);
        }
    }
}
