package com.galih.tugas5.service;

import com.galih.tugas5.model.Item;
import com.galih.tugas5.model.User;
import com.galih.tugas5.repository.ItemRepository;
import com.galih.tugas5.repository.UserRepository;
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
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }


    public Map<String, Object> insert(Item item){
        Map<String, Object> result = new HashMap<>();
        try {
            itemRepository.save(item);
            result.put("success", true);
            result.put("mes", "berhasil");
        }catch (Exception e){
            result.put("success", false);
            result.put("mes", "gagal");
        }
        return result;
    }


    public List<Item> getAllItem(Integer pageNo, String sortKey){
        int noOfRecord = 4;
        Pageable page = PageRequest.of(pageNo, noOfRecord, Sort.by(sortKey));
        Page<Item> pagedResult = itemRepository.findAll(page);
        return pagedResult.getContent();
    }

    public boolean updateItem(Item body) {
        Optional<Item> itemResult = itemRepository.findById(body.getId());

        if (itemResult != null) {
            try {
                itemRepository.save(body);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }

    }


    public boolean Delete(String id) {
        Item result = itemRepository.deleteByid(id);

        if (result != null) {
            try {
                itemRepository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}
