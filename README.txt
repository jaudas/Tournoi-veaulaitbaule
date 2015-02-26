26/01/2015
FREIXA Alba
AUDAS Jessica
CORDIER Diane
EPF Promotion 2016 - Filière TIC
Projet JAVA


|| Postulat ||
 - Le programme que nous avons créé permet de gérer un tournoi de volley-ball uniquement.
 - Avant de lancer le programme, il faut installer la librairie JSON.1-1-1. Nous l'avons utilisée pour créer une base de données permettant de générer des équipes par défaut.
Lien pour télécharger JSON : https://code.google.com/p/json-simple/downloads/detail?name=json-simple-1.1.1.jar&can=2&q=
Importer le fichier .jar dans Eclipse en allant dans Project -> Propertoes -> Build path -> Add external JARS 


|| Fonctionnalités implémentées ||
      -- Les types de tournoi --
Deux types de tournois sont disponibles : 
 - un tournoi par élimination directe à chaque rencontre
 - un tournoi avec une phase de poules. Une poule contient de 1 à 4 équipes. Les deux premières équipes de chaque poule sont qualifiées pour la phase par élimination directe.
   A la fin de la phase de poules, le classement des équipes dans chaque poule est affiché.

Un nombre impair d'équipes est possible dans chaque cas: une équipe sera alors tirée au sort pour passer au tour suivant sans jouer de match.
Dans les deux cas, le gagnant du tournoi est le gagnant de la finale.
A la fin du tournoi, on affiche le classement des équipes avec leurs statistiques.


      -- Les équipes et joueurs du tournoi --
Une équipe possède un nom, une description et des joueurs.
Chaque joueur possède un nom, prénom, âge et sexe.

L'utilisateur a la possibilité de générer des équipes de deux façons :
 - soit il saisit manuellement les informations de chaque équipe
 - soit il utilise les équipes générées automatiquement par le programme. 
Le nombre maximum d'équipes qui peut être créé est, dans chaque cas, égal au nombre de noms différents disponibles pour une équipe dans la liste des couleurs.

Remarque : les équipes générées par le programme sont différentes à chaque fois.
En effet, pour chaque champ d'information de chaque équipe, le programme tire au sort	une valeur dans une base de données:
- Le nom de l'équipe est toujours une couleur
- L'emblème de l'équipe, qui est toujours un animal et qui est donné dans la description de l'équipe.
- Le sexe de chaque joueur
- Le prénom d'un joueur, parmi une liste de prénoms correspondant à son sexe
- Le nom de famille du joueur, parmi une liste de fruits et légumes.
- L'âge d'un joueur, compris entre 15 et 65 ans.
******/// Expliquer JSON et tirage au sort du sexe (Enum)	

L'utilisateur peut:
- ajouter une ou plusieurs équipes
- modifier les informations d'une ou plusieurs équipes
- ajouter un ou plusieurs joueurs dans une équipe
- modifier les informations d'un ou plusieurs joueurs d'une équipe
- afficher les informations concernant les équipes et les joueurs qui la composent


      -- Les matchs --
Un match de volley-ball se joue en 3 sets gagnants (5 sets maximums en jeu). Aucune égalité n'est possible.
L'utilisateur peut:
 - saisir le score de chaque équipe pour un match non joué uniquement. Une fois que tous les matchs de poules ou d'un tour ont été joués, on passe au tour suivant.
 - afficher tous les matchs qui ont été joués et les scores de chaque équipe. 


      -- Les statistiques --
A la fin d'un tournoi, le goal average et le pourcentage de victoires de chaque équipe sont affichés. 
Le goal average correspond à la différence entre le nombre de sets gagnés et le nombre de sets perdus par une équipe au cours du tournoi.
Le pourcentage de victoire est donné en fonction d'une nombre de victoires par rapport au nombre de matchs joués par une équipe.


|| Client ||
Les deux interfaces disponibles pour ce programme ont été implémentées avec :
- la classe Scanner (client console)
- la librairie Swing (client graphique)



|| BONUS ||
     -- Générer la suite du tournoi automatiquement --
Nous avons ajouté une fonction qui permet à l'utilisateur de générer la suite du tournoi automatiquement.
Autrement dit, lorsque l'utilisateur choisit cette option dans le menu principal, les scores de tous les matchs non joués et ceux des tours suivants sont tirés au sort (tout en restant conformes au règles du volley-ball).
Ainsi, on obtient un gagnant aléatoire du tournoi.
Nous avons nous-mêmes utilisé ce mode en s'amusant à parier sur l'équipe gagnante parmi les équipes que nous avions saisies auparavant.
 
