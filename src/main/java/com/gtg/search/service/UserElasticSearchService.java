package com.gtg.search.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtg.search.documents.User;
import com.gtg.search.dto.UserDTO;
import com.gtg.search.repository.UserElasticSearchRepository;

public interface UserElasticSearchService {

	public boolean save(UserDTO userDTO);

	public List<UserDTO> getAll();

	@Service
	public class Impl implements UserElasticSearchService {

		@Autowired
		private UserElasticSearchRepository repository;

		@Override
		public boolean save(UserDTO userDTO) {
			System.out.println("save() - start");
			User user = dtoToDocument(userDTO);
			if (null != user) {
				repository.save(user);
				return true;
			}
			System.out.println("save() - end");
			return false;
		}

		private User dtoToDocument(UserDTO dto) {
			User entity = null;
			if (null != dto) {
				entity = new User();
				entity.setId(dto.getId());
				entity.setFirstName(dto.getFirstName());
				entity.setLastName(dto.getLastName());
				entity.setEmail(dto.getEmail());
				entity.setPincode(dto.getPincode());
				entity.setAddressLine1(dto.getAddressLine1());
				entity.setAddressLine2(dto.getAddressLine2());
				entity.setCity(dto.getCity());
				entity.setState(dto.getState());
				entity.setCountry(dto.getCountry());
				return entity;

			}

			return null;
		}

		private UserDTO documentToDTO(User entity) {
			UserDTO dto = null;
			if (null != entity) {
				dto = new UserDTO();
				dto.setId(entity.getId());
				dto.setFirstName(entity.getFirstName());
				dto.setLastName(entity.getLastName());
				dto.setEmail(entity.getEmail());
				dto.setPincode(entity.getPincode());
				dto.setAddressLine1(entity.getAddressLine1());
				dto.setAddressLine2(entity.getAddressLine2());
				dto.setCity(entity.getCity());
				dto.setState(entity.getState());
				dto.setCountry(entity.getCountry());
				return dto;

			}

			return null;
		}

		@Override
		public List<UserDTO> getAll() {
			System.out.println("getAll() - start");
			List<UserDTO> dtoList = new ArrayList<UserDTO>();
			Iterable<User> list = repository.findAll();

			for (User entity : list) {
				UserDTO dto = documentToDTO(entity);
				dtoList.add(dto);

			}

			System.out.println("getAll() - end");
			return dtoList;
		}

	}

}
