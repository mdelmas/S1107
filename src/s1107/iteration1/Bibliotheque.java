package s1107.iteration1;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
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
	// Attributs
	// -----------------------------------------------

		private HashMap<Integer, Lecteur> _dicoLecteur;
        private HashMap<Long, Ouvrage> _dicoOuvrage;
        private HashSet<Emprunt> _emprunts;
        private int derNumLecteur;

		/*
		 * Le dictionnaire de lecteur permet à bibliotheque de
		 * garantir l'unicité de ces derniers, et facilitent les recherches et créations.
		 */

    // -----------------------------------------------
	// Constructeur
	// -----------------------------------------------

		public Bibliotheque() {
		 	this.setLecteurs(new HashMap<Integer, Lecteur>());
		    this.setOuvrages(new HashMap<Long, Ouvrage>());
		    this.setEmprunts(new HashSet<Emprunt>());
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
	        	dateNaiss = EntreesSorties.lireDate("Entrez la date de naissance du lecteur (JJ/MM/AAAA) : ");
	            dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), dateNaiss.get(GregorianCalendar.MONTH), dateNaiss.get(GregorianCalendar.DATE));
	            if (dateNaissComp.before(dateActuelle)){
	            	age=dateActuelle.get(GregorianCalendar.YEAR)-dateNaiss.get(GregorianCalendar.YEAR);
	            } else {
	                age=dateActuelle.get(GregorianCalendar.YEAR)-dateNaiss.get(GregorianCalendar.YEAR)-1;
	            }
	            if ((age<=3) || (age>=110)){
	            	EntreesSorties.afficherMessage("Age incorrect ("+age+"), veuillez recommencer.");
	            } else {
	                EntreesSorties.afficherMessage("Age du lecteur : " + age + " ans");
	            }
	        } while ((age<=3) || (age>=110));

			String adresse = EntreesSorties.lireChaine("Entrez l'adresse : ");

	        String tel;
	        String regexStr = "^[0-9]{10}$";
	        do {
	            tel = EntreesSorties.lireChaine("Entrez le numero de telephone : ");
	            if (!tel.matches(regexStr))
	                System.out.println("Numéro incorrect, veuillez recommencer.");
	        } while (!tel.matches(regexStr));

	        EntreesSorties.afficherMessage("Fin de saisie.");

	        Lecteur L = new Lecteur(nom, this.getDerNumLecteur()+1, prenom, dateNaiss, adresse, tel);

	        boolean exist = false;
	        for (Iterator<Lecteur> itr = lesLecteurs(); itr.hasNext();){
		        if (L.equals(itr.next())){
	            	System.out.println("Ce lecteur existe déjà.");
	                exist = true;
	                break;
	            }
	        }

			if (exist == false){
	        	incDerNumLecteur();
	            lierLecteur(L, derNumLecteur);
	            System.out.println("Le lecteur n°" + derNumLecteur + " a bien été créé.");
	            L.afficherLecteur();
	        }
		}


		/*
         * La méthode nouvelOuvrage permet de créer un ouvrage, vérifie si l'ouvrage n'existe pas déjà (par l'isbn)
         * sinon on crée l'ouvrage, on l'ajoute au dictionnaire de la classe Bibliothèque et on affiche les informations
         * de l'objet créé.
         */
        public void nouvelOuvrage()
		{
            long numOuvrage;
            do {
                numOuvrage = EntreesSorties.lireLong("Entrez le numero d'ISBN : ");
                if (String.valueOf(numOuvrage).length() != 13)
                    System.out.println("ISBN incorrect (différent de 13 chiffres), veuillez entrer un code à 13 chiffres.");
            } while (String.valueOf(numOuvrage).length() != 13);

            Ouvrage o = getOuvrage(numOuvrage);

            if (o == null) {
                String titre = EntreesSorties.lireChaine("Entrez le titre : ");
                String nomEditeur = EntreesSorties.lireChaine("Entrez le nom de l'éditeur : ");
                GregorianCalendar dateParution;
                GregorianCalendar dateActuelle = new GregorianCalendar();
                do {
                    dateParution = EntreesSorties.lireDate("Entrez la date de parution (JJ/MM/AAAA) : ");
                    if (dateParution.after(dateActuelle))
                        System.out.println("La date de parution saisie est postérieure à la date du jour.");
                } while (dateParution.after(dateActuelle));
                String nomAuteur = EntreesSorties.lireChaine("Entrez le nom de l'auteur : ");

                Integer input;
                do {
                    System.out.print("Entrez le code du public visé (enfant : 1, ado : 2 ou adulte : 3 : ");
                    input = EntreesSorties.lireEntier();
                } while (input < 1 || input > 3);
                Public publicVise = Public.values()[input-1];

                EntreesSorties.afficherMessage("Fin de saisie");

                o = new Ouvrage(numOuvrage, titre, nomEditeur, dateParution, nomAuteur, publicVise);
                lierOuvrage(o,numOuvrage);
                o.afficheOuvrageLight();
            } else {
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
			 if (o != null){
				 o.afficheOuvrage();
			 } else {
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
			if (L != null) {
				L.afficherLecteur();
			} else {
				EntreesSorties.afficherMessage("Aucun lecteur n'est associe a ce numero.");
			}

		}

        /*
         * La méthode NouvelExemplaire() crée des exemplaires d'un ouvrage, on rentre l'ouvrage concerné ainsi
         * que le nombre d'exemplaires à créer. Le numéro des exemplaires est incrémenté à partir du dernier
         * numéro d'exemplaire connu pour l'ouvrage déterminé.
        */
        public void nouvelExemplaire()
        {
            long numOuvrage = EntreesSorties.lireLong("Entrez le numero d'ISBN : ");
            Ouvrage o = getOuvrage(numOuvrage);

            if (o != null) {
                GregorianCalendar dateActuelle = new GregorianCalendar();
                GregorianCalendar dateRecepEx;

                do {
                    dateRecepEx = EntreesSorties.lireDate("Entrez la date de réception des exemplaires (JJ/MM/AAAA) : ");
                    if (dateRecepEx.after(dateActuelle))
                        EntreesSorties.afficherMessage("La date de réception saisie est postérieure à la date du jour");
                    if (dateRecepEx.before(o.getDateParution()))
                        EntreesSorties.afficherMessage("La date de réception saisie est antérieure à la date de parution de l'ouvrage");
                } while (dateRecepEx.after(dateActuelle)||dateRecepEx.before(o.getDateParution()));

                Integer nbExEmpruntables = EntreesSorties.lireEntier("Entrez le nombre d'exemplaires empruntables : ");
                Integer nbExNonEmpruntables = EntreesSorties.lireEntier("Entrez le nombre d'exemplaires non-empruntables : ");

                o.ajouterExemplairesEmpruntables(dateRecepEx, nbExEmpruntables);
                o.ajouterExemplairesNonEmpruntables(dateRecepEx, nbExNonEmpruntables);
            } else {
                EntreesSorties.afficherMessage("Cet ouvrage n'existe pas.");
            }
        }


        /*
         * Affiche pour un ouvrage donné les exemplaires qui lui ont été attribués
         */
        public void consulterExemplairesOuvrage()
		{
			Long numOuvrage = EntreesSorties.lireLong("Entrez le numéro ISBN de l'ouvrage : ");

			Ouvrage o = getOuvrage(numOuvrage);
			if (o != null){
				o.afficheExemplaires();
			} else {
				EntreesSorties.afficherMessage("Aucun lecteur n'est associe a ce numero.");
			}
        }


        public boolean verifPublic(Lecteur lecteur, Ouvrage ouvrage)
		{
            if (lecteur.calculAge() > ouvrage.getPublicVise().getAgeMinimum())
                return true;
            return false;
        }


        public void emprunterExemplaire()
		{
            Integer numLecteur = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");
            Lecteur L = getLecteur(numLecteur);

            if (L == null) {
				EntreesSorties.afficherMessage("Aucun lecteur n'est associe a ce numero.");
                return ;
            } else if (L.lecteurSature() != false) {
                EntreesSorties.afficherMessage("Le lecteur ne peut plus emprunter de livre (lecteur saturé).");
                return ;
            }

            Long numOuvrage = EntreesSorties.lireLong("Entrez le numéro ISBN de l'ouvrage : ");
            Ouvrage o = getOuvrage(numOuvrage);
            if (o == null) {
				EntreesSorties.afficherMessage("Aucun ouvrage n'est associe a ce numero.");
                return ;
            } else if (verifPublic(L, o) == false) {
                EntreesSorties.afficherMessage("Public pas ok pour le lecteur.");
                return ;
            }

            Integer numEx = EntreesSorties.lireEntier("Entrez le numéro de l'exemplaire : ");
            Exemplaire ex = o.getExemplaire(numEx);
            if (ex == null) {
                EntreesSorties.afficherMessage("Exemplaire n'existe pas.");
                return ;
            }

            if (ex.exemplaireDisponible() == true) {
                GregorianCalendar dateEmprunt = new GregorianCalendar();
                Emprunt em = new Emprunt(L, ex, dateEmprunt);
                setEmprunt(em);
                EntreesSorties.afficherMessage("Emprunt créé:");
            } else {
                EntreesSorties.afficherMessage("Exemplaire non disponible à l'emprunt.");
            }

        }

        public void consulterEmpruntsLecteur()
		{
            Integer numLecteur = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");
            Lecteur L = getLecteur(numLecteur);

            if (L != null) {
                L.afficherEmpruntsLecteur();
            } else {
				EntreesSorties.afficherMessage("Aucun lecteur n'est associe à ce numero.");
            }
        }

        /*
         * Parcours la liste des emprunts en cours et affiche ceux datant d'il y a plus de 15 jours
         */
        public void relancerLecteur()
		{
            GregorianCalendar dateJour = new GregorianCalendar();
            Emprunt em;
            for (Iterator<Emprunt> it = _emprunts.iterator(); it.hasNext(); ) {
                em = it.next();
                em.relanceEmprunt(dateJour);
            }
        }

        public void rendreExemplaire()
		{
            long numOuvrage = EntreesSorties.lireLong("Entrez le numero d'ISBN : ");
            Ouvrage o = getOuvrage(numOuvrage);
            if (o == null){
                EntreesSorties.afficherMessage("Aucun ouvrage n'est associé à ce numéro d'ISBN");
                return;
            }

            int numEx = EntreesSorties.lireEntier("Entrez le numero d'exemplaire de l'ouvrage : ");
            Exemplaire ex = o.getExemplaire(numEx);
            Emprunt em = ex.getEmprunt();

            if (ex != null) {
                ex.supprimerEmprunt();
                unSetEmprunt(em);
                System.out.print("Exemplaire suivant est disponible : ");
                ex.afficherExemplaireLight();
            } else {
                EntreesSorties.afficherMessage("Cet exemplaire n'existe pas");
            }

        }

		public void affecterEmprunt(Emprunt em) {
			setEmprunt(em);
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

    	private void setEmprunts(HashSet<Emprunt> emprunts){
            _emprunts = emprunts;
        }

        public void unSetEmprunt(Emprunt em) {
            _emprunts.remove(em);
        }



	// -----------------------------------------------
	// Methodes
	// -----------------------------------------------

		/*
		 * La méthode getLecteur permet de rechercher dans la base de donnée de bibliotheque un objet
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

	    private void lierOuvrage(Ouvrage o, Long isbn)
		{
	        _dicoOuvrage.put(isbn, o);
	    }

	    private void setEmprunt(Emprunt em)
		{
	        _emprunts.add(em);
	    }


		/*
		 * La méthode lesLecteurs permet de créer un iterator sur les lecteurs, dans le but de les parcourir
		 * pour eventuellement les relancer.
		 */
		private Iterator<Lecteur> lesLecteurs()
		{
	        return _dicoLecteur.values().iterator();
		}

	    private Iterator<Ouvrage> lesOuvrages()
		{
	        return _dicoOuvrage.values().iterator();
	    }

	    public void setDerNumLecteur(int v)
		{
	        derNumLecteur = v;
	    }

	    public int getDerNumLecteur()
		{
	        return derNumLecteur;
	    }

	    public void incDerNumLecteur()
		{
	        derNumLecteur++;
	    }

}
