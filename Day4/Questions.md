## Jour 4
### Job 1
**Pourquoi est-il conseillé de séparer la logique métier des contrôleurs ?**

Spring Data JPA réduit le code standard, promeut les meilleures pratiques et améliore   
la productivité des développeurs en offrant un moyen pratique d'interagir avec les   
bases de données relationnelles tout en conservant la flexibilité nécessaire pour   
personnaliser les requêtes et les comportements lorsque cela est nécessaire.

### Job 2
**Question : Quels sont les avantages d'utiliser Spring Security pour protéger une application ?**
Spring Security apporte une sécurité robuste, modulable et standardisée :

Authentification et autorisation prêtes à l’emploi (supporte formulaires, HTTP Basic, OAuth2, JWT, LDAP, etc)
Protection automatique contre les failles fréquentes (CSRF (Cross-Site Request Forgery), XSS (Cross-Site Scripting), Session fixation, Clickjacking)
Intégration facile avec Spring Boot et les standards modernes (OAuth2, OpenID Connect, JWT)

C’est donc un choix naturel pour sécuriser une application Spring, au lieu de réinventer la roue avec une solution maison.

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

Avec Spring Security, on stocke les mots de passe hachés et salés grâce à un PasswordEncoder comme BCryptPasswordEncoder, ou Argon2PasswordEncoder (plus récent, résistant aux attaques GPU/ASIC).

Il ne faut pas stocker les mots-de-passes en clair; et mieux vaut eviter les cryptages MD5, SHA-1, ou SHA-256 seuls.

On encode au moment de l’inscription et on utilise matches() pour vérifier lors de la connexion, via:  
passwordEncoder.matches(rawPassword, hashedPassword).