package com.Andrey.TestTask.service;

import com.Andrey.TestTask.model.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountService {
    List<Discount> getAll();
    Discount getById(Long id);
    void save(Discount discount);
}
