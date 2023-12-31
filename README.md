# ppr-apibiblioteca

Este proyecto, desarrollado por **mrodriguezdev**, tiene como objetivo poner en práctica conocimientos en el desarrollo de microservicios y la implementación de arquitecturas de software, específicamente la arquitectura Hexagonal, también conocida 
como puertos y adaptadores. Para obtener más información sobre Quarkus, visita [quarkus.io](https://quarkus.io/).


> [!NOTE]
> **PPR:** Este proyecto es de carácter personal y se ha creado con el propósito de práctica y aprendizaje. La abreviatura "PPR" se refiere a "Proyecto Personal de Práctica".

## Descripción del proyecto
El proyecto consiste en desarrollar un sistema de gestión de biblioteca que permita a los usuarios buscar, reservar y administrar libros. La información detallada de los libros se obtendrá de una API externa.

## API Externa

Para obtener detalles específicos sobre los libros, nuestro sistema utiliza la API externa de **Google Books APIs**. Puedes encontrar más información sobre la API [aquí](https://developers.google.com/books).

## Documentación OpenAPI

La documentación OpenAPI proporciona una especificación detallada de la API del proyecto. 

```shell script
url=PATH/documentacion
```

## Variables de Entorno

Para ejecutar y configurar este proyecto, se deben definir las siguientes variables de entorno:

```shell script
DB_TYPE=< Tipo de base de datos (ejemplo: mysql, postgresql, sqlite, mongodb) >
DB_USER=< Nombre de usuario para acceder a la base de datos >
DB_PASSWORD=< Contraseña asociada al usuario de la base de datos >
DB_HOST=< Dirección del servidor de la base de datos >
DB_PORT=< Número de puerto en el que el servidor de la base de datos está escuchando >
DB_NAME=< Nombre de la base de datos que la aplicación utilizará >
GOOGLE_BOOKS_API=< URL de Google Books API >
ISSUER=< Identificador único de la entidad emisora del token JWT >
HOST_PUBLIC_KEY=< Dirección del servidor de la clave pública para verificar tokens JWT >
HOST_PRIVATE_KEY= < Dirección del servidor de la clave privada para firmar tokens JWT >
```

## Script de la Base de Datos

El script de la base de datos necesario para la configuración inicial del sistema se encuentra en el siguiente repositorio:

[Enlace al Script de la Base de Datos](https://github.com/mrodriguezdev/ppr-apibiblioteca-db-script)

Este script incluye la estructura de la base de datos y, en algunos casos, datos de ejemplo. Puedes utilizar este script para inicializar la base de datos del sistema.

**Instrucciones:**
1. Clona el repositorio en tu máquina local.
2. Ejecuta el script en tu servidor de base de datos para crear la estructura inicial y, si es necesario, cargar datos de ejemplo.

Ten en cuenta que este script está diseñado para funcionar con las variables de entorno definidas en este proyecto. Asegúrate de configurar las variables de entorno adecuadamente antes de ejecutar el script.
