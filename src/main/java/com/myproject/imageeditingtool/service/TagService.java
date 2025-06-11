package com.myproject.imageeditingtool.service;

import com.myproject.imageeditingtool.entity.Tag;
import com.myproject.imageeditingtool.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TagService {
    @Autowired private TagRepository tagRepository;

    public List<Tag> getAllTags() { return tagRepository.findAll(); }
    public Tag createTag(Tag tag) { return tagRepository.save(tag); }
}
