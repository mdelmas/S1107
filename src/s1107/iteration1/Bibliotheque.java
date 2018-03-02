package s1107.iteration1;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import s1107.iteration1.Ouvrage;
import s1107.iteration1.Lecteur;
import s1107.iteration1.EntreesSorties;


// Classe de gestion de la Bibliotheque

public class Bibliotheque implements Serializable 
{
	
	private static final long serialVersionUID = 262L;

	// -----------------------------------------------
		//Attributs
	// -----------------------------------------------
	
		private HashMap<Integer, Lecteur> _dicoLecteur;
                private HashMap<Long, Ouvrage> _dicoOuvrage;
                private int derNumLecteur;
		
		/*
		 * Le dictionnaire de lecteur permet à bibliotheque de 
		 * garantir l'unicité de ces derniers, et facilitent les recherches et créations.
		 */
	
	// -----------------------------------------------
		//Constructeur
	// -----------------------------------------------
	

		public Bibliotheque() {
			this.setLecteurs(new HashMap<Integer, Lecteur>());
                        this.setOuvrages(new HashMap<Long, Ouvrage>());
                        derNumLecteur=0;
		
		}
	
// -----------------------------------------------
	// Public
// -----------------------------------------------	
		
		// -----------------------------------------------
			// Methodes
		// -----------------------------------------------
	
		/*
		 * La méthode nouveauLecteur permet de créé un lecteur en demandant la saisie de son numéro
		 * nom, prénom, date de naissance, adresse et numéro de téléphone.
		 * L'age doit être compris entre 3 et 110 ans
		 * Le lecteur est identifié par son numéro, si celui ci existe déjà dans le dictionnaire
		 * de bibliothèque, un message d'erreur est affiché.
		 * Une fois le nouveau lecteur créé, il est ajouté au dictionnaire de lecteur
		 * afin de garantir la cohérence des données.
		 */
	public void nouveauLecteur()
	{

            String nom = EntreesSorties.lireChaine("Entrez le nom : ");
            String prenom = EntreesSorties.lireChaine("Entrez le prenom : ");
            Integer age;
            GregorianCalendar dateNaiss, dateNaissComp;
            GregorianCalendar dateActuelle = new GregorianCalendar();
            do {
                    dateNaiss = EntreesSorties.lireDate("Entrez la date de naissance du lecteur (JJ/MM/AAAA): ");
                    dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), dateNaiss.get(GregorianCalendar.MONTH), dateNaiss.get(GregorianCalendar.DATE));
                    if(dateNaissComp.before(dateActuelle)){
                            age=dateActuelle.get(GregorianCalendar.YEAR)-dateNaiss.get(GregorianCalendar.YEAR);
                    }
                    else{
                            age=dateActuelle.get(GregorianCalendar.YEAR)-dateNaiss.get(GregorianCalendar.YEAR)-1;
                    }
                    if ((age<=3) | (age>=110)){
                            EntreesSorties.afficherMessage("Age incorrect ("+age+"), veuillez recommencer.");
                    }
                    else {
                            EntreesSorties.afficherMessage("Age du lecteur : " + age + " ans");
                    }
            } while ((age<=3) | (age>=110));
            String adresse = EntreesSorties.lireChaine("Entrez l'adresse :");
            String tel = EntreesSorties.lireChaine("Entrez le numero de telephone : ");
            EntreesSorties.afficherMessage("Fin de saisie");

            Lecteur L = new Lecteur(nom, this.getDerNumLecteur()+1, prenom, dateNaiss, adresse, tel);
            
            boolean exist = false;
            for (Iterator<Lecteur> itr = lesLecteurs(); itr.hasNext();){
                if(L.equals(itr.next())){
                    System.out.println("Ce lecteur existe déjà");
                    exist = true;
                    break;
                }
            }
            if(exist == false){
                incDerNumLecteur();
                lierLecteur(L,derNumLecteur);
                L.afficherLecteur();
            }
	}
        
        /*
        La méthode nouvelOuvrage permet de créer un ouvrage, vérifie si l'ouvrage n'existe pas déjà (par l'isbn)
        sinon on crée l'ouvrage, on l'ajoute au dictionnaire de la classe Bibliothèque et on affiche les informations
        de l'objet créé.
        */
        
        public void nouvelOuvrage() {
            long numOuvrage = EntreesSorties.lireLong("Entrez le numero d'ISBN : ");
            Ouvrage o = getOuvrage(numOuvrage);  
            

            if (o == null) {
                    String titre = EntreesSorties.lireChaine("Entrez le titre : ");
                    String nomEditeur = EntreesSorties.lireChaine("Entrez le nom de l'éditeur : ");
                    GregorianCalendar dateParution = EntreesSorties.lireDate("Entrez la date de parution (JJ/MM/AAAA) : ");
                    String nomAuteur = EntreesSorties.lireChaine("Entrez le nom de l'auteur : ");
                    Scanner pub  = new Scanner(System.in);
                    System.out.println("Entrez le public visé : enfant, ado ou adulte");
                    String pubv = null;
                    Public publicVise = null;
                    
                    while(publicVise == null){
                        try { 
                            pubv = pub.nextLine();
                            switch (Public.valueOf(pubv.trim())){
                                case enfant :
                                    publicVise = Public.enfant;
                                    break;
                                case ado :
                                    publicVise = Public.ado;
                                    break;
                                case adulte :
                                    publicVise = Public.adulte;
                                    break;
                            }
                        }
                        catch (java.lang.IllegalArgumentException j){
                            System.out.println("Erreur dans la saisie, rappel : enfant, ado ou adulte :");
                        }
                    }
                    
                    GregorianCalendar dateActuelle = new GregorianCalendar();  

                    o = new Ouvrage(numOuvrage, titre, nomEditeur, dateParution, nomAuteur, publicVise);
                    lierOuvrage(o,numOuvrage);
                    o.afficheOuvrage();
            }
            else {
                EntreesSorties.afficherMessage("Cet ouvrage existe déjà.");
            }
        }
        
	/*
	 * La méthode consulterOuvrage permet d'afficher l'ensemble des informations relatives à
	 * un ouvrage, par la saisie de son identifiant (isbn).
	 * Si l'isbn n'est pas dans la base de données de bibliotheque un message d'erreur est
	 * renvoyé a l'utilisateur.
	 */
	public void consulterOuvrage()
	{
		long numOuvrage = EntreesSorties.lireLong("Entrez l'isbn de l'ouvrage : ");
		
		Ouvrage o = getOuvrage(numOuvrage);
		
		if (o!=null){
			o.afficheOuvrage();
		}
		else {
			EntreesSorties.afficherMessage("Aucun ouvrage n'est associe a ce numero.");
		}
	}
	
        
        
        
        
	/*
	 * La méthode consulterLecteur permet d'afficher l'ensemble des informations relatives à
	 * un lecteur, par la saisie de son identifiant (numéro de lecteur).
	 * Si le numéro de lecteur n'est pas dans la base de données de bibliotheque un message d'erreur est
	 * renvoyé a l'utilisateur.
	 */
	public void consulterLecteur()
	{
		Integer numLecteur = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");
		
		Lecteur L = getLecteur(numLecteur);
		
		if (L!=null){
			L.afficherLecteur();
		}
		else {
			EntreesSorties.afficherMessage("Aucun lecteur n'est associe a ce numero.");
		}
                
	}
        
        /*
        La méthode NouvelExemplaire() crée des exemplaires d'un ouvrage, on rentre l'ouvrage concerné ainsi
        que le nombre d'exemplaires à créer. Le numéro des exemplaires est incrémenté à partir du dernier 
        numéro d'exemplaire connu pour l'ouvrage déterminé.
        */
	
        public void nouvelExemplaire()
        {
            long numOuvrage = EntreesSorties.lireLong("Entrez le numero d'ISBN : ");
            Ouvrage o = getOuvrage(numOuvrage);  
            
            if (o != null) {
                GregorianCalendar dateRecepEx = EntreesSorties.lireDate("Entrez la date de réception des exemplaires (JJ/MM/AAAA) : ");
                Integer nbExEmpruntables = EntreesSorties.lireEntier("Entrez le nombre d'exemplaires empruntables : ");
                Integer nbExNonEmpruntables = EntreesSorties.lireEntier("Entrez le nombre d'exemplaires non-empruntables : ");  

                o.ajouterExemplairesEmpruntables(dateRecepEx, nbExEmpruntables);
                o.ajouterExemplairesNonEmpruntables(dateRecepEx, nbExNonEmpruntables);
            }
            else {
                EntreesSorties.afficherMessage("Cet ouvrage n'existe pas.");
            }            
        }
        
        public void consulterExemplairesOuvrage(){
		Long isbn = EntreesSorties.lireLong("Entrez le numéro ISBN de l'ouvrage : ");
		
		Ouvrage o = getOuvrage(isbn);
		
		if (o!=null){
			o.afficheExemplaires();
		}
		else {
			EntreesSorties.afficherMessage("Aucun lecteur n'est associe a ce numero.");
		}            
        }
// -----------------------------------------------
	// Private
// -----------------------------------------------
	
	// -----------------------------------------------
		// Setters
	// -----------------------------------------------
	
	private void setLecteurs(HashMap<Integer, Lecteur> dicoLecteur) {
		_dicoLecteur = dicoLecteur;
	}
        
	private void setOuvrages(HashMap<Long, Ouvrage> dicoOuvrage) {
		_dicoOuvrage = dicoOuvrage;
	}        

	
	
	// -----------------------------------------------
		// Mï¿½thodes
	// -----------------------------------------------
	
	/*
	 * La méthode unLecteur permet de rechercher dans la base de donnée de bibliotheque un objet 
	 * lecteur identifié par son numéro, et de renvoyer l'objet. (ou la donnée null s'il n'est pas trouvé)
	 */
	private Lecteur getLecteur(Integer numLecteur)
	{
		return _dicoLecteur.get(numLecteur);
	}
        
        	/*
	 * La méthode getOuvrage permet de rechercher dans la base de donnée de bibliotheque un objet 
	 * ouvrage identifié par son isbn, et de renvoyer l'objet. (ou la donnée null s'il n'est pas trouvé)
	 */
	private Ouvrage getOuvrage(Long isbn)
	{
		return _dicoOuvrage.get(isbn);
	}
	
	/*
	 * La méthode lierLecteur permet d'ajouter un lecteur a la base de donnée de bibliotheque.
	 */
	private void lierLecteur(Lecteur L, Integer numLecteur)
	{
		_dicoLecteur.put(numLecteur, L);
	}
        
        private void lierOuvrage(Ouvrage o, Long isbn){
            _dicoOuvrage.put(isbn, o);
        }
	
	
	/*
	 * La méthode lesLecteurs permet de créer un iterator sur les lecteurs, dans le but de les parcourir
	 * pour eventuellement les relancer.
	 */
	private Iterator<Lecteur> lesLecteurs() {
            return _dicoLecteur.values().iterator();
	}
        
        private Iterator<Ouvrage> lesOuvrages() {
            return _dicoOuvrage.values().iterator();
        }
        
        public void setDerNumLecteur(int v){
            derNumLecteur = v;
        }
        
        public int getDerNumLecteur(){
            return derNumLecteur;
        }
        
        public void incDerNumLecteur(){
            derNumLecteur++;
        }
}