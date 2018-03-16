
import s1107.iteration1.EntreesSorties;
import s1107.iteration1.Bibliotheque;


public class MenuBiblio {
	private Bibliotheque _bibliotheque;
	
	public MenuBiblio (Bibliotheque bibliotheque) {
	_bibliotheque = bibliotheque; 
	}
	
	/*
	 * menuPrincipal permet à l'utilisateur de selectionner un type de sous menu (Lecteur, Ouvrage ou Exemplaire) 
	 * où il effectuera par la suite l'action désirée. Si l'utilisateur a fini d'utiliuser le programme, il choisit l'option Quitter.
	*/
public void menuPrincipal() {
	Integer menu;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("|                   Menu Principal                       |");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Menu Lecteur : 1                                       |");
		EntreesSorties.afficherMessage("| Menu Ouvrage : 2                                       |");
		EntreesSorties.afficherMessage("| Menu Exemplaire : 3                                    |");
		EntreesSorties.afficherMessage("| Menu Emprunt : 4                                       |");
		EntreesSorties.afficherMessage("| Quitter : 0                                            |");
		EntreesSorties.afficherMessage(" ========================================================");
		menu = EntreesSorties.lireEntier();
			
			switch (menu){
				case 1 : {
					this.menuLecteur();
					break;
				}
                                
                                case 2 : {
                                        this.menuOuvrage();
                                        break;
                                }

                                case 3 : {
                                        this.menuExemplaire();
                                        break;
                                }
                                case 4 : {
                                        this.menuEmprunt();
                                        break;
                                }
				default : {
					break;
				}
			}
	} while (menu != 0);	
}

	/* menuLect permet d'effectuer une série d'action concernant les utilisateur (lecteurs) de la bibliothèque.
	 * Une fois une action effectuée, l'utilisateur sera rediriger vers ce même menu afin de pouvoir selectionner
	 * une nouvelle fois une action concernant les lecteurs.
	 * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
	*/
public void menuLecteur() {
	Integer menuLect;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouveau Lecteur : 1                                    |");
		EntreesSorties.afficherMessage("| Consulter Lecteur : 2                                  |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuLect = EntreesSorties.lireEntier();
			
			switch (menuLect){
				case 1 : {
					_bibliotheque.nouveauLecteur();
					break;
				}
				case 2 : {
					_bibliotheque.consulterLecteur();
					break;
				}
				default : {
					break;
				}
			}
	} while (menuLect != 0);	
}

	/* menuOuvrage permet d'effectuer une série d'action concernant les ouvrages de la bibliothèque.
	 * Une fois une action effectuée, l'utilisateur sera rediriger vers ce même menu afin de pouvoir selectionner
	 * une nouvelle fois une action concernant les lecteurs.
	 * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
	*/
public void menuOuvrage() {
	Integer menuLect;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouvel Ouvrage : 1                                     |");
		EntreesSorties.afficherMessage("| Consulter Ouvrage : 2                                  |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuLect = EntreesSorties.lireEntier();
			
			switch (menuLect){
				case 1 : {
					_bibliotheque.nouvelOuvrage();
					break;
				}
				case 2 : {
					_bibliotheque.consulterOuvrage();
					break;
				}
				default : {
					break;
				}
			}
	} while (menuLect != 0);	
}

	/* menuOuvrage permet d'effectuer une série d'action concernant les ouvrages de la bibliothèque.
	 * Une fois une action effectuée, l'utilisateur sera rediriger vers ce même menu afin de pouvoir selectionner
	 * une nouvelle fois une action concernant les lecteurs.
	 * "Retour Menu Principal" renvoi l'utilisateur au menu principal.
	*/
public void menuExemplaire() {
	Integer menuLect;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Nouveaux Exemplaires : 1                               |");
		EntreesSorties.afficherMessage("| Consulter Exemplaires : 2                              |");
		EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuLect = EntreesSorties.lireEntier();
			
			switch (menuLect){
				case 1 : {
					_bibliotheque.nouvelExemplaire();
					break;
				}
				case 2 : {
					_bibliotheque.consulterExemplairesOuvrage();
					break;
				}
				default : {
					break;
				}
			}
	} while (menuLect != 0);	
}
	

public void menuEmprunt() {
	Integer menuLect;
	do {
		EntreesSorties.afficherMessage(" ========================================================");
		EntreesSorties.afficherMessage("| Saisissez un numero correspondant :                    |");
		EntreesSorties.afficherMessage("| Emprunter exemplaire : 1                               |");
		EntreesSorties.afficherMessage("| Consulter emprunts lecteur : 2                         |");
		EntreesSorties.afficherMessage("| Rendre exemplaire : 3                                  |");
                EntreesSorties.afficherMessage("| Retour Menu Principal : 0                              |");
		EntreesSorties.afficherMessage(" ========================================================");
		menuLect = EntreesSorties.lireEntier();
			
			switch (menuLect){
				case 1 : {
					_bibliotheque.emprunterExemplaire();
					break;
				}
				case 2 : {
					_bibliotheque.consulterEmpruntsLecteur();
                                        break;
                                }
                                case 3 : {
					_bibliotheque.rendreExemplaire();
					break;
				}
				default : {
					break;
				}
			}
	} while (menuLect != 0);	
}
	
}

