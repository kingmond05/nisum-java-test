package com.nisum.javaevaluation.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "phones", schema = "public")
public class Phone {

	@Id
	@Column(name="number")
	public String number;
	@Column(name="userid")
	public String userid;
	@Column(name="citycode")
	public String citycode;
	@Column(name="countrycode")
	public String countrycode;
}
