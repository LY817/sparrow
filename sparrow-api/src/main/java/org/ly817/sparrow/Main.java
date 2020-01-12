package org.ly817.sparrow;

import javafx.util.BuilderFactory;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;

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

//        test();

//        new Thread(() -> {
//            Main.test1();
//        }).start();// run并没有开一个新的线程
//        System.out.println("after");

//        List<String> list = new ArrayList<>();
//        list.add("123");
//        test(list);
//        System.out.println(list);
        A c = new A();
//        x.setB("a");
        String x = "s";
//        paramTest(x);
//        System.out.println(x.getB());
        Consumer<String> consumer = System.out::println;
        consumer.accept(x);
        ArrayList arrayList = (ArrayList) Collections.emptyList();

        IntUnaryOperator function = (int i) -> {
            // 逻辑
            return i * 2;
        };

        IntUnaryOperator function1 = i -> i * 2;

        BuilderFactory builderFactory = (a) -> A::new;

        Function<String,String> toStr = c::doStr;

    }

    public static void test() {
        System.out.println("test");
    }
    public static void test(List<String> list) {
        list.clear();
        list.add("456");
//        list = null;
    }
    public static void test(Integer i) {
        i = 2;
    }

    public static void paramTest(A a) {
        a.setB("b");
        a = null;
    }

//    public static void test1() {
//        System.out.println("test1");
//    }
    Consumer<Integer> consumer = System.out::println;


    static class A {
         void doa() {

        }

        private String b;

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return b;
        }

        public String doStr(String str) {
            return "===" + str;
        }

        public static String doStaticStr(String str) {
            return "===" + str;
        }
    }

    interface ai {
        static void aia() {

        }
    }

}
