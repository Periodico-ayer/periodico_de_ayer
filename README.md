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
- **Framework Backend:** Spring Boot 3.4.4
- **Base de Datos:** PostgreSQL 42.7.5
- **Base de Datos (tests):** H2 2.3
- **Gestión de Proyectos:** Trello
- **Control de Versiones:** Git - GitHub
- **Pruebas de API:** Postman 11.41
- **Testing:**
  - spring-boot-starter-test 3.4.4
  - Mockito JUnit 5.2
- **Configuración:** dotenv-java 3.0

## ✅ Funcionalidades

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

## 🚀 Cómo iniciar el proyecto

### Requisitos previos
- Java 21 instalado
- PostgreSQL instalado y en ejecución
- Maven o Gradle (según la configuración del proyecto)

### Pasos para iniciar el proyecto

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu-usuario/periodico-de-ayer-api.git
   cd periodico-de-ayer-api
   ```

2. **Configurar la base de datos**
   - Crear una base de datos en PostgreSQL:
   ```sql
   CREATE DATABASE periodico_de_ayer;
   ```

3. **Configurar las propiedades de conexión**
   - Editar el archivo `src/main/resources/application.properties` con los datos de tu conexión:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/periodico_de_ayeratasource.url=jdbc:postgresql://localhost:5432/periodico_de_ayer
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Postgre
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ```

4. **Compilar y ejecutar el proyecto**
   - Con Maven:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   - Con Gradle:
   ```bash
   gradle build
   gradle bootRun
   ```

5. **Verificar la instalación**
   - La API estará disponible en: `http://localhost:8080`
   - Puedes probar los endpoints con Postman o cualquier cliente HTTP

## 📊 Conexión con la base de datos

### Estructura de la base de datos
El proyecto utiliza JPA/Hibernate para la creación automática de las tablas en la base de datos. Las principales entidades son:

- **Usuario**: Almacena información de los usuarios que crean artículos
- **Artículo**: Contiene los artículos del periódico con sus propiedades

### Diagrama de la base de datos

## Licencia
Este proyecto está bajo la [Licencia de Producción entre Pares Feminista 2F2](https://labekka.red/licencia-f2f/).  
<br>
<img src="https://github.com/user-attachments/assets/90acbc07-7ba9-45e1-867b-6d284f4e6288" alt="f2f-license" width="150">
<br>
Puedes usarlo, modificarlo y compartirlo libremente. 🎉

Hecho con ❤️ por Alba Riera, Larissa Saud, Maria Bongoll, Marta Ibarra y Priscila Guillen.

## Hecho con amor

Este proyecto está elaborado con amor por los libros y la tecnología, con el objetivo de llevar la alegría de la lectura y una gestión eficiente a todas las personas. Ya seas desarrollador/a o entusiasta de los libros, esperamos que encuentres esta herramienta útil e inspiradora.

## Contactos

<table style="border-collapse: collapse; border: none;">
  <tr>
  <td align="center" style="border: none;">
      <br><b>Alba Riera</b>
      <br>
      <a href="https://www.linkedin.com/in/albamar%C3%ADarieravelazquez/">LinkedIn</a> |
      <a href="https://github.com/rieradipe")">GitHub</a>
    </td>
    <td align="center" style="border: none;">
      <br><b>Larissa Saud</b>
      <br>
      <a href="https://www.linkedin.com/in/larissasaud/">LinkedIn</a> |
      <a href="https://github.com/saudlari/">GitHub</a>
    <td align="center" style="border: none;">
      <br><b>Maria Bongoll</b>
      <br>
      <a href="https://www.linkedin.com/in/mariabongoll">LinkedIn</a> |
      <a href="https://github.com/Femcom-Mari">GitHub</a>
    </td>
    <td align="center" style="border: none;">
      <br><b>Marta Ibarra</b>
      <br>
      <a href="https://www.linkedin.com/in/marta-ibarra-cumbrero"/>LinkedIn</a> |
      <a href="https://github.com/Marpro24">GitHub</a>
    </td>    </td>
      <td align="center" style="border: none;">
      <br><b>Priscila Guillen de Oliveira</b>
      <br>
      <a href="https://www.linkedin.com/in/priscilaguillen/">LinkedIn</a> |
      <a href="https://github.com/pgoliv-code">GitHub</a>
    </td>
  </tr>
</table>

