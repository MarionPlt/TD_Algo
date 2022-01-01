package com.company;


import java.util.*;

public class Main {


    public static void main(String[] args) {
        /**
         * TD1
         */
        //exercice 1 : implémentation de l'arbre

        Tree a = new Tree("a", null);
        Tree b = new Tree("b", a);
        Tree c = new Tree("c", a);
        Tree d = new Tree("d", a);
        Tree e = new Tree("e", b);
        Tree f = new Tree("f", b);
        Tree g = new Tree("g", d);
        Tree h = new Tree("h", d);
        Tree i = new Tree("i", d);
        Tree j = new Tree("j", e);
        Tree k = new Tree("k", e);
        Tree l = new Tree("l", e);
        Tree m = new Tree("m", g);
        Tree n = new Tree("n", i);
        Tree o = new Tree("o", i);
        Tree p = new Tree("p", m);
        a.setChildren(b, c, d);
        b.setChildren(e, f);
        e.setChildren(j, k, l);
        d.setChildren(g, h, i);
        g.setChildren(m);
        m.setChildren(p);
        i.setChildren(n, o);

        //Exercice 2
        //1)
        System.out.println("************TD1 Exercice 2************");
        System.out.println("***** 1) *****");
        List<String> result = new ArrayList();
        //parcours en largeur
        System.out.println("parcours en largeur : " + a.breadthFirstSearch());
        //parcours en profondeur prefixe
        System.out.println("parcours en profondeur prefixe" + a.prefixSearch(result));
        result.clear();
        //parcours en profondeur suffixe
        System.out.println("parcours en profondeur suffixe" + a.suffixSearch(result));
        result.clear();
        //parcours en profondeur infixe
        System.out.println("parcours en profondeur infixe" + a.infixSearch(result));
        result.clear();

        //2)
        // Implémentation de l'arbre
        Tree bip = new Tree("0", null);
        Tree aa = new Tree("20", null);
        Tree bb = new Tree("5", aa);
        Tree cc = new Tree("25", aa);
        Tree dd = new Tree("3", bb);
        Tree ee = new Tree("12", bb);
        Tree ff = new Tree("21", cc);
        Tree gg = new Tree("28", cc);
        Tree hh = new Tree("8", ee);
        Tree ii = new Tree("13", ee);
        Tree kk = new Tree("6", hh);

        aa.setChildren(bb, cc);
        bb.setChildren(dd, ee);
        cc.setChildren(ff, gg);
        ee.setChildren(hh, ii);
        hh.setChildren(kk, bip);

        System.out.println("***** 2) *****");
        System.out.println("parcours en largeur : " + aa.breadthFirstSearch());
        System.out.println("parcours en profondeur prefixe : " + aa.prefixSearch(result));
        result.clear();
        System.out.println("parcours en profondeur suffixe : " + aa.suffixSearch(result));
        result.clear();
        System.out.println("parcours en profondeur infixe : " + aa.infixSearch(result));
/**
 * TD2
 */
        //Exercice 1
        //1)
        int tab[] = {20, 5, 25, 3, 12, 21, 28, 0, 0, 8, 13, 0, 0, 0, 0, 0, 0, 0, 0, 6};
        //2) ce n'est pas un tas car la valeur du noeud parent n'est pas un extremum
        // l'arbre initial n'est pas un tas car il n'est pas presque complet.
        //meme en le triant il gardera la meme config avec plusieurs niveaux pas complets
        //3) C'est un tas, possibilité de le trier
        int tab2[] = {885, 20, 50, 2, 12, 35, 9, 7};

        //Exercice 2
        //j'ai fait la version décroissante mais on garde la même logique
        //1)
        int tab3etape1[] = {25, 40, 2, 65, 10};
        //1er tamisage
        int tab3etape2[] = {65, 40, 2, 25, 10};
        int resultTri[] = {65};
        int tab3etape3[] = {10, 40, 2, 25};
        //2me tamisage
        int tab3etape4[] = {40, 25, 2, 10};
        resultTri = new int[]{65, 40};
        //3eme tamisage
        int tab3etape5[] = {10, 25, 2};
        int tab3etape6[] = {25, 10, 2};
        resultTri = new int[]{65, 40, 25};
        //4eme tamisage
        int tab3etape7[] = {2, 10};
        int tab3etape8[] = {10, 2};
        resultTri = new int[]{65, 40, 25, 10};
        resultTri = new int[]{65, 40, 25, 10, 2};

        //2)
        int tab4etape1[] = {10, 50, 1, 25, 35, 15};
        //1er tamisage
        int tab4etape2[] = {50, 35, 1, 25, 10, 15};
        int resultTri2[] = {50};
        //2eme tamisage
        int tab4etape3[] = {15, 35, 1, 25, 10};
        int tab4etape4[] = {35, 25, 1, 15, 10};
        resultTri2 = new int[]{50, 35};
        //3eme tamisage
        int tab4etape5[] = {10, 25, 1, 15};
        int tab4etape6[] = {25, 15, 1, 10};
        resultTri2 = new int[]{50, 35, 25};
        int tab4etape7[] = {15, 1, 10};
        resultTri2 = new int[]{50, 35, 25, 15};
        //4eme tamisage

        int tab4etape8[] = {1, 10};
        int tab4etape9[] = {10, 1};
        resultTri2 = new int[]{50, 35, 25, 10};
        resultTri2 = new int[]{50, 35, 25, 10, 1};


        /**
         * TD3
         */
        //Exercice 1
        //1) oui c'est un arbe binaire de recherche
        //2) reprensenté en tableau on obtient
        int[] tab5 = {20, 5, 25, 3, 12, 21, 28, 0, 0, 8, 13, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0};
        //insertion 50 :
        tab5 = new int[]{20, 5, 25, 3, 12, 21, 28, 0, 0, 8, 13, 0, 0, 0, 50, 0, 0, 0, 0, 6, 0};
        //insertion 5 => Il existe déjà ! probleme
        //insertion 25 => Il existe déjà ! probleme
        //insertion 19
        tab5 = new int[]{20, 5, 25, 3, 12, 21, 28, 0, 0, 8, 13, 0, 0, 0, 50, 0, 0, 0, 0, 6, 0, 0, 19};
        //3)parcours infixe
        tab5 = new int[]{3, 5, 6, 8, 12, 19, 20, 21, 25, 28, 50}; // ordre croissant!!
        //4) creation de l'objet ObjetATrier
        //Implémentation de l'arbre

        ObjetATrier ghost = new ObjetATrier(0, null);
        ObjetATrier six = new ObjetATrier(6, null);
        ObjetATrier dixneuf = new ObjetATrier(19, null);
        ObjetATrier huit = new ObjetATrier(8, List.of(six, ghost));
        ObjetATrier treize = new ObjetATrier(13, List.of(ghost, dixneuf));
        ObjetATrier douze = new ObjetATrier(12, List.of(huit, treize));
        ObjetATrier trois = new ObjetATrier(3, null);
        ObjetATrier cinq = new ObjetATrier(5, List.of(trois, douze));
        ObjetATrier cinquante = new ObjetATrier(50, null);
        ObjetATrier vingthuit = new ObjetATrier(28, List.of(ghost, cinquante));
        ObjetATrier vingtun = new ObjetATrier(21, null);
        ObjetATrier vingtcinq = new ObjetATrier(25, List.of(vingtun, vingthuit));
        ObjetATrier vingt = new ObjetATrier(20, List.of(cinq, vingtcinq));

        //parcours en profondeur infixe
        List<Integer> caDonneQuoi = new ArrayList<>();
        System.out.println("************TD3 Exercice 1************");
        System.out.println("***** 4) *****");
        System.out.println("Parcours en profondeur infixe : " + vingt.infixSearch(caDonneQuoi));


        //Exercice 2
        //1) creation de l'arbre
        ObjetATrier cinqCinq = new ObjetATrier(55, null);
        ObjetATrier quatreZero = new ObjetATrier(40, null);
        ObjetATrier cinqZero = new ObjetATrier(50, List.of(ghost, cinqCinq));
        ObjetATrier unCinq = new ObjetATrier(15, null);
        ObjetATrier troisZero = new ObjetATrier(30, null);
        ObjetATrier quatreCinq = new ObjetATrier(45, List.of(quatreZero, cinqZero));
        ObjetATrier septZero = new ObjetATrier(70, null);
        cinq.setChildren(null);
        ObjetATrier deuxZero = new ObjetATrier(20, List.of(unCinq, ghost));
        ObjetATrier troisCinq = new ObjetATrier(35, List.of(troisZero, quatreCinq));
        ObjetATrier sixCinq = new ObjetATrier(65, List.of(ghost, septZero));
        ObjetATrier unZero = new ObjetATrier(10, List.of(cinq, deuxZero));
        ObjetATrier sixZero = new ObjetATrier(60, List.of(troisCinq, sixCinq));
        ObjetATrier deuxCinq = new ObjetATrier(25, List.of(unZero, sixZero));

        //je vide la liste caDonneQuoi pour la réutiliser dans tout le fichier
        caDonneQuoi.clear();
        System.out.println("************TD3 Exercice 2************");
        System.out.println("***** 1) *****");
        System.out.println("parcours en profondeur infixe : " + deuxCinq.infixSearch(caDonneQuoi));

        System.out.println("***** 2) *****");
        //creation de la liste aleatoire de 10000 nombres
        List<Integer> randomInt = new ArrayList<>();
        for (int index = 1; index <= 10000; index++) {
            randomInt.add(index);
        }
        Collections.shuffle(randomInt, new Random(3));

        //appliquer la fonction researchTree pour chaque élement de la liste randomInt
        ObjetATrier pointDeDepart = new ObjetATrier(randomInt.get(0), null);
        for (int nb = 1; nb < randomInt.size(); nb++) {
            pointDeDepart.researchTree(randomInt.get(nb));
        }


        /**
         * TD4
         */
        //Exercice 1
        //1) sous arbre gauche = 4
        //sous arbre droit = 2
        // le facteur equilibrage >1 donc l'arbre n'est pas equilibré
        //2) chaque facteur = 0 => arbre équilibré

        //implementation de l'arbre

        ObjetATrier _vingtHuit = new ObjetATrier(28, null);
        ObjetATrier _vingtUn = new ObjetATrier(21, null);
        ObjetATrier _vingtCinq = new ObjetATrier(25, List.of(_vingtHuit, _vingtUn));
        ObjetATrier _six = new ObjetATrier(6, null);
        ObjetATrier _huit = new ObjetATrier(8, List.of(_six, ghost));
        ObjetATrier _treize = new ObjetATrier(13, null);
        ObjetATrier _douze = new ObjetATrier(12, List.of(_huit, _treize));
        ObjetATrier _trois = new ObjetATrier(3, null);
        ObjetATrier _cinq = new ObjetATrier(5, List.of(_trois, _douze));
        ObjetATrier _vingt = new ObjetATrier(20, List.of(_cinq, _vingtCinq));

        caDonneQuoi.clear();
        int brancheGauche = _cinq.heightTree(caDonneQuoi, 0);
        caDonneQuoi.clear();
        int brancheDroite = _vingtCinq.heightTree(caDonneQuoi, 0);
        System.out.println("************TD4 Exercice 1************");
        System.out.println("***** 1) *****");
        System.out.println("hauteur sous-arbre droit: " + brancheDroite);
        System.out.println("hauteur sous-arbre gauche: " + brancheGauche);
        System.out.println("le facteur d'équilibrage est de : " + (brancheDroite - brancheGauche));
        //on vérifie grâce à la fonction isEquilibrated si la'bre est équilibré
        // on retourne une phrase réponse selon le résultat
        System.out.println("l'arbre est equilibré ? " + (isEquilibrated(_vingtCinq, _cinq) ? "oui il l'est!" : "non, il ne l'est pas!"));
        caDonneQuoi.clear();


        //Exercice 2
        //1)noeud 12 = 2 noeud 15 = 1
        //3)noeud 15 = 0 oui c'est un arbre equilibré
        //4) implémentation fonction leftRotation()
    }

    /**
     * fonction qui vérifie si un arbre est équilibré
     *
     * @param right : premier noeud de la sous branche droite
     * @param left  : premier noeud de la sous branche gauche
     * @return boolean
     */
    public static boolean isEquilibrated(ObjetATrier right, ObjetATrier left) {
        List<Integer> caDonneCa = new ArrayList<>();
        int c = 0;
        int a = right.heightTree(caDonneCa, c);
        caDonneCa.clear();
        int b = left.heightTree(caDonneCa, c);
        return -1 <= a - b && a - b >= 1;
    }


}
