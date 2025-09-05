### Job 1
**Qu'est-ce que Spring Initializr et comment peut-il faciliter la création d'un nouveau projet Spring ?**

Spring Initializr est un outil en ligne (utilisable via des IDE comme IntelliJ ou des suites de logiciel comme Spring Tools Suite) qui permet de générer rapidement la structure de base d'un nouveau projet Spring.
Cela permet d'éviter de configurer manuellement le projet (via pom.xml par exemple si on utilise Maven).


### Job 2
**Pourquoi le fichier pom.xml est-il crucial dans un projet Maven ?**

Le fichier pom.xml permet de configurer le projet et gérer les différentes dépendances nécessaires.


### Job 3
**Question : Qu'est-ce qu'un contrôleur dans le contexte de Spring MVC ?**

Le controller dans le contexte de Spring MVC se charge de la communication entre le modèle et la view.
Il fait le lien entre notre code et le framework qui va recevoir des requêtes HTTP et va pouvoir renvoyer une réponse comme une page HTML.

### Job 4
**Question : Comment Spring permet-il l'injection de propriétés depuis des fichiers de configuration ?**

Les propriétés définies dans les fichiers de configurations (application.properties ou application.yml) peuvent être injectées dans des composants.
Spring va se charger d'aller récupérer les valeurs des propriétés se trouvant dans les fichiers de configuration. Cette fonctionnalité nous permet ensuite d'utiliser le décorateur @Value et d'injecter la valeur voulu dans la variable de notre choix.

### Job 5
**Question : Pourquoi serait-il u   tile d'avoir différents profils dans une application Spring ?**

Il est très utile et important d'avoir des configurations différentes afin de mieux gérer les différents environnements. Le plus connu est l'environnement de développement qui ne demande pas du tout les même configurations que l'environnement de production. L'environnement de dev va plus se concentrer sur des configurations qui permet de tester rapidement et avoir les modifications du code sans avoir à relancer l'application par exemple alors que pour la production, l'important et d'avoir l'environnement le plus efficient pour l'utilisation.

### Job 6
**Question : En quoi la dépendance DevTools est-elle bénéfique pour le développement ?**

DevTools permet d'appliquer les modifications du code même si l'application est en cours d'exécution, cela rend le développement plus rapide puisqu'il n'y a plus besoin de redémarrer l'application manuellement