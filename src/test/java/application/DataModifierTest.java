package application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataModifierTest {

    @Test
    void replaceNasaWithFbi() {
        String stringWithNasa = "NASA to Broadcast Final Parachute Test for Orion Spacecraft";
        String stringWithoutNasa = "Colorado Students to Speak with Astronauts on International Space Station";
        String expectedWithNasa = "FBI to Broadcast Final Parachute Test for Orion Spacecraft";
        String expectedWithoutNasa = "Colorado Students to Speak with Astronauts on International Space Station SAMPLE";

        assertEquals(expectedWithNasa, DataModifier.replaceNasaWithFbi(stringWithNasa));
        assertEquals(expectedWithoutNasa, DataModifier.replaceNasaWithFbi(stringWithoutNasa));
    }
}