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
@Table(name = "tipoFuncionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFuncionario.findAll", query = "SELECT t FROM TipoFuncionario t"),
    @NamedQuery(name = "TipoFuncionario.findByIdtipoFuncionario", query = "SELECT t FROM TipoFuncionario t WHERE t.idtipoFuncionario = :idtipoFuncionario"),
    @NamedQuery(name = "TipoFuncionario.findByNomeTipoFuncionario", query = "SELECT t FROM TipoFuncionario t WHERE t.nomeTipoFuncionario = :nomeTipoFuncionario")})
public class TipoFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtipoFuncionario")
    private Long idtipoFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nomeTipoFuncionario")
    private String nomeTipoFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoFuncionarioidtipoFuncionario")
    private List<Funcionarios> funcionariosList;

    public TipoFuncionario() {
    }

    public TipoFuncionario(Long idtipoFuncionario) {
        this.idtipoFuncionario = idtipoFuncionario;
    }

    public TipoFuncionario(Long idtipoFuncionario, String nomeTipoFuncionario) {
        this.idtipoFuncionario = idtipoFuncionario;
        this.nomeTipoFuncionario = nomeTipoFuncionario;
    }

    public Long getIdtipoFuncionario() {
        return idtipoFuncionario;
    }

    public void setIdtipoFuncionario(Long idtipoFuncionario) {
        this.idtipoFuncionario = idtipoFuncionario;
    }

    public String getNomeTipoFuncionario() {
        return nomeTipoFuncionario;
    }

    public void setNomeTipoFuncionario(String nomeTipoFuncionario) {
        this.nomeTipoFuncionario = nomeTipoFuncionario;
    }

    @XmlTransient
    public List<Funcionarios> getFuncionariosList() {
        return funcionariosList;
    }

    public void setFuncionariosList(List<Funcionarios> funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoFuncionario != null ? idtipoFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFuncionario)) {
            return false;
        }
        TipoFuncionario other = (TipoFuncionario) object;
        if ((this.idtipoFuncionario == null && other.idtipoFuncionario != null) || (this.idtipoFuncionario != null && !this.idtipoFuncionario.equals(other.idtipoFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.uniacademia.hospital.model.TipoFuncionario[ idtipoFuncionario=" + idtipoFuncionario + " ]";
    }
    
}
