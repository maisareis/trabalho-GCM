/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Pacientes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author maisa
 */
public class PacienteDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    EntityManager em;

    private DAO<Pacientes> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Pacientes>(this.em, Pacientes.class);
    }

    public Pacientes buscarPorId(Long pacienteId) {
        return this.dao.buscaPorId(pacienteId);
    }

    public void adiciona(Pacientes pacientes) {
        this.dao.adiciona(pacientes);
    }

    public void atualiza(Pacientes pacientes) {
        this.dao.atualiza(pacientes);
    }

    public void remove(Pacientes pacientes) {
        this.dao.remove(pacientes);
    }

    public List<Pacientes> listaTodos() {
        return this.dao.listaTodos();
    }

//    public static FuncionarioDAO getInstance() {
//        if (tipoFuncionarioDAO == null) {
//            tipoFuncionarioDAO = new FuncionarioDAO();
//        }
//        return tipoFuncionarioDAO;
//    }
}
