package com.nisum.javaevaluation.models;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(nullable = false, length = 80)
	public String name;
	@Column(nullable = false, length = 100)
	public String email;
	@Column(nullable = false, length = 128)
	public String password;
}
