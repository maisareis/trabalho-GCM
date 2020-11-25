/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Funcionarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author tassi
 */
public class FuncionarioDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    EntityManager em;

    private DAO<Funcionarios> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Funcionarios>(this.em, Funcionarios.class);
    }

    public Funcionarios buscarPorId(Long funcionarioId) {
        return this.dao.buscaPorId(funcionarioId);
    }

    public void adiciona(Funcionarios funcionarios) {
        this.dao.adiciona(funcionarios);
    }

    public void atualiza(Funcionarios funcionarios) {
        this.dao.atualiza(funcionarios);
    }

    public void remove(Funcionarios funcionario) {
        this.dao.remove(funcionario);
    }

    public List<Funcionarios> listaTodos() {
        return this.dao.listaTodos();
    }

//    public static FuncionarioDAO getInstance() {
//        if (tipoFuncionarioDAO == null) {
//            tipoFuncionarioDAO = new FuncionarioDAO();
//        }
//        return tipoFuncionarioDAO;
//    }
}
