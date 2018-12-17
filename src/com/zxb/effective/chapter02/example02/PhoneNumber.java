package com.zxb.effective.chapter02.example02;

import java.util.HashMap;
import java.util.Map;

/**
 * 覆盖equals方法时总要覆盖hashCode方法
 * hashCode规则：
 * 1. 把某个非零的常数值，比如说17，保存在一个名为result的int类型变量中
 * 2. 对于对象中每个关键域f（指equals方法中涉及的每个域），完成以下步骤：
 *      a. 为该域计算int类型的散列码c：
 *         i.   如果该域是boolean类型，则计算(f ? 1 : 0)
 *         ii.  如果该域是byte、char、short或者int类型，则计算(int)f
 *         iii. 如果该域是long类型，则计算(int) (f ^ (f >>> 32))
 *         iv.  如果该域是float类型，则计算Float.floatToInBits(f).
 *         v.   如果该域是double类型，则计算Double.doubleToLongBits(f)，然后按照步骤2.a.iii，为得到的long类型值计算散列值
 *         vi.  如果该域是一个对象引用，并且该类的equals方法通过递归地调用equals的方式来比较这个域，则同样为这个域递归地调用hashCode。
 *              如果需要更复杂的比较，则为这个域计算一个范式，然后针对这个范式调用hashCode。
 *              如果这个域的值为null，则返回0（或者其他某个常数，但通常是0）
 *         vii. 如果该域是一个数组，则要把每一个当作单独的域来处理，也就是说，递归地应用上述规则，对每个重要的元素计算一个散列码，然后
 *              根据步骤2.b中的做法把这些散列值组合起来。如果数组域中的每个元素都很重要，可以利用发行版本1.5增加的其中一个Array.hashCode方法
 *      b. 按照下面的公式，把步骤2.a中计算得到的散列码c合并到result中：result = 31 * result + c;
 * 3. 返回result
 * 4. 测试hashCode方法，是否具有“相等的实例是否都具有相等的散列码”。
 *
 *
 * @author Mr.zxb
 * @date 2018-12-13 16:18
 */
public class PhoneNumber implements Comparable<PhoneNumber> {

    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix code");
        rangeCheck(lineNumber, 9999, "lineNumber code");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ":" + arg);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) obj;
        return pn.lineNumber == lineNumber && pn.areaCode == areaCode && pn.prefix == prefix;
    }

    // Broken - no hashCode method
    @Override
    public int hashCode() {
        // 习惯上都使用素数来计算散列结果，31有个很好的特性即用移位和减法来代替乘法，可以得到更好的性能：31 * i == (i << 5) - i;
        int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }

    @Override
    public int compareTo(PhoneNumber o) {
        // Compare area codes
//        if (areaCode < o.areaCode) {
//            return -1;
//        }
//        if (areaCode > o.areaCode) {
//            return 1;
//        }
//        // Area codes are equal, compare prefixes
//        if (prefix < o.prefix) {
//            return -1;
//        }
//        if (prefix > o.prefix) {
//            return 1;
//        }
//        if (lineNumber < o.lineNumber) {
//            return -1;
//        }
//        if (lineNumber > o.lineNumber) {
//            return 1;
//        }

        // 优化如下：但使用起来非常小心，除非你确定相关的域不会为负值
        int areaCodeDiff = areaCode - o.areaCode;
        if (areaCodeDiff != 0) {
            return areaCodeDiff;
        }
        int prefixDiff = prefix - o.prefix;
        if (prefixDiff != 0) {
            return prefixDiff;
        }
        int lineNumberDiff = lineNumber - o.lineNumber;
        if (lineNumberDiff != 0) {
            return lineNumberDiff;
        }
        return 0;
    }

    public static void main(String[] args) {

        Map<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber(707, 867, 5309), "Jenny");

        System.out.println(map.get(new PhoneNumber(707, 867, 5309)));

    }

}
