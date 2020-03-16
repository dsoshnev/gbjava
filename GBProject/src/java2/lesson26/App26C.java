package java2.lesson26;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// Client
public class App26C {

    public static final String SERVER_ADDR = "localhost";
    public static final int SERVER_PORT = 9090;
    private static Socket socket;
    private static DataInputStream dis;
    private static DataOutputStream dos;

    public static void main(String[] args) throws IOException {
        try {
            socket = new Socket(SERVER_ADDR,SERVER_PORT);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Клиент запущен: " + socket);

            Thread th1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        Scanner sc = new Scanner(System.in);
                        while (true) {
                            String message = sc.nextLine();
                            dos.writeUTF(message);
                            if (message.equals("/end")) break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread th2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String message = dis.readUTF();
                            System.out.println("Сервер: " + message);
                            if (message.equals("/end")) break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            th1.start();
            th2.start();

            th1.join();
            th2.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Канал закрыт: " + socket);
            if (socket != null) socket.close();
        }

    }
}
