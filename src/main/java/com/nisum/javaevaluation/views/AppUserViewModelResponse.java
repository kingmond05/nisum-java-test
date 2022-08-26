package com.nisum.javaevaluation.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserViewModelResponse {

	public String id;
	public String created;
	public String modified;
	public String last_login;
	public String token;
	public boolean isactive;
}