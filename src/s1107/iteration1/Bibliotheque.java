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
    //

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

	public Bibliotheque()
        {
            this.setLecteurs(new HashMap<Integer, Lecteur>());
            this.setOuvrages(new HashMap<Long, Ouvrage>());
            this.setEmprunts(new HashSet<Emprunt>());
            derNumLecteur=0;
	}


    // -----------------------------------------------
    // Public
    // -----------------------------------------------

	// -----------------------------------------------
	// Méthodes
	// -----------------------------------------------


        // Méthodes gestion de la Bibliothéque

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
            String nom;
            do {
                nom = EntreesSorties.lireChaine("Entrez le nom : ");
                if (nom.isEmpty())
                    EntreesSorties.afficherMessageCouleur("Entrez un nom valide.", Color.RED);
            } while (nom.isEmpty());

            String prenom;
            do {
                prenom = EntreesSorties.lireChaine("Entrez le prenom : ");
                if (prenom.isEmpty())
                    EntreesSorties.afficherMessageCouleur("Entrez un prénom valide.", Color.RED);
            } while (prenom.isEmpty());

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
	        	EntreesSorties.afficherMessageCouleur("Age incorrect (" + age + "), veuillez recommencer.", Color.RED);
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
	            EntreesSorties.afficherMessageCouleur("Numéro incorrect, veuillez recommencer.", Color.RED);
	    } while (!tel.matches(regexStr));

	    EntreesSorties.afficherMessage("Fin de saisie.\n");

	    Lecteur L = new Lecteur(nom, this.getDerNumLecteur()+1, prenom, dateNaiss, adresse, tel);

	    boolean exist = false;
	    for (Iterator<Lecteur> itr = lesLecteurs(); itr.hasNext();){
                if (L.equals(itr.next())) {
                    EntreesSorties.afficherMessageCouleur("Ce lecteur existe déjà.", Color.RED);
                    exist = true;
                    break;
	        }
	    }

            if (exist == false) {
                incDerNumLecteur();
	        setLecteur(L, derNumLecteur);
	        EntreesSorties.afficherMessageCouleur("Le lecteur n°" + derNumLecteur + " a bien été créé.\n", Color.BLUE);
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
                    EntreesSorties.afficherMessageCouleur("ISBN incorrect (différent de 13 chiffres), veuillez entrer un code à 13 chiffres.", Color.RED);
            } while (String.valueOf(numOuvrage).length() != 13);

            Ouvrage o = getOuvrage(numOuvrage);

            if (o == null) {
                String titre = EntreesSorties.lireChaine("Entrez le titre : ");
                String nomAuteur = EntreesSorties.lireChaine("Entrez le nom de l'auteur : ");
                String nomEditeur = EntreesSorties.lireChaine("Entrez le nom de l'éditeur : ");
                GregorianCalendar dateParution;
                GregorianCalendar dateActuelle = new GregorianCalendar();
                do {
                    dateParution = EntreesSorties.lireDate("Entrez la date de parution (JJ/MM/AAAA) : ");
                    if (dateParution.after(dateActuelle))
                        EntreesSorties.afficherMessageCouleur("La date de parution saisie est postérieure à la date du jour.", Color.RED);
                } while (dateParution.after(dateActuelle));

                Integer input;
                do {
                    System.out.print("Entrez le code du public visé (enfant : 1, ado : 2 ou adulte : 3) : ");
                    input = EntreesSorties.lireEntier();
                } while (input < 1 || input > 3);
                Public publicVise = Public.values()[input-1];

                EntreesSorties.afficherMessage("Fin de saisie.\n");

                o = new Ouvrage(numOuvrage, titre, nomEditeur, dateParution, nomAuteur, publicVise);
                setOuvrage(o,numOuvrage);
                EntreesSorties.afficherMessageCouleur("L'ouvrage n°" + numOuvrage + " a bien été créé.\n", Color.BLUE);
                o.afficheOuvrageLight();
            } else {
                EntreesSorties.afficherMessageCouleur("Cet ouvrage existe déjà.", Color.RED);
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
                        EntreesSorties.afficherMessageCouleur("La date de réception saisie est postérieure à la date du jour", Color.RED);
                    if (dateRecepEx.before(o.getDateParution()))
                        EntreesSorties.afficherMessageCouleur("La date de réception saisie est antérieure à la date de parution de l'ouvrage", Color.RED);
                } while (dateRecepEx.after(dateActuelle) || dateRecepEx.before(o.getDateParution()));

                Integer nbExEmpruntables = EntreesSorties.lireEntier("Entrez le nombre d'exemplaires empruntables : ");
                Integer nbExNonEmpruntables = EntreesSorties.lireEntier("Entrez le nombre d'exemplaires non-empruntables : ");

                EntreesSorties.afficherMessage("Fin de saisie.\n");

                Integer nb = nbExEmpruntables + nbExNonEmpruntables;
                EntreesSorties.afficherMessageCouleur("Création de " + nb + " exemplaires pour l'ouvrage n°" + numOuvrage + " : ", Color.BLUE);
                o.ajouterExemplairesEmpruntables(dateRecepEx, nbExEmpruntables);
                o.ajouterExemplairesNonEmpruntables(dateRecepEx, nbExNonEmpruntables);
            } else {
                EntreesSorties.afficherMessageCouleur("Cet ouvrage n'existe pas.", Color.RED);
            }
        }


	/*
         * La méthode emprunterExemplaire permet de créer un emprunt, liant un exemplaire à un lecteur.
         * Elle vérifie si le lecteur et l'exemplaire existe, si le lecteur n'est pas saturé (déjà 5 emprunts) et si le public de l'ouvrage correspond au lecteur.
         * Si conditions ok, créée l'emprunt, l'ajoute au dictionnaire de la classe Bibliothèque et affiche les informations.
         */
        public void emprunterExemplaire()
	{
            Integer numLecteur = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");
            Lecteur L = getLecteur(numLecteur);

            if (L == null) {
		EntreesSorties.afficherMessageCouleur("Aucun lecteur n'est associe a ce numero.", Color.RED);
                return ;
            } else if (L.lecteurSature() != false) {
                EntreesSorties.afficherMessageCouleur("Le lecteur ne peut plus emprunter de livre (lecteur saturé).", Color.RED);
                return ;
            }

            Long numOuvrage = EntreesSorties.lireLong("Entrez le numéro ISBN de l'ouvrage : ");
            Ouvrage o = getOuvrage(numOuvrage);
            if (o == null) {
		EntreesSorties.afficherMessageCouleur("Aucun ouvrage n'est associe a ce numero.", Color.RED);
                return ;
            } else if (verifPublic(L, o) == false) {
                EntreesSorties.afficherMessageCouleur("Public ne correspond pas à l'âge du lecteur.", Color.RED);
                return ;
            }

            Integer numEx = EntreesSorties.lireEntier("Entrez le numéro de l'exemplaire : ");
            Exemplaire ex = o.getExemplaire(numEx);
            if (ex == null) {
                EntreesSorties.afficherMessageCouleur("Exemplaire n'existe pas.", Color.RED);
                return ;
            }

            EntreesSorties.afficherMessage("Fin de saisie.\n");

            if (ex.exemplaireDisponible() == true) {
                GregorianCalendar dateEmprunt = new GregorianCalendar();
                Emprunt em = new Emprunt(L, ex, dateEmprunt);
                setEmprunt(em);
                EntreesSorties.afficherMessageCouleur("Emprunt créé.", Color.BLUE);
                em.afficherCreationEmprunt();
            } else {
                EntreesSorties.afficherMessageCouleur("Exemplaire non disponible à l'emprunt.", Color.RED);
            }
        }

	/*
         * La méthode rendreExemplaire permet de supprimer un emprunt, à partir d'un isbn et d'un numero d'exemplaire.
         * Elle vérifie si l'ouvrage et l'exemplaire existe, puis toutes les références de l'emprunt
         * (dictionnaire de la classe Bibliothèque, lecteur et exemplaire).
         */
        public void rendreExemplaire()
	{
            long numOuvrage = EntreesSorties.lireLong("Entrez le numero d'ISBN : ");
            Ouvrage o = getOuvrage(numOuvrage);
            if (o == null){
                EntreesSorties.afficherMessageCouleur("Aucun ouvrage n'est associé à ce numéro d'ISBN", Color.RED);
                return;
            }

            int numEx = EntreesSorties.lireEntier("Entrez le numero d'exemplaire de l'ouvrage : ");
            Exemplaire ex = o.getExemplaire(numEx);
            Emprunt em = ex.getEmprunt();

            EntreesSorties.afficherMessage("Fin de saisie.\n");

            if (ex != null) {
                ex.supprimerEmprunt();
                unSetEmprunt(em);
                EntreesSorties.afficherMessageCouleur("L'exemplaire suivant est disponible : ", Color.BLUE);
                ex.afficherExemplaireLight();
            } else {
                EntreesSorties.afficherMessageCouleur("Cet exemplaire n'existe pas.", Color.RED);
            }

        }


        // Méthodes consultation

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
            if (o != null) {
                EntreesSorties.afficherMessage("");
		o.afficheOuvrage();
            } else {
                EntreesSorties.afficherMessageCouleur("Aucun ouvrage n'est associe a ce numero.", Color.RED);
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
                EntreesSorties.afficherMessage("");
		L.afficherLecteur();
            } else {
		EntreesSorties.afficherMessageCouleur("Aucun lecteur n'est associe a ce numero.", Color.RED);
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
                EntreesSorties.afficherMessage("");
		o.afficheExemplaires();
            } else {
		EntreesSorties.afficherMessageCouleur("Aucun lecteur n'est associe a ce numero.", Color.RED);
            }
        }

        /*
         * Affiche pour un lecteur donné, ses emprunts en cours
         */
        public void consulterEmpruntsLecteur()
	{
            Integer numLecteur = EntreesSorties.lireEntier("Entrez le numero du lecteur : ");
            Lecteur L = getLecteur(numLecteur);

            if (L != null) {
                EntreesSorties.afficherMessage("");
                L.afficherEmpruntsLecteur();
            } else {
		EntreesSorties.afficherMessageCouleur("Aucun lecteur n'est associe à ce numero.", Color.RED);
            }
        }


        //

        /*
         * Parcours la liste des emprunts en cours et affiche ceux datant d'il y a plus de 15 jours
         */
        public void relancerLecteur()
	{
            GregorianCalendar dateJour = new GregorianCalendar();
            Emprunt em;
            boolean relancesAFaire = false;
            EntreesSorties.afficherMessage("");
            EntreesSorties.afficherMessageCouleur("Relances à effectuer : \n", Color.BLUE);
            for (Iterator<Emprunt> it = _emprunts.iterator(); it.hasNext(); ) {
                em = it.next();
                if (em.relanceEmprunt(dateJour))
                    relancesAFaire = true;
            }
            if (!relancesAFaire)
                EntreesSorties.afficherMessage("Aucune relance à effectuer.");
        }

        public boolean verifPublic(Lecteur lecteur, Ouvrage ouvrage)
        {
            if (lecteur.calculAge() > ouvrage.getPublicVise().getAgeMinimum())
                return true;
            return false;
        }

	public void affecterEmprunt(Emprunt em)
        {
            setEmprunt(em);
	}


        // Méthode de création du jeu de test

        public void creationJeuDeTest()
        {
            Ouvrage o1 = new Ouvrage(1234567891234L, "Les fiancés de l'hiver", "Gallimard", new GregorianCalendar(), "Dabos", Public.ADO);
            Ouvrage o2 = new Ouvrage(4321987654321L, "Orgueil et préjugés", "Hachette", new GregorianCalendar(),"Jane Austen", Public.ADULTE);
            Ouvrage o3 = new Ouvrage(4561237896543L, "Le monde s'effondre", "Hachette", new GregorianCalendar(),"Hans Christian Andersen",Public.ADULTE);

            setOuvrage(o1,1234567891234L);
            setOuvrage(o2,4321987654321L);
            setOuvrage(o3,4561237896543L);

            o1.ajouterExemplairesEmpruntables(new GregorianCalendar(), 4);
            o1.ajouterExemplairesNonEmpruntables(new GregorianCalendar(), 3);

            o2.ajouterExemplairesEmpruntables(new GregorianCalendar(), 4);
            o2.ajouterExemplairesNonEmpruntables(new GregorianCalendar(), 5);

            o3.ajouterExemplairesEmpruntables(new GregorianCalendar(), 2);
            o3.ajouterExemplairesNonEmpruntables(new GregorianCalendar(), 1);

            Lecteur l1 = new Lecteur("DELMAS", 1, "Morgane", new GregorianCalendar(), "Grenoble", "0612345678");
            Lecteur l2 = new Lecteur("VALENTIN", 2, "Daniel", new GregorianCalendar(), "Paris", "8765432106");
            Lecteur l3 = new Lecteur("CISSOKHO", 2, "Aissata", new GregorianCalendar(), "Lyon", "4561237891");

            setLecteur(l1,1);
            setLecteur(l2,2);
            setLecteur(l3,3);

            Exemplaire ex1 = o1.getExemplaire(1);
            Exemplaire ex2 = o1.getExemplaire(2);
            Exemplaire ex3 = o2.getExemplaire(3);

            GregorianCalendar dateEmprunt1 = new GregorianCalendar();
            GregorianCalendar dateEmprunt2 = new GregorianCalendar();
            GregorianCalendar dateEmprunt3 = new GregorianCalendar();

            dateEmprunt1.add(GregorianCalendar.DAY_OF_MONTH,-15 );
            dateEmprunt2.add(GregorianCalendar.DAY_OF_MONTH,-7 );
            dateEmprunt3.add(GregorianCalendar.DAY_OF_MONTH,-17 );

            Emprunt em1 = new Emprunt(l1,ex1,dateEmprunt1);
            Emprunt em2 = new Emprunt(l1,ex3,dateEmprunt2);
            Emprunt em3 = new Emprunt(l2,ex2,dateEmprunt3);

            setEmprunt(em1);
            setEmprunt(em2);
            setEmprunt(em3);
        }


    // -----------------------------------------------
    // Private
    // -----------------------------------------------

	// -----------------------------------------------
	// Setters
	// -----------------------------------------------

	private void setLecteurs(HashMap<Integer, Lecteur> dicoLecteur)
        {
            _dicoLecteur = dicoLecteur;
	}

	private void setOuvrages(HashMap<Long, Ouvrage> dicoOuvrage)
        {
            _dicoOuvrage = dicoOuvrage;
	}

    	private void setEmprunts(HashSet<Emprunt> emprunts)
        {
            _emprunts = emprunts;
        }

	// -----------------------------------------------
	// Methodes
	// -----------------------------------------------

	/*
         * La méthode getLecteur permet de rechercher dans la base de donnée de bibliotheque un objet
	 * lecteur identifié par son numéro, et de renvoyer l'objet (ou la donnée null s'il n'est pas trouvé)
	 */
	private Lecteur getLecteur(Integer numLecteur)
	{
            return _dicoLecteur.get(numLecteur);
	}

	/*
         * La méthode getOuvrage permet de rechercher dans la base de donnée de bibliotheque un objet
	 * ouvrage identifié par son isbn, et de renvoyer l'objet (ou la donnée null s'il n'est pas trouvé)
	 */
	private Ouvrage getOuvrage(Long isbn)
	{
            return _dicoOuvrage.get(isbn);
	}

        /*
	 * La méthode setLecteur permet d'ajouter un lecteur a la base de donnée de bibliotheque.
	 */
	private void setLecteur(Lecteur L, Integer numLecteur)
	{
            _dicoLecteur.put(numLecteur, L);
	}

        /*
	 * La méthode setOuvrage permet d'ajouter un ouvrage a la base de donnée de bibliotheque.
	 */
	private void setOuvrage(Ouvrage o, Long isbn)
	{
	    _dicoOuvrage.put(isbn, o);
	}

        /*
	 * La méthode setEmprunt permet d'ajouter un emprunt a la base de donnée de bibliotheque.
	 */
	private void setEmprunt(Emprunt em)
	{
	    _emprunts.add(em);
	}

        /*
	 * La méthode unsetEmprunt permet d'ajouter un emprunt a la base de donnée de bibliotheque.
	 */
        private void unSetEmprunt(Emprunt em)
        {
            _emprunts.remove(em);
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

	    private void setDerNumLecteur(int v)
		{
	        derNumLecteur = v;
	    }

	public int getDerNumLecteur()
	{
	    return derNumLecteur;
	}

	    private void incDerNumLecteur()
		{
	        derNumLecteur++;
	    }

}
