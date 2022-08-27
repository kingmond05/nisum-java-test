package com.nisum.javaevaluation.models;


import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class AppUser {

	@Id
	public Long id;
	public String name;
	public String email;
	public String password;
	public String token;
	public Date created;
	public Date modified;
	public Date last_login;
	public boolean isactive;
}
