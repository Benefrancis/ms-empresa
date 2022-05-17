package br.com.benefrancis.pessoal.model;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "address")
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADDRESS")
	@SequenceGenerator(name = "SEQ_ADDRESS", sequenceName = "SEQ_ADDRESS", allocationSize = 1, initialValue = 1)
	@Column(name = "ID_ADDRESS")
	private Long id;

	private String city;

	private String country;

	@JoinColumn(name = "phone_id", referencedColumnName = "id_phone", nullable = true)
	@ManyToOne(fetch = FetchType.EAGER)
	private Phone phone = new Phone();

	private String state;

	private String street;

	private String zipCode;

}
