package com.persadoproject.service;

import com.persadoproject.model.Publisher;
import com.persadoproject.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	PublisherRepository publisherRepository;

	@Override
	public Publisher createPublisher(Publisher publisher){
		return publisherRepository.save(publisher);
	}

}
