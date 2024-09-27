Proyecto de Verificación de Palíndromos
Este proyecto es un servicio que verifica si una cadena de texto es un palíndromo. 
Utiliza Spring Boot para implementar una API REST que recibe cadenas y devuelve información sobre ellas, incluyendo:

Longitud total de la cadena.
Indicador de si la cadena es un palíndromo.
Conteo de caracteres especiales (excluyendo espacios).
Además, el servicio consume una API externa de mockapi.io para obtener una lista de ejemplos de cadenas a verificar.

Características
Validación de entradas: Se manejan excepciones personalizadas para entradas nulas o vacías y errores en el procesamiento.
Gestión de excepciones global: Utiliza un GlobalExceptionHandler para manejar excepciones de manera uniforme en toda la aplicación.
Compatibilidad con caracteres acentuados: Reconoce letras con tilde como caracteres válidos en las cadenas.
Consumo de API externa: Consume la API de mockapi.io para obtener ejemplos de cadenas que pueden ser verificadas como palíndromos.
Tecnologías Utilizadas
Java: Lenguaje de programación principal.
Spring Boot: Para construir la API REST.
RestTemplate: Para la comunicación con otros servicios (incluyendo la API de mockapi.io).
