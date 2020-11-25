/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.dao.FuncionarioDAO;
import br.edu.uniacademia.hospital.dao.TipoFuncionarioDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.TipoFuncionario;
import br.edu.uniacademia.hospital.tx.Transacional;
import java.io.Serializable;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author claud
 */
@Named
@ViewScoped
public class FuncinarioBean implements Serializable {

    @Inject
    private Funcionarios funcionario;

    @Inject
    private Enderecos enderecos;

    private Long funcionarioId;

    private Long tipoFuncionarioId;

    private Long enderecoId;

    private List<Funcionarios> funnariosList;

    @Inject
    private FuncionarioDAO fundao;

    @Inject
    private TipoFuncionarioDAO tipodao;

    @Inject
    private EnderecoDAO enddao;

    @Inject
    private FacesContext context;

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Long getTipoFuncionarioId() {
        return tipoFuncionarioId;
    }

    public void setTipoFuncionarioId(Long tipoFuncionarioId) {
        this.tipoFuncionarioId = tipoFuncionarioId;
    }

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public List<Funcionarios> getFunnariosList() {
        if (this.funnariosList == null) {
            this.funnariosList = this.fundao.listaTodos();
        }
        return funnariosList;
    }

    public List<TipoFuncionario> getTipoFuncionarios() {
        return this.tipodao.listaTodos();
    }

    public TipoFuncionario getTipoFuncionariosDeFuncionarios() {
        return this.funcionario.getTipoFuncionarioidtipoFuncionario();
    }

    public void carregarFuncionariosPeloId() {
        this.funcionario = this.fundao.buscarPorId(funcionarioId);
    }

    public void gravarTipoFuncionario() {
        TipoFuncionario tipoFuncionario = this.tipodao.buscarPorId(this.tipoFuncionarioId);
        this.funcionario.setTipoFuncionarioidtipoFuncionario(tipoFuncionario);
    }

    @Transacional
    public String gravar() {
        if (this.funcionario.getIdFuncionario() == null) {
            this.enddao.adiciona(this.enderecos);
            this.gravarTipoFuncionario();
            this.funcionario.setEnderecosidEnderecos(this.enderecos);
            this.fundao.adiciona(this.funcionario);
            this.funnariosList = this.fundao.listaTodos();
        } else {
            this.enddao.atualiza(this.enderecos);
            this.gravarTipoFuncionario();
            this.fundao.atualiza(this.funcionario);
            this.funnariosList = this.fundao.listaTodos();
        }
        this.funcionario = new Funcionarios();
        this.enderecos = new Enderecos();

        return "funcionario?faces-redirect=true";
    }

    @Transacional
    public void remover(Funcionarios funcionario) {
        System.out.println("Removendo Funcionario " + funcionario.getNomeFuncionario());
        this.fundao.remove(funcionario);
        this.enddao.remove(funcionario.getEnderecosidEnderecos());
        this.funnariosList = this.fundao.listaTodos();
    }

    public void carregar(Funcionarios funcionario) {
        System.out.println("Carregar funcionario");
        this.funcionario = this.fundao.buscarPorId(funcionario.getIdFuncionario());
    }

    public Enderecos getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
        this.enderecos = enddao.buscarPorId(funcionario.getEnderecosidEnderecos().getIdEndereco());

    }

    public void novo() {
        this.funcionario = new Funcionarios();
        this.enderecos = new Enderecos();
    }

}
