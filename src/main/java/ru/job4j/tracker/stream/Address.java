package ru.job4j.tracker.stream;

public class Address {
    private String city;
    private String street;
    private int apartment;
    private int home;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }
}
