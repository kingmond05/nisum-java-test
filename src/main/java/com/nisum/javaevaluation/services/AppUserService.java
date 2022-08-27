package com.nisum.javaevaluation.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.javaevaluation.models.AppUser;
import com.nisum.javaevaluation.repositories.AppUserRepository;
import com.nisum.javaevaluation.utils.SecuritySupports;
import com.nisum.javaevaluation.views.AppUserViewModelRequest;

@Service
public class AppUserService {
	
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
    private ModelMapper modelMapper;
	@Autowired
	private SecuritySupports secureUtils;
	
	public void saveUser(AppUserViewModelRequest user) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AppUser userEntity = modelMapper.map(user, AppUser.class);
		modelMapper.createTypeMap(AppUser.class, AppUserViewModelRequest.class);
		modelMapper.validate();
		//userEntity.password = secureUtils.hashUserPassword(user.password);
		//userRepository.save(userEntity);
	}
	
	public List<AppUser> listAll(){
		return userRepository.findAll();
	}
	
	public String getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}
}	
