package ru.job4j.tracker.stream;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest extends TestCase {

    Profiles  profiles = new Profiles();

    public void testCollect() {
        List<Profile> profile = Arrays.asList(
                new Profile(new Address("Volgograd", "Tsvetochnaya", 21, 13)));
      List<Address> rsl = profiles.collect(profile);
        assertThat(rsl.get(0).getCity(), is("Volgograd"));
    }
}