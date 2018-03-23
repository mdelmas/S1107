package s1107.iteration1;

import s1107.iteration1.EntreesSorties;
import s1107.iteration1.Bibliotheque;


public class MenuBiblio 
{
    private Bibliotheque _bibliotheque;
	
    public MenuBiblio (Bibliotheque bibliotheque) 
    {
        _bibliotheque = bibliotheque; 
    }
	
	/*
	 * menuPrincipal permet à l'utilisateur de selectionner un type de sous menu (Lecteur, Ouvrage ou Exemplaire) 
	 * où il effectuera par la suite l'action désirée. Si l'utilisateur a fini d'utiliuser le programme, il choisit l'option Quitter.
	*/
    public void menuPrincipal() {
	Integer menu;
	do {
            EntreesSorties.afficherMessageCouleur("\n ========================================================", Color.GRAY);
            EntreesSorties.afficherMessageCouleur("|                   Menu Principal                       |", Color.GRAY);
            EntreesSorties.afficherMessageCouleur("| Saisissez un numero correspondant :                    |", Color.GRAY);
            EntreesSorties.afficherMessageCouleur("| Menu Lecteur : 1                                       |", Color.GRAY);
            EntreesSorties.afficherMessageCouleur("| Menu Ouvrage : 2                                       |", Color.GRAY);
            EntreesSorties.afficherMessageCouleur("| Menu Exemplaire : 3                                    |", Color.GRAY);
            EntreesSorties.afficherMessageCouleur("| Menu Emprunt : 4                                       |", Color.GRAY);
            EntreesSorties.afficherMessageCouleur("| Quitter : 0                                            |", Color.GRAY);
            EntreesSorties.afficherMessageCouleur(" ========================================================", Color.GRAY);
            menu = EntreesSorties.lireEntier();
			
            switch (menu) {
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
		EntreesSorties.afficherMessageCouleur("\n ========================================================", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Saisissez un numero correspondant :                    |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Nouveau Lecteur : 1                                    |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Consulter Lecteur : 2                                  |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Retour Menu Principal : 0                              |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur(" ========================================================", Color.GRAY);
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
		EntreesSorties.afficherMessageCouleur("\n ========================================================", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Saisissez un numero correspondant :                    |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Nouvel Ouvrage : 1                                     |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Consulter Ouvrage : 2                                  |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Retour Menu Principal : 0                              |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur(" ========================================================", Color.GRAY);
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
		EntreesSorties.afficherMessageCouleur("\n ========================================================", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Saisissez un numero correspondant :                    |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Nouveaux Exemplaires : 1                               |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Consulter Exemplaires : 2                              |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Retour Menu Principal : 0                              |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur(" ========================================================", Color.GRAY);
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
		EntreesSorties.afficherMessageCouleur("\n ========================================================", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Saisissez un numero correspondant :                    |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Emprunter exemplaire : 1                               |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur("| Consulter emprunts lecteur : 2                         |", Color.GRAY);
                EntreesSorties.afficherMessageCouleur("| Rendre exemplaire : 3                                  |", Color.GRAY);
                EntreesSorties.afficherMessageCouleur("| Liste Relances : 4                                     |", Color.GRAY);
                EntreesSorties.afficherMessageCouleur("| Retour Menu Principal : 0                              |", Color.GRAY);
		EntreesSorties.afficherMessageCouleur(" ========================================================", Color.GRAY);
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
                                case 4 : {
                                        _bibliotheque.relancerLecteur();
                                        break;
                                }
				default : {
					break;
				}
			}
	} while (menuLect != 0);	
}
	
}

