package com.persadoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persadoproject.model.Publisher;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>  {

}
