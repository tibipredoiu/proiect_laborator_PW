package com.example.proiectfinal;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void TestCreateUser()
    {
        UserClass userClass = new UserClass();
        userClass.setPassword("test");
        userClass.setEmail("user1.admin@mail.ru");
        userClass.setLastName("test");
        userClass.setName("admin");

        UserClass savedUser = userRepository.save(userClass);

        UserClass existsUser = testEntityManager.find(UserClass.class, savedUser.getID());

        assertThat(existsUser.getEmail()).isEqualTo(userClass.getEmail());
    }

    @Test
    public void TestFindUserByEmail()
    {
        String email = "admin.uaz@mail.ru";

        UserClass userClass = userRepository.findByEmail(email);
        assertThat(userClass).isNotNull();
    }
}
