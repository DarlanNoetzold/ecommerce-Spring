package tech.noetzold.ecommerce.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.aspectj.weaver.VersionedDataInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import tech.noetzold.ecommerce.modelos.EntradaItens;
import tech.noetzold.ecommerce.modelos.EntradaProduto;
import tech.noetzold.ecommerce.modelos.Estado;
import tech.noetzold.ecommerce.modelos.Produto;
import tech.noetzold.ecommerce.modelos.Estado;
import tech.noetzold.ecommerce.repositorios.EntradaItensRepositorio;
import tech.noetzold.ecommerce.repositorios.EntradaProdutoRepositorio;
import tech.noetzold.ecommerce.repositorios.EstadoRepositorio;
import tech.noetzold.ecommerce.repositorios.FuncionarioRepositorio;
import tech.noetzold.ecommerce.repositorios.ProdutoRepositorio;

@Controller
public class EntradaProdutoControle {

	private List<EntradaItens> listaEntrada = new ArrayList<EntradaItens>();

	@Autowired
	private EntradaProdutoRepositorio entradaProdutoRepositorio;

	@Autowired
	private EntradaItensRepositorio entradaItensRepositorio;

	@Autowired
	private FuncionarioRepositorio funcionarioRepositorio;

	@Autowired
	private ProdutoRepositorio produtoRepositorio;

	@GetMapping("/administrativo/entrada/cadastrar")
	public ModelAndView cadastrar(EntradaProduto entrada, EntradaItens entradaItens) {
		ModelAndView mv = new ModelAndView("administrativo/entrada/cadastro");
		mv.addObject("entrada", entrada);
		mv.addObject("listaEntradaItens", this.listaEntrada);
		mv.addObject("entradaItens", entradaItens);
		mv.addObject("listaFuncionarios", funcionarioRepositorio.findAll());
		mv.addObject("listaProdutos", produtoRepositorio.findAll());
		return mv;
	}

//	@GetMapping("/administrativo/estados/listar")
//	public ModelAndView listar() {
//		ModelAndView mv=new ModelAndView("administrativo/estados/lista");
//		mv.addObject("listaEstados", estadoRepositorio.findAll());
//		return mv;
//	}

//	@GetMapping("/administrativo/estados/editar/{id}")
//	public ModelAndView editar(@PathVariable("id") Long id) {
//		Optional<Estado> estado = estadoRepositorio.findById(id);
//		return cadastrar(estado.get());
//	}

//	@GetMapping("/administrativo/estados/remover/{id}")
//	public ModelAndView remover(@PathVariable("id") Long id) {
//		Optional<Estado> estado = estadoRepositorio.findById(id);
//		estadoRepositorio.delete(estado.get());
//		return listar();
//	}

	@PostMapping("/administrativo/entrada/salvar")
	public ModelAndView salvar(String acao, EntradaProduto entrada, EntradaItens entradaItens) {

		if (acao.equals("itens")) {
			this.listaEntrada.add(entradaItens);
		} else if (acao.equals("salvar")) {
			entradaProdutoRepositorio.saveAndFlush(entrada);
			for (EntradaItens it : listaEntrada) {
				it.setEntrada(entrada);
				entradaItensRepositorio.saveAndFlush(it);
				Optional<Produto> prod = produtoRepositorio.findById(it.getProduto().getId());
				Produto produto = prod.get();
				produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + it.getQuantidade());
				produto.setValorVenda(it.getValorVenda());
				produtoRepositorio.saveAndFlush(produto);
				this.listaEntrada = new ArrayList<>();
			}
			return cadastrar(new EntradaProduto(), new EntradaItens());
		}

		return cadastrar(entrada, new EntradaItens());
	}

}
