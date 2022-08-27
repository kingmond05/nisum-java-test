package com.nisum.javaevaluation.views;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserViewModelRequest {

	public String name;
	public String email;
	public String password;
	public List<PhoneViewModel> phones;
}
