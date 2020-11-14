/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassi
 */
@Entity
@Table(name = "Pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByIdPaciente", query = "SELECT p FROM Pacientes p WHERE p.idPaciente = :idPaciente"),
    @NamedQuery(name = "Pacientes.findByNomePaciente", query = "SELECT p FROM Pacientes p WHERE p.nomePaciente = :nomePaciente"),
    @NamedQuery(name = "Pacientes.findByCpf", query = "SELECT p FROM Pacientes p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Pacientes.findBySexo", query = "SELECT p FROM Pacientes p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Pacientes.findByDataNascimento", query = "SELECT p FROM Pacientes p WHERE p.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Pacientes.findByTipoSanguineo", query = "SELECT p FROM Pacientes p WHERE p.tipoSanguineo = :tipoSanguineo")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaciente")
    private Long idPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomePaciente")
    private String nomePaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private Character sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 3)
    @Column(name = "tipoSanguineo")
    private String tipoSanguineo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacientesidPaciente")
    private List<Prontuarios> prontuariosList;
    @JoinColumn(name = "endereco", referencedColumnName = "idEndereco")
    @ManyToOne(optional = false)
    private Enderecos endereco;

    public Pacientes() {
    }

    public Pacientes(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Pacientes(Long idPaciente, String nomePaciente, String cpf, Character sexo, Date dataNascimento) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    @XmlTransient
    public List<Prontuarios> getProntuariosList() {
        return prontuariosList;
    }

    public void setProntuariosList(List<Prontuarios> prontuariosList) {
        this.prontuariosList = prontuariosList;
    }

    public Enderecos getEndereco() {
        return endereco;
    }

    public void setEndereco(Enderecos endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.hospital.model.Pacientes[ idPaciente=" + idPaciente + " ]";
    }
    
}
