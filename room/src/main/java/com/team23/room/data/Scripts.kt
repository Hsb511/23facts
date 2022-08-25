package com.team23.room.data

object Scripts {
    const val categoriesScript = """
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('MA', 'Mathematics', 'Mathématique');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('PC', 'Physics & Chemistry', 'Physique Chimie');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('BG', 'Biology & Geology', 'Biologie & Géologie');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('ME', 'Medicine', 'Médecine');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('CS', 'Computer Science', 'Informatique');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('VG', 'Video Games', 'Jeux vidéo');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('MU', 'Music', 'Musique');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('MS', 'Movie & Series', 'Film & Séries');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('AE', 'Art', 'Art');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('SP', 'Sport', 'Sport');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('RM', 'Religion & Mythology', 'Religion & mythologie');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('PL', 'Politics & Law', 'Politique & Droit');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('AM', 'Military & Aviation', 'Militaire & aviation');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('HI', 'History', 'Histoire');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('GE', 'Geography', 'Géographie');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('BD', 'Famous Birth & Death', 'Naissance & Mort célèbres');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('RN', 'Records & News', 'Recors & Faits divers');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('IB', 'Industry & Business', 'Industrie & Commerce');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('FE', 'Finance & Economics', 'Finance & Economie');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('AT', 'Automotive & Transportation', 'Automobile & Transport');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('GF', 'Gastronomy & Food product', 'Gastronomie & Produit alimentaire');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('SM', 'Social Media', 'Réseau social');
        INSERT OR IGNORE INTO T_CATEGORY VALUES ('OT', 'Others', 'Autres');
    """
    const val factsScript = """
        INSERT OR IGNORE INTO T_FACT VALUES ('46', 'en', 'MA', 'The Birthday Paradox', 'https://images.unsplash.com/photo-1602631985686-1bb0e6a8696e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 'In a room of just 23 people there''s a 50-50 chance of at least two people having the same birthday.\nIn mathematics this is called the Birthday Paradox because we expect probabilities to be linear by only considering the scenarios we''re involved in.\n\nWe assume there are 365 equiprobable birthdays. The probability that each person has a unique birthday is: 364/365*363/365*...*343/365 ~ 0.4927.\nA contrario the probability that at least two persons share the same birthday is ~ 50.73%', 'https://en.wikipedia.org/wiki/Birthday_problem;https://pudding.cool/2018/04/birthday-paradox/;https://betterexplained.com/articles/understanding-the-birthday-paradox/ ');
        INSERT OR IGNORE INTO T_FACT VALUES ('46', 'fr', 'MA', 'Le Paradoxe des Anniversaires', 'https://images.unsplash.com/photo-1602631985686-1bb0e6a8696e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80', 'Dans une pièce où se trouvent 23 personnes, il y a une chance sur deux qu''au moins deux personnes aient le même anniversaire.\nEn mathématique ce phénomène est appelé le paradoxe des anniversaires, parce que l''on s''attend à ce que les probabilités soient linéaires, en ne considérant que les scénarios dans lesquels on est impliqué.\n\nOn suppose qu''il existe 365 anniversaires équiprobables. La probabilité que chaque personne ait un anniversaire unique est : 364/365*363/365*...*343/365 ~ 0.4927.\nA contrario la probabilité qu''il y a au moins deux personnes qui partagent le même anniversaire est donc d''environ 50.73%', 'https://fr.wikipedia.org/wiki/Paradoxe_des_anniversaires;https://pudding.cool/2018/04/birthday-paradox/;https://fr-academic.com/dic.nsf/frwiki/1290013;');
        INSERT OR IGNORE INTO T_FACT VALUES ('69', 'fr', 'MA', 'Les problèmes de Hilbert', 'https://miro.medium.com/max/1400/1*ahy12g2hFP21x7YolyQ_Ug.jpeg', 'Le 8 août 1900, à l''occasion du second Congrès International des mathématiciens à la Sorbonne, David Hilbert, né le 23 janvier 1862, énonça une liste de 23 problèmes qui devaient être pour lui un guide pour les recherches à venir. Leur résolution devait permettre aux mathématiciens de faire des progrès considérables dans leur science.', 'https://fr.m.wikipedia.org/wiki/Probl%C3%A8mes_de_Hilbert;https://www.bibmath.net/dico/index.php?action=affiche&quoi=./h/hilbertpbs.html ');
        INSERT OR IGNORE INTO T_FACT VALUES ('69', 'en', 'MA', 'Hilbert''s problems', 'https://miro.medium.com/max/1400/1*ahy12g2hFP21x7YolyQ_Ug.jpeg', 'On August 8th 1900 during the Second International Congress of Mathematicians at the Sorbonne, David Hilbert born in January 23rd 1862, presented unsolved problems that should be a guide for future researchs. Their resolution should influence and make considerable progress in science. ', 'https://en.m.wikipedia.org/wiki/Hilbert%27s_problems;https://mathworld.wolfram.com/HilbertsProblems.html ');
        INSERT OR IGNORE INTO T_FACT VALUES ('92', 'en', 'MA', 'The first problem of the Project Euler', 'https://pbs.twimg.com/profile_images/1586710859/Leonhard_Euler_400x400.jpg', 'Project Euler is a website launched on October 5th 2001 and containing a series of challenging mathematical or programming problems.\nThe first problem stems from the observation that if we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. The goal of this problem is to find the sum of all the multiples of 3 or 5 below 1000. The results is 233168', 'https://projecteuler.net/problem=1;https://en.m.wikipedia.org/wiki/Project_Euler#Example_problem_and_solutions');
        INSERT OR IGNORE INTO T_FACT VALUES ('92', 'fr', 'MA', 'Le premier problème du Projet Euler', 'https://pbs.twimg.com/profile_images/1586710859/Leonhard_Euler_400x400.jpg', 'Le Projet Euler est un site web lancé le 5 Octobre 2001 et qui contient une série de challenges mathématiques ou informatiques.\nLe premier problème part du constat que si on liste tous les nombres entiers inférieurs à 10 et divisibles par 3 ou 5 nous avons 3, 5, 6 et 9. La somme de ses chiffres est 2. Le but du problème est de calculer la somme des nombres entiers inférieurs à 1000 divisibles par 3 et 5. Le résultat de ce problème est 233168.', 'https://projecteuler.net/problem=1;https://fr.wikipedia.org/wiki/Project_Euler#Exemple_de_probl%C3%A8me_et_solutions;https://www.lucaswillems.com/fr/articles/26/project-euler-1-solution-python');
        INSERT OR IGNORE INTO T_FACT VALUES ('115', 'fr', 'MA', 'Le problème de Sun Zi', 'https://en.wikipedia.org/wiki/Sunzi_Suanjing#/media/File:Sun_Zi_Suanjing.JPG', 'La plus petite solution possible au problème de Sun Zi (mathématicien chinois du IIIe siècle) aussi appelé le problèmes des restes chinois est 23.\nDans le troisième chapitre du Sunzi suanjing (Manuel classique mathématique de Sunzi), le problème suivant est posé :\nOn ignore la quantité d’objets. Mais, en les rangeant par 3, il en reste 2, en les rangeant par 5, il en reste 3 et en les rangeant par 7, il en reste 2. Combien y a-t-il d''objets ?\nLa résolution passe par un système d''équations dans le monde des congruences. Les plus petites solutions sont 23, 128, 233, 338, 443, 548, ...', 'https://fr.wikipedia.org/wiki/Th%C3%A9or%C3%A8me_des_restes_chinois;http://villemin.gerard.free.fr/ThNbDemo/ModSunZi.htm');
        INSERT OR IGNORE INTO T_FACT VALUES ('115', 'en', 'MA', 'Sun Zi problem', 'https://en.wikipedia.org/wiki/Sunzi_Suanjing#/media/File:Sun_Zi_Suanjing.JPG', 'The smallest possible solution for the Sunzi problem (chinese mathematician from the 3rd century) also called the Chinese remainder problem is 23.\nIn the third chapter of the Sunzi suanjing (Sunzi classic mathematical textbook) the following problem is stated:\nSuppose there are an unknown number of objects. When counted in threes, 2 remain; when counted in fives, 3 remain; when counted in sevens, 2 remain. Question: How many objects are there?\nThis problem is a system of indeterminate equations. The smallest solutions are 23, 128, 233, 338, 443, 548, ...', 'https://math-physics-problems.fandom.com/wiki/Sunzi_Suanjing_Lower_Scroll_26;https://en.wikipedia.org/wiki/Chinese_remainder_theorem');
        INSERT OR IGNORE INTO T_FACT VALUES ('138', 'en', 'MA', 'Sum of 8 integral nonnegative cubes', 'https://mathshistory.st-andrews.ac.uk/Biographies/Dickson/Dickson_2.jpeg', 'In 1770 the british mathematician Edward Waring stated that every positive integer is a sum of nine integral nonnegative cubes.\nIn 1939 the american mathematician Leonard Eugene Dickson proved that every positive integer other than 23 and 239 is a sum of eight integral nonnegative cubes.', 'https://projecteuclid.org/journals/bulletin-of-the-american-mathematical-society-new-series/volume-45/issue-8/All-integers-except-23-and-239-are-sums-of-eight/bams/1183502007.full;https://en.wikipedia.org/wiki/Waring%27s_problem#The_number_g(k)');
        INSERT OR IGNORE INTO T_FACT VALUES ('138', 'fr', 'MA', 'Somme de 8 cubes entiers non négatifs', 'https://mathshistory.st-andrews.ac.uk/Biographies/Dickson/Dickson_2.jpeg', 'En 1770 le mathématicien britannique Edward Waring énonce que tout entier positif est la somme de neuf cubes entiers non négatifs.\nEn 1939 le mathématicien américain Leonard Eugene Dickson a prouvé que tout entier positif à l''exception de 23 et 239 est la somme de huit cubes entiers non-négatifs.', 'https://blogdemaths.wordpress.com/2017/01/01/2017-annee-des-cubes/#ref1;https://fr.wikipedia.org/wiki/Probl%C3%A8me_de_Waring;');
        INSERT OR IGNORE INTO T_FACT VALUES ('161', 'fr', 'MA', 'Problème du carré rigide', 'https://mathworld.wolfram.com/images/eps-svg/BracedSquareNonoverlapping_800.svg', 'Un triangle équilatéral est un polygône naturellement rigide. Il n''est pas possible de le déformer sans changer la longueur de ses côtés. Le problème est donc le suivant : Quelle est la quantité minimum de tiges de longueur unité nécessaires pour rigidifier un carré ?\nIl faut au moins 23 tiges de longueur unité pour rigidifier un carré sans qu''elles s''entrecroisent.\nLe minimum de tiges qui s''entrecroisent est de 15. Si on prend en compte 3 dimensions il suffit alors de 8 tiges.', 'http://villemin.gerard.free.fr/Geometri/CarRigid.htm');
        INSERT OR IGNORE INTO T_FACT VALUES ('161', 'en', 'MA', 'Braced square problem', 'https://mathworld.wolfram.com/images/eps-svg/BracedSquareNonoverlapping_800.svg', 'A equilateral triangle is naturally braced. It''s not possible to deform it without changing the length of its edges. The question is: What is the minimum required rods with unit length edges to make a square braced ?\nThe best answer with non-crossing rods is 23.\nWith crossing rods it''s 15 and in 3 dimensions it''s 8.', 'https://mathworld.wolfram.com/BracedPolygon.html;https://proofwiki.org/wiki/Square-Bracing_Problem/Non-Crossing_Rods');
        INSERT OR IGNORE INTO T_FACT VALUES ('184', 'fr', 'MA', 'Somme de 2 nombres d''Ulam', 'https://static.timesofisrael.com/www/uploads/2021/12/STAN_ULAM_HOLDING_THE_FERMIAC-e1639402905333-640x400.jpg', 'Les suites d''Ulam ont été introduites en 1964 par le mathématicien Stanislaw Ulam.\nLa suite standard d''Ulam (la suite Ulam(1,2)) commence avec U1 = 1 et U2 = 2. Puis pour n > 2 Un est le plus petit entier somme de deux termes distincts précédents de la suite, et d''une seule manière.\nLes premiers termes de la suite d''Ulam standard sont 1, 2, 3, 4, 6, 8, 11, 13, 16, 18, 26, ...\n23 est le plus petit entier positif qui ne peut pas être obtenu par la somme de deux nombres d''Ulam.', 'http://villemin.gerard.free.fr/aNombre/TYPSEQUE/Ulam.htm;http://jeux-et-mathematiques.davalan.org/mots/suites/ulam/index.html');
        INSERT OR IGNORE INTO T_FACT VALUES ('184', 'en', 'MA', 'Sum of 2 Ulam numbers', 'https://static.timesofisrael.com/www/uploads/2021/12/STAN_ULAM_HOLDING_THE_FERMIAC-e1639402905333-640x400.jpg', 'The Ulam numbers comprise an integer sequence devised by and named after Stanislaw Ulam, who introduced it in 1964.\nThe standard Ulam sequence (the (1, 2)-Ulam sequence) starts with U1 = 1 and U2 = 2. Then for n > 2, Un is defined to be the smallest integer that is the sum of two distinct earlier terms in exactly one way and larger than all earlier terms.\nThe first terms of the standard sequence are 1, 2, 3, 4, 6, 8, 11, 13, 16, 18, 26, ...\n23 is the smallest positive integer which is not the sum of two Ulam numbers from the standard Ulam sequence.', 'https://en.wikipedia.org/wiki/Ulam_number;https://proofwiki.org/wiki/23');
        INSERT OR IGNORE INTO T_FACT VALUES ('207', 'en', 'MA', 'Regular icositrigon', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Regular_polygon_23.svg/800px-Regular_polygon_23.svg.png', 'In geometry, an icositrigon is a 23-sided polygon.\nThe regular icositrigon is the first regular polygon that is not constructible with a compass and straight edge or with the aide of an angle trisector (since it is neither a Fermat prime nor a Pierpont prime), nor by neusis. It is thus not constructible with origami.', 'https://en.wikipedia.org/wiki/Icositrigon;https://en.wikipedia.org/wiki/Neusis_construction;https://en-academic.com/dic.nsf/enwiki/1226927');
        INSERT OR IGNORE INTO T_FACT VALUES ('207', 'fr', 'MA', 'Icosikaitrigone régulier', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Regular_polygon_23.svg/800px-Regular_polygon_23.svg.png', 'En géométrie, l''icosikatrigone est le polygône qui possède 23 côtés.\nL''icosikatrigone régulier est le premier polygône régulier qui n''est pas constructible avec un compas, une règle droite ou une trisectrice d''angle (comme ce n''est ni un nombre premier de Fermat ni de Pierpont), ni par neusis. Il n''est par conséquent pas possible de le construire en origami. ', 'http://villemin.gerard.free.fr/GeomLAV/Polygone/Poly23.htm;https://hmn.wiki/fr/Neusis_construction;https://fr-academic.com/dic.nsf/frwiki/2061348');
        INSERT OR IGNORE INTO T_FACT VALUES ('230', 'fr', 'MA', 'Nombre premier particulier', 'https://medias.pourlascience.fr/api/v1/images/view/5ca3f7948fe56f372349a085/wide_1300/image.jpg', 'Un nombre premier est un entier naturel qui admet exactement deux diviseurs distincts entiers et positifs.\n23 est le neuvième nombre premier. Il est en outre :\n- cousin avec 19 : paire de nombres premiers différents de 4\n- sexy avec 17 et 29 : paire de nombres premiers différents de 6\n- factoriel : nombre premier différent de plus ou moins 1 avec une factorielle\n- sûr et de Sophie-Germain avec 11 et 47: car de la forme 2p+1 avec p premier et car il vérifie la formule en tant que p\n- supersingulier : qui correspondant à une courbe elliptique ayant des propriétés exceptionnelles', 'https://fr.wikipedia.org/wiki/23_(nombre)#En_math%C3%A9matiques;https://www.pourlascience.fr/sd/mathematiques/nombres-premiers-des-jumeaux-des-cousins-et-des-nombres-sexy-16720.php');
        INSERT OR IGNORE INTO T_FACT VALUES ('230', 'en', 'MA', 'Peculiar prime number', 'https://medias.pourlascience.fr/api/v1/images/view/5ca3f7948fe56f372349a085/wide_1300/image.jpg', 'A prime number is a natural number greater than 1 that is not a product of two smaller natural numbers.\n23 is the ninth prime. It is also:\n- cousin with 19: prime numbers that differ from each other by four\n- sexy with 17 and 29: prime numbers that differ from each other by 6\n- factorial: prime number that is one less or one more than a factorial \n- safe and Sophie Germain with 11 and 47: if has the form if 2p + 1 with p also a prime  \n- supersingular: a supersingular prime for a given elliptic curve is a prime number with a certain relationship to that curve.', 'https://en.wikipedia.org/wiki/23_(number)#In_mathematics;https://prime-numbers.fandom.com/wiki/23#:~:text=23%20is%20a%20prime%20number,prime%20number%20from%201%2D100.');
        INSERT OR IGNORE INTO T_FACT VALUES ('253', 'fr', 'MA', 'Constante de Gelfond', 'https://prabook.com/web/alexander.gelfond/2564173', 'la constante de Gelfond est le nombre réel transcendant e^pi. Cette constante est nommé en l''honneur du mathématicien russe Alexandre Gelfond qui prouva sa transcendance en 1929 et est un cas particulier du 7e probleme de Hilbert. \nLe nombre entier le plus proche de cette constante est 23 car elle vaut environ 23,14069 ', 'http://www.maeckes.nl/Constante%20van%20Gelfond%20FR.html;https://fr.wikipedia.org/wiki/Constante_de_Gelfond;https://fr-academic.com/dic.nsf/frwiki/1527908');
        INSERT OR IGNORE INTO T_FACT VALUES ('253', 'en', 'MA', 'Gelfond''s constant', 'https://prabook.com/web/alexander.gelfond/2564173', 'In mathematics, Gelfond''s constant is the real transcendental number e^pi. It is named after Aleksandr Gelfond, a russian mathematician who proved its transcendance in 1929 and is mention in Hilbert''s seventh problem.\nThe closest integer of Gelfond''s constant is 23 because its value is approximatively 23.14069.', 'https://mathworld.wolfram.com/GelfondsConstant.html;https://en.wikipedia.org/wiki/Gelfond%27s_constant;https://terrytao.wordpress.com/2011/08/21/hilberts-seventh-problem-and-powers-of-2-and-3/');
        INSERT OR IGNORE INTO T_FACT VALUES ('276', 'fr', 'MA', 'Propriétés dans différentes bases', 'https://diconombre.pagesperso-orange.fr/Nb23Nb.htm', 'En base 7 le nombre 23 s''écrit 32 et est donc le même chiffre écrit à l''envers.\nEn base 16 le nombre décimal 232323 s''écrit 38B83 et est donc un palindrome.\nEn base 10 le nombre hexadécimal 232323 vaut environ 23 * 10^5.\nEn base 2, 23 s''écrit 10111 donc sous la forme 10 puis 3 fois 1. C''est une particularité des nombres de Thabit qui s''écrivent sous la forme 3 * 2^n - 1 = = 2^(n + 1) + (2^n – 1). Cette dernière égalité explique la forme binaire.', 'https://diconombre.pagesperso-orange.fr/Nb23Nb.htm;https://fr.wikipedia.org/wiki/Nombre_de_Thebit');
        INSERT OR IGNORE INTO T_FACT VALUES ('276', 'en', 'MA', 'Properties in different bases', 'https://diconombre.pagesperso-orange.fr/Nb23Nb.htm', 'The representation of 23 in base 7 is 32 the same number inverted.\nThe representation of 232323 in base 16 is 38B83 and thus a palindrome.\nThe number of (232323)_16 in base 10 is approximatedly 23 * 10^5\nThe binary representaiton of 23 is 10111 it consists "10" followed by n 1s. This is a particularity of the Thabit Numbers: integers of the form 3 * 2^n - 1 = 2^(n + 1) + (2^n - 1). This last equity explains the binary form.', 'https://en.wikipedia.org/wiki/Thabit_number');
        """
}