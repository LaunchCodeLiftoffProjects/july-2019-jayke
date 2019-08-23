package com.aplaygroundreviewer.repository;

import com.aplaygroundreviewer.dto.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentDao extends JpaRepository<Equipment, Integer> {

}
