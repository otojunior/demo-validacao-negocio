/**
 * 
 */
package br.org.otojunior.demo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author otoju
 *
 */
@Entity
@Getter
@Setter
public class Pessoa extends AbstractDemoEntidade {
	@Column(nullable = false)
	private Integer codigo;
	
	@Column(nullable = false, length = 30)
	private String nome;
}
