package com.galih.tugas5.service;

import com.galih.tugas5.model.Item;
import com.galih.tugas5.model.Kurir;
import com.galih.tugas5.repository.ItemRepository;
import com.galih.tugas5.repository.KurirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class KurirService {
    @Autowired
    KurirRepository kurirRepository;

    public List<Kurir> getAllKurir() {
        return kurirRepository.findAll();
    }


    public Map<String, Object> insert(Kurir kurir){
        Map<String, Object> result = new HashMap<>();
        try {
            kurirRepository.save(kurir);
            result.put("success", true);
            result.put("mes", "berhasil");
        }catch (Exception e){
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }


    public List<Kurir> getAllKurir(Integer pageNo, String sortKey){
        int noOfRecord = 4;
        Pageable page = PageRequest.of(pageNo, noOfRecord, Sort.by(sortKey));
        Page<Kurir> pagedResult = kurirRepository.findAll(page);
        return pagedResult.getContent();
    }

    public boolean updateKurir(Kurir body) {
        Optional<Kurir> kurirResult = kurirRepository.findById(body.getId());

        if (kurirResult != null) {
            try {
                kurirRepository.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

    }


    public boolean Delete(String id) {
        Kurir result = kurirRepository.deleteByid(id);

        if (result != null) {
            try {
                kurirRepository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
