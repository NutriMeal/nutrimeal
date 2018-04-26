insert into recette(ID_RECETTE, NOM_RECETTE)
values(1, 'Salade césar');

insert into recette(ID_RECETTE, NOM_RECETTE)
values(2, 'Steak frite');


insert into ingredient(ID_INGREDIENT, LIBELLE, VITAMINES, MINERAUX)
values (1, 'Carottes',405,438);

insert into ingredient(ID_INGREDIENT, LIBELLE, VITAMINES, MINERAUX)
values (2, 'Pommes de terre',410,39);

insert into ingredient(ID_INGREDIENT, LIBELLE, VITAMINES, MINERAUX)
values (3, 'Steak',40,48);


insert into recette_ingredient(ID_RECETTE, ID_INGREDIENT, QUANTITE)
values (1,2,34);

insert into recette_ingredient(ID_RECETTE, ID_INGREDIENT, QUANTITE)
values (1,1,2);

insert into recette_ingredient(ID_RECETTE, ID_INGREDIENT, QUANTITE)
values (2,3,10);

insert into recette_ingredient(ID_RECETTE, ID_INGREDIENT, QUANTITE)
values (2,1,3);

