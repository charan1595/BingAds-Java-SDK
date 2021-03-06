package com.microsoft.bingads.v12.api.test.entities.budget.read;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v12.api.test.entities.budget.BulkBudgetTest;
import com.microsoft.bingads.v12.bulk.entities.BulkBudget;

public class BulkBudgetReadFromRowValuesBudgetNameTest extends BulkBudgetTest {

    @Parameter(value = 1)
    public String expectedResult;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Test Budget 1", "Test Budget 1"},
            {"", ""},
            {null, null}
        });
    }

    @Test
    public void testRead() {
        this.<String>testReadProperty("Budget Name", this.datum, this.expectedResult, new Function<BulkBudget, String>() {
            @Override
            public String apply(BulkBudget c) {
                return c.getBudget().getName();
            }
        });
    }
}
