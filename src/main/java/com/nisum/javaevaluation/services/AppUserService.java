package com.nisum.javaevaluation.services;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.javaevaluation.models.AppUser;
import com.nisum.javaevaluation.repositories.AppUserRepository;
import com.nisum.javaevaluation.utils.SecuritySupports;
import com.nisum.javaevaluation.views.AppUserViewModelRequest;
import com.nisum.javaevaluation.views.AppUserViewModelResponse;

@Service
public class AppUserService {
	
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
    private ModelMapper modelMapper;
	@Autowired
	private SecuritySupports secureUtils;
	@Autowired
	private PhoneService phoneService;
	
	public AppUserViewModelResponse saveUser(AppUserViewModelRequest user) throws NoSuchAlgorithmException {
		//Config mapper
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE)
		.setSkipNullEnabled(true)
	    .setFieldMatchingEnabled(true);
		AppUser userEntity = modelMapper.map(user, AppUser.class);
		
		//Crea hash para clave
		userEntity.password = secureUtils.hashUserPassword(user.password);
		
		//Genera nuevo ID al usuario
		userEntity.id = UUID.randomUUID().toString();
		
		//Agregar otros datos
		
		userEntity.created = Calendar.getInstance().getTime();
		userEntity.modified = Calendar.getInstance().getTime();
		userEntity.last_login = Calendar.getInstance().getTime();
		userEntity.token = UUID.randomUUID().toString();
		userEntity.isactive = true;
		userRepository.save(userEntity);
		
		//Guarda los telefonos si existen
		if(user.phones.size() > 0) {
			phoneService.savePhone(user, userEntity.id);
		}
		
		return modelMapper.map(userEntity, AppUserViewModelResponse.class);
	}
	
	public List<AppUser> listAll(){
		return userRepository.findAll();
	}
	
	public String getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}
}	
