/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.dao.PacienteDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Pacientes;
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
public class PacienteBean implements Serializable {

    @Inject
    private Pacientes pacientes;

    @Inject
    private Enderecos enderecos;

    private Long pacienteId;

    private Long enderecoId;

    private List<Pacientes> pacienteList;

    @Inject
    private PacienteDAO pacidao;

    @Inject
    private EnderecoDAO enddao;

    public List<Pacientes> getPacienteList() {
        if (this.pacienteList == null) {
            this.pacienteList = this.pacidao.listaTodos();
        }
        return pacienteList;
    }

    public void carregarPacientesPeloId() {
        this.pacientes = this.pacidao.buscarPorId(pacienteId);
    }

    @Transacional
    public String gravar() {
        if (this.pacientes.getIdPaciente() == null) {
            this.enddao.adiciona(this.enderecos);
            this.pacientes.setEndereco(this.enderecos);
            this.pacidao.adiciona(this.pacientes);
            this.pacienteList = this.pacidao.listaTodos();
        } else {
            this.enddao.atualiza(this.enderecos);
            this.pacidao.atualiza(this.pacientes);
            this.pacienteList = this.pacidao.listaTodos();
        }
        this.pacientes = new Pacientes();
        this.enderecos = new Enderecos();

        return "paciente?faces-redirect=true";
    }

    @Transacional
    public void remover(Pacientes pacientes) {
        System.out.println("Removendo Funcionario " + pacientes.getNomePaciente());
        this.pacidao.remove(pacientes);
        this.enddao.remove(pacientes.getEndereco());
        this.pacienteList = this.pacidao.listaTodos();
    }

    public Enderecos getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
        this.enderecos = enddao.buscarPorId(pacientes.getEndereco().getIdEndereco());
    }
}
