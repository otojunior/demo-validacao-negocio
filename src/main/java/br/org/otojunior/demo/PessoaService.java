/**
 * 
 */
package br.org.otojunior.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author otoju
 *
 */
@Service
public class PessoaService extends AbstractDemoService<Pessoa> {
	@Autowired private PessoaRepositorio pessoaRepositorio;
	@Autowired private PessoaValidacaoNegocio pessoaValidacaoNegocio;
	
	/**
	 * 
	 * @param demoEntidade
	 * @return
	 * @throws ValidacaoNegocioException 
	 */
	@Transactional
	public Pessoa inserir(final Pessoa pessoa) {
		return salvar(pessoa, pessoaValidacaoNegocio, pessoaRepositorio);
	}

	/**
	 * 
	 * @return
	 */
	public List<Pessoa> listar() {
		return pessoaRepositorio.findAll();
	}
}
