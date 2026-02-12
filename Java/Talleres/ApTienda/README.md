![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

# Tienda de Películas en Java

Aplicación de consola en Java para la gestión de una tienda de películas, desarrollada como parte de un taller universitario.

## 🎬 Características

- Menú interactivo por consola
- Gestión de catálogo de películas
- Carrito de compras
- Sistema de ventas
- Cálculo de precios con IVA
- Gestión de inventario

## 🛠️ Requisitos

- Java JDK 8 o superior
- Manejador de dependencias (opcional)

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/stiiven19/universidad.git
   cd universidad/Java/Talleres/ApTienda
   ```

2. Abre el proyecto en NetBeans

## 📝 Uso

1. Al iniciar la aplicación, se mostrará un menú con las siguientes opciones:
   - Consultas
   - Mostrar Catálogo de Películas
   - Hacer una Venta
   - Hacer un Pedido
   - Mostrar Dinero en Caja
   - Salir

2. Sigue las instrucciones en pantalla para navegar por las diferentes funcionalidades.

## 📚 Documentación Técnica

### Clase Principal: ApTienda
Maneja el flujo principal de la aplicación y la interfaz de usuario por consola.

### Clase Pelicula
- **Atributos**:
  - `codigo`: Identificador único de la película
  - `titulo`: Título de la película
  - `precioBase`: Precio base sin IVA
  - `cantidadActual`: Stock disponible

### Clase CarroCompra
Gestiona los artículos seleccionados por el cliente durante una compra.

### Clase ItemsCompra
Maneja la lógica de los ítems en el carrito de compras.

## Desarrollado por
Steven Guerrero - Ingeniero de sistemas
