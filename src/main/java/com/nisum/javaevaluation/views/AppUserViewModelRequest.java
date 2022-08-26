package com.nisum.javaevaluation.views;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserViewModelRequest {

	public String name;
	public String email;
	public String password;
	public List<PhoneViewModel> phones;
}
