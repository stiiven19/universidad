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

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:
   ```bash
   # Clona todo el repositorio (recomendado)
   git clone https://github.com/stiiven19/universidad.git
   cd universidad/Java/Talleres/ApTienda
   
   # O si solo quieres este proyecto
   # git clone https://github.com/stiiven19/universidad/Java/Talleres/ApTienda.git
   # cd ApTienda
   ```

2. Compila el proyecto:
   ```bash
   # Crea el directorio bin si no existe
   mkdir -p bin
   
   # Compila todos los archivos Java
   javac -d bin src/ApTienda/*.java
   ```

3. Ejecuta la aplicación:
   ```bash
   java -cp bin ApTienda.ApTienda
   ```

## 📋 Estructura del Proyecto

```
ApTienda/
├── src/
│   └── ApTienda/
│       ├── ApTienda.java      # Clase principal con el menú
│       ├── Pelicula.java      # Clase que representa una película
│       ├── CarroCompra.java   # Lógica del carrito de compras
│       ├── ItemsCompra.java   # Gestión de ítems de compra
│       └── Libro.java         # Clase adicional para futuras expansiones
├── .gitignore
└── README.md
```

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

## 📄 Licencia
Este proyecto fue desarrollado como parte de un taller universitario. Se proporciona "tal cual" sin garantías de ningún tipo.

## 🤝 Contribuciones
¡Las contribuciones son bienvenidas! Siéntete libre de enviar un Pull Request o reportar issues.

## 📧 Contacto
[steven guerrero](mailto:stiiven19lol@gmail.com) - [GitHub](https://github.com/stiiven19)

---

<div align="center">
  Hecho para el curso de Programación
</div>