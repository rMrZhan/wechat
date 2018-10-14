package top.jianghuling.wechatapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.jianghuling.wechatapp.dao.RoomMapper;
import top.jianghuling.wechatapp.dao.UserInfoMapper;
import top.jianghuling.wechatapp.model.Room;
import top.jianghuling.wechatapp.model.RoomExample;
import top.jianghuling.wechatapp.model.UserInfo;

import java.util.HashMap;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomMapper roomMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Transactional
    public List<Room> getRoom() {
        return roomMapper.selectByExample(new RoomExample());
    }


    @Transactional
    public void addRoom(String id, int start,int destination) {
        Room room = new Room();
        room.setaId(id);
        room.setStart(start);
        room.setDestination(destination);
        roomMapper.insertSelective(room);
    }
    @Transactional
    public Integer myRoom(String id){
        try{
            Room result = roomMapper.selectByUserId(id);
            if (result.getRoomId()>0){
                return result.getRoomId();
            }
        }catch (Exception e){
            return 0;
        }
        return 0;
    }
    @Transactional
    public String join(String id, int order,int roomId) {
           if(myRoom(id)!=0){
               Room room = roomMapper.selectByPrimaryKey(roomId);
               if (room.getAblein()==true) {

                   switch (order) {
                       case 2:
                           if(room.getbId().length()>0)
                               return "该座位已经有人";
                           room.setbId(id);
                           break;
                       case 3:
                           if(room.getcId().length()>0)
                               return "该座位已经有人";
                           room.setcId(id);
                           break;
                       case 4:
                           if(room.getdId().length()>0)
                               return "该座位已经有人";
                           room.setdId(id);
                           break;


                   }
                   room.setPeople(room.getPeople() + 1);
                   if(room.getPeople()==4){
                       room.setAblein(false);
                   }
                   roomMapper.updateByPrimaryKey(room);
                   return "加入成功";
               }else{
                   return "人数已满";
               }
           }else{
               return "你已加入房间";
           }



}
    @Transactional
    public String leave(String id, int order, int roomId) {
        Room room = roomMapper.selectByPrimaryKey(roomId);

        switch (order){
            case 2:
                room.setbId("");
                room.setbStatus(false);
                break;
            case 3:
                room.setcId("");
                room.setcStatus(false);
                break;
            case 4:
                room.setdId("");
                room.setdStatus(false);
                break;


        }
        room.setPeople(room.getPeople()-1);
        if(room.getPeople()==3){
            room.setAblein(true);
        }
        roomMapper.updateByPrimaryKey(room);
        return "退出房间成功";
    }
    @Transactional
    public String ready(String userId) {
        try {
            int id = myRoom(userId);
            if(id!=0){
                Room result = roomMapper.selectByPrimaryKey(id);

                if(result.getbId().equals(userId)){
                    result.setbStatus(true);
                }
                else if(result.getcId().equals(userId)){
                    result.setcStatus(true);
                }
                else if(result.getdId().equals(userId)){
                    result.setdStatus(true);
                }
                roomMapper.updateByPrimaryKey(result);
                return "已准备";

            }else{
                return "失败";
            }


        }catch (Exception e){
            return "失败";
        }


    }
    @Transactional
    public HashMap<String,String> go(String aId, int roomId) {
        HashMap<String,String>info = new HashMap<String, String>();
        Room room = roomMapper.selectByPrimaryKey(roomId);
        if (!aId.equals(room.getaId())){
            info.put("null","null");
            return info;
        }else{
            try{
                String bId = room.getbId();
                String cId = room.getcId();
                String dId = room.getdId();
                if (room.getbId().length()>0){
                    info.put("b's phone",userInfoMapper.selectByPrimaryKey(bId).getPhone());
                }
                if (room.getcId().length()>0){
                    info.put("c's phone",userInfoMapper.selectByPrimaryKey(cId).getPhone());
                }
                if (room.getdId().length()>0){
                    info.put("d's phone",userInfoMapper.selectByPrimaryKey(dId).getPhone());
                }
                return info;
            }catch (Exception e){
                info.put("Msg","查询错误");
                return info;
            }

        }

    }
}
