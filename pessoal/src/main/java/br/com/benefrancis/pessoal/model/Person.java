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
@Table(name = "person")
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public  class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Person")
	@SequenceGenerator(name = "SEQ_Person", sequenceName = "SEQ_Person", allocationSize = 1, initialValue = 1)
	@Column(name = "ID_Person")
	private Long id;

	private String firstName;

	private String lastName;

	@JoinColumn(name = "address_id", referencedColumnName = "id_address", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Address address = new Address();

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar birthDay;

	private String picture;

	private String personalEmail;

}
