package com.wangzz.struct.binarytree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author wangzz
 * @date
 */
public class GenerateParenthesis {


    public static void main(String[] args) {

//        for (int i = 1; i <= 11; i++) {
//            Random random1 = new Random();
//            BigDecimal paymentAmount = new BigDecimal(String.valueOf(random1.nextDouble() * 10000000).substring(0, 10));
//            BigDecimal repaymentAmount = paymentAmount.multiply(new BigDecimal(String.valueOf(random1.nextDouble()).substring(0, 4)));
//            double mob0 = random1.nextDouble() * 0.2;
//            double mob30 = random1.nextDouble() * 0.2;
//            double mob60 = random1.nextDouble() * 0.2;
//            double mob90 = random1.nextDouble() * 0.2;
//            int next = i;
//            for (int j = 11; j >= i; j--) {
//                String month = String.valueOf(i < 10 ? "0" + i : i);
//                String nextmonth = String.valueOf(++next < 10 ? "0" + next : next);
//                System.out.println("INSERT INTO `tn_micro`.`finance_vintage_indicators` " +
//                        "(`scene_id`, `provider_id`, `payment_month`, `analyze_date`, `payment_amount`, " +
//                        "`repayment_amount`, `overdue_amount_rate`, `vintage_30_plus`, `vintage_60_plus`, " +
//                        "`vintage_90_plus`, `create_time`) " +
//                        "VALUES " +
//                        "('10000212', '10050021', '2019-" + month + "', '2019-" + nextmonth + "-28 00:00:00',  '" + paymentAmount +  "', " +
//                        "' " + repaymentAmount + "', '" + String.valueOf((mob0 = mob0 * 0.9)).substring(0, 6) + "', '" +
//                        String.valueOf((mob30 = mob30 * 0.9)).substring(0, 6) + "', '" + String.valueOf((mob60 = mob60 * 0.9)).substring(0, 6) +
//                        "', '" + String.valueOf((mob90 = mob90 * 0.9)).substring(0, 6) + "', '2019-" + month + "-28 15:01:07');");
//
//
//            }
//        }
        generateParenthesis(2);
        System.out.println(result);
    }

    private static List<String> result = new ArrayList<>();
    private static void generateParenthesis(int n) {
        generateOneByOne(0, 0, n, "");
    }

    private static void generateOneByOne(int left, int right, int n, String subResult) {
        if (left == n && right == n) {
            result.add(subResult);
            return;
        }
        if (left < n) {
            generateOneByOne(left + 1, right, n, subResult + "(");
        }
        if (left > right && right < n) {
            generateOneByOne(left, right + 1, n, subResult + ")");
        }
    }

}
