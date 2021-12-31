package com.casestudy.marsrover;

import com.casestudy.marsrover.common.BaseUnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class EntryToPlateauTest extends BaseUnitTest {

    @InjectMocks
    private EntryToPlateau entryToPlateau;

    @Test
    void begin() {
        String input = "5 5" + "\n" + "1 2 N" + "\n" + "LMLMLMLMM" + "\n" + "3 3 E" + "\n" + "MMRMMRMRRM";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        entryToPlateau.setScanner(new Scanner(System.in));
        entryToPlateau.begin();
    }
}
