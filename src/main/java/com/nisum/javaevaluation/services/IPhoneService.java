package com.nisum.javaevaluation.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.nisum.javaevaluation.models.Phone;
import com.nisum.javaevaluation.views.AppUserViewModelRequest;

public interface IPhoneService {
	public void savePhone(AppUserViewModelRequest user, String userid) throws NoSuchAlgorithmException;
	public List<Phone> listAll();
}
