# Periódico de ayer API

## 🗞️ Gestión de Artículos para el "Periódico de ayer"

El señor Héctor Lavoe nos ha encomendado la construcción de una API para gestionar los artículos de un periódico digital llamado "Periódico de ayer". Esta API permitirá a los usuarios interactuar con los artículos a través de diversas funcionalidades.

## 🎯 Objetivos

El objetivo principal es desarrollar una API REST utilizando Spring Boot que permita la gestión de artículos en un periódico digital. Esta API sigue una arquitectura MVC de 3 capas, tiene un estilo cliente-servidor (tipo API Rest) y se conecta a una base de datos PostgreSQL.

## 📓 Competencias Técnicas

Este proyecto desarrolla las siguientes competencias técnicas:

- **Backend Development:** Construcción de la lógica del servidor y la API.
- **Database Creation:** Diseño y creación de la base de datos.
- **Data Access Components:** Desarrollo de los componentes para interactuar con la base de datos.

## 💻 Tecnologías y Herramientas

Las siguientes tecnologías y herramientas han sido utilizadas en este proyecto:

- **Lenguaje de Programación:** Java 21
- **Framework Backend:** Spring Boot
- **Base de Datos:** PostgreSQL
- **Gestión de Proyectos:** Trello
- **Control de Versiones:** Git - GitHub
- **Pruebas de API:** Postman

## ✅ Requisitos Funcionales

La API permite:

- **Crear un artículo:** Permite la creación de un nuevo artículo especificando su título, contenido, fecha de publicación, categoría y el usuario que lo crea.
- **Listar todos los artículos:** Muestra una lista de todos los artículos disponibles en el periódico.
- **Obtener un artículo por ID:** Recupera un artículo específico utilizando su identificador único.
- **Actualizar un artículo:** Modifica el contenido de un artículo existente.
- **Eliminar un artículo:** Elimina un artículo del sistema.
- **Crear un usuario:** Permite la creación de un nuevo usuario con nombre y correo electrónico (sin necesidad de autenticación o autorización en esta fase).
- **Relación Usuario-Artículo (Uno-a-Muchos):** Un usuario puede crear y tener múltiples artículos asociados.
- **Relación Artículo-Usuario (Muchos-a-Uno):** Cada artículo pertenece a un único usuario creador.
- **Validación del Título:** El título del artículo no debe estar vacío y no debe exceder los 255 caracteres.
- **Validación del Contenido:** El contenido del artículo no debe estar vacío, debe tener al menos 50 caracteres y un máximo de 2000 caracteres.
- **Eliminación en Cascada:** Si un usuario es eliminado, todos sus artículos asociados también deben ser eliminados automáticamente de la base de datos.

## ✨ Autoras

- Alba Riera
- Larissa Santos
- Marta Ibarra
- Priscila Guillén
