package ru.job4j.tracker.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = profiles.stream()
                .map(profile -> profile.getAddress())
                .distinct()
                .sorted((Comparator.comparing(Address::getCity)))
                .collect(Collectors.toList());
        return addresses;
    }
}
