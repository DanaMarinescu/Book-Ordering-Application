package org.loose.fis.sre.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.model.Order;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class OrderService {
    private static ObjectRepository<Order>orderRepository;

    public static void initDatabase(String publishingHouse) {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile(publishingHouse+"orders.db").toFile())
                .openOrCreate("test", "test");

        orderRepository = database.getRepository(Order.class);
    }
    public static void addOrder(Book bookOrdered, String status) {
        orderRepository.insert(new Order(bookOrdered.getTitle(),bookOrdered.getAuthorName(),bookOrdered.getYear(),bookOrdered.getPrice(),status));
    }

    public static void editStatus(Order order, String status){
       orderRepository.remove(order);
       orderRepository.insert(new Order(order.getBookTitle(),order.getAuthor(),order.getYear(),order.getPrice(),status));
    }

    public static void clearDatabase(){
        for (Order order: orderRepository.find()){
            orderRepository.remove(order);
        }
    }

    public static ObservableList<Order> getCurrentOrders(){
        ObservableList ordersList= FXCollections.observableArrayList();
        ordersList.removeAll();
        for (Order order:orderRepository.find()){
            if(order.getStatus().equals("Placed"))
            ordersList.add(order);
        }
        return ordersList;
    }

    public static ObservableList<Order> getPastOrders(){
        ObservableList ordersList= FXCollections.observableArrayList();
        ordersList.removeAll();
        for (Order order:orderRepository.find()){
            if(order.getStatus().equals("Delivered"))
            ordersList.add(order);
        }
        return ordersList;
    }
}
