package top.jianghuling.wechatapp.model;

import java.util.Date;

public class Room {
    private Integer roomId;

    private Integer people;

    private String aId;

    private String bId;

    private Boolean bStatus;

    private String cId;

    private Boolean cStatus;

    private String dId;

    private Boolean dStatus;

    private Boolean ablein;

    private Integer start;

    private Integer destination;

    private Date time;

    private Date createTime;

    private Boolean end;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId == null ? null : aId.trim();
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId == null ? null : bId.trim();
    }

    public Boolean getbStatus() {
        return bStatus;
    }

    public void setbStatus(Boolean bStatus) {
        this.bStatus = bStatus;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public Boolean getcStatus() {
        return cStatus;
    }

    public void setcStatus(Boolean cStatus) {
        this.cStatus = cStatus;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId == null ? null : dId.trim();
    }

    public Boolean getdStatus() {
        return dStatus;
    }

    public void setdStatus(Boolean dStatus) {
        this.dStatus = dStatus;
    }

    public Boolean getAblein() {
        return ablein;
    }

    public void setAblein(Boolean ablein) {
        this.ablein = ablein;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getEnd() {
        return end;
    }

    public void setEnd(Boolean end) {
        this.end = end;
    }
}