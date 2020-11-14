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
import javax.persistence.Id;
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
@Table(name = "Enderecos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enderecos.findAll", query = "SELECT e FROM Enderecos e"),
    @NamedQuery(name = "Enderecos.findByIdEndereco", query = "SELECT e FROM Enderecos e WHERE e.idEndereco = :idEndereco"),
    @NamedQuery(name = "Enderecos.findByLogradouro", query = "SELECT e FROM Enderecos e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Enderecos.findByNumero", query = "SELECT e FROM Enderecos e WHERE e.numero = :numero"),
    @NamedQuery(name = "Enderecos.findByComplemento", query = "SELECT e FROM Enderecos e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "Enderecos.findByBairro", query = "SELECT e FROM Enderecos e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "Enderecos.findByLocalidade", query = "SELECT e FROM Enderecos e WHERE e.localidade = :localidade"),
    @NamedQuery(name = "Enderecos.findByUf", query = "SELECT e FROM Enderecos e WHERE e.uf = :uf"),
    @NamedQuery(name = "Enderecos.findByCep", query = "SELECT e FROM Enderecos e WHERE e.cep = :cep")})
public class Enderecos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEndereco")
    private Long idEndereco;
    @Size(max = 45)
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 45)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 45)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "localidade")
    private String localidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "uf")
    private String uf;
    @Size(max = 8)
    @Column(name = "cep")
    private String cep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enderecosidEnderecos")
    private List<Funcionarios> funcionariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endereco")
    private List<Pacientes> pacientesList;

    public Enderecos() {
    }

    public Enderecos(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Enderecos(Long idEndereco, String localidade, String uf) {
        this.idEndereco = idEndereco;
        this.localidade = localidade;
        this.uf = uf;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @XmlTransient
    public List<Funcionarios> getFuncionariosList() {
        return funcionariosList;
    }

    public void setFuncionariosList(List<Funcionarios> funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    @XmlTransient
    public List<Pacientes> getPacientesList() {
        return pacientesList;
    }

    public void setPacientesList(List<Pacientes> pacientesList) {
        this.pacientesList = pacientesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndereco != null ? idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enderecos)) {
            return false;
        }
        Enderecos other = (Enderecos) object;
        if ((this.idEndereco == null && other.idEndereco != null) || (this.idEndereco != null && !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.hospital.model.Enderecos[ idEndereco=" + idEndereco + " ]";
    }
    
}
