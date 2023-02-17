package org.example.test;

import org.example.decorator.Cash;
import org.example.decorator.CashDecorator;
import org.example.decorator.FullReduceDecorator;
import org.example.decorator.NormalCash;
import org.example.entity.FullReduceRule;
import org.example.entity.StrawberryInfo;
import org.example.strategy.*;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Test {

    public static void main( String[] args ) throws InterruptedException {

        StrawberryInfo strawberryInfo = new StrawberryInfo();
        FruitStrategy apple = new AppleStrategy();
        FruitStrategy strawberry = new StrawberryStrategy(strawberryInfo);
        FruitContext appcontext = new FruitContext(apple);
        FruitContext strawberrycontext = new FruitContext(strawberry);
        BigDecimal applePrice = appcontext.qutoPrice("8","2");
        BigDecimal strawberryPrice = strawberrycontext.qutoPrice("13","2");
        BigDecimal totalPrice1 = applePrice.add(strawberryPrice);
        Cash cash1 = new CashDecorator(new NormalCash(totalPrice1));
        String totalCash1 = cash1.totalPrice();
        System.out.println(totalCash1);
        //增加的芒果
        FruitStrategy mango = new MangoStrategy();
        FruitContext mangocontext = new FruitContext(mango);
        BigDecimal mangoPrice = mangocontext.qutoPrice("20","6");
        BigDecimal totalPrice2 = mangoPrice.add(totalPrice1);
        Cash cash2 = new CashDecorator(new NormalCash(totalPrice2));
        String totalCash2 = cash2.totalPrice();
        System.out.println(totalCash2);
        //草莓限时打八折
        strawberryInfo.setBroken(true);
        strawberryInfo.setBrokenRate(new BigDecimal("0.8"));
        BigDecimal strawberryPriceBroken = strawberrycontext.qutoPrice("13","2");
        BigDecimal totalPrice3 = applePrice.add(strawberryPriceBroken).add(mangoPrice);
        Cash cash3 = new CashDecorator(new NormalCash(totalPrice3));
        String totalCash3 = cash3.totalPrice();
        System.out.println(totalCash3);

        //满减
        Cash cash4 = new FullReduceDecorator(new NormalCash(totalPrice2),new FullReduceRule());
        String totalCash4 = cash4.totalPrice();
        System.out.println(totalCash4);


//        testSamef();
//        testCountDownLatch();
          testReverse();

    }

    public  static void testSamef() throws InterruptedException{
        Semaphore s = new Semaphore(1);
        s.acquire();
        System.out.println("我获取了信号");
        s.acquire();//阻塞说明对同一个线程有效
        System.out.println("我又获取了");


    }

    public static void testCountDownLatch()throws InterruptedException{
        CountDownLatch c = new CountDownLatch(1);
        c.countDown();
        System.out.println("我释放了");
        c.await();//同一个线程有效
        System.out.println("我可以执行了");
    }
    public static void testReverse(){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for(int i = 2; i < 4; i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        head = reverListNode(head);
        temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static ListNode reverListNode(ListNode head){
        ListNode lastNode = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = lastNode;
            if(temp == null){
                lastNode = head;
                break;
            }
            lastNode = temp;
            ListNode temp1 = temp.next;
            temp.next = head;
            head = temp1;
        }
        return lastNode;
    }

    static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
