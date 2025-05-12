package com.dsg.deploybackendpost.repository;

import com.dsg.deploybackendpost.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
