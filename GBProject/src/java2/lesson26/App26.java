package java2.lesson26;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Server
public class App26 {
    // Написать консольный вариант клиент\серверного приложения, в котором пользователь может писать сообщения
    // как на клиентской стороне, так и на серверной. Т.е. если на клиентской стороне написать «Привет», нажать Enter,
    // то сообщение должно передаться на сервер и там отпечататься в консоли. Если сделать то же самое на серверной стороне,
    // сообщение, соответственно, передаётся клиенту и печатается у него в консоли. Есть одна особенность, которую нужно
    // учитывать: клиент или сервер может написать несколько сообщений подряд. Такую ситуацию необходимо корректно обработать.
    //
    // Разобраться с кодом с занятия — он является фундаментом проекта-чата.
    // ВАЖНО! Сервер общается только с одним клиентом, т.е. не нужно запускать цикл, который будет ожидать второго/третьего/n-го клиента.

    public static final int SERVER_PORT = 9090;
    private static Socket socket;
    private static DataInputStream dis;
    private static DataOutputStream dos;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;

        try {
            ss = new ServerSocket(SERVER_PORT);
            System.out.println("Сервер запущен: " + ss);
            socket = ss.accept();
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Клиент подключился: " + socket);

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
                            System.out.println("Клиент: " + message);
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
            System.out.println("Сервер остановлен: " + ss);
            if (ss != null) ss.close();
            if (socket != null) socket.close();
        }

    }
}
