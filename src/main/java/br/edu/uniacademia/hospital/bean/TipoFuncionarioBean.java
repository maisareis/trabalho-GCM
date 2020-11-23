/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.TipoFuncionarioDAO;
import br.edu.uniacademia.hospital.model.TipoFuncionario;
import br.edu.uniacademia.hospital.tx.Transacional;
import java.io.Serializable;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author claud
 */
@Named
@ViewScoped
public class TipoFuncionarioBean implements Serializable {

    @Inject
    private TipoFuncionario tipoFuncionario;

    private Long tipoFuncionarioId;

    @Inject
    private TipoFuncionarioDAO dao;

    public Long getTipoFuncionarioId() {
        return tipoFuncionarioId;
    }

    public void setTipoFuncionarioId(Long tipoFuncionarioId) {
        this.tipoFuncionarioId = tipoFuncionarioId;
    }

    public void carregarTipoFuncionarioPeloId() {
        System.out.println("Carregando tipo");
        this.tipoFuncionario = this.dao.buscarPorId(tipoFuncionarioId);
    }

    @Transacional
    public String gravar() {
        System.out.println("Gravando tipo funcionario" + this.tipoFuncionario.getNomeTipoFuncionario());

        if (this.tipoFuncionario.getIdtipoFuncionario() == null) {
            this.dao.adiciona(this.tipoFuncionario);
        } else {
            this.dao.atualiza(this.tipoFuncionario);
        }
        this.tipoFuncionario = new TipoFuncionario();

        return "tipoFuncionario?faces-redirect=true";

    }

    @Transacional
    public void remover(TipoFuncionario tipoFuncionario) {
        System.out.println("Removendo tipo funcionario" + tipoFuncionario.getNomeTipoFuncionario());

        this.dao.remove(tipoFuncionario);
    }

    public List<TipoFuncionario> getTipoFuncionarios() {
        return this.dao.listaTodos();
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public void carregar(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public void novo() {
        this.tipoFuncionario = new TipoFuncionario();
    }

}
