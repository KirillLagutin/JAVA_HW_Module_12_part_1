/*
    Задание 1
Создайте веб-приложение, которое позволит клиенту заказать пиццу.
Пользователь выбирает пиццу из списка готовых пицц:
 ■Маргарита;
 ■Четыре сыра;
 ■Капричоза;
 ■Гавайская.
Клиент указывает имя, контактный телефон, email, адрес доставки.

    Задание 2
Добавьте к первому заданию возможность добавления
топпингов (оливки, каперсы, дополнительный сыр и т. д.)
к существующему рецепту пиццы.

    Задание 3
Добавьте ко второму заданию конструктор пиццы.
С помощью него пользователь может создать свой рецепт пиццы.
*/

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String pizzaName = null;

        System.out.println("Choose a pizza");
        System.out.println("Margarita: enter 1");
        System.out.println("Four cheeses: enter 2");
        System.out.println("Capriccioza: enter 3");
        System.out.println("Hawaiian: enter 4");
        System.out.print("Please make a choice: ");
        int choice = new Scanner(System.in).nextInt();

        if(choice==1){
            pizzaName = "Margarita";
        }
        if(choice==1){
            pizzaName = "Four cheeses";
        }
        if(choice==1){
            pizzaName = "Capriccioza";
        }
        if(choice==1){
            pizzaName = "Hawaiian";
        }

        //Pizza pizza = new Pizza(pizzaName);

        /* Sending */
        InetAddress ia = InetAddress.getByName("10.3.60.112");
        int port = 19999;
        byte[] dataSend = pizzaName.getBytes();
        DatagramPacket packetSend = new DatagramPacket(dataSend, dataSend.length, ia, port);
        DatagramSocket socketSend = new DatagramSocket();
        socketSend.send(packetSend);

        /* Receiving */
        DatagramSocket socketGet = new DatagramSocket(port);
        byte[] buffer = new byte[10240];
        DatagramPacket packetGet = new DatagramPacket(buffer, buffer.length);
        socketGet.receive(packetGet);
        byte[] dataGet = packetGet.getData();
        String strGet = new String(dataGet, 0, dataGet.length);
        System.out.println(strGet);
    }
}
