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
