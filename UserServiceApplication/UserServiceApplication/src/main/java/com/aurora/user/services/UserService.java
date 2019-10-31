package com.aurora.user.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.aurora.user.dtos.UserDetailsDTO;
import com.aurora.user.entities.UserDetails;
import com.aurora.user.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository usrRepository;
	
	@Transactional
	public UserDetailsDTO saveUpdate(UserDetailsDTO user)
	{
		try {
			UserDetails userDetails = new UserDetails();
			userDetails.setName(user.getName());
			userDetails.setAge(user.getAge());
			return getUserDetailsDTO(usrRepository.save(userDetails ) );
		} catch (Exception e) {
			return null;
		}
	}
	public UserDetailsDTO getById(Long id)
	{
		return getUserDetailsDTO(usrRepository.getOne(id));
	}
	
	public List<UserDetailsDTO> getByName(String name)
	{
		List<UserDetails> userDetailList = usrRepository.findUserByName(name);
		
		if(CollectionUtils.isEmpty(userDetailList)) {return null; }
	
		return userDetailList.stream().map(this::getUserDetailsDTO).collect(Collectors.toList()); 
	}
	
	public UserDetailsDTO getUserDetailsDTO(UserDetails userDetails)
	{
		return new UserDetailsDTO(userDetails.getId() ,
									userDetails.getName(),
									userDetails.getAge() );
	}
}
