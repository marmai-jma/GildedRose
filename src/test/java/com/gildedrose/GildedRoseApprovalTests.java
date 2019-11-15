package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

@ExtendWith(MockitoExtension.class)
public class GildedRoseApprovalTests {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream out;

    @BeforeEach
    public void setUp() {
        out = System.out;
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(out);
    }

    @Test
    void approve_operations_on_2_days() {
        TexttestFixture.main(new String[0]);
        System.out.flush();
        Approvals.verify(output.toString());
    }

    @Test
    void approve_operations_on_60_days() {
        PrintStream out = System.out;
        TexttestFixture.main(new String[]{"60"});
        System.out.flush();
        Approvals.verify(output.toString());
    }
}
