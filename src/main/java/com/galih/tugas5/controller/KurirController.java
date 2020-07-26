package com.galih.tugas5.controller;

import com.galih.tugas5.model.Item;
import com.galih.tugas5.model.Kurir;
import com.galih.tugas5.repository.ItemRepository;
import com.galih.tugas5.repository.KurirRepository;
import com.galih.tugas5.service.ItemService;
import com.galih.tugas5.service.KurirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/kurir")
public class KurirController {
    @Autowired
    KurirService service;
    @Autowired
    KurirRepository kurirRepository;

    @GetMapping
    public List<Kurir> getAllKurir(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                   @RequestParam(value = "sortKey", defaultValue = "name") String sortKey) {
        return service.getAllKurir(pageNo, sortKey);
    }


    @DeleteMapping("/delete")
    Map<String, Object> deleteById(@RequestParam String id) {
        Map<String, Object> result = new HashMap<>();
        if (service.Delete(id)) {
            result.put("success", true);
        } else {
            result.put("success", false);

        }
        return result;
    }

    @PutMapping("/update")
    Map<String, Object> UpdateItem(@RequestBody Kurir body) {
        Map<String, Object> result = new HashMap<>();
        if (service.updateKurir(body)) {
            result.put("success", true);
            result.put("mes", "berhasil");
        } else {
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }

    @PostMapping("/insert")
    public Map<String, Object> insert(@RequestBody Kurir kurir) {
        return service.insert(kurir);
    }
}