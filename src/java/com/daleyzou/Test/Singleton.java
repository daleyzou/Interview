package com.daleyzou.Test;

/**
 * Singleton
 *
 * @author zoudaifa
 * @description singleton
 * @date 2022年01月14日 8:11 下午
 */
public class Singleton {
    private static class LazyHolder {

        private static Singleton singleton = new Singleton();

        static {
            System.out.println("LazyHolder.<clinit>");
        }
    }

    private Singleton() {

    }

    public static Object getInstance(boolean flag) {
        if (flag) {
            return new LazyHolder[2];
        } else {
            return LazyHolder.singleton;
        }
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("----");
        getInstance(false);
    }
}
