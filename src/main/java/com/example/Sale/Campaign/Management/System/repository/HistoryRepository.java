package com.example.Sale.Campaign.Management.System.repository;

import com.example.Sale.Campaign.Management.System.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface HistoryRepository extends JpaRepository<History,Integer> {
    @Query(value = "select * from tbl_history where product_id=? and date=?",nativeQuery = true)
    History getOldHistory(int id, LocalDate date);

}
