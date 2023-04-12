package users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDBTest {

    User user1 = new User(1, new Address(new Geolocation(-10, -10), null, null, 0, null));
    User user2 = new User(2, new Address(new Geolocation(0, 0), null, null, 0, null));
    User user3 = new User(3, new Address(new Geolocation(10, 10), null, null, 0, null));
    User user4 = new User(4, new Address(new Geolocation(7, 5), null, null, 0, null));
    UserDB userDB;

    @BeforeEach
    void beforeEach() throws IOException {
        List<User> users = List.of(user1, user3, user3, user4);

        userDB = new UserDB();
        userDB.setUsers(users);
    }

    @Test
    void shouldReturnUser3() {
        assertEquals(user3, userDB.getUser(3));
    }

    @Test
    void shouldReturnUser1And2() {

        List<User> furthestUsers = List.of(user1, user3);

        assertEquals(furthestUsers, userDB.getFurthestUsers());
    }
}