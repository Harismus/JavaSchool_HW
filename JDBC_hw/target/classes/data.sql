
set schema public;

drop table IF EXISTS Factorial;

create table FACTORIAL (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    num INT NOT NULL,
    result INT NOT NULL
);

CREATE UNIQUE INDEX IF NOt EXISTS UNIQUE_NUMBER ON FACTORIAL(num, result);



