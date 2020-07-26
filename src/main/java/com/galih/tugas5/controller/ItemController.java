package com.galih.tugas5.controller;

import com.galih.tugas5.model.Item;
import com.galih.tugas5.model.User;
import com.galih.tugas5.repository.ItemRepository;
import com.galih.tugas5.repository.UserRepository;
import com.galih.tugas5.service.ItemService;
import com.galih.tugas5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/item")
public class ItemController {
    @Autowired
    ItemService service;
    @Autowired
    ItemRepository itemRepository;

    @GetMapping
    public List<Item> getAllUser(@RequestParam(value ="pageNo", defaultValue = "0") Integer pageNo,
                                 @RequestParam(value = "sortKey", defaultValue = "name") String sortKey)
    {
        return service.getAllItem(pageNo, sortKey);
    }


    @DeleteMapping("/delete")
    Map<String, Object> deleteById(@RequestParam String id) {
        Map<String, Object> result = new HashMap<>();
        if (service.Delete(id)){
            result.put("success", true);
        } else {
            result.put("success", false);

        }
        return result;
    }
    @PutMapping("/update")
    Map<String, Object> UpdateItem(@RequestBody Item body){
        Map<String, Object> result = new HashMap<>();
        if (service.updateItem(body)) {
            result.put("success", true);
            result.put("mes", "berhasil");
        }else {
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }
    @PostMapping("/insert")
    public Map<String, Object> insert(@RequestBody Item item) {
        return service.insert(item);
    }

}
