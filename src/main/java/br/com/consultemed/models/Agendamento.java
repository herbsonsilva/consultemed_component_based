package br.com.consultemed.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({ @NamedQuery(name = "Agendamento.findAll", query = "SELECT a FROM Agendamento a")})
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Getter
@Setter
@Table(name = "TB_AGENDAMENTOS")
public class Agendamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@ManyToOne
	@JoinColumn(name="ID_PACIENTE")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name="ID_MEDICO")
	private Medico medico;
	
	@Column(name="DATA_AGENDAMENTO")
	private LocalDate dataAgendamento;

	@Enumerated(EnumType.STRING)
	private StatusAgendamento status;

}
