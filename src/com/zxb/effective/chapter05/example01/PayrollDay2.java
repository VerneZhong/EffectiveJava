package com.zxb.effective.chapter05.example01;

/**
 * The strategy enum pattern
 * 策略枚举模式
 * @author Mr.zxb
 * @date 2019-01-06 15:55:17
 */
public enum PayrollDay2 {

    MONDY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay2(PayType payType) {
        this.payType = payType;
    }

    /**
     * Calculating salary
     * @param hoursWorked
     * @param payRate
     * @return
     */
    double pay(double hoursWorked, double payRate) {
        return payType.pay(hoursWorked, payRate);
    }

    /**
     * The strategy enum type
     */
    private enum PayType {
        WEEKDAY {
            @Override
            double overtimePay(double hrs, double payRate) {
                return hrs <= HOURS_PER_SHIFT ? 0 : (hrs - HOURS_PER_SHIFT) * payRate /2;
            }
        },
        WEEKEND {
            @Override
            double overtimePay(double hrs, double payRate) {
                return hrs * payRate / 2;
            }
        };

        public static final int HOURS_PER_SHIFT = 8;

        abstract double overtimePay(double hrs, double payRate);

        public double pay(double hoursWorked, double payRate) {
            double base = hoursWorked * payRate;
            return base + overtimePay(hoursWorked, payRate);
        }
    }
}
