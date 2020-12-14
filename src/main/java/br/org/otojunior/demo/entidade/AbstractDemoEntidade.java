/**
 * 
 */
package br.org.otojunior.demo.entidade;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author otoju
 *
 */
@MappedSuperclass
public abstract class AbstractDemoEntidade implements DemoEntidade {
	@Id
	@GeneratedValue
	private Long id;
}
