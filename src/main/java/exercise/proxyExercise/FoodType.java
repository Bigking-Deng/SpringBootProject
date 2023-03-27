package exercise.proxyExercise;

public enum FoodType {
    bread("bread", 30, 10),
    cake("cake", 20, 5);

    String description;
    Integer costTime;
    Integer cleanTime;

    FoodType(String description, Integer costTime, Integer cleanTime) {
        this.description = description;
        this.costTime = costTime;
        this.cleanTime = cleanTime;
    }

}
