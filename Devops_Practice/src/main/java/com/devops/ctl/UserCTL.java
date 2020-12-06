package com.devops.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.DevopsPracticeApplication;
import com.devops.Constants.DevopsEnumConstant;
import com.devops.DTO.UserDTO;
import com.devops.Service.UserService;
import com.devops.exception.ApplicationException;

@RestController
@RequestMapping("/api/user")
public class UserCTL {
	
	
	
	@Autowired
	UserService service;
	
	@GetMapping
	public String test() {
		return "Testing Successfull";
	}
	
	@PostMapping("/save")
	public Map<String, Object> add(@RequestBody UserDTO userDto){
		   
		Map<String, Object> res = new HashMap<>();
		UserDTO dto = service.save(userDto);
	     
		res.put("message", "Data Saved Successfully");
		res.put("dto", dto);
		return res;	
	}
	
	@GetMapping("/delete/{id}")
	public Map<String, Object> delete(@PathVariable int id){
		
	   // comment added
		//coment sadasd
		Map<String, Object> res = new HashMap<>();
		service.delete(id);
		
		res.put("message", "Data Deleted Successfully");
		
		return res;
	}
	
	@GetMapping("/getAll")
	public Map<String, Object> getAll(){
		
		Map<String, Object> res = new HashMap<>();
		List<UserDTO> findAll = service.findAll();
		res.put("list", findAll);
		
		return res;
		
	}
	
	@GetMapping("/getByID/{id}")
	public Map<String, Object> findById(@PathVariable int id) throws ApplicationException{
		 
		Map<String, Object> res = new HashMap<>();
		UserDTO dto = new UserDTO();
		Optional<UserDTO> findById = service.findById(id);
		if(findById.isPresent())
		{
			dto = findById.get();
			res.put("data", dto);
		}else
		{
			throw new ApplicationException(DevopsEnumConstant.RECORD_NOT_FOUND.getMessage());
		}
	
		
		
		return res;
		
	}
	
}
