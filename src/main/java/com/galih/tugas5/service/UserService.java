package com.galih.tugas5.service;

import com.galih.tugas5.model.User;
import com.galih.tugas5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findByUserId(int id) {
        return userRepository.findById(id);
    }

    public Map<String, Object> insert(User user){
        Map<String, Object> result = new HashMap<>();
        try {
            userRepository.save(user);
            result.put("success", true);
            result.put("mes", "berhasil");
        }catch (Exception e){
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }


    public List<User> getAllUser(Integer pageNo, String sortKey){
        int noOfRecord = 4;
        Pageable page = PageRequest.of(pageNo, noOfRecord, Sort.by(sortKey));
        Page <User> pagedResult = userRepository.findAll(page);
        return pagedResult.getContent();
    }

    public boolean updateUser(User body) {
        Optional<User> userResult = userRepository.findById(body.getId());

        if (userResult != null) {
            try {
                userRepository.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

    }


    public boolean deleteByUserId(int id) {
        User result = userRepository.findById(id);

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
}