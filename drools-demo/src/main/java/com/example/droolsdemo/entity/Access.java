package com.example.droolsdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "access")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accessId;
    private String read;
    private String write;

    public Access() {}

    public Access(String read, String write) {
        this.read = read;
        this.write = write;
    }

    public Long getAccessId() {
        return accessId;
    }

    public void setAccessId(Long accessId) {
        this.accessId = accessId;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }
}
