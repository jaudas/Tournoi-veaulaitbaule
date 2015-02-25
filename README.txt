26/01/2015
FREIXA Alba
AUDAS Jessica
CORDIER Diane
EPF Promotion 2016 - Filière TIC
Projet JAVA

Le programme que nous avons créé permet de gérer un tounoi de volley-ball uniquement.

|| Fonctionnalités implémentées ||
      --Les types de tournoi --
Deux types de tournois sont disponibles : 
 - un tournoi par élimination directe à chaque rencontre
 - un tournoi avec une phase de poules. Une poule contient de 1 à 4 équipes. Les deux premières équipes de chaque poule sont ensuite sélectionnées pour la phase par élimination directe.
Un nombre impair d'équipes est possible dans chaque cas: une équipe est tirée au sort pour passer au tour suivant sans match.
Dans les deux cas, le gagnant du tournoi est le gagnant de la finale.


      -- Les équipes du tournoi --
Une équipe possède un nom, une description et des joueurs.
Chaque joueur possède un nom, prénom, âge et sexe.

L'utilisateur a la possibilité de générer des équipes de deux façons :
 - soit il saisit manuellement les informations de chaque équipe;
 - soit il utilise les équipes générées automatiquement par le programmes. 
Le nombre maximum d'équipes qui peut être créé est, dans chaque cas, égal au nombre de noms différents disponibles pour une équipe dans la liste des couleurs.

Remarque : les équipes générées par le programme sont différentes à chaque fois.
En effet, pour chaque champ d'information de chaque équipe, le programme tire au sort	une valeur dans une base de données:
- Le nom de l'équipe est toujours une couleur, tirée au sort dans une base de données de noms de couleur
- La description consiste à indiquer l'emblème de l'équipe. Cet emblème est toujours un animal, tiré au sort parmi une liste d'animaux.
- Le sexe de chaque joueur est tiré au sort. 
- Le prénom d'un joueur est tiré au sort parmi une liste de prénoms correspondant à son sexe
- Le nom de famille du joueur est tiré au sort parmi une liste de fruits et légumes.
- L'âge d'un joueur est tiré au sort entre 15 et 65 ans.
******/// Expliquer JSON et tirage au sort du sexe (Enum)	

L'utilisateur peut:
- ajouter une ou plusieurs équipes
- modifier les informations d'une ou plusieurs équipes
- ajouter un ou plusieurs joueurs d'une équipe
- modifier les informations d'une ou plusieurs équipes
- afficher les informations concernant les équipes et les joueurs qui la composent

      -- Les matchs --
Un match de volley-ball se joue en 3 sets gagnants (5 sets maximums en jeu), aucune égalité n'est possible.
L'utilisateur peut:
 - saisir le score de chaque équipe pour un match non joué. Une fois que tous les matchs de poules ou d'un tour ont été joués, on passe au tour suivant.
 - afficher tous les matchs qui ont été joués et les scores de chaque équipe. 

     -- Le goal average --


|| BONUS ||
Nous avons ajouté une fonction qui permet à l'utilisateur de générer la suite du tournoi automatiquement.
Autrement dit, lorsque l'utilisateur choisit cette option dans le menu principal, les scores de tous les matchs non joués et ceux des tours suivants sont tirés au sort (tout en restant conformes au règles du volley-ball).
Ainsi, on obtient un gagnant aléatoire du tournoi.
Nous avons nous-mêmes utilisé ce mode en s'amusant à parier sur l'équipe gagnante parmi les équipes que nous avions saisies auparavant.

Fonctionnalités non implémentées :

Informations pour démarrer le projet:

Remarques : 
