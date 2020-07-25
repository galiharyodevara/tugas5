package com.galih.tugas5.controller;

import com.galih.tugas5.model.User;
import com.galih.tugas5.repository.UserRepository;
import com.galih.tugas5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser(@RequestParam(value ="pageNo", defaultValue = "0") Integer pageNo,
                                 @RequestParam(value = "sortKey", defaultValue = "name") String sortKey)
    {
        return service.getAllUser(pageNo, sortKey);
    }


    @DeleteMapping("/delete")
    Map<String, Object> deleteById(@RequestParam int id) {
        Map<String, Object> result = new HashMap<>();
        if (service.deleteByUserId(id)) {
            result.put("success", true);
        } else {
            result.put("success", false);

        }
        return result;
    }
    @PutMapping("/update")
    Map<String, Object> UpdateUser(@RequestBody User body){
        Map<String, Object> result = new HashMap<>();
        if (service.updateUser(body)) {
            result.put("success", true);
            result.put("mes", "berhasil");
        }else {
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }
    @PostMapping("/insert")
    public Map<String, Object> insert(@RequestBody User user) {
        return service.insert(user);
    }

}
