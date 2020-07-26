package com.galih.tugas5.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "kurir")
public class Kurir {
    @Id
    private String id;
    private String name, resi;

    public Kurir() {
    }

    public Kurir(String id, String name, String resi) {
        this.id = id;
        this.name = name;
        this.resi = resi;
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

    public String getResi() {
        return resi;
    }

    public void setResi(String resi) {
        this.resi = resi;
    }
}
