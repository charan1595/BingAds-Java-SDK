package com.microsoft.bingads.v12.api.test.entities.criterions.adgroup.radius.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v12.api.test.entities.criterions.adgroup.radius.BulkAdGroupRadiusCriterionTest;
import com.microsoft.bingads.v12.bulk.entities.BulkAdGroupRadiusCriterion;
import com.microsoft.bingads.v12.campaignmanagement.RadiusCriterion;

@RunWith(Parameterized.class)
public class BulkAdGroupRadiusCriterionWriteNameTest extends BulkAdGroupRadiusCriterionTest {

    @Parameterized.Parameter(value = 1)
    public String propertyValue;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                	{"Test1", "Test1"},
                    {"Test 2", "Test 2"},
                    {"", ""},
                    {null, null}
                }
        );
    }

    @Test
    public void testWrite() {
        testWriteProperty(
                "Name",
                datum,
                propertyValue,
                new BiConsumer<BulkAdGroupRadiusCriterion, String>() {
                    @Override
                    public void accept(BulkAdGroupRadiusCriterion c, String v) {
                        ((RadiusCriterion)c.getBiddableAdGroupCriterion().getCriterion()).setName(v);
                    }
                }
        );
    }
}
