package com.galih.tugas5.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaksidetail")
public class TransaksiDetail {
    @Id
    private String id;
    private String id_transaksi, id_item, id_kurir;
    private String jumlah,alamat,berat,no_resi,harga;

    public TransaksiDetail() {
    }

    public TransaksiDetail(String id, String id_transaksi, String id_item, String id_kurir, String jumlah, String alamat, String berat, String no_resi, String harga) {
        this.id = id;
        this.id_transaksi = id_transaksi;
        this.id_item = id_item;
        this.id_kurir = id_kurir;
        this.jumlah = jumlah;
        this.alamat = alamat;
        this.berat = berat;
        this.no_resi = no_resi;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_item() {
        return id_item;
    }

    public void setId_item(String id_item) {
        this.id_item = id_item;
    }

    public String getId_kurir() {
        return id_kurir;
    }

    public void setId_kurir(String id_kurir) {
        this.id_kurir = id_kurir;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public String getNo_resi() {
        return no_resi;
    }

    public void setNo_resi(String no_resi) {
        this.no_resi = no_resi;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
