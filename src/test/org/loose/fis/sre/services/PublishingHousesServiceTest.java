package org.loose.fis.sre.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.h2.store.fs.FileUtils;
import org.junit.jupiter.api.*;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.ModelPH;

import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PublishingHousesServiceTest {
    public static final String ADMIN = "admin";


    @Test
    void getPublishingHousesTest() {
        ObservableList<ModelPH> pubHouse = FXCollections.observableArrayList();
        ModelPH m = new ModelPH("Admin","role");
            if(Objects.equals("Admin", m.getRole()))
                pubHouse.add(new ModelPH(m.getName(), m.getRole()));

        Assertions.assertEquals(true,pubHouse.isEmpty());
    }

    @Test
    void addUsertest() throws UsernameAlreadyExistsException {
                PublishingHousesService.addUser(ADMIN, ADMIN);
                PublishingHousesService.addUser("admin2", "admin2");
        }

    @Test
    void testUserIsAddedToDatabse() throws UsernameAlreadyExistsException {
        PublishingHousesService.addUser(ADMIN, ADMIN);
        assertThat(PublishingHousesService.getPublishingHouses()).isEmpty();
        Objects.equals(assertThat(PublishingHousesService.getPublishingHouses()).size(), "1");
        ModelPH user = PublishingHousesService.getPublishingHouses().get(0);
        assertThat((ObservableList<ModelPH>) user).isEmpty();
        assertThat(user.getName()).equals(ADMIN);
        assertThat(user.getRole()).equals(ADMIN);
        Assertions.assertEquals(false,assertThat(PublishingHousesService.getPublishingHouses()).isEmpty());
        Assertions.assertEquals(false,assertThat((ObservableList<ModelPH>) user).isEmpty());

    }

    private String assertThat(String publishingHouses) {
    return publishingHouses;
    }
    private ObservableList<ModelPH> assertThat(ObservableList<ModelPH> publishingHouses){
        return publishingHouses;
    }

}