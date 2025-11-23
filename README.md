# TP Réflexion et Injection de Dépendances en Java

## Objectif
Ce TP a pour but de comprendre l'utilisation de la programmation dynamique en Java via la réflexion pour :  
- Instancier des classes dynamiquement.  
- Injecter des dépendances.  
- Appeler des méthodes via la réflexion.  

L'application peut ainsi charger différentes implémentations de manière flexible à partir d'un fichier de configuration.

---

## Structure du projet
<img width="444" height="426" alt="image" src="https://github.com/user-attachments/assets/c83ff752-a2d9-4a11-95d2-ac3bc4d67137" />


---

## Packages et classes

### dao
- **IDao** : interface avec `double getValue()`.
- **DaoImpl** : implémentation qui retourne une valeur fixe (`100.0`).

### metier
- **IMetier** : interface avec `double calcul()`.
- **MetierImpl** : implémentation qui double la valeur obtenue via `IDao`.

### presentation
- **Presentation2** : classe principale qui utilise la réflexion pour :
  1. Lire les noms de classes depuis `config.txt`.
  2. Instancier les classes dynamiquement.
  3. Injecter le DAO dans le Métier.
  4. Afficher le résultat.

---

## Fichier de configuration `config.txt`
```
dao.DaoImpl
metier.MetierImpl
```
- Chaque ligne correspond au **nom complet de la classe** à charger.  
- Il doit être placé à la racine du projet.

---

## Exécution avec IntelliJ

1. Créer une configuration d’exécution pour `presentation.Presentation2`.  
2. Assurer que le **working directory** pointe vers le dossier racine contenant `config.txt`.  
3. Lancer le programme.  

**Résultat attendu :**

<img width="680" height="179" alt="Screenshot 2025-11-23 221243" src="https://github.com/user-attachments/assets/7ac1af8c-d787-40b7-9604-816cfc360baa" />


