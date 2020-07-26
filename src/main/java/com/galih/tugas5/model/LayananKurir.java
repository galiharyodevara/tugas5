package com.galih.tugas5.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "layanankurir")
public class LayananKurir {
    @Id
    private String id;
    private String name, harga, id_kurir, estimasi;

    public LayananKurir() {
    }

    public LayananKurir(String id, String name, String harga, String id_kurir, String estimasi) {
        this.id = id;
        this.name = name;
        this.harga = harga;
        this.id_kurir = id_kurir;
        this.estimasi = estimasi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getId_kurir() {
        return id_kurir;
    }

    public void setId_kurir(String id_kurir) {
        this.id_kurir = id_kurir;
    }

    public String getEstimasi() {
        return estimasi;
    }

    public void setEstimasi(String estimasi) {
        this.estimasi = estimasi;
    }
}
