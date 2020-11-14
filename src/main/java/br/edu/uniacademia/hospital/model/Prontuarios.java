/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tassi
 */
@Entity
@Table(name = "Prontuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prontuarios.findAll", query = "SELECT p FROM Prontuarios p"),
    @NamedQuery(name = "Prontuarios.findByIdProntuario", query = "SELECT p FROM Prontuarios p WHERE p.idProntuario = :idProntuario"),
    @NamedQuery(name = "Prontuarios.findByData", query = "SELECT p FROM Prontuarios p WHERE p.data = :data"),
    @NamedQuery(name = "Prontuarios.findByDescricao", query = "SELECT p FROM Prontuarios p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Prontuarios.findByObservacoes", query = "SELECT p FROM Prontuarios p WHERE p.observacoes = :observacoes")})
public class Prontuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProntuario")
    private Long idProntuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 255)
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "Funcionarios_idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionarios funcionariosidFuncionario;
    @JoinColumn(name = "Pacientes_idPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
    private Pacientes pacientesidPaciente;

    public Prontuarios() {
    }

    public Prontuarios(Long idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Prontuarios(Long idProntuario, Date data, String descricao) {
        this.idProntuario = idProntuario;
        this.data = data;
        this.descricao = descricao;
    }

    public Long getIdProntuario() {
        return idProntuario;
    }

    public void setIdProntuario(Long idProntuario) {
        this.idProntuario = idProntuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Funcionarios getFuncionariosidFuncionario() {
        return funcionariosidFuncionario;
    }

    public void setFuncionariosidFuncionario(Funcionarios funcionariosidFuncionario) {
        this.funcionariosidFuncionario = funcionariosidFuncionario;
    }

    public Pacientes getPacientesidPaciente() {
        return pacientesidPaciente;
    }

    public void setPacientesidPaciente(Pacientes pacientesidPaciente) {
        this.pacientesidPaciente = pacientesidPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProntuario != null ? idProntuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prontuarios)) {
            return false;
        }
        Prontuarios other = (Prontuarios) object;
        if ((this.idProntuario == null && other.idProntuario != null) || (this.idProntuario != null && !this.idProntuario.equals(other.idProntuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.hospital.model.Prontuarios[ idProntuario=" + idProntuario + " ]";
    }
    
}
