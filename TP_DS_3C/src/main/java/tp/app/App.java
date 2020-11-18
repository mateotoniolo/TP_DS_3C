package tp.app;

import java.awt.EventQueue;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tp.DAO.DataBase;
import tp.GUI.MainApplication;
import tp.clases.Deporte;

public class App {
	public static EntityManager entity;
public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entity = JPAUtil.getEntityManagerFactory().createEntityManager();
					MainApplication mainApplication = new MainApplication();
					mainApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
}
}
