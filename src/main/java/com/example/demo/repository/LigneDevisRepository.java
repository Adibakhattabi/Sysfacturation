
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LigneDevis;

public interface LigneDevisRepository
        extends JpaRepository<LigneDevis, Long> {

}
