CREATE DATABASE IF NOT EXISTS biblio_alexandria;
USE biblio_alexandria;

CREATE TABLE IF NOT EXISTS Usuario(
	usuario_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
	senha VARCHAR(255) NOT NULL,
	telefone VARCHAR(18) UNIQUE,
	alerta BOOLEAN NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS Autor(
	autor_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	biografia TEXT NOT NULL,
	nacionalidade VARCHAR(255) NOT NULL,
	data_nascimento DATE NOT NULL,
	data_morte DATE    
);

CREATE TABLE IF NOT EXISTS Livro(
	livro_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	titulo VARCHAR(255) NOT NULL,
	descricao TEXT NOT NULL,
	nota DECIMAL(4, 2) NOT NULL DEFAULT 0.00,
	ano YEAR NOT NULL,
	autor BIGINT NOT NULL,
	FOREIGN KEY(autor) REFERENCES Autor(autor_id)
);

CREATE TABLE IF NOT EXISTS Avaliacao(
	avaliacao_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	nota DECIMAL(4, 2) NOT NULL,
	usuario BIGINT NOT NULL,
	livro BIGINT NOT NULL,
	FOREIGN KEY(usuario) REFERENCES Usuario(usuario_id),
	FOREIGN KEY(livro) REFERENCES Livro(livro_id)
);

CREATE TABLE IF NOT EXISTS Emprestimo(
	emprestimo_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	data_emprestimo DATETIME NOT NULL,
	data_devolucao DATE NOT NULL,
	usuario BIGINT NOT NULL,
	livro BIGINT NOT NULL,
	FOREIGN KEY(usuario) REFERENCES Usuario(usuario_id),
	FOREIGN KEY(livro) REFERENCES Livro(livro_id)
);

DELETE FROM Autor WHERE autor_id<=38;

INSERT INTO Autor(autor_id, nome, biografia, nacionalidade, data_nascimento, data_morte) VALUES
    (1, "Machado de Assis", "Considerado o maior escritor brasileiro, sua obra abrange desde o romantismo até o realismo, com destaque para romances como 'Dom Casmurro' e 'Memórias Póstumas de Brás Cubas'. Foi também poeta, ensaísta e dramaturgo.", "Brasileiro", "1839-06-21", "1908-09-29"),
    (2, "Fiódor Dostoiévski", "Um dos maiores escritores da literatura russa, conhecido por suas obras psicológicas e filosóficas, como 'Crime e Castigo' e 'Os Irmãos Karamazov'.", "Russo", "1821-11-11", "1881-02-09"),
    (3, "Jane Austen", "Escritora inglesa cujas obras abordam questões de classe, casamento e moralidade na sociedade britânica do século XIX. Seus livros mais famosos incluem 'Orgulho e Preconceito' e 'Emma'.", "Britânica", "1775-12-16", "1817-07-18"),
    (4, "Gabriel García Márquez", "Escritor colombiano, líder do movimento realismo mágico, autor de 'Cem Anos de Solidão', uma das obras mais importantes da literatura latino-americana.", "Colombiano", "1927-03-06", "2014-04-17"),
    (5, "F. Scott Fitzgerald", "Autor americano, famoso por seu romance 'O Grande Gatsby', que aborda a decadência e o materialismo da sociedade americana nos anos 1920.", "Americano", "1896-09-24", "1940-12-21"),
    (6, "George Orwell", "Escritor e jornalista britânico, conhecido por sua crítica ao totalitarismo, especialmente nas obras '1984' e 'A Revolução dos Bichos'.", "Britânico", "1903-06-25", "1950-01-21"),
    (7, "Franz Kafka", "Escritor de língua alemã, conhecido por sua escrita existencialista e pela criação de mundos surreais e angustiantes, como em 'A Metamorfose' e 'O Processo'.", "Alemão", "1883-07-03", "1924-06-03"),
    (8, "Jean-Paul Sartre", "Filósofo, dramaturgo e romancista francês, um dos principais expoentes do existencialismo, autor de 'A Náusea' e 'A Idade da Razão'.", "Francês", "1905-06-21", "1980-04-15"),
    (9, "Harper Lee", "Escritora americana conhecida por seu único romance, 'O Sol é Para Todos', que aborda questões de racismo e justiça nos Estados Unidos.", "Americana", "1926-04-28", "2016-02-19"),
    (10, "Milan Kundera", "Escritor e ensaísta tcheco, conhecido por obras como 'A Insustentável Leveza do Ser', que explora o amor, a política e a história.", "Tcheco", "1929-04-01", ""),
    (11, "J.D. Salinger", "Escritor americano, famoso por seu romance 'O Apanhador no Campo de Centeio', que aborda a adolescência e a alienação.", "Americano", "1919-01-01", "2010-01-27"),
    (12, "Albert Camus", "Filósofo e escritor francês, associado ao existencialismo e ao absurdismo, é famoso por obras como 'O Estrangeiro' e 'A Peste'.", "Francês", "1913-11-07", "1960-01-04"),
    (13, "Oscar Wilde", "Escritor e dramaturgo irlandês, conhecido por suas obras satíricas e pelo uso do paradoxo, como em 'O Retrato de Dorian Gray'", "Irlandês", "1854-10-16", "1900-11-30"),
    (14, "J.R.R. Tolkien", "Filólogo e escritor britânico, autor da trilogia 'O Senhor dos Anéis' e 'O Hobbit', sendo considerado o pai da fantasia moderna.", "Britânico", "1892-01-03", "1973-09-02"),
    (15, "Mark Twain", "Escritor americano, conhecido por suas sátiras e pelo estilo humorístico, sendo 'As Aventuras de Huckleberry Finn' uma de suas obras-primas.", "Americano", "1835-11-30", "1910-04-21"),
    (16, "Charlotte Brontë", "Escritora inglesa, famosa por seu romance 'Jane Eyre', que explora questões de amor, independência e identidade feminina.", "Britânica", "1816-04-21", "1855-03-31"),
    (17, "Emily Brontë", "Escritora inglesa, autora de 'O Morro dos Ventos Uivantes', um romance gótico e sombrio, focado nas obsessões e paixões intensas dos personagens.", "Britânica", "1818-07-30", "1848-12-19"),
    (18, "Homero", "Poeta grego antigo, considerado o autor dos épicos 'A Ilíada' e 'A Odisseia', que são pilares da literatura ocidental.", "Grego", "100-01-01", "100-01-01"),
    (19, "Dante Alighieri", "Poeta e filósofo italiano, autor da 'Divina Comédia', uma das maiores obras da literatura mundial, que descreve a jornada pelo Inferno, Purgatório e Paraíso.", "Italiano", "1265-06-01", "1321-09-14"),
    (20, "Hermann Hesse", "Escritor e poeta alemão-suíço, conhecido por suas obras introspectivas como 'O Lobo da Estepe' e 'Siddhartha'.", "Alemão-Suíço", "1877-07-02", "1962-08-09"),
    (21, "Italo Calvino", "Escritor italiano, conhecido por suas obras de ficção científica e fantasia, como 'O Barão nas Árvores' e 'As Cidades Invisíveis'.", "Italiano", "1923-10-15", "1985-09-19"),
    (22, "José de Alencar", "Romancista, dramaturgo e político brasileiro, conhecido por obras como 'Iracema' e 'Senhora', que exploram a cultura e os mitos brasileiros.", "Brasileiro", "1829-05-01", "1877-12-12"),
    (23, "Alexandre Dumas", "Escritor francês, famoso por seus romances de capa e espada, como 'O Conde de Monte Cristo' e 'Os Três Mosqueteiros'.", "Francês", "1802-07-24", "1870-12-05"),
    (24, "Khaled Hosseini", "Escritor afegão, autor de 'O Caçador de Pipas' e 'A Cidade do Sol', que abordam os conflitos no Afeganistão e a experiência humana.", "Afegão", "1965-03-04", ""),
    (25, "Edgar Allan Poe", "Poeta, escritor e crítico americano, mestre do conto policial e gótico, famoso por obras como 'O Corvo' e 'O Coração Delator'.", "Americano", "1809-01-19", "1849-10-07"),
    (26, "William Golding", "Escritor britânico, conhecido por seu romance 'O Senhor das Moscas', que explora a natureza humana e a violência.", "Britânico", "1911-09-19", "1993-06-19"),
    (27, "James Joyce", "Escritor irlandês, uma das figuras mais influentes da literatura moderna, autor de 'Ulisses' e 'Retrato do Artista Quando Jovem'.", "Irlandês", "1882-02-02", "1941-01-13"),
    (28, "Herman Melville", "Escritor americano, conhecido por seu romance 'Moby Dick', uma história de vingança e obsessão contra uma baleia.", "Americano", "1819-08-01", "1891-09-28"),
    (29, "John Boyne", "Escritor irlandês, autor de 'O Menino do Pijama Listrado', um conto comovente ambientado durante o Holocausto.", "Irlandês", "1971-04-30", ""),
    (30, "Frances Hodgson Burnett", "Escritora inglesa-americana, conhecida por obras infantis como 'O Jardim Secreto' e 'A Princesinha'.", "Britânica", "1849-11-24", "1924-10-29"),
    (31, "Ernest Hemingway", "Escritor americano, premiado com o Nobel, conhecido por seu estilo enxuto e por obras como 'O Velho e o Mar'.", "Americano", "1899-07-21", "1961-07-02"),
    (32, "Joseph Conrad", "Escritor inglês de origem polonesa, autor de 'Coração das Trevas', obra crítica ao colonialismo e à natureza humana.", "Polonês-Inglês", "1857-12-03", "1924-08-03"),
    (33, 'Guimarães Rosa', 'Considerado um dos maiores escritores brasileiros do século XX, Guimarães Rosa explorou a cultura e a linguagem do sertão brasileiro em obras como "Grande Sertão: Veredas" e "Primeiras Estórias".', 'Brasileiro', '1908-06-27', '1967-12-19'),
    (34, 'Bram Stoker', 'Escritor irlandês, famoso por seu romance gótico "Drácula", que se tornou um dos mais importantes da literatura de terror.', 'Irlandês', '1847-11-08', '1912-04-20'),
    (35, 'Mary Shelley', 'Autora inglesa, conhecida por seu clássico "Frankenstein", uma das primeiras obras de ficção científica que explora a ética da criação de vida e os limites da ciência.', 'Britânica', '1797-08-30', '1851-02-01'),
    (36, 'Jules Verne', 'Escritor francês, um dos pioneiros da ficção científica, conhecido por suas aventuras épicas como "Vinte Mil Léguas Submarinas" e "A Volta ao Mundo em Oitenta Dias".', 'Francês', '1828-02-08', '1905-03-24'),
    (37, 'José Saramago', 'Escritor português, vencedor do Prêmio Nobel de Literatura, suas obras frequentemente abordam temas filosóficos e políticos, como "O Ensaio Sobre a Cegueira" e "A Caverna".', 'Português', '1922-11-16', '2010-06-18'),
    (38, 'Clarice Lispector', 'Uma das mais importantes escritoras brasileiras, conhecida por sua escrita introspectiva e sensível, com obras como "A Hora da Estrela" e "Perto do Coração Selvagem".', 'Brasileira', '1920-12-10', '1977-12-09');

DELETE FROM Livro WHERE livro_id<=44;

INSERT INTO Livro(livro_id, titulo, ano, descricao, autor_id) VALUES
    (1, "Dom Casmurro", 1899, "Romance que explora a dúvida e o ciúmes de Bentinho, o protagonista, sobre o comportamento de sua esposa Capitu.", 1), -- Machado de Assis
    (2, "Memórias Póstumas de Brás Cubas", 1881, "Narrativa do ponto de vista de Brás Cubas, um defunto que reflete sobre sua vida.", 1), -- Machado de Assis
    (3, "Crime e Castigo", 1866, "A luta interna de Raskólnikov, que mata uma velha usurária e enfrenta os dilemas morais de sua consciência.", 2), -- Fiodor Dostoiévski
    (4, "Orgulho e Preconceito", 1813, "A história de Elizabeth Bennet e sua relação com o rico, mas orgulhoso, Mr. Darcy.", 3), -- Jane Austen
    (5, "Cem Anos de Solidão", 1967, "A saga da família Buendía na fictícia Macondo, mistura de realidade e magia.", 4), -- Gabriel García Márquez
    (6, "O Grande Gatsby", 1925, "Um retrato da década de 1920 nos EUA, explorando a decadência, os sonhos e a busca por felicidade de Jay Gatsby.", 5), -- F. Scott Fitzgerald
    (7, "1984", 1949, "Uma sociedade distópica onde o governo controla a informação e a individualidade é erradicada.", 6), -- George Orwell
    (8, "A Metamorfose", 1915, "A história de Gregor Samsa, que acorda transformado em inseto e se torna um reflexo da alienação social.", 7), -- Franz Kafka
    (9, "A Náusea", 1938, "Um retrato existencialista da crise de identidade e o absurdo da existência de Antoine Roquentin.", 8), -- Jean-Paul Sartre
    (10, "O Sol é Para Todos", 1960, "A luta contra o racismo e a injustiça social na fictícia cidade de Maycomb, através dos olhos de Scout Finch.", 9), -- Harper Lee
    (11, "A Insustentável Leveza do Ser", 1984, "A história de quatro personagens cujas vidas se entrelaçam em meio ao regime comunista na Tchecoslováquia.", 10), -- Milan Kundera
    (12, "O Apanhador no Campo de Centeio", 1951, "A jornada de Holden Caulfield, um jovem rebelde em busca de identidade e verdade no mundo adulto.", 11), -- J.D. Salinger
    (13, "O Estrangeiro", 1942, "Meursault, um homem indiferente à vida, enfrenta as consequências de seus atos em uma sociedade que não o compreende.", 12), -- Albert Camus
    (14, "O Retrato de Dorian Gray", 1890, "Um jovem que faz um pacto para que seu retrato envelheça no seu lugar, enquanto ele permanece jovem e belo.", 13), -- Oscar Wilde
    (15, "O Senhor dos Anéis", 1954, "A luta épica entre o bem e o mal na Terra-média, em uma jornada liderada por Frodo Baggins.", 14), -- J.R.R Tolkien
    (16, "As Aventuras de Huckleberry Finn", 1884, "As peripécias de Huck, um garoto que foge de seu pai e se junta a Jim, um escravo fugitivo.", 15), -- Mark Twan
    (17, "Jane Eyre", 1847, "A história da órfã Jane, que enfrenta adversidades e se apaixona por seu empregador, o misterioso Sr. Rochester.", 16), -- Charlotte Brontë
    (18, "O Morro dos Ventos Uivantes", 1847, "O drama trágico e obsessivo de Heathcliff e Catherine, cujas vidas se entrelaçam em um ciclo de amor e vingança.", 17), -- Emily Brontë
    (19, "A Odisseia", 100, "A jornada épica de Ulisses para retornar a Ítaca após a guerra de Troia, enfrentando deuses e monstros.", 18), -- Homero
    (20, "A Divina Comédia", 1320, "A viagem de Dante pelos três reinos do além: Inferno, Purgatório e Paraíso.", 19), -- Dante Alighieri
    (21, "O Processo", 1925, "A história de Josef K., um homem preso por um crime que nunca é revelado, refletindo sobre a burocracia e a alienação.", 7), -- Franz Kafka
    (22, "Grande Sertão: Veredas", 1956, "A luta entre o bem e o mal no sertão, narrada por Riobaldo, um jagunço que se apaixona e questiona seu destino.", 33), -- Guimarães Rosa
    (23, "Drácula", 1897, "O famoso conto gótico sobre o Conde Drácula e sua busca por novas vítimas na Inglaterra.", 34), -- Bram Stoker
    (24, "Frankenstein", 1818, "A história de Victor Frankenstein, que cria um monstro que se volta contra seu criador em uma busca por aceitação.", 35), -- Mary Shelley
    (25, "O Senhor das Moscas", 1954, "A história de um grupo de meninos que se perde em uma ilha deserta e gradualmente se transforma em selvagens.", 26), -- William Golding
    (26, "Ulisses", 1922, "A jornada de Leopold Bloom através de um único dia em Dublin, em uma obra que mistura a realidade e o mito.", 27), -- James Joyce
    (27, "O Conde de Monte Cristo", 1844, "A história de Edmond Dantès, que busca vingança contra aqueles que o traíram.", 23), -- Alexandre Dumas
    (28, "O Caçador de Pipas", 2003, "Um relato sobre amizade, redenção e culpa, ambientado no Afeganistão em meio à guerra.", 24), -- Khaled Hosseini
    (29, "O Corvo", 1845, "O poema gótico e sombrio de Edgar Allan Poe, onde um homem é atormentado por um corvo que repete 'Nevermore'.", 25), -- Edgar Allan Poe
    (30, "O Lobo da Estepe", 1927, "A história de Harry Haller, um homem dividido entre seu lado humano e sua natureza selvagem, em uma jornada de autodescoberta.", 20), -- Hermann Hesse
    (31, "O Barão nas Árvores", 1957, "A história de Cosimo, que decide viver nas árvores e recusa-se a viver na sociedade, em um conto repleto de simbolismo.", 21), -- Italo Calvino
    (32, "O Primo Basílio", 1882, "Romance que explora a infidelidade e os conflitos familiares na sociedade do século XIX.", 22), -- José de Alencar
    (33, "Os Irmãos Karamazov", 1880, "A história de uma família marcada por um pai decadente e filhos com diferentes destinos e filosofias de vida.", 2), -- Fiódor Dostoiévski
    (34, "O Hobbit", 1937, "A jornada de Bilbo Baggins, que sai de sua zona de conforto para enfrentar dragões e recuperar um tesouro.", 14), -- J.R.R Tolkien
    (35, "Vinte Mil Léguas Submarinas", 1870, "Aventura de exploração submarina com o Capitão Nemo e sua misteriosa nave, o Nautilus.", 36), -- Jules Verne
    (36, "A caverna", 2000, "A história de um oleiro que, ao perceber o controle externo sobre sua arte, tenta entender os limites da liberdade humana.", 37), -- José Saramago
    (37, "O Encontro Marcado", 1956, "A história de Vanzolini, um personagem que questiona a vida e busca um significado em suas relações.", 38), -- Clarice Lispector
    (38, "Moby Dick", 1851, "A obsessão de Capitão Ahab em caçar a baleia branca que lhe arrancou a perna.", 28), -- Herman Melville
    (39, "O Menino do Pijama Listrado", 2006, "A história de um garoto que faz amizade com um prisioneiro de um campo de concentração nazista.", 29), -- John Boyne
    (40, "O Jardim Secreto", 1911, "A transformação de um jardim abandonado em um local de cura e renovação para os personagens.", 30), -- Frances Hodgson Burnett
    (41, "O Velho e o Mar", 1952, "A luta de Santiago, um velho pescador cubano, contra um marlin gigantesco em uma batalha épica de resistência.", 31), -- Ernest Hemingway
    (42, "Coração das Trevas", 1899, "A viagem de Marlow, que explora a escuridão da África e da natureza humana.", 32), -- Joseph Conrad
    (43, "O Velho e o Mar", 1952, "A luta de Santiago, um velho pescador cubano, contra um marlin gigantesco em uma batalha épica de resistência.", 31), -- Ernest Hemingway
    (44, "A Revolução dos Bichos", 1945, "Uma fábula política sobre uma revolução de animais que substituem seus opressores humanos.", 6); -- George Orwell