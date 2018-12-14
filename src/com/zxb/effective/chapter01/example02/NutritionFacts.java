package com.zxb.effective.chapter01.example02;

/**
 * 遇到多个构造器参数时要考虑有Builder模式
 * 营养成分类
 * @author Mr.zxb
 * @date 2018-12-11 16:06
 */
public class NutritionFacts {

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

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts(240, 8);
    }
}
