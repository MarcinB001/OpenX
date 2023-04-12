package users;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private Address address;
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;

    public User() {
    }

    public User(int _id, Address _address) {
        id = _id;
        address = _address;
    }

    public User(int _id, Name _name) {
        id = _id;
        name = _name;
    }

    public User(users.Address _address, int _id, String _email, String _username, String _password, users.Name _name, String _phone) {
        address = _address;
        id = _id;
        email = _email;
        username = _username;
        password = _password;
        name = _name;
        phone = _phone;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Name getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

class Geolocation {
    private double lat;
    @JsonAlias({"long"})
    private double longg;

    public Geolocation() {
    }

    public Geolocation(double _lat, double _long) {
        lat = _lat;
        longg = _long;
    }

    public double getLat() {
        return lat;
    }

    public double getLongg() {
        return longg;
    }
}

record Address(users.Geolocation geolocation, String city, String street, int number, String zipcode) {
}
