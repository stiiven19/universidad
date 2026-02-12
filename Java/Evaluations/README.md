![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

# Evaluations

Este proyecto contiene implementaciones de componentes de interfaz gráfica en Java, incluyendo una herramienta de selección de cuadrícula personalizable, un diseño de ojos que siguen el cursor y otras aplicaciones gráficas.

## 📂 Estructura del Proyecto

- **GridSelect**: Componente personalizado para selección en cuadrícula
  - `GridSelection.java`: Implementación principal del componente de selección de cuadrícula

- **Hyperlink**: Componente de hipervínculo personalizado
  - `Hyperlink.java`: Implementación de un componente de hipervínculo interactivo

- **ev01**: Primera evaluación
  - `ev_match.java`: Implementación de un juego de memoria

- **ev02**: Segunda evaluación
  - Componentes de interfaz gráfica avanzada
  - Implementación de patrones de diseño

- **eyes**: Componente de ojos que siguen el cursor
  - Versión básica de seguimiento ocular

- **eyes4**: Versión mejorada del componente de ojos
  - Mayor suavidad en el seguimiento
  - Personalización avanzada

- **progress1**: Componente de barra de progreso personalizada
  - Visualización personalizada del progreso
  - Soporte para diferentes estados y colores

- **simulacrumD_01**: Simulacro de evaluación final
  - Implementación de componentes avanzados
  - Ejemplos de diseño de interfaz de usuario

## 🚀 Características

- **Selección en Cuadrícula**: Componente personalizado para selección de celdas en una cuadrícula
- **Personalizable**: Configuración de filas y columnas personalizables
- **Interfaz Gráfica Intuitiva**: Fácil de integrar en aplicaciones Swing

## 🛠 Tecnologías Utilizadas

- Java SE
- Swing (GUI)
- Java 2D (para renderizado personalizado)

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/stiiven19/universidad.git
   cd universidad/Java/Evaluations
   ```

2. Abre el proyecto en NetBeans

## 📝 Uso Básico

```java
// Crear una instancia de GridSelection
String[] columnas = {"A", "B", "C", "D"};
String[] filas = {"1", "2", "3", "4", "5"};
GridSelection grid = new GridSelection(5, 4, columnas, filas);

// Agregar a un contenedor
JFrame frame = new JFrame("Ejemplo GridSelection");
frame.add(grid);
frame.pack();
frame.setVisible(true);
```

## Desarrollado por
Steven Guerrero - Ingeniero de sistemas