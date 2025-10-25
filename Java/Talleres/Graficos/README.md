# 🎨 Proyecto de Gráficos por Computadora

Este proyecto implementa un sistema de gráficos 2D desde cero en Java, comenzando con operaciones básicas de píxeles hasta formas geométricas complejas. Es una herramienta educativa que demuestra los algoritmos fundamentales de gráficos por computadora.

## 🚀 Características Principales

- **Dibujo de formas básicas**: Píxeles, líneas, círculos, rectángulos, triángulos, etc.
- **Algoritmos clásicos**: Incluye implementaciones de algoritmos fundamentales de gráficos
- **Interfaz interactiva**: Permite dibujar formas con el ratón
- **Sistema de capas**: Soporte para múltiples formas superpuestas
- **Personalización**: Varios estilos de línea y colores predefinidos

## 📂 Estructura del Proyecto

```
src/Graficos/
├── Shape.java            # Clase base abstracta para todas las formas
├── FrameShapes.java      # Ventana principal de la aplicación
├── DrawingPanel.java     # Área de dibujo personalizada
├── Pixel.java            # Implementación de píxel individual
├── Linea.java            # Algoritmo de dibujo de líneas
├── Circulo.java          # Algoritmo del punto medio para círculos
├── Cuadrado.java         # Implementación de cuadrados
├── Rectangulo.java       # Implementación de rectángulos
├── Tequilatero.java      # Triángulo equilátero
├── Trectangulo.java      # Triángulo rectángulo
├── Pentagono.java        # Implementación de pentágonos
├── Cubo.java             # Representación 3D de un cubo
└── Cubop.java            # Versión alternativa del cubo
```

## 🛠️ Requisitos

- Java JDK 17 o superior
- IDE compatible con Java (Eclipse, IntelliJ, VS Code, etc.)
- Maven (para la gestión de dependencias, si se agregan en el futuro)

## 🚀 Cómo Ejecutar

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/graficos.git
   cd graficos
   ```

2. Abre el proyecto en tu IDE preferido

3. Ejecuta la clase principal:
   ```
   Graficos.FrameShapes
   ```

## 🎯 Uso Básico

1. **Dibujar formas**:
   - Selecciona una forma del menú
   - Haz clic y arrastra en el área de dibujo para crear la forma

2. **Cambiar colores**:
   - Usa las teclas numéricas (0-9) para cambiar el color de la forma actual

3. **Modificar estilos**:
   - Las formas pueden ser sólidas o solo el contorno
   - Algunas formas admiten patrones de relleno

## 📚 Documentación Técnica

### Algoritmos Implementados

- **Líneas**: Algoritmo de Bresenham
- **Círculos**: Algoritmo del punto medio
- **Relleno**: Algoritmo de relleno por barrido

### Estructura de Clases

- **Shape**: Clase base abstracta que define la interfaz común
- **Formas Específicas**: Heredan de `Shape` e implementan `paintComponent`
- **DrawingPanel**: Maneja la interacción del usuario y el dibujo

## 📝 Notas de Desarrollo

- El proyecto está diseñado con fines educativos
- El código incluye comentarios explicativos
- Fácil de extender con nuevas formas y algoritmos

## 🤝 Contribuir

Las contribuciones son bienvenidas. Por favor, crea un issue para discutir los cambios propuestos antes de hacer un pull request.

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más información.

---

<div align="center">
  Desarrollado para el curso de programacion
</div>
