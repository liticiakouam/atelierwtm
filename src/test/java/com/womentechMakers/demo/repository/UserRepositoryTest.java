package com.womentechMakers.demo.repository;

import com.womentechMakers.demo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:mysql://localhost:3306/atelierwtm?createDatabaseIfExist=true&useSSL=false&serverTimezone=UTC\n"
})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testShouldReturnUsers() {
        List<User> users = userRepository.findAll();

        Assertions.assertEquals(2, users.size());
    }

    @Test
    public void testShouldSaveUser() {
        User user = User.builder().age(2).fullName("akl").build();
        User userSave = userRepository.save(user);

        Assertions.assertEquals(2, userSave.getAge());
    }


}
