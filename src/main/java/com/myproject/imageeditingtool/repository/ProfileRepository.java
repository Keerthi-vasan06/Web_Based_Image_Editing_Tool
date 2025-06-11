package com.myproject.imageeditingtool.repository;


import com.myproject.imageeditingtool.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



//      Profile Repository
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>
{

}
