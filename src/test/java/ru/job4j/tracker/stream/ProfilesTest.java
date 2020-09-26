package ru.job4j.tracker.stream;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest extends TestCase {

    Profiles  profiles = new Profiles();

    public void testCollect() {
        List<Profile> profile = new ArrayList<>();
                profile.add(new Profile(new Address("moscow", "tverskaya", 22, 143)));
                profile.add(new Profile(new Address("Volgograd", "Tsvetochnaya", 21, 13)));
        profile.add(new Profile(new Address("Volgograd", "Tsvetochnaya", 21, 13)));
      List<Address> rsl = profiles.collect(profile);
      List<Address> exp = new ArrayList<>();
      exp.add(new Address("Volgograd", "Tsvetochnaya", 21, 13));
      exp.add(new Address("moscow", "tverskaya", 22, 143));
       Assert.assertEquals(rsl, exp);
    }
}