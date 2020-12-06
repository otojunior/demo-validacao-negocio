/**
 * 
 */
package br.org.otojunior.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author otoju
 *
 */
@Repository
public interface DemoRepositorio extends JpaRepository<DemoEntidade, Long> {

}
