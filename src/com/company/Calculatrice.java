package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;


public class Calculatrice {

    // Déclaration de tous les composants de la calculatrice.
    JPanel contenuFenetre = new JPanel();
    JTextField champAffichage = new JTextField(25);

    // chiffres
    JButton bouton0 = new JButton("0");
    JButton bouton1 = new JButton("1");
    JButton bouton2 = new JButton("2");
    JButton bouton3 = new JButton("3");
    JButton bouton4 = new JButton("4");
    JButton bouton5 = new JButton("5");
    JButton bouton6 = new JButton("6");
    JButton bouton7 = new JButton("7");
    JButton bouton8 = new JButton("8");
    JButton bouton9 = new JButton("9");
    JButton boutonParentheseGauche = new JButton("(");
    JButton boutonParentheseDroite = new JButton(")");

    //opérations
    JButton boutonClear = new JButton("C");
    JButton boutonDivision = new JButton("/");
    JButton boutonMultiplication = new JButton("x");
    JButton boutonSoustraction = new JButton("-");
    JButton boutonAddition = new JButton("+");
    JButton boutonVirgule = new JButton(",");
    JButton boutonPourcentage = new JButton("%");
    JButton boutonEgale = new JButton("=");

    /*
    Le constructeur crée les composants en mémoire et les
    ajoute au cadre en utilisant une combinaison de
     Borderlayout et de Gridlayout
     */

    Calculatrice() {
        // contenuFenetre = new JPanel();
        // on affecte un gestionnaire de présentation à ce panneau
        BorderLayout disposition1 = new BorderLayout();
        contenuFenetre.setLayout(disposition1);// au contenu de la fenêtre, je mets le layout "disposition1"

        /* création du champ d'affichage et le positionner
        dans la zone nord de la fenêtre */

        contenuFenetre.add("North", champAffichage);

        // création du panneau avec le quadrillage contenant les boutons,
        JPanel panneauChiffres = new JPanel();
        GridLayout disposition2 = new GridLayout(4, 3, 1, 1);
        panneauChiffres.setLayout(disposition2); //au panneauChiffres, je mets le layout disposition2

        //au panneauChiffres on ajoute les boutons

        panneauChiffres.add(bouton7);
        panneauChiffres.add(bouton8);
        panneauChiffres.add(bouton9);
        panneauChiffres.add(bouton4);
        panneauChiffres.add(bouton5);
        panneauChiffres.add(bouton6);
        panneauChiffres.add(bouton1);
        panneauChiffres.add(bouton2);
        panneauChiffres.add(bouton3);
        panneauChiffres.add(boutonVirgule);
        panneauChiffres.add(bouton0);
        panneauChiffres.add(boutonClear);

        // au contenuFenetre, on ajoute le panneauChiffres au centre
        contenuFenetre.add("Center", panneauChiffres);
        //contenuFenetre.add(champAffichage, "North");

        JPanel panneauOperations = new JPanel();
        GridLayout disposition3 = new GridLayout(8, 1);
        contenuFenetre.add("East", panneauOperations);

        panneauOperations.setLayout(disposition3); // au panneauOperations, je mets le layout disposition3

        panneauOperations.add(boutonPourcentage);
        panneauOperations.add(boutonDivision);
        panneauOperations.add(boutonAddition);
        panneauOperations.add(boutonMultiplication);
        panneauOperations.add(boutonSoustraction);
        panneauOperations.add(boutonParentheseGauche);
        panneauOperations.add(boutonParentheseDroite);
        panneauOperations.add(boutonEgale);


        // Créer la cadre et y affecter son contenu
        JFrame frame = new JFrame("Calculatrice");
        frame.setContentPane(contenuFenetre);

        // on permet au cadre de s'adapter à la taille de son contenu
        frame.pack();

        // on rend la fenêtre visible
        frame.setVisible(true);
        //}

        //public static void main(String[] args) {
        //  Calculatrice calc = new Calculatrice();


        // bouton0 affichera les parametres mis dans la méthode ActionEvent de la classe MoteurCalcul
        //la classe MoteurCalcul est reliiée au bouton0

        MoteurCalcul moteurCalcul = new MoteurCalcul(this);

        // définition bouton par bouton : une fenetre s'ouvre en cliquant sur
        // l'un de ses 4 boutons

        bouton0.addActionListener(moteurCalcul);
        bouton1.addActionListener(moteurCalcul);
        bouton2.addActionListener(moteurCalcul);
        bouton3.addActionListener(moteurCalcul);
        bouton4.addActionListener(moteurCalcul);
        bouton5.addActionListener(moteurCalcul);
        bouton6.addActionListener(moteurCalcul);
        bouton7.addActionListener(moteurCalcul);
        bouton8.addActionListener(moteurCalcul);
        bouton9.addActionListener(moteurCalcul);
        boutonAddition.addActionListener(moteurCalcul);
        boutonClear.addActionListener(moteurCalcul);
        boutonDivision.addActionListener(moteurCalcul);
        boutonEgale.addActionListener(moteurCalcul);
        boutonMultiplication.addActionListener(moteurCalcul);
        boutonParentheseDroite.addActionListener(moteurCalcul);
        boutonParentheseGauche.addActionListener(moteurCalcul);
        boutonPourcentage.addActionListener(moteurCalcul);
        boutonSoustraction.addActionListener(moteurCalcul);
        boutonVirgule.addActionListener(moteurCalcul);


    }


}