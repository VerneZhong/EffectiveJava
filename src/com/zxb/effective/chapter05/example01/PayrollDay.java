package com.zxb.effective.chapter05.example01;

/**
 * Enum that switches on its value to share code - questionable
 * Enum打开它的值来共享代码 - 值得怀疑
 *
 * @author Mr.zxb
 * @date 2019-01-06 15:42:32
 */
public enum PayrollDay {
    MONDY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    private static final int HOURS_PER_SHIFT = 8;

    double pay(double hoursWorked, double payRate) {
        double basePay = hoursWorked * payRate;

        // Calculate overtime pay 计算加班费
        double overtimePay;
        switch (this) {
            case SATURDAY:
            case SUNDAY:
                overtimePay = hoursWorked * payRate / 2;
            default:
                // Weekdays
                    overtimePay = hoursWorked <= HOURS_PER_SHIFT ? 0 : (hoursWorked - HOURS_PER_SHIFT) * payRate /2;
                    break;
        }
        return basePay + overtimePay;
    }
}
