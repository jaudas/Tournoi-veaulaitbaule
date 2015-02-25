26/01/2015
FREIXA Alba
AUDAS Jessica
CORDIER Diane
EPF Promotion 2016 - Fili�re TIC
Projet JAVA

Le programme que nous avons cr�� permet de g�rer un tounoi de volley-ball uniquement.

|| Fonctionnalit�s impl�ment�es ||
      --Les types de tournoi --
Deux types de tournois sont disponibles : 
 - un tournoi par �limination directe � chaque rencontre
 - un tournoi avec une phase de poules. Une poule contient de 1 � 4 �quipes. Les deux premi�res �quipes de chaque poule sont ensuite s�lectionn�es pour la phase par �limination directe.
Un nombre impair d'�quipes est possible dans chaque cas: une �quipe est tir�e au sort pour passer au tour suivant sans match.
Dans les deux cas, le gagnant du tournoi est le gagnant de la finale.


      -- Les �quipes du tournoi --
Une �quipe poss�de un nom, une description et des joueurs.
Chaque joueur poss�de un nom, pr�nom, �ge et sexe.

L'utilisateur a la possibilit� de g�n�rer des �quipes de deux fa�ons :
 - soit il saisit manuellement les informations de chaque �quipe;
 - soit il utilise les �quipes g�n�r�es automatiquement par le programmes. 
Le nombre maximum d'�quipes qui peut �tre cr�� est, dans chaque cas, �gal au nombre de noms diff�rents disponibles pour une �quipe dans la liste des couleurs.

Remarque : les �quipes g�n�r�es par le programme sont diff�rentes � chaque fois.
En effet, pour chaque champ d'information de chaque �quipe, le programme tire au sort	une valeur dans une base de donn�es:
- Le nom de l'�quipe est toujours une couleur, tir�e au sort dans une base de donn�es de noms de couleur
- La description consiste � indiquer l'embl�me de l'�quipe. Cet embl�me est toujours un animal, tir� au sort parmi une liste d'animaux.
- Le sexe de chaque joueur est tir� au sort. 
- Le pr�nom d'un joueur est tir� au sort parmi une liste de pr�noms correspondant � son sexe
- Le nom de famille du joueur est tir� au sort parmi une liste de fruits et l�gumes.
- L'�ge d'un joueur est tir� au sort entre 15 et 65 ans.
******/// Expliquer JSON et tirage au sort du sexe (Enum)	

L'utilisateur peut:
- ajouter une ou plusieurs �quipes
- modifier les informations d'une ou plusieurs �quipes
- ajouter un ou plusieurs joueurs d'une �quipe
- modifier les informations d'une ou plusieurs �quipes
- afficher les informations concernant les �quipes et les joueurs qui la composent

      -- Les matchs --
Un match de volley-ball se joue en 3 sets gagnants (5 sets maximums en jeu), aucune �galit� n'est possible.
L'utilisateur peut:
 - saisir le score de chaque �quipe pour un match non jou�. Une fois que tous les matchs de poules ou d'un tour ont �t� jou�s, on passe au tour suivant.
 - afficher tous les matchs qui ont �t� jou�s et les scores de chaque �quipe. 

     -- Le goal average --


|| BONUS ||
Nous avons ajout� une fonction qui permet � l'utilisateur de g�n�rer la suite du tournoi automatiquement.
Autrement dit, lorsque l'utilisateur choisit cette option dans le menu principal, les scores de tous les matchs non jou�s et ceux des tours suivants sont tir�s au sort (tout en restant conformes au r�gles du volley-ball).
Ainsi, on obtient un gagnant al�atoire du tournoi.
Nous avons nous-m�mes utilis� ce mode en s'amusant � parier sur l'�quipe gagnante parmi les �quipes que nous avions saisies auparavant.

Fonctionnalit�s non impl�ment�es :

Informations pour d�marrer le projet:

Remarques : 
