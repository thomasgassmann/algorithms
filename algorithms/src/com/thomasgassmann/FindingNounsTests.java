package com.thomasgassmann;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class FindingNounsTests {
    @Test
    public void CheckCorrectness() {
        Assertions.assertEquals(
                FindingNouns.CanFind(
                        "kuzdrabokrgostakdoshes",
                        new HashMap() {{
                            put("bokr", true);
                            put("bokrgos", true);
                            put("doshes", true);
                            put("drabok", true);
                            put("gostak", true);
                            put("kuz", true);
                            put("kuzdra", true);
                            put("takdos", true);
                        }}), true);
    }
}
