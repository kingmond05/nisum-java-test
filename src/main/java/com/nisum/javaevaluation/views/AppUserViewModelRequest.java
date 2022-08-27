package com.nisum.javaevaluation.views;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserViewModelRequest {

	@NotBlank(message = "Nombre es requerido")
	@Email(message = "Email debe tener formato user@domain.com")
	public String name;
	@NotBlank(message = "Email es requerido")
	public String email;
	@NotBlank(message = "Password es requerido")
	@Pattern(regexp = "\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Mínimo ocho caracteres, al menos una letra y un número")
	public String password;
	//public List<PhoneViewModel> phones;
}
