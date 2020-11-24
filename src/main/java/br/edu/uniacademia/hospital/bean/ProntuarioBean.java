/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.FuncionarioDAO;
import br.edu.uniacademia.hospital.dao.PacienteDAO;
import br.edu.uniacademia.hospital.dao.ProntuarioDAO;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.Pacientes;
import br.edu.uniacademia.hospital.model.Prontuarios;
import br.edu.uniacademia.hospital.tx.Transacional;
import java.io.Serializable;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author maisa
 */
@Named
@ViewScoped
public class ProntuarioBean implements Serializable {

    @Inject
    private Prontuarios prontuarios;

    @Inject
    private Pacientes pacientes;

    @Inject
    private Funcionarios funcionarios;

    private Long prontuarioId;

    private Long funcionarioId;

    private Long pacienteId;

    private List<Prontuarios> prontuariosesList;

    @Inject
    private ProntuarioDAO prontdao;

    @Inject
    private PacienteDAO pacdao;

    @Inject
    private FuncionarioDAO fundao;

    public Prontuarios getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(Prontuarios prontuarios) {
        this.prontuarios = prontuarios;
    }

    public void carregarProntuarioPeloId() {
        System.out.println("Carregando Prontuario");
        this.prontuarios = this.prontdao.buscarPorId(prontuarioId);
    }

    @Transacional
    public String gravar() {
        System.out.println("Gravando Prontuaio" + this.prontuarios.getIdProntuario());

        if (this.prontuarios.getIdProntuario() == null) {
            gravarFuncionario();
            gravarPaciente();
            this.prontdao.adiciona(this.prontuarios);
        } else {
            this.prontdao.atualiza(this.prontuarios);
        }
        this.prontuarios = new Prontuarios();

        return "prontuario?faces-redirect=true";

    }

    @Transacional
    public void remover(Prontuarios prontuarios) {
        System.out.println("Removendo tipo funcionario" + prontuarios.getIdProntuario());

        this.prontdao.remove(prontuarios);
    }

    public List<Prontuarios> getProntuariosesList() {
        if (this.prontuariosesList == null) {
            this.prontuariosesList = this.prontdao.listaTodos();
        }
        return prontuariosesList;
    }

    public Long getProntuarioId() {
        return prontuarioId;
    }

    public void setProntuarioId(Long prontuarioId) {
        this.prontuarioId = prontuarioId;
    }

    public List<Funcionarios> getFuncionarios() {
        return this.fundao.listaTodos();
    }

    public List<Pacientes> getPacienteses() {
        return this.pacdao.listaTodos();
    }

    public void gravarFuncionario() {
        Funcionarios funcionarios = this.fundao.buscarPorId(this.funcionarioId);
        this.prontuarios.setFuncionariosidFuncionario(funcionarios);
    }

    public void gravarPaciente() {
        Pacientes pacientes = this.pacdao.buscarPorId(this.pacienteId);
        this.prontuarios.setPacientesidPaciente(pacientes);
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }


    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

}
