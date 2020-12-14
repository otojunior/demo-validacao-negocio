/**
 * 
 */
package br.org.otojunior.demo.rest;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author otoju
 *
 */
@Getter
@Setter
public class PessoaDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String nome;
}
