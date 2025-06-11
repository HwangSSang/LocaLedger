package com.project.localledger.repository;

import com.project.localledger.entity.AddIncome;
import org.springframework.data.repository.CrudRepository;

public interface IncomeRepository extends CrudRepository<AddIncome, Long> {
}
