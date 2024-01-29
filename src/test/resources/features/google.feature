# language: ca

Característica: Proves a Google

  Antecedents: Accedim a Google
    Donat que es navega a "www.google.cat"

  Esquema de l'escenari: : Buscar paraula
    Donat que sescriu al buscador "<Cerca>"
    Quan es pulsa Cerca a Google
    Aleshores es valida que apareix "<Resultat>"

    Exemples:
      | Cerca     | Resultat  |
      | Badalona  | resultats |
      | Barcelona | resultats |
