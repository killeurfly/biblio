CREATE TABLE livre (
    id      BIGSERIAL PRIMARY KEY,
    titre   VARCHAR(200) NOT NULL,
    auteur  VARCHAR(120) NOT NULL,
    isbn    VARCHAR(13)  NOT NULL UNIQUE,
    annee   INT
);
CREATE TABLE emprunt (
    id            BIGSERIAL PRIMARY KEY,
    livre_id      BIGINT       NOT NULL REFERENCES livre(id),
    emprunteur    VARCHAR(120) NOT NULL,
    date_emprunt  DATE         NOT NULL DEFAULT CURRENT_DATE,
    date_retour   DATE
);
INSERT INTO livre (titre, auteur, isbn, annee) VALUES
 ('Clean Code', 'Robert C. Martin', '9780132350884', 2008),
 ('Refactoring', 'Martin Fowler', '9780134757599', 2018),
 ('Domain-Driven Design', 'Eric Evans', '9780321125217', 2003);