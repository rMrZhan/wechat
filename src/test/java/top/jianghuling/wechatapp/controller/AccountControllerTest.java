package top.jianghuling.wechatapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import top.jianghuling.wechatapp.dao.UserInfoMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountControllerTest {
    @Autowired
    private WebApplicationContext context;
    MockMvc mockMvc;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testSms() {
        try {
            MvcResult result = mockMvc.perform(post("/account/sms")
                    .param("phone", "17711388724")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andReturn();
            System.out.println(result.getResponse().getContentAsString());
        } catch (Exception e) {

        }
    }


    @Test
    public void bondPhone() {
        try{//这是测试控制器
            MvcResult result = mockMvc.perform(post("/account/bondPhone")
                    .param("phone","17711388724")
                    .param("vCode","5487")
                    .param("secretId","5b5edcd0b3d7d83ab07f983e5711333c")
                    //debug过程中secretId是可以成功转换成userId的
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andReturn();
            System.out.println(result.getResponse().getContentAsString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testLogin(){
//        try{//这是测试控制器
//            MvcResult result = mockMvc.perform(post("/account/login")
//                    .param("jscode","023X0buh02xjjy1O0Wsh06iwuh0X0buU")
//                    //debug过程中secretId是可以成功转换成userId的
//                    .contentType(MediaType.APPLICATION_JSON_UTF8))
//                    .andExpect(status().isOk())
//                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                    .andReturn();
//            System.out.println(result.getResponse().getContentAsString());
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }

        userInfoMapper.selectByPrimaryKey("efaefaf");

    }


}