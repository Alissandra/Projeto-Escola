/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.controle;

import br.edu.ifrn.web.modelo.Turma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Alissandra
 */

public class TurmaControle {
    
    @PersistenceContext
    private EntityManager entityManeger;

    @Transactional
    public void salvar(Turma turma) {
        entityManeger.persist(turma);
    }
    @Transactional
    public void atualizar(Turma turma) {
        entityManeger.merge(turma);
    }


     public List<Turma> listar(){
        
        return entityManeger.createQuery("from turma").getResultList();
    }
   /* public void buscar(Integer id){
        entityManeger.find(type, turma)
    }*/

    public void excluir(Turma turma){
        entityManeger.remove(turma);
    }
    
    
}
