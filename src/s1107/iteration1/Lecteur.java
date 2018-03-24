package s1107.iteration1;

import s1107.iteration1.EntreesSorties;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;

// Classe de gestion de Lecteur

public class Lecteur implements Serializable
{

	private static final long serialVersionUID = 422L;

	// -----------------------------------------------
	// Attributs
	// -----------------------------------------------

		private String _nom;
		private String _prenom;
		private Integer _numLecteur;
		private GregorianCalendar _dateNaiss;
		private String _adresse;
		private String _tel;
        private HashSet<Emprunt> emprunts;



	// -----------------------------------------------
	//Constructeur
	// -----------------------------------------------

		public Lecteur(String nom, int numLecteur, String prenom, GregorianCalendar dateNaiss, String adresse, String tel)
		{
			this.setNom(nom);
			this.setPrenom(prenom);
            this.setNumLecteur(numLecteur);
			this.setDateNaiss(dateNaiss);
			this.setAdresse(adresse);
			this.setTel(tel);
            emprunts = new HashSet<>();
		}

// -----------------------------------------------
// Public
// -----------------------------------------------

		// -----------------------------------------------
		//Getters
		// -----------------------------------------------

		public String getNom()
		{
			return _nom;
		}

		public String getPrenom()
		{
			return _prenom;
		}

		public Integer getNumLecteur()
		{
			return _numLecteur;
		}

		public GregorianCalendar getDateNaiss()
		{
			return _dateNaiss;
		}

		public String getAdresse()
		{
			return _adresse;
		}

		public String getTel()
		{
			return _tel;
		}

        private HashSet<Emprunt> getEmprunts()
		{
            return emprunts;
        }

		// -----------------------------------------------
		// Methodes
		// -----------------------------------------------

            /**
             * Affiche uniquement les informations nécessaire à la relance
             */
			 public void afficherLecteurRelance()
			 {
                System.out.println("Nom et prénom du lecteur : " + this.getNom() + " " + this.getPrenom());
                System.out.println("Adresse : " + this.getAdresse());
                System.out.println("Telephone : " + this.getTel());
            }

			/**
			 * La methode afficherLecteur affiche l'ensemble des informations relatives à un lecteur.
			 */
            public void afficherLecteur()
            {
                System.out.println("Lecteur : ");
                System.out.println("Nom : " + this.getNom() + ", prénom : " + this.getPrenom());
                System.out.println("Age : " + this.calculAge() + " ans");
                System.out.println("Adresse : " + this.getAdresse());
		System.out.println("Telephone : " + this.getTel());
            }


			/**
		 	 * la methode calculAge permet de determiner l'age des lecteurs grace a leur date de naissance
		 	 * et la date actuelle. De cette façon, il n'y a pas de mise a jour a faire sur l'age des lecteurs.
		 	 */
		 	public Integer calculAge()
			{
				Integer age;
				GregorianCalendar dateNaissComp;
				GregorianCalendar dateActuelle = new GregorianCalendar();
				dateNaissComp = new GregorianCalendar(dateActuelle.get(GregorianCalendar.YEAR), _dateNaiss.get(GregorianCalendar.MONTH), _dateNaiss.get(GregorianCalendar.DATE));
				if (dateNaissComp.before(dateActuelle))
				{
					age = dateActuelle.get(GregorianCalendar.YEAR) - _dateNaiss.get(GregorianCalendar.YEAR);
				} else {
					age = dateActuelle.get(GregorianCalendar.YEAR) - _dateNaiss.get(GregorianCalendar.YEAR) - 1;
				}
				return age;
			}

            /**
             * La méthode equals permet de vérifier si un lecteur existe déjà lors de sa création
             * @param L
             * @return
             */
            public boolean equals(Lecteur L)
			{
                if (_nom.equals(L._nom) && _prenom.equals(L._prenom) && _dateNaiss.equals(L._dateNaiss) && _adresse.equals(L._adresse) && _tel.equals(L._tel)){
                    return true;
                } else {
                    return false;
                }
            }

            /**
             * Vérifie si le lecteur a déjà emprunté 5 exemplaires, renvoie vrai si oui
             * @return
             */
            public boolean lecteurSature()
			{
                if (emprunts.size() == 5)
                    return true;
                return false;
            }

            /**
             * affecte un emprunt au Lecteur
             * @param emprunt
             */
            public void affecterEmprunt(Emprunt emprunt)
			{
                getEmprunts().add(emprunt);
            }

            /**
             * Affiche les informations des emprunts en cours du lecteur
             */
			public void afficherEmpruntsLecteur()
		 	{
	            HashSet<Emprunt> emprunts = getEmprunts();
	            System.out.print("Lecteur n°" + getNumLecteur());
	            System.out.println(", " + getNom() + " " + getPrenom());
	            System.out.println(emprunts.size() + " emprunts en cours");
	            for (Emprunt emprunt: emprunts) {
                	System.out.print(" - ");
                    emprunt.afficherEmprunt();
                }
			}


	// -----------------------------------------------
	// Private
	// -----------------------------------------------

		// -----------------------------------------------
		//Setters
		// -----------------------------------------------

			private void setNom(String nom)
			{
				this._nom = nom;
			}

			private void setPrenom(String prenom)
			{
				this._prenom = prenom;
			}

			private void setNumLecteur(Integer numLecteur)
			{
				this._numLecteur = numLecteur;
			}

			private void setDateNaiss(GregorianCalendar dateNaiss)
			{
				this._dateNaiss = dateNaiss;
			}

			private void setAdresse(String adresse)
			{
				this._adresse = adresse;
			}

			private void setTel(String tel)
			{
				this._tel = tel;
			}

			public void supprimerEmprunt(Emprunt em)
			{
				unSetEmprunt(em);
			}

			private void unSetEmprunt(Emprunt em)
			{
				emprunts.remove(em);
			}

}
