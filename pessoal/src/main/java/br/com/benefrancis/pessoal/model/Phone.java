package br.com.benefrancis.pessoal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "phone")
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PHONE")
	@SequenceGenerator(name = "SEQ_PHONE", sequenceName = "SEQ_PHONE", allocationSize = 1, initialValue = 1)
	@Column(name = "id_phone")
	private Long id;

	private String ddi;

	private String ddd;

	private String number;

	private String phoneNumber;

	public Phone(String phoneNumber) {
		super();
		this.phoneNumber = number; // +55 (83) 0109-5572
	}

}
