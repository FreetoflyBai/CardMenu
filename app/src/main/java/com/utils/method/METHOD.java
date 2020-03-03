package com.utils.method;

/**
 * author   : kevin.bai
 * date      : 2020-03-03 22:11
 * qq        :904869397@qq.com
 */
public class METHOD {

        public static void main(String[] args) {
            productMethod();
        }

        private static void productMethod() {
            for (int i = 0; i < 10000; i++) {
                System.out.println("private void method" + i + "(){");
                if (i == 0) {
                    System.out.println("    method" + 9999 + "();");
                } else {

                    System.out.println("    method" + (i - 1) + "();");
                }
                System.out.println("}");
            }
        }

}
