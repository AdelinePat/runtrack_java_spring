## Jour 3

### Job 1
**Question : Qu'est-ce que JPA et comment facilite-t-il l'accès aux bases de données ?**

Spring Data JPA fournit une implémentation de la couche d'accès aux données pour une application Spring. C'est une brique très pratique car elle permet de ne pas réinventer la roue de l'accès aux données à chaque nouvelle application et donc de se concentrer sur la partie métier.

### Job 2
**Question : Pourquoi les bases de données en mémoire, comme H2, sont-elles utiles pendant le développement ?**

Cela permet d'avoir d'émuler la phase de production de l'application sans avoir besoin de modifier la véritable base de données.
L'avoir en mémoire permet une plus grande rapidité d'exécution pour les tests


### Job 3
**Question : Quelle est l'importance des annotations, telles que @Entity, dans le contexte de JPA ?**

Les annotations comme @Entity permet de faire le lien entre le code Java et JPA (Java Persistence API) qui va communiquer avec la base de données.
Cela va permettre de facilement mapper entre l'objet et la table et vice versa.
Les autres annotations permet de paramètrer les différents éléments qui doivent pouvoir être en lien avec la base de données.
@Id permet d'identifier la clé primaire d'une table dans un objet, @GeneratedValue permet de spécifier que la valeur doit être générée automatiquement et pas manuellement.
Cela permet de faire du SQL sans faire de requête directement et de se concentrer sur la logique métier de l'application



### Job 4
**Question : Comment Spring Data facilite-t-il la création de requêtes de base de données?**

Spring Data JPA réduit le code standard, promeut les meilleures pratiques et améliore la productivité des développeurs en offrant un moyen pratique d'interagir avec les bases de données relationnelles tout en conservant la flexibilité nécessaire pour personnaliser les requêtes et les comportements lorsque cela est nécessaire.

### Job 05
**Question : Comment pouvez-vous créer et lire des entités avec Spring Data JPA ?**

Pour créer et lire des entités avec Spring Data JPA, on définit une interface qui étend JpaRepository.

Cela nous donne déjà accès aux méthodes CRUD comme save() pour insérer ou mettre à jour, et findAll() / findById() pour lire. On peut aussi déclarer des méthodes personnalisées, par exemple User findByEmail(String email), que Spring implémente automatiquement.

Exemple rapide :

`java
public interface UserRepository extends JpaRepository<User, Long> {
User findByEmail(String email);
}`

### Job 06
**Question : Comment la méthode save de Spring Data JPA peut-elle être utilisée à la fois pour la création et la mise à jour ?**

La méthode save() de Spring Data JPA fait à la fois création (INSERT) et mise à jour (UPDATE) grâce au comportement de JPA/Hibernate qui se base sur la clé primaire (@Id) de l’entité :

*Si l’entité n’a pas encore d’ID (ou que l’ID n’existe pas en base):*

    save() effectue un INSERT → création d’un nouvel enregistrement.

*Si l’entité a déjà un ID correspondant à une ligne existante en base:*

    save() effectue un UPDATE → la ligne est modifiée avec les nouvelles valeurs.

## Jour 4
### Job 1
**Pourquoi est-il conseillé de séparer la logique métier des contrôleurs ?**

Cela rend le code plus lisible et maintenable

### Job 2
**Question : Quels sont les avantages d'utiliser Spring Security pour protéger une application ?**


### Job 3
**Question : Comment personnaliser le formulaire de connexion avec Spring Security ?**

Pour personnaliser le formulaire de connexion, il fait créer une view dédiée (login.html par exemple) avec les champs username et password.
Dans la classe de configuration de Spring Security (celle qui utilise l'annotation @Configuration et securityFilterChain) on utilise .formLogin().loginPage("/login") pour préciser à Spring Security d'utiliser la page de login plutôt que la page par défaut. 
On ajoute aussi un controller relié à la view du formulaire de connexion pour pouvoir renvoyer la page dans le navigateur.

Il suffit d'ajouter un autre controller (java) et view (html) pour le formulaire, dans la classe pour laquelle on a utilisé l'annotation @Configuration on redirige les requêtes http vers le bon controller (ne pas utiliser celui par défaut mais celui du login du coup) qui traite les données et vers la bonne view en conséquence.


### Job 4
**Question : Comment Spring Security gère-t-il les autorisations basées sur les  rôles ?**

Spring Security gère les autorisations via la classe @Configuration en utilisant UserDetailsService pour créer les utilisateurs et leur rôle dans la base de données
Dans l'objet de la classe SecurityFilterChain (se trouvant dans la classe de @Configuration), dans la méthode authorizeHttpRequests, on peut spécifier quel rôle peut accéder à quel URL.
Si un utilisateur n'ayant pas le rôle prévu par authorizeHttpRequests essaye d'accéder à cet URL, une erreur de type "whilelabel" s'affichera, si l'utilisateur a accès, Spring Security lui affichera la page normalement.


### Job 5
**Question : Comment stocker en toute sécurité les mots de passe des utilisateurs avec Spring Security? **