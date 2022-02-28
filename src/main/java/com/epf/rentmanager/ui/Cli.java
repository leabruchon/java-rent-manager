package com.epf.rentmanager.ui;

import java.util.Scanner;

public class Cli {
	
		private int choixMenu;
		private static Cli instance;
		public static Cli getInstance() {
			if (instance == null) {
				instance = new Cli();
			}
			
			return instance;
		}
		
		public int getChoixMenu() {
			return choixMenu;
		}
	
		public void createMenu() {
			
			System.out.println("1. Créer un client");
			System.out.println("2. Lister les clients");
			System.out.println("3. Créer un véhicule");
			System.out.println("4. Lister les véhicules");
			System.out.println("5. Supprimer un client");
			System.out.println("6. Supprimer un véhicule");
			System.out.println("----------------------------");
			
			
		}
		
		public int chooseMenuOption() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez saisir un choix :");
			int choix = sc.nextInt();
			
			return choix;
		}

		
}
