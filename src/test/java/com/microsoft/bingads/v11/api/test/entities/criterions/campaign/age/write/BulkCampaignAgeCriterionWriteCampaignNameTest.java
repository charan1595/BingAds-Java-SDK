package com.microsoft.bingads.v11.api.test.entities.criterions.campaign.age.write;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.v11.api.test.entities.criterions.campaign.age.BulkCampaignAgeCriterionTest;
import com.microsoft.bingads.v11.bulk.entities.BulkCampaignAgeCriterion;

@RunWith(Parameterized.class)
public class BulkCampaignAgeCriterionWriteCampaignNameTest extends BulkCampaignAgeCriterionTest {

    @Parameterized.Parameter(value = 1)
    public String propertyValue;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {"123", "123"},
                        {"XXX YYY", "XXX YYY"},
                        {"", ""},
                        {null, null}
                }
        );
    }

    @Test
    public void testWrite() {
        testWriteProperty(
                "Campaign",
                datum,
                propertyValue,
                new BiConsumer<BulkCampaignAgeCriterion, String>() {
                    @Override
                    public void accept(BulkCampaignAgeCriterion c, String v) {
                        c.setCampaignName(v);
                    }
                }
        );
    }
}
