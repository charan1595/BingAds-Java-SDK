package com.microsoft.bingads.v12.api.test.entities.ad_group_dsa_target.read;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.microsoft.bingads.internal.functionalinterfaces.Function;
import com.microsoft.bingads.v12.api.test.entities.ad_group_dsa_target.BulkAdGroupDynamicSearchAdTargetTest;
import com.microsoft.bingads.v12.bulk.entities.BulkAdGroupDynamicSearchAdTarget;
import com.microsoft.bingads.v12.campaignmanagement.BiddableAdGroupCriterion;


public class BulkAdGroupDynamicSearchAdTargetReadTrackingTemplateTest extends BulkAdGroupDynamicSearchAdTargetTest{

	@Parameter(value = 1)
	public String expectedResult;
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"", ""},
			{"template", "template"},
		});
	}
	
	@Test
    public void testRead() {
        Map<String, String> values = new HashMap<String, String>();
        
        values.put("Tracking Template", datum);

        testReadProperty(
                values,
                expectedResult,
                new Function<BulkAdGroupDynamicSearchAdTarget, String>() {
                    @Override
                    public String apply(BulkAdGroupDynamicSearchAdTarget c) {
                        return ((BiddableAdGroupCriterion) c.getBiddableAdGroupCriterion()).getTrackingUrlTemplate();
                    }
                }
        );
    }
}
