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

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("orders.db").toFile())
                .openOrCreate("test", "test");

        orderRepository = database.getRepository(Order.class);
    }
    public static void addOrder(Book bookOrdered, String status) {
        orderRepository.insert(new Order(bookOrdered,status));
    }
    public static ObservableList<Order> getOrders(String publishingHouse){
        ObservableList ordersList= FXCollections.observableArrayList();
        ordersList.removeAll();
        for (Order order:orderRepository.find()){
            ordersList.add(order);
        }
        return ordersList;
    }
}
