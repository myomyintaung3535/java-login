package dev.startup.javaloginapp;

import dev.startup.javaloginapp.model.User;
import dev.startup.javaloginapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setFirstName("Aung");
        user.setLastName("Thu");
        user.setEmail("aungthu.tester@gmail.com");
        user.setPassword("@ungthu.t3st3r");
        User savedUser =  repo.save(user);
        User existUser = entityManager.find(User.class,savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(savedUser.getEmail());
    }

}
