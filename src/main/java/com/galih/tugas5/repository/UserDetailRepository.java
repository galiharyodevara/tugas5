package com.galih.tugas5.repository;

import com.galih.tugas5.model.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailRepository extends MongoRepository<UserDetail, String> {
}
