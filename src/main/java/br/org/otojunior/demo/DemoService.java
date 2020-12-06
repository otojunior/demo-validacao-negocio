/**
 * 
 */
package br.org.otojunior.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author otoju
 *
 */
@Service
public class DemoService {
	@Autowired
	private DemoRepositorio demoRepositorio;
	
	/**
	 * 
	 * @param demoEntidade
	 * @return
	 */
	public DemoEntidade inserir(DemoEntidade demoEntidade) {
		return demoRepositorio.saveAndFlush(demoEntidade);
	}

	/**
	 * 
	 * @return
	 */
	public List<DemoEntidade> listar() {
		return demoRepositorio.findAll();
	}
}
