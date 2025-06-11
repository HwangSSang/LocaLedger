package com.project.localledger.repository;

import com.project.localledger.entity.AddExpense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<AddExpense, Long> {
}
