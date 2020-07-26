package com.galih.tugas5.service;

import com.galih.tugas5.model.User;
import com.galih.tugas5.repository.UserDetailRepository;
import com.galih.tugas5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserDetailRepository userDetailRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public Map insertNewUser(User user) {
        Optional<User> userResult = userRepository.findByUsername(user.getUsername());
        Map<String, Object> resultMap = new HashMap<>();
        if (userResult.isPresent()) {
            resultMap.put("success", false);
            resultMap.put("message", "user telah terdaftar");
        } else {
            try {
                userRepository.save(user);
                resultMap.put("success", true);
                resultMap.put("message", "insert user berhasil");
            } catch (Exception e) {
                resultMap.put("success", false);
                resultMap.put("message", "insert user gagal");
            }
        }
        return resultMap;
    }

    public List<User> getByAlamat(String alamat) {
        List<User> user = userRepository.findByAlamat(alamat);
        System.out.println("user result : " + user.toString());
        return user;
    }

    public Map<String, Object> updateUser(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            Query query = new Query(new Criteria("id").is(user.getId()));
            Map<String, Object> objectMap = Utility.objectToMap(user);
            Update updateQuery = new Update();
            objectMap.forEach((key, value) -> {
                if (value != null) {
                    updateQuery.set(key, value);
                }
            });
            mongoTemplate.findAndModify(query, updateQuery, User.class);
            resultMap.put("success", true);
            resultMap.put("message", "user updated");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("success", false);
            resultMap.put("message", "user update failed");
        }
        return resultMap;
    }

    public boolean deleteUser(String id) {
        User result = userRepository.deleteByid(id);
        if (result != null) {
            try {
                userRepository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public Page<User> getAllUserPaginated(String search, Pageable pageable) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").regex(".*" + search + ".*", "i"));
        query.with(pageable);
        List<User> list = mongoTemplate.find(query, User.class);
        return PageableExecutionUtils.getPage(list, pageable, () -> mongoTemplate.count(query, User.class));
    }

    public User getByUserName(String userName) {
        try {
            return userRepository.findByUsername(userName).get();
        } catch (Exception e) {
            return null;
        }
    }

}