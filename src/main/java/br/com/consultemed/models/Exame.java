//package br.com.consultemed.models;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@NamedQueries({ @NamedQuery(name = "Exame.findAll", query = "SELECT e FROM Exame e")})
//@NoArgsConstructor
//@EqualsAndHashCode
//@Entity
//@Getter
//@Setter
//@Table(name = "TB_EXAMES")
//public class Exame implements Serializable{
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	@Column(name = "RESULTADO_EXAME")
//	private String resultadoExame;
//	
//}
