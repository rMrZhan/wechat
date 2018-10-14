package top.jianghuling.wechatapp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.jianghuling.wechatapp.model.BriefOrder;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void releaseOrderTest() {

        String express[]={"韵达","中通","天天","顺丰","圆通","邮政","唯品会","京东"};
        for(int i = 0;i<15;i++){
            Date dateTimeStart = new Date();
            dateTimeStart.setHours(((int)((Math.random()*2.4)*10)));
            dateTimeStart.setMinutes(((int)((Math.random()*6)*10)));
            dateTimeStart.setSeconds(((int)((Math.random()*6)*10)));
            Date dateTimeEnd = new Date();
            dateTimeEnd.setHours(23);
            dateTimeEnd.setMinutes(59);
            dateTimeEnd.setSeconds(59);


            String randomId = UUID.randomUUID().toString();
            orderService.releaseNewOrder("o6n8M5GNNqdUKyZGLirGh3Rq9QUc",String.valueOf((int)(Math.random()*9*1000)),"准时送达",2f,"Jason","17711388724",
                    "西南门快递街","9舍","10千克",dateTimeStart,dateTimeEnd,express[(int)(Math.random()*7)]);
//            try{
//                Thread.currentThread().sleep(1000);
//            }catch (Exception e){
//                e.printStackTrace();
//            }

        }

    }

    @Test
    public void acceptOrderTest(){

        String orders[]={"ac1c79ac094f30459c0a8d609bb671148b6f","86d32af504581047df0857902a8543792635"
                ,"b860347b0ca4904c800bbc10dda489bf39da","b8c9942108d4c04e330b3d60ef20bd425e32","ccb81b32082e0043b80b9690244fc37cb75c"};
        for(int i=0;i<orders.length;i++){
            System.out.println(orderService.takeMission("fieaofeiamfafrmlereaofmeao",orders[i]));
        }


    }

    @Test
    public void missionSuccessTest(){
        String orders[]={"1abdbfe90ce15043700b3460e092caa59bfb","1abf7271070a804059091f10d6d20396612f",
                "1c68a34b01e75048fc0b99a04c2762011a9d","1c755a580c2180475808878088411575ac23","1d03944c08e1d04c930a42404997a6a69a06","1d1eca57047da04568080380f48f4a32e270","1fbcbbad004df04640097ed01ccc539d1c23",
                "2602c21109448044950aac10e846926e1810","26fb09cd0600504ca4080360c2d1b3f8a2aa"};

        for(int i=0;i<orders.length;i++){
            System.out.println(orderService.missionSuccess(orders[i]));
        }

    }


    @Test
    public void cancelOrderByHostTest(){
        String orders[]={"0cddafd40846404f8a0bcb2016d611900664","0cf0fad402a8204ad20aac903d7566820ccf","0d4940b303cd4048b1093a0098e22f4350df","0ec88ebf07ca4040bf08a9e09b56d4332696","17f985cf0c1290470f0be9b0dbb9e5049a73"
                ,"18429bb40405d04ac70b04200b363c4e547e","193f1abc024a404145083770207a196cfce0"};
        for(int i=0;i<orders.length;i++)
        System.out.println(orderService.cancelOrderByHost(orders[i]));
    }

    @Test
    public void abandonMissionTest(){
        String orders[]={"02480d9c0d4c604a2908da20047545ca828b","0380f98303f8b04f8d09b3701d3c9505dc3a",
                "03d51ae30ca1104119090710c8eace821870","03d58a890a6b7041530badc0224fb02bfa98"};
        for(int i=0;i<orders.length;i++)
        System.out.println(orderService.abandonMission(orders[i]));

    }

    @Test
    public void browseReleaseOrdersTest(){
        List<BriefOrder> briefOrders = orderService.getOtherRelease("o6n8M5GNNqdUKyZGLirGh3Rq9QUc",0,5);
        System.out.println(briefOrders.get(0).gettEnd());
        System.out.println(briefOrders.get(0).gettRelease());
    }
    @Test
    public void browseMyReleaseOrderTest(){
        System.out.println(orderService.getMyRelease("eaefeeawfreeagf323fazgnfrvv",0,5).get(1).getOrderId());

    }

    @Test
    public void browseMyMissionRecordsTest(){
        System.out.println(orderService.getMyAccept("o6n8M5GNNqdUKyZGLirGh3Rq9QUc",1,10).get(0).getOrderId());
    }

    @Test
    public void confirmMissionFinishTest(){
        String orders[]={"007f5ecd08b7d0480d0bf0701fc043643af1"
                ,"0097f9a10c87504de00aaf80b0703b682a5b","0103f0d301c7504ff20bbe40cfa66dcf5f48",};
        for(int i=0;i<orders.length;i++)
            System.out.println(orderService.confirmFinishMission(orders[i]));
    }

    @Test
    public void missionFailTest(){
        orderService.missionFail("7752415e016f0048430b20d008e8abac8dff");
    }

    @Test
    public void cancelOrderTest(){
        System.out.println(orderService.preCancelOrderByHost("b6e4b1990a68304a5e085a20d71908572688"));
        System.out.println(orderService.cancelOrderByHost("b6e4b1990a68304a5e085a20d71908572688"));
    }


}