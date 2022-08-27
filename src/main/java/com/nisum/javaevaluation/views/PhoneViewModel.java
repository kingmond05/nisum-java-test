package com.nisum.javaevaluation.views;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneViewModel {

	@NotBlank(message = "Nombre es requerido")
	public String number;
	@NotBlank(message = "Nombre es requerido")
	public String citycode;
	@NotBlank(message = "Nombre es requerido")
	public String countrycode;
}
