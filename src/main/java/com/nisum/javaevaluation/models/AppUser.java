package com.nisum.javaevaluation.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "public")
public class AppUser {

	@Id
	@Column(name="id")
	public String id;
	@Column(name="name")
	public String name;
	@Column(name="email")
	public String email;
	@Column(name="password")
	public String password;
	@Column(name="token")
	public String token;
	@Column(name="created")
	public Date created;
	@Column(name="modified")
	public Date modified;
	@Column(name="last_login")
	public Date last_login;
	@Column(name="state")
	public boolean state;
	@OneToMany(mappedBy="id")
	List<Phone> phones;
}
