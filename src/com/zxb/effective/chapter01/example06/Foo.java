package com.zxb.effective.chapter01.example06;

/**
 * 终结方法守卫者：finalizer guardian idiom
 * @author Mr.zxb
 * @date 2018-12-12 16:46
 */
public class Foo {

    /**
     * Sole purpose of this object is to finalizer outer Foo object
     * 此对象的唯一目的是终结外部Foo对象
     */
    private final Object finalizerGuardian = new Object() {
        @Override
        protected void finalize() throws Throwable {
            // Finalize outer Foo object
            super.finalize();
        }
    };

    // ...其他方法
}
