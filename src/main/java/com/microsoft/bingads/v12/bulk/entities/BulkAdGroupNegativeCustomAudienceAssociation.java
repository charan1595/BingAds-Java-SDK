package com.microsoft.bingads.v12.bulk.entities;

import com.microsoft.bingads.Authentication;
import com.microsoft.bingads.HeadersImpl;
import com.microsoft.bingads.v12.bulk.BulkFileReader;
import com.microsoft.bingads.v12.bulk.BulkFileWriter;
import com.microsoft.bingads.v12.bulk.BulkOperation;
import com.microsoft.bingads.v12.bulk.BulkServiceManager;
import com.microsoft.bingads.v12.campaignmanagement.*;
import com.microsoft.bingads.v12.internal.bulk.StringExtensions;
import com.microsoft.bingads.v12.internal.bulk.StringTable;
import com.microsoft.bingads.v12.internal.bulk.BulkMapping;
import com.microsoft.bingads.v12.internal.bulk.MappingHelpers;
import com.microsoft.bingads.v12.internal.bulk.RowValues;
import com.microsoft.bingads.v12.internal.bulk.SimpleBulkMapping;
import com.microsoft.bingads.v12.internal.bulk.entities.SingleRecordBulkEntity;
import com.microsoft.bingads.internal.functionalinterfaces.BiConsumer;
import com.microsoft.bingads.internal.functionalinterfaces.Function;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents an Ad Group Negative Custom Audience Association that can be read or written in a bulk file.
 * <p/>
 * This class exposes the {@link #setAdGroupCriterion} and {@link #getAdGroupCriterion} methods
 * that can be used to read and write fields of the Ad Group Negative Custom Audience Association record in a bulk file.
 * <p/>
 * <p>
 * For more information, see Ad Group Negative Custom Audience Association at
 * <a href="https://go.microsoft.com/fwlink/?linkid=846127">https://go.microsoft.com/fwlink/?linkid=846127</a>.
 * </p>
 *
 * @see BulkServiceManager
 * @see BulkOperation
 * @see BulkFileReader
 * @see BulkFileWriter
 */
public class BulkAdGroupNegativeCustomAudienceAssociation extends SingleRecordBulkEntity {

    private NegativeAdGroupCriterion negativeAdGroupCriterion;

    private String campaignName;

    private String adGroupName;

    private String customAudienceName;

    private PerformanceData performanceData;

    private static final List<BulkMapping<BulkAdGroupNegativeCustomAudienceAssociation>> MAPPINGS;

    static {
        List<BulkMapping<BulkAdGroupNegativeCustomAudienceAssociation>> m = new ArrayList<BulkMapping<BulkAdGroupNegativeCustomAudienceAssociation>>();

        m.add(new SimpleBulkMapping<BulkAdGroupNegativeCustomAudienceAssociation, String>(StringTable.Status,
                new Function<BulkAdGroupNegativeCustomAudienceAssociation, String>() {
                    @Override
                    public String apply(BulkAdGroupNegativeCustomAudienceAssociation c) {
                        AdGroupCriterionStatus status = c.getNegativeAdGroupCriterion().getStatus();

                        return status == null ? null : status.value();
                    }
                },
                new BiConsumer<String, BulkAdGroupNegativeCustomAudienceAssociation>() {
                    @Override
                    public void accept(String v, BulkAdGroupNegativeCustomAudienceAssociation c) {
                        c.getNegativeAdGroupCriterion().setStatus(StringExtensions.parseOptional(v, new Function<String, AdGroupCriterionStatus>() {
                            @Override
                            public AdGroupCriterionStatus apply(String s) {
                                return AdGroupCriterionStatus.fromValue(s);
                            }
                        }));
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkAdGroupNegativeCustomAudienceAssociation, Long>(StringTable.Id,
                new Function<BulkAdGroupNegativeCustomAudienceAssociation, Long>() {
                    @Override
                    public Long apply(BulkAdGroupNegativeCustomAudienceAssociation c) {
                        return c.getNegativeAdGroupCriterion().getId();
                    }
                },
                new BiConsumer<String, BulkAdGroupNegativeCustomAudienceAssociation>() {
                    @Override
                    public void accept(String v, BulkAdGroupNegativeCustomAudienceAssociation c) {
                        c.getNegativeAdGroupCriterion().setId(StringExtensions.<Long>parseOptional(v, new Function<String, Long>() {
                            @Override
                            public Long apply(String value) {
                                return Long.parseLong(value);
                            }
                        }));
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkAdGroupNegativeCustomAudienceAssociation, Long>(StringTable.ParentId,
                new Function<BulkAdGroupNegativeCustomAudienceAssociation, Long>() {
                    @Override
                    public Long apply(BulkAdGroupNegativeCustomAudienceAssociation c) {
                        return c.getNegativeAdGroupCriterion().getAdGroupId();
                    }
                },
                new BiConsumer<String, BulkAdGroupNegativeCustomAudienceAssociation>() {
                    @Override
                    public void accept(String v, BulkAdGroupNegativeCustomAudienceAssociation c) {
                        c.getNegativeAdGroupCriterion().setAdGroupId(StringExtensions.<Long>parseOptional(v, new Function<String, Long>() {
                            @Override
                            public Long apply(String value) {
                                return Long.parseLong(value);
                            }
                        }));
                    }
                }
        ));


        m.add(new SimpleBulkMapping<BulkAdGroupNegativeCustomAudienceAssociation, String>(StringTable.Campaign,
                new Function<BulkAdGroupNegativeCustomAudienceAssociation, String>() {
                    @Override
                    public String apply(BulkAdGroupNegativeCustomAudienceAssociation c) {
                        return c.getCampaignName();
                    }
                },
                new BiConsumer<String, BulkAdGroupNegativeCustomAudienceAssociation>() {
                    @Override
                    public void accept(String v, BulkAdGroupNegativeCustomAudienceAssociation c) {
                        c.setCampaignName(v);
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkAdGroupNegativeCustomAudienceAssociation, String>(StringTable.AdGroup,
                new Function<BulkAdGroupNegativeCustomAudienceAssociation, String>() {
                    @Override
                    public String apply(BulkAdGroupNegativeCustomAudienceAssociation c) {
                        return c.getAdGroupName();
                    }
                },
                new BiConsumer<String, BulkAdGroupNegativeCustomAudienceAssociation>() {
                    @Override
                    public void accept(String v, BulkAdGroupNegativeCustomAudienceAssociation c) {
                        c.setAdGroupName(v);
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkAdGroupNegativeCustomAudienceAssociation, String>(StringTable.Audience,
                new Function<BulkAdGroupNegativeCustomAudienceAssociation, String>() {
                    @Override
                    public String apply(BulkAdGroupNegativeCustomAudienceAssociation c) {
                        return c.getCustomAudienceName();
                    }
                },
                new BiConsumer<String, BulkAdGroupNegativeCustomAudienceAssociation>() {
                    @Override
                    public void accept(String v, BulkAdGroupNegativeCustomAudienceAssociation c) {
                        c.setCustomAudienceName(v);
                    }
                }
        ));

        m.add(new SimpleBulkMapping<BulkAdGroupNegativeCustomAudienceAssociation, Long>(StringTable.AudienceId,
                new Function<BulkAdGroupNegativeCustomAudienceAssociation, Long>() {
                    @Override
                    public Long apply(BulkAdGroupNegativeCustomAudienceAssociation c) {
                        if (c.getNegativeAdGroupCriterion() instanceof NegativeAdGroupCriterion) {
                            AudienceCriterion audienceCriterion = (AudienceCriterion) c.getNegativeAdGroupCriterion().getCriterion();
                            if (audienceCriterion == null) {
                                return null;
                            } else {
                                return audienceCriterion.getAudienceId();
                            }
                        } else {
                            return null;
                        }
                    }
                },
                new BiConsumer<String, BulkAdGroupNegativeCustomAudienceAssociation>() {
                    @Override
                    public void accept(String v, BulkAdGroupNegativeCustomAudienceAssociation c) {
                        AudienceCriterion audienceCriterion = (AudienceCriterion) c.getNegativeAdGroupCriterion().getCriterion();
                        if (audienceCriterion == null) {
                            return;
                        }

                        audienceCriterion.setAudienceId(StringExtensions.<Long>parseOptional(v, new Function<String, Long>() {
                            @Override
                            public Long apply(String value) {
                                return Long.parseLong(value);
                            }
                        }));
                    }
                }
        ));

        MAPPINGS = Collections.unmodifiableList(m);
    }

    @Override
    public void processMappingsFromRowValues(RowValues values) {
        NegativeAdGroupCriterion adGroupCriterion = new NegativeAdGroupCriterion();
        adGroupCriterion.setType(NegativeAdGroupCriterion.class.getSimpleName());

        AudienceCriterion audienceCriterion = new AudienceCriterion();
        audienceCriterion.setType(AudienceCriterion.class.getSimpleName());

        adGroupCriterion.setCriterion(audienceCriterion);

        this.setNegativeAdGroupCriterion(adGroupCriterion);

        MappingHelpers.convertToEntity(values, MAPPINGS, this);

        performanceData = PerformanceData.readFromRowValuesOrNull(values);
    }

    @Override
    public void processMappingsToRowValues(RowValues values, boolean excludeReadonlyData) {
        validatePropertyNotNull(getNegativeAdGroupCriterion(), "AdGroupCustomAudienceAssociation");

        MappingHelpers.convertToValues(this, values, MAPPINGS);

        if (!excludeReadonlyData) {
            PerformanceData.writeToRowValuesIfNotNull(performanceData, values);
        }
    }

    /**
     * Gets an AdGroup Criterion.
     */
    public NegativeAdGroupCriterion getNegativeAdGroupCriterion() {
        return this.negativeAdGroupCriterion;
    }

    /**
     * Sets an AdGroup Criterion.
     */
    public void setNegativeAdGroupCriterion(NegativeAdGroupCriterion adGroupCriterion) {
        this.negativeAdGroupCriterion = adGroupCriterion;
    }

    /**
     * Gets the name of the campaign.
     * Corresponds to the 'Campaign' field in the bulk file.
     */
    public String getCampaignName() {
        return this.campaignName;
    }

    /**
     * Sets the name of the campaign.
     * Corresponds to the 'Campaign' field in the bulk file.
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    /**
     * Gets the name of the ad group.
     */
    public String getAdGroupName() {
        return this.adGroupName;
    }

    /**
     * Sets the name of the ad group.
     */
    public void setAdGroupName(String adGroupName) {
        this.adGroupName = adGroupName;
    }

    /**
     * Gets the name of the custom audience.
     */
    public String getCustomAudienceName() {
        return this.customAudienceName;
    }

    /**
     * Sets the name of the custom audience.
     */
    public void setCustomAudienceName(String customAudienceName) {
        this.customAudienceName = customAudienceName;
    }
}
