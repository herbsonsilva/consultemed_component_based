package br.com.consultemed.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({ @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c")})
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Getter
@Setter
@Table(name = "TB_CONSULTAS")
public class Consulta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="ID_MEDICO")
	private Medico medico;
	
	@OneToOne(cascade= {CascadeType.PERSIST ,CascadeType.REMOVE}) 
	@JoinColumn(name="ID_AGENDAMENTO")
	private Agendamento agendamento;
	
//	@OneToMany(cascade=CascadeType.REMOVE)
//	@JoinColumn(name="ID_CONSULTA")
//	private List<Exame> exames;
	
}
