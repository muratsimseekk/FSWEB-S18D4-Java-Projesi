package com.workintechs18d4project.S18D4.repository;

import com.workintechs18d4project.S18D4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
