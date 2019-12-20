package org.ly817.sparrow;

import java.util.UUID;

/**
 * @author LY
 * @date 2019/08/21 14:42
 * <p>
 * Description:
 */
public class Main {
    public static void main(String[] args) {

//        String[] strings = "eqwe-fqtf-qwewe-luoyu666".split("-");
//        System.out.println(strings[strings.length - 1]);

        test();

//        new Thread(() -> {
//            Main.test1();
//        }).start();// run并没有开一个新的线程
//        System.out.println("after");
    }

    public static void test() {
        System.out.println("test");
    }

    public void paramTest(String a) {
        String b = "b";
    }

//    public static void test1() {
//        System.out.println("test1");
//    }
}
