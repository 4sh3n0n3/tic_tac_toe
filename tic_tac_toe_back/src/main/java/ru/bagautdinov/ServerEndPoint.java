package ru.bagautdinov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bagautdinov.models.Game;
import ru.bagautdinov.models.Player;
import ru.bagautdinov.utils.CommadnsHandler;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.lang.String.format;


@Component
@ServerEndpoint(value = "/server", encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class})
public class ServerEndPoint {

    @Autowired
    public CommadnsHandler commadnsHandler;

    static Set<Session> detailUsers = Collections.synchronizedSet(new HashSet<Session>());

    @OnOpen
    public void handleOpen(Session session){
        System.out.println(format("%s joined ", session.getId()));
        detailUsers.add(session);
    }

    @OnMessage
    public void handleMessage(Message incomingMessage, Session session) throws IOException, EncodeException {
        Game currentGame = (Game) session.getUserProperties().get("currentGame");
        Player player = (Player) session.getUserProperties().get("player");

        commadnsHandler.proceedCommand(incomingMessage.getMessage(), currentGame, player);


        Message outcomingMessageData = new Message();

        if (username == null){
            session.getUserProperties().put("username", incomingMessage.getUsername());
            outcomingMessageData.setUsername("System");
            outcomingMessageData.setMessage("you are now connected as "+ incomingMessage.getUsername());
            session.getBasicRemote().sendObject(outcomingMessageData);
        }else{
            outcomingMessageData.setUsername(username);
            outcomingMessageData.setMessage(incomingMessage.getMessage());
            Iterator<Session> it = detailUsers.iterator();
            while (it.hasNext())it.next().getBasicRemote().sendObject(outcomingMessageData);
        }
    }

    @OnClose
    public void handleClose(Session session){
        detailUsers.remove(session);
    }

    @OnError
    public void handleError(Throwable t){
        t.printStackTrace();
    }
}

