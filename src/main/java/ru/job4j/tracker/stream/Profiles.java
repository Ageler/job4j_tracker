package ru.job4j.tracker.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        List<Address> addresses = profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
        return addresses;
    }
}
