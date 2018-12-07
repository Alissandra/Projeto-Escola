/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.web.bean;

import br.edu.ifrn.web.controle.TurmaControle;
import br.edu.ifrn.web.modelo.Turma;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Alissandra
 */

@Model
public class TurmaBean {
    @Inject
    private TurmaControle turmaDao;
    @Inject
    private Turma turmamodel;
    @Inject
    private FacesContext facesContext;
    private int idbean;

    public TurmaControle getTurmaDao() {
        return turmaDao;
    }

    public void setTurmaDao(TurmaControle turmaDao) {
        this.turmaDao = turmaDao;
    }

    public Turma getTurmamodel() {
        return turmamodel;
    }

    public void setTurmamodel(Turma turmamodel) {
        this.turmamodel = turmamodel;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public int getIdbean() {
        return idbean;
    }

    public void setIdbean(int idbean) {
        this.idbean = idbean;
    }
    
    public String salvarTurma(){
   String path = "/turma/"  ;
   String mensagem;
   if(turmamodel.getId() != null){
       turmaDao.atualizar(turmamodel);
       mensagem = "Turma Atualizada com suceso";
   }else{
       turmaDao.salvar(turmamodel);
       mensagem = "Turma salva com sucesso";
   }
   
   turmamodel = new Turma();
   facesContext.getExternalContext().getFlash().setKeepMessages(true);
   facesContext.addMessage(null,new FacesMessage(mensagem));
   
   return "turma.xhtml";

}
    
    
}
