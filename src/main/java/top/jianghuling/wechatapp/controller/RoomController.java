package top.jianghuling.wechatapp.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.jianghuling.wechatapp.model.Msg;
import top.jianghuling.wechatapp.service.RoomService;

@RestController
public class RoomController {
        @Autowired
        RoomService roomService;

        @GetMapping(value = "/room")
        public Msg getRoom(){
                return Msg.success().add("room",roomService.getRoom());
        }
        @GetMapping(value = "/addroom/{id}/{start}/{destination}")
        public Msg addRoom(@PathVariable("id") String id,@PathVariable("start") int start,@PathVariable("destination") int destination){
                roomService.addRoom(id,start,destination);
                return Msg.success();

        }
        @GetMapping(value = "/join/{id}/{order}/{roomId}")
        public Msg join(@PathVariable("id") String id, @PathVariable("order") int order,@PathVariable("roomId") int roomid){

                return Msg.success().add("msg",roomService.join(id,order,roomid));

        }
        @GetMapping(value = "/leave/{id}/{order}/{roomId}")
        public Msg leave(@PathVariable("id") String id, @PathVariable("order") int order,@PathVariable("roomId") int roomid){

                return Msg.success().add("msg",roomService.leave(id,order,roomid));

        }
        @GetMapping(value = "/getRoomId/{userId}")
        public Msg MyRoom(@PathVariable("userId") String userId){
               return Msg.success().add("roomId",roomService.myRoom(userId)); //0表示没有参加房间
        }

        @GetMapping(value = "/ready/{userId}")
        public Msg ready(@PathVariable("userId") String userId){
                return Msg.success().add("msg",roomService.ready(userId)) ; //0表示没有参加房间
        }
        @GetMapping(value = "/go/{userId}/{roomId}")
        public Msg go(@PathVariable("userId") String aId,@PathVariable("roomId") int roomId){

                return Msg.success().add("Msg",roomService.go(aId,roomId));
        }

}
