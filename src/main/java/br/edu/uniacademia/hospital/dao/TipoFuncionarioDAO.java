/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;


import br.edu.uniacademia.hospital.model.TipoFuncionario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author claud
 */
public class TipoFuncionarioDAO implements Serializable {

    @Inject
    EntityManager em;

    private DAO<TipoFuncionario> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<TipoFuncionario>(this.em, TipoFuncionario.class);
    }

    public TipoFuncionario buscarPorId(Long tipoFuncionarioId) {
        return this.dao.buscaPorId(tipoFuncionarioId);
    }

    public void adiciona(TipoFuncionario tipoFuncionario) {
        this.dao.adiciona(tipoFuncionario);
    }

    public void atualiza(TipoFuncionario tipoFuncionario) {
        this.dao.atualiza(tipoFuncionario);
    }

    public void remove(TipoFuncionario tipoFuncionario) {
        this.dao.remove(tipoFuncionario);
    }

    public List<TipoFuncionario> listaTodos() {
        return this.dao.listaTodos();
    }
}
