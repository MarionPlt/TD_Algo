package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TD1 : construction de l'objet Tree
 */

public class Tree {
    String id;
    Tree parent;

    List<Tree> children;

    public Tree(String id, Tree parent) {
        this.id = id;
        this.parent = parent;
    }

    public Tree getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(Tree... children) {
        this.children = Arrays.stream(children).toList();
    }


    /**
     * parcours en largeur
     *
     * @return liste de noeuds (string)
     */
    public List<String> breadthFirstSearch() {
        List<Tree> currentNodes = new ArrayList();
        currentNodes.add(this);
        List<String> result = new ArrayList();

        while (!currentNodes.isEmpty()) {
            Tree currentTree = currentNodes.get(0);
            result.add(currentTree.id);
            currentNodes.remove(currentTree);
            if (currentTree.children != null) {
                for (Tree child : currentTree.children) {
                    currentNodes.add(child);
                }
            }
        }
        return result;
    }

    /**
     * parcours en profondeur prefixe
     *
     * @param result liste de noeuds (string)
     * @return liste de noeuds (string)
     */
    public List<String> prefixSearch(List<String> result) {
        result.add(this.id);
        if (children != null) {
            for (Tree child : children) {
                child.prefixSearch(result);
            }
        }
        return result;
    }

    /**
     * parcours en profondeur suffixe
     *
     * @param result liste de noeuds (string)
     * @return liste de noeuds (string)
     */
    public List<String> suffixSearch(List<String> result) {
        if (children != null) {
            for (Tree child : children) {
                child.suffixSearch(result);
            }
        }
        result.add(this.id);
        return result;
    }

    /**
     * parcours en profondeur infixe
     *
     * @param result : liste de noeuds (string)
     * @return liste de noeuds (string)
     */
    public List<String> infixSearch(List<String> result) {
        if (children != null && children.get(0) != null && !children.get(0).id.equals("0")) {
            children.get(0).infixSearch(result);
        }

        result.add(this.id);

        if (children != null && children.get(1) != null && !children.get(1).id.equals("0")) {
            children.get(1).infixSearch(result);
        }


        return result;
    }
}