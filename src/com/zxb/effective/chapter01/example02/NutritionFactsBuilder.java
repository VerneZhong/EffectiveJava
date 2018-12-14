package com.zxb.effective.chapter01.example02;

/**
 * Builder构建对象
 * @author Mr.zxb
 * @date 2018-12-11 16:27
 */
public class NutritionFactsBuilder {

    /**
     * ml required
     */
    private final int servingSize;
    /**
     * per container  required
     */
    private final int servings;
    /**
     * optional
     */
    private final int calories;
    /**
     * g  optional
     */
    private final int fat;
    /**
     * mg optional
     */
    private final int sodium;
    /**
     * g  optional
     */
    private final int carbohydrate;

    public NutritionFactsBuilder(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static class Builder {
        private final int servingSize;
        private final int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFactsBuilder builder() {
            return new NutritionFactsBuilder(this);
        }
    }

    public static void main(String[] args) {

        NutritionFactsBuilder builder = new NutritionFactsBuilder.Builder(240, 8).builder();
    }
}
