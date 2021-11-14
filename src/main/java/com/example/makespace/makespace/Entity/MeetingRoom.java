package com.example.makespace.makespace.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "meetingroom")
public class MeetingRoom
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "room_name")
    private String roomName;

    public MeetingRoom() {
    }

    public MeetingRoom(int roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public MeetingRoom(String roomName) {
        this.roomName = roomName;
    }

    public int getId() {
        return roomId;
    }

    public void setId(int id) {
        this.roomId = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingRoom that = (MeetingRoom) o;
        return roomId == that.roomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }
}
