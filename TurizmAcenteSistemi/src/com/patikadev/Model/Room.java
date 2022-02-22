package com.patikadev.Model;

public class Room {
    int bedNum;
    String roomType, roomProperties;

    public Room(int bedNum, String roomType, String roomProperties) {
        this.bedNum = bedNum;
        this.roomType = roomType;
        this.roomProperties = roomProperties;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomProperties() {
        return roomProperties;
    }

    public void setRoomProperties(String roomProperties) {
        this.roomProperties = roomProperties;
    }
}
