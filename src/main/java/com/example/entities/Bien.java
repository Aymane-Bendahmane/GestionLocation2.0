package com.example.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.core.sym.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bien implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long refference;
	private Double prix;
	private Date date_ajoute;
	private Double surface;
	private Integer nb_chambre;
	private Integer nb_etage;
	private Integer nb_salon;
	private Boolean balcon;
	private Boolean garage;
	private Boolean parking;
	private String description;
	private Boolean disponibilite;
	private String ville;
	private String quartier ;


	// un bien a un type
	@ManyToOne
	@JoinColumn(name = "id_type")
	private Type type;

	
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<User> users;

}
