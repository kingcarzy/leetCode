package code0002;

import javax.lang.model.element.VariableElement;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    /**
     * [9]
     * [1,9,9,9,9,9,9,9,9,9]
     * @param args
     */
    public static void main(String[] args) {
        ListNode firstNode = new ListNode(9);
        ListNode secondNode = new ListNode(1, new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode listNode = addTwoNumbers2(firstNode, secondNode);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (listNode != null){
            stringBuilder.append(listNode.val);
            stringBuilder.append(",");
            listNode = listNode.next;
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int num1 = 0;
        int num2 = 0;
        int overflow = 0;
        int sum = 0;
        ListNode resultNode = new ListNode();
        ListNode p = resultNode;
        while (p1 != null || p2 != null || overflow == 1){
            if (p1 != null){
                num1 = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                num2 = p2.val;
                p2 = p2.next;
            }
            sum = num1 + num2 + overflow;
            if (sum > 9){
                overflow = 1;
                sum = sum - 10;
            }else{
                overflow = 0;
            }
            p.val = sum;
            if (p1 != null || p2 != null || overflow == 1){
                p.next = new ListNode();
                p = p.next;
            }
            num1 = 0;
            num2 = 0;

        }
        return resultNode;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = l1;
        BigInteger num1 = new BigInteger("0");
        BigInteger num2 = new BigInteger("0");
        BigInteger mul = new BigInteger("1");
        while(listNode != null){
            num1 = mul.multiply(BigInteger.valueOf(listNode.val)).add(num1);
            mul = mul.multiply(BigInteger.valueOf(10));
            listNode = listNode.next;
        }
        listNode = l2;
        mul = BigInteger.valueOf(1);
        while(listNode != null){
            num2 = mul.multiply(BigInteger.valueOf(listNode.val)).add(num2);
            mul = mul.multiply(BigInteger.valueOf(10));
            listNode = listNode.next;
        }
        BigInteger sum = num1.add(num2);
        // 取模
        mul = BigInteger.valueOf(10);
        ListNode returnNode = new ListNode();
        listNode = returnNode;
        BigInteger remainder = new BigInteger("0");
        int val = 0;
        while (sum.compareTo(BigInteger.ZERO) == 1){
            remainder = sum.remainder(mul);
            val = (remainder.multiply(BigInteger.valueOf(10)).divide(mul)).intValue();
            listNode.val = val;
            mul = mul .multiply(BigInteger.valueOf(10));
            sum = sum.subtract(remainder);
            if (sum.compareTo(BigInteger.ZERO) == 1){
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }
        return returnNode;
    }
}
