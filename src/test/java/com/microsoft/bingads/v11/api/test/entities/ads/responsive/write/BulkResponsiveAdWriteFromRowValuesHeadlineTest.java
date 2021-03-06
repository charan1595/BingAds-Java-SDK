package com.microsoft.bingads.v11.api.test.entities.ads.responsive.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v11.api.test.entities.ads.responsive.BulkResponsiveAdTest;
import com.microsoft.bingads.v11.bulk.entities.BulkResponsiveAd;

public class BulkResponsiveAdWriteFromRowValuesHeadlineTest extends BulkResponsiveAdTest {

    @Parameterized.Parameter(value = 1)
    public String expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Headline string", "Headline string"},
                {null, null}
        });
    }

    @Test
    public void testWrite() {
        this.testWriteProperty("Headline", this.datum, this.expectedResult, new BiConsumer<BulkResponsiveAd, String>() {
            @Override
            public void accept(BulkResponsiveAd c, String v) {
                c.getResponsiveAd().setHeadline(v);
            }
        });
    }
}
