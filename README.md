# Trabajo 2 Bases de Datos 2

### Santiago Rendón Giraldo
### Juan José Sapuyes Pino

## Requerimientos

* Java FX SDK 16 o superior. 
* Multichain 2 Community
* Multichain Java API 4
* JDK 15

Es necesario tener una blockchain llamada empresa con un stream llamado vendedores y otro ganancias. También se debe ejecutar el comando `multichaind empresa -daemon` para conectarnos y poder ejecutar el programa generado a través de JavaFX.

## Punto 1

Creamos e inicializamos la blockchain llamada *empresa*
```bat
multichain-util create empresa

multichaind empresa -daemon
```
Creamos los streams *vendedores* y *ganancias*
```bat
multichain-cli empresa create stream vendedores '{\"restrict\":\"write\"}'

multichain-cli empresa create stream ganancias '{\"restrict\":\"write\"}'
```
Creamos los smart filter

```bat
multichain-cli empresa create streamfilter vendedorfilter '{}' 'Filtro 1'


multichain-cli empresa create streamfilter gananciasfilter '{}' 'Filtro 2'
```
Nota: Ambos filtros se pueden encontrar en `cli-scripts/smart_filters.js` y
es necesario escapar las comillas dobles.


Finalmente, aprobamos los filtros
```bat
multichain-cli empresa approvefrom %address% vendedorfilter '{\"for\":\"vendedores\",\"approve\":true}'

multichain-cli empresa approvefrom %address% gananciasfilter '{\"for\":\"ganancias\",\"approve\":true}'
```


## Punto 2

La interfaz gráfica es bastante sencilla, utilizando JavaFX se hicieron las 4 vistas solicitadas y sus respectivos controladores. 

Antes de hacer el `LISTSTREAMITEMS` debemos suscribirnos con el comando `SUBSCRIBE`.

Para crear un vendedor recibimos los datos de la interfaz y los agregamos (nombre y telefono) a un JSON y los formateamos adecuadamente. Finalmente, los agregamos al stream con la cédula como llave, con el comando `PUBLISH` usando `Multichain Java API 4`.

Para registrar una ganancia se hace el mismo procedimiento, pero sólo se agrega el campo valor.

Para listar los vendedores y sus ganancias se usa el comando `LISTSTREAMITEMS` en cada stream y se hace el mapeo correspondiente.
