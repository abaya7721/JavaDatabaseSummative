package com.assessment.bistro.repository;

import com.assessment.bistro.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
