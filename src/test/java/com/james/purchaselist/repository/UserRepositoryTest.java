package com.james.purchaselist.repository;

import com.james.purchaselist.domain.model.entity.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends PartnerRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;


    @Test
    public void create() {
        Users user = new Users();

        user.setAccount("testUser03")
                .setEmail("testUser@gmail.com")
                .setPassword("password")
                .setPhoneNumber("010-1234-5678");

        Users newUser = usersRepository.save(user);

        newUser.setModifiedBy("changed");
        usersRepository.save(newUser);
        Assertions.assertNotNull(newUser);


    }


}
