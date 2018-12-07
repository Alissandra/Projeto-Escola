/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifrn.web.bean;

import br.edu.ifrn.web.controle.TurmaControle;
import br.edu.ifrn.web.modelo.Turma;
import java.util.List;
import javax.enterprise.inject.Model;

/**
 *
 * @author Alissandra
 */

@Model
public class ListaTurma {
    private TurmaControle turmaControl;
    private List<Turma> turmaList;

    public List<Turma> listar() {
        if (turmaList == null) {
            turmaList = turmaControl.listar();
        }
        return turmaList;
    }

    
     public void excluir(Turma turma){
        turmaControl.excluir(turma);
        turmaList = null;
    }
    
     
     
     public String atualizar(Integer id){
        return "turma.xhtml?id=" + String.valueOf(id);
    }
     
     public String novo(){
        return "turma.xhtml?faces-redirect=true";
    }
     
    
}
