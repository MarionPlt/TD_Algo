package com.company;

import java.util.*;

/**
 * TD3-TD4 : construction de l'objet ObjetAtrier
 */

public class ObjetATrier {
    int id;
    List<ObjetATrier> children;

    public ObjetATrier(int id, List<ObjetATrier> children) {
        this.id = id;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<ObjetATrier> getChildren() {
        return children;
    }

    public void setChildren(List<ObjetATrier> children) {
        this.children = children;
    }

    public void setChild(int index, ObjetATrier child) {
        //ghost est un objet null par défaut
        ObjetATrier ghost = new ObjetATrier(0, null);
        if (children != null && Objects.equals(children.get(index), ghost)) {
            children.remove(index);
            children.add(index, child);
        } else {
            if (index == 0) {
                this.setChildren(List.of(child, ghost));
            } else {
                this.setChildren(List.of(ghost, child));
            }
        }
    }

    /**
     * fonction de recherche en profondeur infixe
     *
     * @param result : liste d'entier
     * @return une liste d'entier représentant le parcours de l'arbre
     */
    public List<Integer> infixSearch(List<Integer> result) {
        //si nbe d'enfant = 1, on remplace le second par un object avec id=0

        if (children != null && children.get(0) != null && children.get(0).id != 0) {
            children.get(0).infixSearch(result);
        }

        result.add(this.id);

        if (children != null && children.get(1) != null && children.get(1).id != 0) {
            children.get(1).infixSearch(result);
        }


        return result;
    }

    /**
     * parcours en largeur
     *
     * @return liste de noeuds (int)
     */
    public List<Integer> breadthFirstSearch() {
        List<ObjetATrier> currentNodes = new ArrayList();
        currentNodes.add(this);
        List<Integer> result = new ArrayList();

        while (!currentNodes.isEmpty()) {
            ObjetATrier currentObject = currentNodes.get(0);
            result.add(currentObject.id);
            currentNodes.remove(currentObject);
            if (currentObject.children != null) {
                for (ObjetATrier child : currentObject.children) {
                    currentNodes.add(child);
                }
            }
        }
        return result;
    }

    /**
     * Fonction de creation d'arbre de recherche
     *
     * @param number : entier à ajouter dans l'arbre
     */
    public void researchTree(int number) {
        if (this.getId() < number) {
            if (children != null && children.get(0) != null) {
                children.get(0).researchTree(number);
            }
            this.setChild(0, new ObjetATrier(number, null));

        } else {
            if (children != null && children.get(1) != null) {
                children.get(1).researchTree(number);
            }
            this.setChild(1, new ObjetATrier(number, null));
        }

    }

    /**
     * fonction calcul d'équilibrage
     *
     * @param result   liste d'entiers
     * @param compteur : compteur de noeuds (int)
     * @return valeur maximale de la liste
     */
    public int heightTree(List<Integer> result, int compteur) {

        if (children != null) {
            compteur++;
            for (ObjetATrier child : children) {
                child.heightTree(result, compteur);
            }
        }
        result.add(compteur);
        return Collections.max(result, null);
    }

    /**
     * fonction pur réaliser une rotation gauche
     */
    public void leftRotation() {
        if (children != null) {
            this.setChildren(List.of(children.get(0), children.get(1).getChildren().get(0)));
            children.get(1).setChildren(List.of(this, children.get(1).children.get(1)));
        }
    }

}



