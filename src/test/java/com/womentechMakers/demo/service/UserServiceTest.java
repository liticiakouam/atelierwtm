package com.womentechMakers.demo.service;

import com.womentechMakers.demo.model.User;
import com.womentechMakers.demo.repository.UserRepository;
import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class UserServiceTest {

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final UserService userService = new UserServiceImpl(userRepository);

    @Test
    public void getUsers() {
        List<User> userList = Arrays.asList(
                User.builder().fullName("abc").age(2).build(),
                User.builder().fullName("liti").age(2).passWord("123").build()

        );
        Mockito.when(userRepository.findAll()).thenReturn(userList);




        List<User> users = userService.getAll();
        Assertions.assertEquals(2, users.size());
        Assertions.assertEquals("abc", users.get(0).getFullName());
    }
}
