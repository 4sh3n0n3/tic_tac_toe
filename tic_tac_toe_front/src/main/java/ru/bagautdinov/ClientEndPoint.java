package ru.bagautdinov;

import org.glassfish.tyrus.client.ClientManager;
import ru.bagautdinov.game.GameController;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import static java.lang.String.format;

/**
 * Date 02.06.2018
 *
 * @author Hursanov Sulaymon
 * @version v1.0
 **/
@ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientEndPoint  {
    public static final String SERVER = "ws://localhost:8080/ws/server";

    private static Session session;
    public ClientEndPoint()  {
        ClientManager client = ClientManager.createClient();
        try {
            session = client.connectToServer(this, new URI(SERVER));
        } catch (DeploymentException | URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public static Session getSession() {
        return session;
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(format("Connection established. session id: %s", session.getId()));
    }

    @OnMessage
    public void onMessage(Message message,Session session) {
        System.out.println(message.toString());
        String command=message.getMessage();
        String[] commands = command.split(" ");
        if (commands[0].equals("set")) {
            GameController.setPlayerChar(commands[1]);
        } else if (commands[0].equals("win")) {

        }
    }
    public static void sendMessage(Message m){
        if (session==null){

        }
        try {
            session.getBasicRemote().sendObject(m);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }
}
