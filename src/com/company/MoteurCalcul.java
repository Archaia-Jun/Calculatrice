package com.company;

import android.net.wifi.p2p.WifiP2pManager;

import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.text.ParsePosition;

import javax.swing.*;


class MoteurCalcul implements WifiP2pManager.ActionListener {

    Calculatrice parent; // référence à la Calculatrice
    //MoteurCalcul moteurCalcul = new MoteurCalcul(this);
    char actionChoisie = ' '; // +,-,/,x

    double resultatCourant = 0;

    NumberFormat formatNombres = NumberFormat.getInstance(); //un objet capable de lire et présenter un nombre

    // le constructeur stocke la référence à la fenêtre Calculatrice dans la variable membre parent
    MoteurCalcul(Calculatrice parent) {
        this.parent = parent;
    }


//la méthode actionPerformed(ActionEvent e) , remplacer "e" par le nom de l'action

    // au clique des boutons, les actions suivantes seront réalisées
    @Override
    public void actionPerformed(ActionEvent eventClick) {

        // Retrouve la source de l'action
        JButton boutonClique = (JButton) eventClick.getSource();

        // récupère le texte existant dans le champ Affichage de la calculatrice
        String texteChampAffichage = parent.champAffichage.getText();

        double valeurAffichee = 0;

        // Retrouve le nombre présenté dans le champ texte s'il n'est pas vide
        if (!"".equals(texteChampAffichage)) {
            //analyse la chaîne de caractères
            valeurAffichee = formatNombres.parse(texteChampAffichage, new ParsePosition(0)).doubleValue();
        }

        Object sourceEvenement = eventClick.getSource(); // vérifie quel objet est à l'origine de l'évènement (click)

        /*Pour chaque bouton d'action, mémorise l'action
        sélectionnée, +, -, /, ou *, stocke la valeur courante
        dans la variable resultatCourant et vide le champ
        Affichage avant l'entrée du nombre suivant*/


        /* Effectue les calculs en fonction des actions choisies
         Modifie la valeur de la variable resultatCourant
         et affiche le resultat

         */

        double resultatIntermediaire = resultatCourant += valeurAffichee;


        if (sourceEvenement == parent.boutonAddition) {
            // ici code pour additionner 2 nombres
            actionChoisie = '+';
            resultatCourant = valeurAffichee;
            parent.champAffichage.setText("");

        } else if (sourceEvenement == parent.boutonSoustraction) {
            actionChoisie = '-';
            resultatCourant = valeurAffichee;
            parent.champAffichage.setText("");

        } else if (sourceEvenement == parent.boutonMultiplication) {
            actionChoisie = '*';
            resultatCourant = valeurAffichee;
            parent.champAffichage.setText("");

        } else if (sourceEvenement == parent.boutonDivision) {
            actionChoisie = '/';
            resultatCourant = valeurAffichee;
            parent.champAffichage.setText("");

        } else if (sourceEvenement == parent.boutonPourcentage) {
            actionChoisie = '%';
            resultatCourant = valeurAffichee;
            parent.champAffichage.setText("");

        } else if (sourceEvenement == parent.boutonClear) {
            actionChoisie = 'C';
            resultatCourant = valeurAffichee;
            parent.champAffichage.setText("");

        } else if (sourceEvenement == parent.boutonParentheseGauche) {
            actionChoisie = '(';
            resultatCourant = valeurAffichee;
            parent.champAffichage.setText("");

        } else if (sourceEvenement == parent.boutonParentheseDroite) {
            actionChoisie = ')';
            resultatCourant = valeurAffichee;
            parent.champAffichage.setText("");

        } else if (sourceEvenement == parent.boutonEgale) {

            // Convertit le resultat en le transformant en String
            // à l'aide de formatNombres
            if (actionChoisie == '+') {
                resultatIntermediaire = resultatCourant += valeurAffichee;
                parent.champAffichage.setText(formatNombres.format(resultatCourant));
            } else if (actionChoisie == '-') {
                resultatCourant -= valeurAffichee;
                parent.champAffichage.setText(formatNombres.format(resultatCourant));

            } else if (actionChoisie == '*') {
                resultatCourant *= valeurAffichee;
                parent.champAffichage.setText(formatNombres.format(resultatCourant));

            } else if (actionChoisie == '/') {
                resultatCourant /= valeurAffichee;
                parent.champAffichage.setText(formatNombres.format(resultatCourant));


              if (valeurAffichee == 0) {
                   try {

                       resultatCourant /= 0;
                       System.out.println("impossible de diviser par 0!");

                   } catch (Exception e) {
                    parent.champAffichage.setText("impossible de diviser par 0");
                }}
            } else if (actionChoisie == '%') {
                resultatCourant = (resultatCourant / 100);
                parent.champAffichage.setText(formatNombres.format(resultatCourant));

            }


        } else {
            // Pour tous les boutons numériques, ajoute le libellé du bouton au champ texte
            String libelleBoutonClique = boutonClique.getText();

            parent.champAffichage.setText(texteChampAffichage + libelleBoutonClique);


        }

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(int reason) {

    }
}
