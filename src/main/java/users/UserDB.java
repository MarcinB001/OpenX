package users;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.NullUserException;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static java.util.Objects.isNull;

public class UserDB {

    private List<User> users;

    public UserDB() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        users = objectMapper.readValue(new URL("https://fakestoreapi.com/users"), new TypeReference<>() {
        });
    }

    public User getUser(int userId) {
        for (User user : users) {
            if (user.getId() == userId)
                return user;
        }
        return null;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getFurthestUsers() {
        User firstUser = null;
        User secondUser = null;
        double maxDistance = 0.0;
        for (User user1 : users) {
            double x1 = user1.getAddress().geolocation().getLongg();
            double y1 = user1.getAddress().geolocation().getLat();
            for (User user2 : users) {
                double x2 = user2.getAddress().geolocation().getLongg();
                double y2 = user2.getAddress().geolocation().getLat();
                double distance = Math.hypot(x1 - x2, y1 - y2);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    firstUser = user1;
                    secondUser = user2;
                }
            }
        }

        if (isNull(firstUser) || isNull(secondUser)) {
            throw new NullUserException("");
        }

        return List.of(firstUser, secondUser);
    }

}
