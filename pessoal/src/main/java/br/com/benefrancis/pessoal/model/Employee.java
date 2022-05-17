package br.com.benefrancis.pessoal.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "employee")
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Employee")
	@SequenceGenerator(name = "SEQ_Employee", sequenceName = "SEQ_Employee", allocationSize = 1, initialValue = 1)
	@Column(name = "ID_Employee")
	private Long id;

	private String matricula;

	@JoinColumn(name = "person_id", referencedColumnName = "id_person", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Person person;

	private String corporateEmail;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar hiringDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dismissalDate;

}
