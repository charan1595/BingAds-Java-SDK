package com.microsoft.bingads.v12.api.test.entities.audience.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.audience.BulkProductAudienceTest;
import com.microsoft.bingads.v12.bulk.entities.BulkProductAudience;
import com.microsoft.bingads.v12.campaignmanagement.EntityScope;

@RunWith(Parameterized.class)
public class BulkProductAudienceWriteToRowValuesScopeTests extends BulkProductAudienceTest {

    @Parameter(value = 1)
    public EntityScope propertyValue;

    @Parameters
    public static Collection<Object[]> data() {
        // In this example, the parameter generator returns a List of
        // arrays.  Each array has two elements: { datum, expected }.
        // These data are hard-coded into the class, but they could be
        // generated or loaded in any way you like.
        return Arrays.asList(new Object[][]{
            {EntityScope.ACCOUNT.value(), EntityScope.ACCOUNT},
            {EntityScope.CUSTOMER.value(), EntityScope.CUSTOMER},
            {null, null}
        });
    }

    @Test
    public void testWrite() {
        this.<EntityScope>testWriteProperty("Scope", this.datum, this.propertyValue, new BiConsumer<BulkProductAudience, EntityScope>() {
            @Override
            public void accept(BulkProductAudience c, EntityScope v) {
                c.getProductAudience().setScope(v);
            }
        });
    }
}
