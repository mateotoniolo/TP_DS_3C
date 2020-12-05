package tp.app;

import java.awt.EventQueue;
import java.awt.Image;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;

import org.hibernate.mapping.Collection;

import tp.DAO.DataBase;
import tp.GUI.MainApplication;
import tp.clases.Competencia;
import tp.clases.Deporte;
import tp.clases.ItemLugar;
import tp.clases.Lugar;

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
static public ImageIcon emoji(String fileName, int width, int height) {
	Image imagen = new ImageIcon(fileName).getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
	return new ImageIcon(imagen);
}
}
