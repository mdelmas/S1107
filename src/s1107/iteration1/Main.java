package s1107.iteration1;

import s1107.iteration1.EntreesSorties;
import s1107.iteration1.Bibliotheque;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Main 
{ 
	
    public Main() 
    {
	Bibliotheque bibliotheque = new Bibliotheque();
		
	String nomFich="save.ser";
                
	/*---------------------------------------------------------------------------------------------
	 * Récupération des serialisation précédentes dans le fichier du nom de "save.ser".
	 * L'utilisateur est informé de la réussite ou non de la récupération des données.
	 */
	try {
	    FileInputStream fichier = new FileInputStream(nomFich);
	    ObjectInputStream in = new ObjectInputStream(fichier);

            bibliotheque = (Bibliotheque) in.readObject();
			
            fichier.close();
            in.close();

            EntreesSorties.afficherMessage(" $$$ Restauration du fichier " + nomFich + " realisee");
	} catch (Exception e) {
            EntreesSorties.afficherMessageCouleur(" *** Start : Pbs de Restauration / fichier " + nomFich, Color.RED);
	}
	//----------------------------------------------------------------------------------------------
		
	MenuBiblio menu = new MenuBiblio(bibliotheque);
	menu.menuPrincipal();
		
	/*---------------------------------------------------------------------------------------------
	 * Sériaisation dans le fichier du nom de "save.ser".
	 * L'utilisateur est informé de la réussite ou non de la sauvegarde des données.
	 */
	try {
            FileOutputStream f = new FileOutputStream(nomFich);
            ObjectOutputStream out = new ObjectOutputStream(f);

            out.writeObject(bibliotheque);

            EntreesSorties.afficherMessage(" $$$ Sauvegarde dans le fichier " + nomFich + " realisee");
			
            out.close();
            f.close();
	} catch (Exception e) {
            EntreesSorties.afficherMessageCouleur(" *** Start :Pbs de Sauvegarde dans le fichier " + nomFich, Color.RED);
	}
    }
	
    public static void main(String args[])
    {
            new Main();
    }
    
}
