/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tassi
 */
@Entity
@Table(name = "Funcionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionarios.findAll", query = "SELECT f FROM Funcionarios f"),
    @NamedQuery(name = "Funcionarios.findByIdFuncionario", query = "SELECT f FROM Funcionarios f WHERE f.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Funcionarios.findByNomeFuncionario", query = "SELECT f FROM Funcionarios f WHERE f.nomeFuncionario = :nomeFuncionario"),
    @NamedQuery(name = "Funcionarios.findByCpf", query = "SELECT f FROM Funcionarios f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Funcionarios.findByRg", query = "SELECT f FROM Funcionarios f WHERE f.rg = :rg"),
    @NamedQuery(name = "Funcionarios.findByCrm", query = "SELECT f FROM Funcionarios f WHERE f.crm = :crm")})
public class Funcionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFuncionario")
    private Long idFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeFuncionario")
    private String nomeFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "crm")
    private String crm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionariosidFuncionario")
    private List<Prontuarios> prontuariosList;
    @JoinColumn(name = "Enderecos_idEnderecos", referencedColumnName = "idEndereco")
    @ManyToOne(optional = false)
    private Enderecos enderecosidEnderecos;
    @JoinColumn(name = "tipoFuncionario_idtipoFuncionario", referencedColumnName = "idtipoFuncionario")
    @ManyToOne(optional = false)
    private TipoFuncionario tipoFuncionarioidtipoFuncionario;

    public Funcionarios() {
    }

    public Funcionarios(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionarios(Long idFuncionario, String nomeFuncionario, String cpf, String rg, String crm) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cpf = cpf;
        this.rg = rg;
        this.crm = crm;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @XmlTransient
    public List<Prontuarios> getProntuariosList() {
        return prontuariosList;
    }

    public void setProntuariosList(List<Prontuarios> prontuariosList) {
        this.prontuariosList = prontuariosList;
    }

    public Enderecos getEnderecosidEnderecos() {
        return enderecosidEnderecos;
    }

    public void setEnderecosidEnderecos(Enderecos enderecosidEnderecos) {
        this.enderecosidEnderecos = enderecosidEnderecos;
    }

    public TipoFuncionario getTipoFuncionarioidtipoFuncionario() {
        return tipoFuncionarioidtipoFuncionario;
    }

    public void setTipoFuncionarioidtipoFuncionario(TipoFuncionario tipoFuncionarioidtipoFuncionario) {
        this.tipoFuncionarioidtipoFuncionario = tipoFuncionarioidtipoFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.hospital.model.Funcionarios[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
