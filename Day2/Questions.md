## Jour 2

### Job 1
**Question : Question : Comment le modèle MVC aide-t-il à structurer une application web ?**

Le modèle MVC (Model View Controller) permet de séparer la logique métier et la gestion des données (model) de l'interface graphique (vue).
Le controller se charge de faire communiquer ce que l'utilisateur voit avec la logique de l'application, selon les actions de l'utilisateur, le controller va permettre d'aller demander au model les informations nécessaires demandées par la vue, le model renvoie au controller ce dont la vue a besoin et la vue s'adapte.

### Job 2
**Question : Quelle est la différence entre Thymeleaf et les templates HTML classiques ?**

Thymeleaf permet de créer des balises dynamiques, c'est à dire de remplacer leur contenu en fonction du code. Alors qu'une page HTML standard ne peut qu'afficher ce qui a été écrit en l'état.

### Job 3
**Question : Comment pouvez-vous passer des données d'un contrôleur à unevue dans Spring ?**

Pour passer des données du controller vers la vue, il suffit d'utiliser les attributs th: dans la vue, déterminer le nom de la variable sous ce format ${nomDeVariable}.
Une fois dans le controller, on utilise la méthode model.addAttribute("nomDeLaVariable", laValeurDeLaVariable); où laValeurDeLaVariable est la valeur trouvée dans le controller via le Model (en général).

### Job 4
**Question : Comment Spring facilite-t-il la gestion des formulaires ?**
Spring permet de facilement récupérer les données du formulaire via les méthodes POST ou GET.
Il va récupérer un objet avec les différents champs en utilisant l'attribut "name" des balises et grâce à @PostMapping qui permet de récupérer l'objet contenant les champs et leurs valeurs ainsi que @RequestParam qui permet de viser un champ particulier, on peut récupérer les valeurs que l'on veut et traiter ensuite les différentes données comme on l'entend.
Cela permet de facilement manipuler les données provenant de la view et grâce à thymeleaf, on peut renvoyer d'autres informations à la view après le traitement des informations

### Job 5
**Question : Comment Spring permet-il la validation des données du formulaire ?**

Spring valide les données grâce à @Valid @ModelAttribute, il va utiliser un objet (classe que l'on crée) pour vérifier que les données respectent certaines conditions (comme @NotBlank pour les string et @NotNull pour les nombres par exemple), ces annotations permettent de vérifier les valeurs avant de les appliquer à l'objet, si les conditions ne sont pas respectée, alors .hasError sera déclenché par le binding des données du formulaire et de l'objet, ce qui permet de facilement gérer les erreurs d'entrées utilisateurs sans réécrire la logique toujours utilisées pour les inputs.
Erreur ou non, il est simple avec .hasError de renvoyer la vue nécessaire.