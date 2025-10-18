package application;

import model.entities.Client;
import model.entities.Product;
import model.entities.enums.Order_Status;
import model.service.Order;
import model.service.OrderItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Start System
        System.out.println("Welcome to Order Management System!");
        System.out.println();

        //Client *
        System.out.println("Enter a client data!");
        System.out.print("Name: " );
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date: (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();

        LocalDate lDT = LocalDate.parse(birthDate, fmt01);
        Client client = new Client(name, email, lDT);
        //Client X

        //Status *
        System.out.print("Status: " );
        String status = sc.nextLine();
        Order_Status status00 = Order_Status.valueOf(status);
        Order order = new Order(now, status00, client);
        //Status X

        //Products *
        System.out.print("Please enter a quantity of item for this order: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter a #%d order data: \n", i + 1);
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            sc.nextLine();
            System.out.print("Product quantity: ");
            int productQuantity = sc.nextInt();
            sc.nextLine();

            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
            order.addOrderItem(orderItem);
        }
        //Products X
        System.out.println(order);




    }
}