SELECT NOMBRE FROM PRODUCTO;
SELECT NOMBRE, PRECIO FROM PRODUCTO;
SELECT * FROM PRODUCTO;
SELECT NOMBRE, ROUND(PRECIO) FROM PRODUCTO;
SELECT CODIGO_FABRICANTE FROM producto;
SELECT CODIGO_FABRICANTE FROM producto GROUP BY codigo_fabricante;
SELECT NOMBRE FROM FABRICANTE ORDER BY NOMBRE;
SELECT NOMBRE, PRECIO FROM PRODUCTO ORDER BY NOMBRE ASC, PRECIO DESC;
SELECT * FROM FABRICANTE limit 5;
SELECT NOMBRE, PRECIO FROM PRODUCTO
ORDER BY PRECIO LIMIT 1;
SELECT NOMBRE, PRECIO FROM PRODUCTO
ORDER BY PRECIO DESC LIMIT 1;
SELECT NOMBRE FROM PRODUCTO WHERE PRECIO=120;
SELECT * FROM PRODUCTO WHERE PRECIO between 60 AND 200;
SELECT * FROM PRODUCTO WHERE CODIGO IN (1,3,5);
SELECT NOMBRE FROM PRODUCTO WHERE NOMBRE LIKE '%Portátil%';
SELECT P.CODIGO,P.NOMBRE,F.CODIGO,F.NOMBRE FROM FABRICANTE F INNER JOIN PRODUCTO P;
SELECT P.NOMBRE,P.PRECIO,F.NOMBRE FROM FABRICANTE F INNER JOIN PRODUCTO P ORDER BY P.NOMBRE;
SELECT P.NOMBRE, P.PRECIO,F.NOMBRE FROM PRODUCTO P INNER JOIN FABRICANTE F ORDER BY P.PRECIO LIMIT 1;
SELECT * FROM PRODUCTO P INNER JOIN FABRICANTE F  WHERE F.NOMBRE LIKE 'Lenovo';
SELECT * FROM PRODUCTO P INNER JOIN FABRICANTE F  WHERE F.NOMBRE LIKE 'Crucial' AND P.PRECIO>200;
SELECT * FROM PRODUCTO P INNER JOIN FABRICANTE F WHERE F.NOMBRE IN ('Asus','Hewlett-Packard');
SELECT P.NOMBRE, P.PRECIO, F.NOMBRE FROM PRODUCTO P INNER JOIN FABRICANTE F WHERE P.PRECIO>=180 ORDER BY P.PRECIO ASC, P.NOMBRE DESC;
