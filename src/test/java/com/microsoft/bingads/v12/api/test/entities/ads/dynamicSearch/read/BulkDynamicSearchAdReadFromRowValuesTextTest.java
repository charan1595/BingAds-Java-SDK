package com.microsoft.bingads.v12.api.test.entities.ads.dynamicSearch.read;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v12.api.test.entities.ads.dynamicSearch.BulkDynamicSearchAdTest;
import com.microsoft.bingads.v12.bulk.entities.BulkDynamicSearchAd;

@RunWith(Parameterized.class)
public class BulkDynamicSearchAdReadFromRowValuesTextTest extends BulkDynamicSearchAdTest {

    @Parameter(value = 1)
    public String expectedResult;

    /*
     * Test data generator.
     * This method is called the the JUnit parameterized test runner and
     * returns a Collection of Arrays.  For each Array in the Collection,
     * each array element corresponds to a parameter in the constructor.
     */
    @Parameters
    public static Collection<Object[]> data() {
        // In this example, the parameter generator returns a List of
        // arrays.  Each array has two elements: { datum, expected }.
        // These data are hard-coded into the class, but they could be
        // generated or loaded in any way you like.
        return Arrays.asList(new Object[][]{
            {"Test Text 1", "Test Text 1"},
            {"", ""},
            {null, null}
        });
    }

    @Test
    public void testRead() {
        this.<String>testReadProperty("Text", this.datum, this.expectedResult, new Function<BulkDynamicSearchAd, String>() {
            @Override
            public String apply(BulkDynamicSearchAd c) {
                return c.getDynamicSearchAd().getText();
            }
        });
    }
}
