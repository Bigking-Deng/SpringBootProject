package exercise.reflectionExercise;

public enum FraudIPDetectionAlgorithmEnums {

    SiteAndMeetingNumber(2310, 11, SiteAndMeetingNumberDetectionStrategy.class);

    private final int ruleId;
    private final int ruleJobId;
    private final Class<?> clazz;

    FraudIPDetectionAlgorithmEnums(int ruleId, int ruleJobId, Class<?> clazz) {
        this.ruleId = ruleId;
        this.ruleJobId = ruleJobId;
        this.clazz = clazz;
    }

    public int getRuleId() {
        return ruleId;
    }

    public int getRuleJobId() {
        return ruleJobId;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}