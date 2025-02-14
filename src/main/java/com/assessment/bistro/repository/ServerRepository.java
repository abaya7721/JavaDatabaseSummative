package com.assessment.bistro.repository;

import com.assessment.bistro.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServerRepository extends JpaRepository<Server, Integer> {

}
