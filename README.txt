26/01/2015
FREIXA Alba
AUDAS Jessica
CORDIER Diane
EPF Promotion 2016 - Fili�re TIC
Projet JAVA


|| Postulat ||
 - Le programme que nous avons cr�� permet de g�rer un tournoi de volley-ball uniquement.
 - Avant de lancer le programme, il faut installer la librairie JSON.1-1-1. Nous l'avons utilis�e pour cr�er une base de donn�es permettant de g�n�rer des �quipes par d�faut.
Lien pour t�l�charger JSON : https://code.google.com/p/json-simple/downloads/detail?name=json-simple-1.1.1.jar&can=2&q=
Importer le fichier .jar dans Eclipse en allant dans Project -> Propertoes -> Build path -> Add external JARS 


|| Fonctionnalit�s impl�ment�es ||
      -- Les types de tournoi --
Deux types de tournois sont disponibles : 
 - un tournoi par �limination directe � chaque rencontre
 - un tournoi avec une phase de poules. Une poule contient de 1 � 4 �quipes. Les deux premi�res �quipes de chaque poule sont qualifi�es pour la phase par �limination directe.
   A la fin de la phase de poules, le classement des �quipes dans chaque poule est affich�.

Un nombre impair d'�quipes est possible dans chaque cas: une �quipe sera alors tir�e au sort pour passer au tour suivant sans jouer de match.
Dans les deux cas, le gagnant du tournoi est le gagnant de la finale.
A la fin du tournoi, on affiche le classement des �quipes avec leurs statistiques.


      -- Les �quipes et joueurs du tournoi --
Une �quipe poss�de un nom, une description et des joueurs.
Chaque joueur poss�de un nom, pr�nom, �ge et sexe.

L'utilisateur a la possibilit� de g�n�rer des �quipes de deux fa�ons :
 - soit il saisit manuellement les informations de chaque �quipe
 - soit il utilise les �quipes g�n�r�es automatiquement par le programme. 
Le nombre maximum d'�quipes qui peut �tre cr�� est, dans chaque cas, �gal au nombre de noms diff�rents disponibles pour une �quipe dans la liste des couleurs.

Remarque : les �quipes g�n�r�es par le programme sont diff�rentes � chaque fois.
En effet, pour chaque champ d'information de chaque �quipe, le programme tire au sort	une valeur dans une base de donn�es:
- Le nom de l'�quipe est toujours une couleur
- L'embl�me de l'�quipe, qui est toujours un animal et qui est donn� dans la description de l'�quipe.
- Le sexe de chaque joueur
- Le pr�nom d'un joueur, parmi une liste de pr�noms correspondant � son sexe
- Le nom de famille du joueur, parmi une liste de fruits et l�gumes.
- L'�ge d'un joueur, compris entre 15 et 65 ans.
******/// Expliquer JSON et tirage au sort du sexe (Enum)	

L'utilisateur peut:
- ajouter une ou plusieurs �quipes
- modifier les informations d'une ou plusieurs �quipes
- ajouter un ou plusieurs joueurs dans une �quipe
- modifier les informations d'un ou plusieurs joueurs d'une �quipe
- afficher les informations concernant les �quipes et les joueurs qui la composent


      -- Les matchs --
Un match de volley-ball se joue en 3 sets gagnants (5 sets maximums en jeu). Aucune �galit� n'est possible.
L'utilisateur peut:
 - saisir le score de chaque �quipe pour un match non jou� uniquement. Une fois que tous les matchs de poules ou d'un tour ont �t� jou�s, on passe au tour suivant.
 - afficher tous les matchs qui ont �t� jou�s et les scores de chaque �quipe. 


      -- Les statistiques --
A la fin d'un tournoi, le goal average et le pourcentage de victoires de chaque �quipe sont affich�s. 
Le goal average correspond � la diff�rence entre le nombre de sets gagn�s et le nombre de sets perdus par une �quipe au cours du tournoi.
Le pourcentage de victoire est donn� en fonction d'une nombre de victoires par rapport au nombre de matchs jou�s par une �quipe.


|| Client ||
Les deux interfaces disponibles pour ce programme ont �t� impl�ment�es avec :
- la classe Scanner (client console)
- la librairie Swing (client graphique)



|| BONUS ||
     -- G�n�rer la suite du tournoi automatiquement --
Nous avons ajout� une fonction qui permet � l'utilisateur de g�n�rer la suite du tournoi automatiquement.
Autrement dit, lorsque l'utilisateur choisit cette option dans le menu principal, les scores de tous les matchs non jou�s et ceux des tours suivants sont tir�s au sort (tout en restant conformes au r�gles du volley-ball).
Ainsi, on obtient un gagnant al�atoire du tournoi.
Nous avons nous-m�mes utilis� ce mode en s'amusant � parier sur l'�quipe gagnante parmi les �quipes que nous avions saisies auparavant.
 
