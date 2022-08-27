package com.nisum.javaevaluation.services;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.nisum.javaevaluation.controllers.UserValidationConfig;
import com.nisum.javaevaluation.models.AppUser;
import com.nisum.javaevaluation.repositories.AppUserRepository;
import com.nisum.javaevaluation.utils.RegexValidation;
import com.nisum.javaevaluation.utils.SecuritySupports;
import com.nisum.javaevaluation.views.AppUserViewModelRequest;
import com.nisum.javaevaluation.views.AppUserViewModelResponse;

@Service
public class AppUserService implements IAppUserService {
	
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
    private ModelMapper modelMapper;
	@Autowired
	private SecuritySupports secureUtils;
	@Autowired
	private IPhoneService phoneService;
	@Autowired
	private RegexValidation regex;
	@Autowired
	private UserValidationConfig validationConfig;
	
	public AppUserViewModelResponse saveUser(AppUserViewModelRequest user) 
			throws NoSuchAlgorithmException, 
			MethodArgumentNotValidException {
		//Config mapper
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE)
		.setSkipNullEnabled(true)
	    .setFieldMatchingEnabled(true);
		AppUser userEntity = modelMapper.map(user, AppUser.class);
		
		//Valida regex de clave
		if(!regex.applyRegexValidation(validationConfig.getPasswordregex(), user.password)) {
			List<ObjectError> errors = new ArrayList<>();			
			FieldError fieldError = new FieldError("AppUserViewModelRequest", "Clave", validationConfig.getPasswordregexerrortext());
			errors.add(fieldError);
			BeanPropertyBindingResult result = new BeanPropertyBindingResult(errors, "result");
			throw new MethodArgumentNotValidException(null, result);
		}
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
