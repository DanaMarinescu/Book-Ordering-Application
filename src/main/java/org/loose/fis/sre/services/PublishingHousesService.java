package org.loose.fis.sre.services;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.ModelPH;
import org.loose.fis.sre.model.User;

import javax.validation.constraints.NotNull;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class PublishingHousesService {
    private static ObjectRepository<ModelPH> phRepository;

    public static void initDatabase() {
       Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("publishing-houses.db").toFile())
                .openOrCreate("test", "test");

        phRepository = database.getRepository(ModelPH.class);
    }

    @org.jetbrains.annotations.NotNull

    public static ObservableList<ModelPH> getPublishingHouses() {
        ObservableList<ModelPH> pubHouse = FXCollections.observableArrayList();
        for (ModelPH ph : phRepository.find()) {
            if(Objects.equals("Admin", ph.getRole()))
                pubHouse.add(new ModelPH(ph.getName(), ph.getRole()));
        }
        return pubHouse;
    }

    public static void addUser(String username, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        phRepository.insert(new ModelPH(username, role));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (ModelPH user : phRepository.find()) {
            if (Objects.equals(username, user.getName()))
                throw new UsernameAlreadyExistsException(username);
        }
    }
}
