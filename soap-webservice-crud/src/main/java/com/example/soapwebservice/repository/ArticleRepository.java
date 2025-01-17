package com.example.soapwebservice.repository;

import com.example.soapwebservice.entity.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Articles, Long> {

}
