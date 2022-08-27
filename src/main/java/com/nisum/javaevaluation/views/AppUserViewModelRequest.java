package com.nisum.javaevaluation.views;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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
	public String name;
	@NotBlank(message = "Email es requerido")
	@Email(message = "Email debe tener formato user@domain.cl")
	public String email;
	@NotBlank(message = "Password es requerido")
	@Pattern(regexp = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{7,16}$", message = "El password debe tener al entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.")
	public String password;
	public List<PhoneViewModel> phones;
}
