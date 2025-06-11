package com.myproject.imageeditingtool.service;

import com.myproject.imageeditingtool.entity.Profile;
import com.myproject.imageeditingtool.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired private ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) { return profileRepository.save(profile); }
}
