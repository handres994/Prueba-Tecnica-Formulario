# 📋 Formulario de registro

Este proyecto es una **prueba técnica** que consiste en un formulario web donde un usuario puede **registrarse con sus datos personales**.  
La información que se digita en el formulario se guarda en una base de datos **MySQL** por medio de un servicio construido en **Java con Spring Boot**.  
La parte visual (interfaz) está hecha con **React** y se ejecuta con **Vite**.

---

## 🧰 Tecnologías usadas

- **Java + Spring Boot:** el motor que maneja la lógica y conecta con la base de datos.  
- **MySQL:** donde se guardan los datos de los clientes.  
- **React + Vite:** la parte visual de la página, lo que el usuario ve y usa.  
- **npm:** gestor que instala y ejecuta el proyecto del frontend.  

---

## ✅ Requisitos antes de empezar

Para que funcione el proyecto necesitas tener instalado en tu computador:

- **Java 17 o superior** → para ejecutar el backend.  
- **Node.js 18 o superior** → para ejecutar el frontend.  
- **MySQL 8 o superior** → para la base de datos.  
- **Git** → para clonar el repositorio.

---

## 📂 Estructura del proyecto

Dentro del repositorio verás 3 carpetas principales:

back/ → contiene el backend (Java + Spring Boot)
baseDatos/ → contiene los archivos SQL de la base de datos
front/ → contiene el frontend (React + Vite)

---

## 🗄️ Configuración de la base de datos

1. Abre **MySQL Workbench** (o tu herramienta favorita).  
2. Crea una base llamada `registro_clientes`.  
3. Importa el archivo que está en:
baseDatos/base_datos_clientes.sql

Este archivo ya contiene las tablas necesarias (clientes, países, ciudades).

---

## ▶️ Cómo ejecutar el proyecto

### Paso 1: Clonar el repositorio
Abre una consola y escribe:
git clone <url-del-repositorio>
cd Prueba-Tecnica-Formulario
Paso 2: Ejecutar el backend (Java + Spring Boot)
bash
Copiar código
cd back/FormularioInscripcion
./mvnw spring-boot:run
👉 Si todo funciona bien, el backend quedará corriendo en:
http://localhost:8080

Paso 3: Ejecutar el frontend (React + Vite)
Abre otra consola y escribe:

bash
Copiar código
cd front/formulario-registro
npm install
npm run dev
👉 Si todo funciona bien, abre tu navegador en:
http://localhost:5173

🔍 ¿Cómo sé que funciona?
Abre http://localhost:5173.

Diligencia el formulario de cliente (nombre, correo, ciudad, etc.).

Al guardar, los datos se envían al backend y se guardan en la base de datos.

Puedes comprobar en MySQL que los clientes quedaron registrados en la tabla.

💡 Nota importante
Si ves errores de conexión, revisa que MySQL esté encendido y que el usuario/contraseña estén bien configurados en el archivo:

Si el navegador bloquea la conexión, probablemente sea por CORS, que se puede habilitar en el backend (yo ya lo dejé configurado).


