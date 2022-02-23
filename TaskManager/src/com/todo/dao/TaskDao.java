package com.todo.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.todo.model.Task;

//Repository - Camada de persistência - Data Access Object
public class TaskDao {

	private EntityManager em; //Conectado com o persistence.xml para manipular os dados.
	
	public TaskDao() { //Garantir que todos os utilizem o msm EntityManager - Singleton
		em = com.todo.util.HibernateUtil
                .geteEntityManagerFactory().createEntityManager();
	}
	
	public void saveOrUpdate(Task task) {
        
        try {
            em.getTransaction().begin();
            if (task.getId() == null) {
                em.persist(task); //Cria ID único para a nova task a ser adicionada
                if(FacesContext.getCurrentInstance() != null) //Para sinalizar ao usuário em tela
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Task saved successfully"));
            }else {
                em.merge(task); //Utilizado quando editamos um objeto da planilha, pois já tem ID.
                if(FacesContext.getCurrentInstance() != null)
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Task updated successfully"));
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } 
    }
	
    public void delete(Task task) {
        try {
            em.getTransaction().begin();
            Task al = em.find(Task.class, task.getId());
            em.remove(al);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public List<Task> list() {
        List<Task> result = null;
        try {
            Query query = em.createQuery("FROM Task WHERE completedTask = false ORDER BY id DESC");
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public Task findTask(Long id) {
		return em.find(Task.class, id);
	}
    
    public void setAsCompleted(Task task) {
    	 try {
             em.getTransaction().begin();
             Task al = em.find(Task.class, task.getId());
             em.setProperty("completedtask", true);
             em.getTransaction().commit();
         } catch (Exception e) {
             em.getTransaction().rollback();
         }	
    	
    }
}
