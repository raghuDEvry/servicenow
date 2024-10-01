package com.example.servicecenter.repository;

import com.example.servicecenter.entity.CallMe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallMeRepository extends JpaRepository<CallMe, Long> {
}
