# SPRING BOOT I

Ejercicio Spring Boot

## Parte 1. Internacionalización
Tomando como partida el código de la aplicación subido por el profesor, queremos hacer lo siguiente: :

Queremos realizar la internacionalización de la aplicación de tal manera que, dependiendo del idioma del usuario, nos devuelva los datos de la película en inglés, o en español.

Para ello vamos a tener que modificar el método GET de la instancia película (no hace falta que lo apliquemos al GET del listado general), de la siguiente manera: En caso de que la petición incluya un header: “accept-language” que contenga la cadena: “es-ES”, la aplicación devolverá los datos de la película en español

En caso de que la petición no contenga este header, o el header no contenga la cadena especificada arriba, deberemos responder con los datos de la película en inglés.

Para resolver este ejercicio tendremos que crear un nuevo servicio que nos proporcione películas en inglés. Dicho servicio deberá contener un array con un listado de películas en inglés.

### Peticiones de ejemplo:

````shell
curl --location --request GET 'http://localhost:8080/peliculas/1' \
--header 'accept-language: es-ES'
````

````shell
curl --location --request GET 'http://localhost:8080/peliculas/1' \
--header 'accept-language: en-EN'
````


## Parte 2. Filtrado por puntuación
Tomando como partida el código de la aplicación subido por el profesor, queremos hacer lo siguiente:

Realizar el filtrado de películas (método GET de /peliculas ) por puntuación máxima o puntuación mínima. Para ello debemos recibir un parámetro de URL con la puntuación máxima: “puntuacion.max” y otro con la puntuación mínima: “puntuacion.min”.

El método deberá responder correctamente tanto si se introduce un campo como si se introducen los dos o incluso ninguno.

El método deberá lanzar un error de tipo BAD_REQUEST en caso de que la puntuación máxima solicitada sea menor que la mínima solicitada.

### Peticiones de ejemplo

```shell
curl --location --request GET 'http://localhost:8080/peliculas?puntuacion.min=3&puntuacion.max=11'
```

```shell
curl --location --request GET 'http://localhost:8080/peliculas?puntuacion.max=11'
```

```shell
curl --location --request GET 'http://localhost:8080/peliculas?puntuacion.min=3'
```

## Parte 3. Soy una tetera
Tomando como partida el código de la aplicación subido por el profesor, queremos hacer lo siguiente:

Realizar un controlador que gestione peticiones al siguiente path: GET /tes

Y que nos devuelva con cada petición un error 418, junto a un mensaje de texto en el que podéis escribir lo que os apetezca.

Deberéis entregar todo el contenido de vuestra aplicación, comprimido en un zip para su corrección por el profesor.

### Petición de ejemplo
```shell
curl --location --request GET 'http://localhost:8080/tes'
```

## Parte 4. API de datos meteorológicos
Queremos realizar una aplicación que necesita obtener datos meteorológicos de una localidad u ubicación.

Necesitamos:

Tiempo actual, incluyendo: temperatura, precipitaciones, velocidad y dirección del viento.
Tiempo de los próximos tres días, incluyendo: estimación de temperatura, probabilidades de precipitación, y estimación de la velocidad del viento.
Evalúa apis de proveedores y determina cuál de ellas se ajusta a nuestras necesidades (podemos emplear varias en caso de ser necesario). Asimismo necesitamos saber el precio de cada una de ellas y cual sería más barata en el caso de que fuéramos a realizar un número elevado de peticiones.

Evalúa posibles problemas de seguridad en las diferentes APIS seleccionadas


## Parte 5 - ¿Que API crearías?

Partiendo de una aplicación existente, piensa una propuesta de cómo crearías la API para esa aplicación.
