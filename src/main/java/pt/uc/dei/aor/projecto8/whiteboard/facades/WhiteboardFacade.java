/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.aor.projecto8.whiteboard.facades;

import java.util.Calendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.uc.dei.aor.projecto8.whiteboard.entities.Users;
import pt.uc.dei.aor.projecto8.whiteboard.entities.Whiteboard;

/**
 *
 * @author Vitor
 */
@Stateless
public class WhiteboardFacade extends AbstractFacade<Whiteboard> {

    @PersistenceContext(unitName = "WhiteboardPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WhiteboardFacade() {
        super(Whiteboard.class);
    }

    public void insertImage(String name, byte[] imagedata, Users user) {
        Whiteboard novo = new Whiteboard();
        novo.setName("teste");      
        novo.setImageDateCreator(Calendar.getInstance());
        novo.setImagedata(imagedata);
        novo.setUsersUsername(user);
        super.create(novo);
        System.out.println(novo.toString());

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
