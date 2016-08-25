package com.gtg.search.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.gtg.search.documents.User;

public interface UserElasticSearchRepository extends ElasticsearchRepository<User, Long> {

}
