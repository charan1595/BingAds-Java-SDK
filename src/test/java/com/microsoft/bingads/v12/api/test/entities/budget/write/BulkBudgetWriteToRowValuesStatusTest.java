package com.microsoft.bingads.v12.api.test.entities.budget.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.budget.BulkBudgetTest;
import com.microsoft.bingads.v12.bulk.entities.BulkBudget;
import com.microsoft.bingads.v12.bulk.entities.Status;

@RunWith(Parameterized.class)
public class BulkBudgetWriteToRowValuesStatusTest extends BulkBudgetTest {

    @Parameter(value = 1)
    public Status propertyValue;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Active", Status.ACTIVE},
            {"Deleted", Status.DELETED},
            {null, null}
        });
    }

    @Test
    public void testWrite() {
        this.<Status>testWriteProperty("Status", this.datum, this.propertyValue, new BiConsumer<BulkBudget, Status>() {
            @Override
            public void accept(BulkBudget c, Status v) {
                c.setStatus(v);
            }
        });
    }
}
