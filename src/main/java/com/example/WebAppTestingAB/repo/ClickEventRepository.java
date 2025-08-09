package com.example.WebAppTestingAB.repo;

import com.example.WebAppTestingAB.model.ClickEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickEventRepository extends JpaRepository<ClickEvent, Long> {

}
