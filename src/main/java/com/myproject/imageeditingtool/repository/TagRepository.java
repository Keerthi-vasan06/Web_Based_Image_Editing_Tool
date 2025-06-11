package com.myproject.imageeditingtool.repository;


import com.myproject.imageeditingtool.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Tag Repository
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {}