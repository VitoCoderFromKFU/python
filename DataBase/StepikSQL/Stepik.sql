-- create table
CREATE TABLE book(
    book_id INT PRIMARY KEY,
    title VARCHAR2(50),
    author VARCHAR2(30),
    price NUMBER(8,2),
    amount INT,
    );

--drop/delete table
DROP TABLE book;
DELETE TABLE book;

--insert to table
INSERT INTO book(book_id,title,author,price,amount)
VALUES(1, 'Мастер и Маргарита', 'Булгаков М.А.',670.99,3);

--or short
INSERT INTO book VALUES(2, 'Капитанская дочка', 'Пушкин А.С.',1299.99,5);

--select all data of table
SELECT * FROM book

/*
structure of select
*key word SELECT
*list arrows with ","
*name table
*/
SELECT author,title,price FROM book

/*
Выборка новых столбцов и присвоение им новых имен
Для того чтобы отобрать данные из определенных столбцов таблицы и одновременно задать столбцам новые имена используется SQL запрос следующей структуры: 

*ключевое слово SELECT ; 
*имя столбца;
*ключевое слово AS ; 
*новое название столбца (можно русскими буквами), но это должно быть одно слово, если название состоит из двух слов – соединяйте их подчеркиванием, например, Количество_книг ; 
*запятая; 
*имя столбца; 
*.... 
*ключевое слово FROM ; 
*имя таблицы.
*/
SELECT title AS Название, amount FROM book;

/*
Выборка данных с созданием вычисляемого столбца
С помощью SQL запросов можно осуществлять вычисления по каждой строке таблицы с помощью вычисляемого столбца. 
Для него в списке полей после оператора SELECT указывается выражение и задается имя.


*/
SELECT title, amount, amount * 1.65 AS pack
FROM book


/*
Функция	Описание	Пример
CEILING(x)	возвращает наименьшее целое число, большее или равное x
(округляет до целого числа в большую сторону)	CEILING(4.2)=5
CEILING(-5.8)=-5

ROUND(x, k)	округляет значение x до k знаков после запятой,
если k не указано – x округляется до целого	ROUND(4.361)=4
ROUND(5.86592,1)=5.9

FLOOR(x)	возвращает наибольшее целое число, меньшее или равное x
(округляет до  целого числа в меньшую сторону)	FLOOR(4.2)=4
FLOOR(-5.8)=-6

POWER(x, y)	возведение x в степень y	POWER(3,4)=81.0

SQRT(x)	квадратный корень из x	SQRT(4)=2.0
SQRT(2)=1.41...

DEGREES(x)	конвертирует значение x из радиан в градусы	DEGREES(3) = 171.8...

RADIANS(x)	конвертирует значение x из градусов в радианы	RADIANS(180)=3.14...

ABS(x)	модуль числа x	ABS(-1) = 1
ABS(1) = 1

PI()	pi = 3.1415926...	 
*/
SELECT title, 
    price, 
    ROUND((price*18/100)/(1+18/100),2) AS tax, 
    ROUND(price/(1+18/100),2) AS price_tax 
FROM book;