package com.etiya.ecommercedemopair5.repository.abstracts;

import com.etiya.ecommercedemopair5.entities.concretes.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
