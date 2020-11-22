package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.UsuarioDao;
import br.edu.uniacademia.hospital.model.Usuario;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ViewScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Usuario usuario;

    @Inject
    UsuarioDao dao;

    @Inject
    FacesContext context;

    public Usuario getUsuario() {
        return usuario;
    }

    public String efetuaLogin() {
        System.out.println("fazendo login do usuario "
                + this.usuario.getEmail());

        boolean existe = dao.existe(this.usuario);
        if (existe) {
            context.getExternalContext().getSessionMap()
                    .put("usuarioLogado", this.usuario);
            return "index?faces-redirect=true";
        }

        context.getExternalContext().getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage("Usuário não encontrado"));

        return "login?faces-redirect=true";
    }

    public String deslogar() {
        context.getExternalContext().getSessionMap().remove("usuarioLogado");
        return "login?faces-redirect=true";
    }
}
