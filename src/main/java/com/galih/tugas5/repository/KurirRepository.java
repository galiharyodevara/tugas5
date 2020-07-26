package com.galih.tugas5.repository;

import com.galih.tugas5.model.Item;
import com.galih.tugas5.model.Kurir;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KurirRepository extends MongoRepository<Kurir, String> {
    Optional<Kurir> findById(String id);

    Kurir deleteByid(String id);
}
