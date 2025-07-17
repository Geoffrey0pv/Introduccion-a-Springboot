# 🎓 Academic Management WebApp

Aplicación web desarrollada con **Spring Boot**, **React** y **PostgreSQL** para la **gestión de matrículas universitarias**. Este proyecto forma parte de una iniciativa académica y tiene como objetivo simular el ciclo completo de registro, consulta y administración de estudiantes y asignaturas.

## 🚀 Tecnologías utilizadas

### Backend
- **Java 17**
- **Spring Boot**
- Spring Web
- Spring Data JPA
- PostgreSQL
- WebSockets
- Maven

### Frontend
- **React JS**
- Axios
- Bootstrap / CSS3
- WebSocket (cliente)

### Base de Datos
- PostgreSQL

## ⚙️ Funcionalidades principales

- 📋 Registro de estudiantes y asignaturas.
- ✅ Gestión de matrículas universitarias.
- 🔍 Consulta de información académica.
- 🧩 Comunicación en tiempo real con WebSockets.
- 📦 Arquitectura cliente-servidor (RESTful API).

## 📂 Estructura del proyecto

```

Academic\_Management\_Webapp/
│
├── Backend/        # Proyecto Spring Boot
│   ├── src/main/
│   └── pom.xml
│
├── Fronted/        # Proyecto React
│   └── src/
│
└── .gitignore

````

## 🧠 Aprendizajes clave

- Separación de responsabilidades entre frontend y backend.
- Consumo de APIs REST con React.
- Persistencia con JPA y PostgreSQL.
- Comunicación en tiempo real con WebSockets.
- Gestión de dependencias y estructura modular.

## 📦 Instalación y ejecución

### Requisitos previos
- Java 17+
- Node.js y npm
- PostgreSQL

### Pasos

1. Clonar el repositorio:
```bash
git clone https://github.com/Geoffrey0pv/Academic_Management_Webapp.git
````

2. Configurar la base de datos PostgreSQL:

   * Crear una base de datos (por ejemplo, `university_db`)
   * Configurar las credenciales en `application.properties`

3. Ejecutar el backend:

```bash
cd Backend
./mvnw spring-boot:run
```

4. Ejecutar el frontend:

```bash
cd Fronted
npm install
npm start
```

## 🧑‍💻 Autor

**Geoffrey Pasaje**

Desarrollador Java | Spring | React

[GitHub](https://github.com/Geoffrey0pv) | [LinkedIn](https://www.linkedin.com/in/geoffrey-esteban-pasaje-vidal-585108267/)

