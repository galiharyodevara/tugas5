package com.galih.tugas5.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userdetail")
public class UserDetail {

    private String alamat, phone1, phone2, type, jenis_kelamin, kode_pos;

    public UserDetail() {
    }

    public UserDetail(String alamat, String phone1, String phone2, String type, String jenis_kelamin, String kode_pos) {
        this.alamat = alamat;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.type = type;
        this.jenis_kelamin = jenis_kelamin;
        this.kode_pos = kode_pos;
    }


    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getKode_pos() {
        return kode_pos;
    }

    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }
}
