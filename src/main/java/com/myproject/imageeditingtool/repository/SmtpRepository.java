package com.myproject.imageeditingtool.repository;


import com.myproject.imageeditingtool.entity.SmtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myproject.imageeditingtool.entity.SmtpEntity;


@Repository
public interface SmtpRepository extends JpaRepository<SmtpEntity, Integer> {
}



