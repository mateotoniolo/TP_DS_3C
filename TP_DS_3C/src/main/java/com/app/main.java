package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.model.Deporte;

import tp.app.JPAUtil;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Deporte Deporte;

		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		while (opcion!=5) {
			System.out.println("1. Crear Deporte");
			System.out.println("2. Buscar Deporte");
			System.out.println("3. Actualizar Deporte");
			System.out.println("4. Eliminar Deporte");
			System.out.println("5. Salir");
			System.out.println("Elija una opción:");

			opcion = scanner.nextInt();
			switch (opcion) {
			case 1:
//				System.out.println("Digite el nombre del Deporte:");
//				Deporte = new Deporte();
//				Deporte.setId(null);
//				scanner.nextLine();
//				Deporte.setNombre(scanner.nextLine());
//
//				System.out.println("Digite el precio del Deporte:");
//				Deporte.setPrecio(scanner.nextDouble());
//				System.out.println(Deporte);
//				entity.getTransaction().begin();
//				entity.persist(Deporte);
//				entity.getTransaction().commit();
//				System.out.println("Deporte registrado..");
//				System.out.println();
				break;

			case 2:
				System.out.println("Digite el id del Deporte a buscar:");
				Deporte = new Deporte();
				Deporte = entity.find(Deporte.class, scanner.nextInt());
				if (Deporte != null) {
					System.out.println(Deporte);
					System.out.println();
				} else {
					System.out.println();
					System.out.println("Deporte no encontrado... Lista de Deportes completa");
					List<Deporte> listaDeportes= new ArrayList<>();
					Query query=entity.createQuery("SELECT p FROM Deporte p");
					listaDeportes=query.getResultList();
					for (Deporte p : listaDeportes) {
						System.out.println(p);
					}
					
					System.out.println();
				}

				break;
			case 3:
				System.out.println("Digite el id del Deporte a actualizar:");
				Deporte = new Deporte();

				Deporte = entity.find(Deporte.class, scanner.nextLong());
				if (Deporte != null) {
					System.out.println(Deporte);
					System.out.println("Digite el nombre del Deporte:");
					scanner.nextLine();
//					Deporte.setNombre(scanner.nextLine());
//					System.out.println("Digite el precio del Deporte:");
//					Deporte.setPrecio(scanner.nextDouble());
					entity.getTransaction().begin();
					entity.merge(Deporte);
					entity.getTransaction().commit();
					System.out.println("Deporte actualizado..");
					System.out.println();
				} else {
					System.out.println("Deporte no encontrado....");
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Digite el id del Deporte a eliminar:");
				Deporte = new Deporte();

				Deporte = entity.find(Deporte.class, scanner.nextLong());
				if (Deporte != null) {
					System.out.println(Deporte);
					entity.getTransaction().begin();
					entity.remove(Deporte);
					entity.getTransaction().commit();
					System.out.println("Deporte eliminado...");
				} else {
					System.out.println("Deporte no encontrado...");
				}
				break;
			case 5:entity.close();JPAUtil.shutdown();
			break;

			default:
				System.out.println("Opción no válida\n");
				break;
			}
		}
	}

}
