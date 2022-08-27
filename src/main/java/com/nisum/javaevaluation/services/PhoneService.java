package com.nisum.javaevaluation.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import com.nisum.javaevaluation.models.Phone;
import com.nisum.javaevaluation.repositories.PhoneRepository;
import com.nisum.javaevaluation.views.AppUserViewModelRequest;

public class PhoneService {
	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
    private ModelMapper modelMapper;
	
	public void savePhone(AppUserViewModelRequest user, String userid) throws NoSuchAlgorithmException {
		//Config mapper
		modelMapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE)
		.setSkipNullEnabled(true)
	    .setFieldMatchingEnabled(true);
		
		//Extrae, recorre y guarda los telefonos enviados en la peticion
		List<Phone> phoneEntity = modelMapper.map(user.phones, new TypeToken<List<Phone>>() {}.getType());
		for(Phone phoneUnit : phoneEntity) {
			phoneUnit.userid = userid;
			phoneRepository.save(phoneUnit);
		}
	}
}
