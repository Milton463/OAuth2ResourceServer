package com.milton.auth2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "utility")
@Data
public class Utility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "utility_id")
	private int utilityId;

	@Column(name = "utility_name")
	private String utilityName;

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//	@JoinTable(name = "utility_provider", joinColumns = { @JoinColumn(name = "utility_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "user_id") })
//	private Set<User> utilityProviders;
//
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//	@JoinTable(name = "utility_consumer", joinColumns = { @JoinColumn(name = "utility_id") }, inverseJoinColumns = {
//			@JoinColumn(name = "user_id") })
//	private Set<User> utilityConsumers;
}
