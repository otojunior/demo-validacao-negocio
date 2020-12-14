/**
 * 
 */
package br.org.otojunior.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.otojunior.demo.entidade.Pessoa;
import br.org.otojunior.demo.repositorio.PessoaRepositorio;
import br.org.otojunior.demo.validacao.PessoaValidacaoNegocio;
import br.org.otojunior.demo.validacao.ValidacaoNegocioException;

/**
 * @author otoju
 *
 */
@Service
public class PessoaService extends AbstractDemoService<Pessoa> {
	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	/**
	 * 
	 * @param demoEntidade
	 * @return
	 * @throws ValidacaoNegocioException 
	 */
	@Transactional
	public Pessoa inserir(Pessoa pessoa) {
		return salvar(pessoa, PessoaValidacaoNegocio.class, pessoaRepositorio);
	}

	/**
	 * 
	 * @return
	 */
	public List<Pessoa> listar() {
		return pessoaRepositorio.findAll();
	}
}
