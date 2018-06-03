package ru.bagautdinov;

import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Server server = new Server("localhost", 8080, "/ws", ServerEndPoint.class);
        try {
            server.start();
            System.out.println("Press enter to stop the server..");
            new Scanner(System.in).nextLine();
        } catch (DeploymentException e) {
            throw new RuntimeException(e);
        }
    }
}
