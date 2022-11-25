package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    public void testPhrases() {
        String given = "kajak";

        boolean result = Main.check(given);

        assertTrue(result);

    }

}


//Phrases: [, "Dogma I am God", "Live on time, emit no evil" ...]
//
//        Numbers: [111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...]
//
//        Words: [radar, level, rotor, kayak, reviver, racecar, madam, ...]