/**
 * 
 */
package br.org.otojunior.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author otoju
 *
 */
@Entity
@Getter
@Setter
public class Pessoa {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private Integer codigo;
	
	@Column(nullable = false, length = 30)
	private String nome;
}
