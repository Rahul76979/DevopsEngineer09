package com.devops.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devops.DTO.UserDTO;
import com.devops.dao.UserDAO;
import com.devops.exception.ApplicationException;

@Service
public class UserService  implements UserserviceInt
{
	@Autowired
	private UserDAO dao;
	
	public UserDTO save(UserDTO dto)
	{
		UserDTO save = dao.save(dto);
		return save;
	}
	
	public void delete(int id)
	{
		dao.deleteById(id);
	}
	
	public List<UserDTO> findAll()
	{
		List<UserDTO> all = dao.findAll();
		return all;
	}
	
	public Optional<UserDTO> findById(int id)
	{
		Optional<UserDTO> get = dao.findById(id);
		
		return get;
	}
}
