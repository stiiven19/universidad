![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

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
src/
├── Graficos/             # Sistema completo de gráficos interactivos
│   ├── Shape.java            # Clase base abstracta para todas las formas
│   ├── FrameShapes.java      # Ventana principal de la aplicación
│   ├── DrawingPanel.java     # Área de dibujo personalizada
│   ├── Pixel.java            # Implementación de píxel individual
│   ├── Linea.java            # Algoritmo de dibujo de líneas
│   ├── Circulo.java          # Algoritmo del punto medio para círculos
│   ├── Cuadrado.java         # Implementación de cuadrados
│   ├── Rectangulo.java       # Implementación de rectángulos
│   ├── Tequilatero.java      # Triángulo equilátero
│   ├── Trectangulo.java      # Triángulo rectángulo
│   ├── Pentagono.java        # Implementación de pentágonos
│   ├── Cubo.java             # Representación 3D de un cubo
│   └── Cubop.java            # Versión alternativa del cubo
└── Diagrama/            # Proyecto de figuras geométricas básicas
    ├── CGrafica.java         # Ventana principal para dibujar figuras
    ├── Pixel.java            # Clase para representar píxeles individuales
    ├── Linea.java            # Implementación de algoritmo de líneas
    └── Rectangulo.java       # Implementación de rectángulos
```

## 🛠️ Requisitos

- Java JDK 17 o superior
- IDE compatible con Java (Eclipse, IntelliJ, VS Code, etc.)
- Maven (para la gestión de dependencias, si se agregan en el futuro)

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/stiiven19/universidad.git
   cd universidad/Java/Graficos
   ```

2. Abre el proyecto en NetBeans

## 🎯 Uso Básico

### Sistema Graficos (Interactivo)

1. **Dibujar formas**:
   - Selecciona una forma del menú
   - Haz clic y arrastra en el área de dibujo para crear la forma

2. **Cambiar colores**:
   - Usa las teclas numéricas (0-9) para cambiar el color de la forma actual

3. **Modificar estilos**:
   - Las formas pueden ser sólidas o solo el contorno
   - Algunas formas admiten patrones de relleno

### Proyecto Diagrama (Figuras por Código)

El proyecto `Diagrama` implementa figuras geométricas básicas utilizando píxeles y líneas creadas programáticamente:

1. **Ejecutar el proyecto**:
   ```bash
   java Diagrama.CGrafica
   ```

2. **Características**:
   - **Pixel**: Clase fundamental que representa un píxel individual con posición y color
   - **Linea**: Implementación de algoritmo para dibujar líneas entre dos puntos
   - **Rectangulo**: Construcción de rectángulos utilizando píxeles y líneas
   - **CGrafica**: Ventana principal que coordina el dibujo de todas las figuras

3. **Ejemplo de uso**:
   - El sistema genera figuras geométricas mediante coordenadas específicas
   - Cada figura se construye a partir de píxeles individuales
   - Las líneas conectan puntos para formar las figuras deseadas

## 📚 Documentación Técnica

### Algoritmos Implementados

#### Sistema Graficos
- **Líneas**: Algoritmo de Bresenham
- **Círculos**: Algoritmo del punto medio
- **Relleno**: Algoritmo de relleno por barrido

#### Proyecto Diagrama
- **Píxeles**: Representación básica con coordenadas (x, y) y color
- **Líneas**: Conexión entre puntos mediante algoritmo de dibujo vectorial
- **Rectángulos**: Construcción mediante combinación de líneas y píxeles

### Estructura de Clases

#### Sistema Graficos
- **Shape**: Clase base abstracta que define la interfaz común
- **Formas Específicas**: Heredan de `Shape` e implementan `paintComponent`
- **DrawingPanel**: Maneja la interacción del usuario y el dibujo

#### Proyecto Diagrama
- **Pixel**: Componente visual básico con posición y dimensiones personalizables
- **Linea**: Extiende Applet para dibujar líneas entre coordenadas específicas
- **Rectangulo**: Implementación de rectángulos mediante técnicas de píxeles
- **CGrafica**: Ventana principal JFrame que gestiona el dibujo de figuras geométricas

## Desarrollado por
Steven Guerrero - Ingeniero de sistemas