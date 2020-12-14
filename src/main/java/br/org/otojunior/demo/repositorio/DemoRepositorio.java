/**
 * 
 */
package br.org.otojunior.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.org.otojunior.demo.entidade.AbstractDemoEntidade;

/**
 * @author otoju
 *
 */
@NoRepositoryBean
public interface DemoRepositorio<T extends AbstractDemoEntidade> extends JpaRepository<T, Long> { }
