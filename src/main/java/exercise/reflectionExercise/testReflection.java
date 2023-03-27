package exercise.reflectionExercise;

public class testReflection {
    public static void main(String[] args) {
        try {
            String clazz1 = Class.forName(FraudIPDetectionAlgorithmEnums.SiteAndMeetingNumber.getClazz().getName()).toString();
            Thread.sleep(3000000);
//            BaseIPDetectionStrategy detectionBean = Class.forName(FraudIPDetectionAlgorithmEnums.SiteAndMeetingNumber.getClazz().toString()).asSubclass(BaseIPDetectionStrategy.class).newInstance();
//            System.out.println(detectionBean.toString());
            System.out.println(clazz1.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
