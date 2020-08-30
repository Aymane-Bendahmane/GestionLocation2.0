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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Affectation implements Serializable {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id_aff;
		private Date date_aff;
		private Date date_fin_aff;
		
	
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		private Collection<Document> documents;
		
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		private Collection<Paiment> paiments;
		
		@ManyToOne
		@JoinColumn(name="id_manager")
		private Manager manager;
		
		
		
		@ManyToOne
		@JoinColumn(name="refference")
		private Bien bien;
		
}
