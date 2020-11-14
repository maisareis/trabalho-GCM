/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.TipoFuncionario;
import br.edu.uniacademia.hospital.util.PersistenceUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author tassi
 */
public class TipoFuncionarioDAO {

    public static TipoFuncionarioDAO tipoFuncionarioDAO;

    public static TipoFuncionarioDAO getInstance() {
        if (tipoFuncionarioDAO == null) {
            tipoFuncionarioDAO = new TipoFuncionarioDAO();
        }
        return tipoFuncionarioDAO;
    }

    public String persistir(TipoFuncionario tipoFuncionario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            tipoFuncionario = em.merge(tipoFuncionario);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TipoFuncionario salvo com sucesso!");
            return "TipoFuncionario " + tipoFuncionario.getNomeTipoFuncionario() + " salvo com sucesso!";
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.flush();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível salvar o tipoFuncionario!", e.getMessage());
            if (e.getMessage().contains("ConstraintViolationException")) {
                return "Não foi possível salvar o tipoFuncionario " + tipoFuncionario.getNomeTipoFuncionario() + ", pois o título deve ser único";
            }
            return "Não foi possível salvar o tipoFuncionario " + tipoFuncionario.getNomeTipoFuncionario() + "!";
        }
    }

    public String removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("TRUNCATE TipoFuncionario");
            query.executeUpdate();
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "Todos os tipoFuncionarios foram deletados!");
            return "Todos os tipoFuncionarios foram deletados!";
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.flush();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível deletar todos os tipoFuncionarios!", e.getMessage());
            return "Não foi possível deletar todos os tipoFuncionarios!";
        } finally {
            em.close();
        }
    }

    public String remover(TipoFuncionario tipoFuncionario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            tipoFuncionario = em.merge(tipoFuncionario);
            em.remove(tipoFuncionario);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "TipoFuncionario removido com sucesso!");
            return "TipoFuncionario " + tipoFuncionario.getNomeTipoFuncionario() + " removido com sucesso!";
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.flush();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi possível remover o tipoFuncionario!", e.getMessage());
            return "Não foi possível remover o tipoFuncionario " + tipoFuncionario.getNomeTipoFuncionario() + ", pois está vinculado a um ou mais exemplares";
        }
    }

    public List<TipoFuncionario> buscarTodas() {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM TipoFuncionario l");
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foram encontrados tipoFuncionarios!", e.getMessage());
            return new ArrayList<>();
        }
    }

    public TipoFuncionario buscar(long id) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM TipoFuncionario l WHERE l.id = :id");
            query.setParameter("id", id);
            TipoFuncionario tipoFuncionario = (TipoFuncionario) query.getSingleResult();
            if (tipoFuncionario != null && tipoFuncionario.getIdtipoFuncionario() > 0) {
                return tipoFuncionario;
            } else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "Não foram encontrados tipoFuncionarios!");
                return null;
            }
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foram encontrados tipoFuncionarios!", e.getMessage());
            return null;
        }
    }

    public List<TipoFuncionario> buscar(String titulo) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM TipoFuncionario l WHERE l.titulo LIKE :titulo");
            query.setParameter("titulo", "%" + titulo + "%");
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foram encontrados livros!", e.getMessage());
            return null;
        }
    }

    public TipoFuncionario buscar(TipoFuncionario l) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT l FROM TipoFuncionario l WHERE l.id = :id");
            query.setParameter("id", l.getIdtipoFuncionario());
            TipoFuncionario livro = (TipoFuncionario) query.getSingleResult();
            if (livro != null && livro.getIdtipoFuncionario() > 0) {
                return livro;
            } else {
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO, "Não foram encontrados livros!");
                return null;
            }
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foram encontrados livros!", e.getMessage());
            return null;
        }
    }
}
