# Jaque 4 Caballos

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)
![JGraphT](https://img.shields.io/badge/JGraphT-5E2CA5?style=for-the-badge&logo=graph&logoColor=white)
![GraphStream](https://img.shields.io/badge/GraphStream-00599C?style=for-the-badge&logo=graph&logoColor=white)

Un programa que simula el movimiento de 4 caballos en un tablero de ajedrez para lograr dar jaque mate al rey en la menor cantidad de movimientos posibles.

## Descripción

Este proyecto implementa un algoritmo de **búsqueda informada A*** que encuentra la secuencia óptima de movimientos para que 4 caballos den jaque mate al rey en un tablero de ajedrez estándar (8x8). 

El sistema utiliza una **función heurística** que evalúa cada estado del tablero asignando puntuaciones basadas en la amenaza al rey, permitiendo al algoritmo priorizar los movimientos más prometedores. La búsqueda se optimiza mediante:

- **Función de evaluación heurística** que asigna valores según la amenaza al rey
- **Poda de ramas** para reducir el espacio de búsqueda
- **Lista de cerrados** para evitar ciclos y estados repetidos

El objetivo es encontrar la solución con el menor número de movimientos posibles, utilizando técnicas de inteligencia artificial para la toma de decisiones.

## Características

- Simulación de movimientos de caballos en ajedrez
- Algoritmo de búsqueda en espacio de estados
- Visualización gráfica de las posiciones iniciales y finales
- Interfaz gráfica para ingresar posiciones iniciales
- Validación de movimientos según las reglas del ajedrez
- Implementación de función heurística para optimizar la búsqueda

## Requisitos

- Java JDK 8 o superior
- NetBeans IDE (recomendado)
- Librerías necesarias:
  - **JGraphT** (v1.5.2 o superior) - Para la manipulación de grafos
  - **GraphStream** (v2.0) - Para la visualización de grafos
  - **Guava** - Para colecciones y utilidades adicionales

### Instalación de Librerías

Las librerías ya están incluidas en la carpeta `lib/` del proyecto. Si necesitas añadirlas manualmente:

1. **JGraphT**: Descarga desde [https://github.com/jgrapht/jgrapht](https://github.com/jgrapht/jgrapht)
2. **GraphStream**: Descarga desde [http://graphstream-project.org/](http://graphstream-project.org/)
3. Agrega los archivos .jar a la carpeta `lib/` del proyecto
4. En NetBeans: clic derecho en el proyecto → Properties → Libraries → Add JAR/Folder

## Capturas del Programa

### Tablero Inicial y Final
![Tablero Inicial](imagenes/Inicio.webp)

### Movimientos 
![Movimientos](imagenes/Movimientos.webp)

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/stiiven19/universidad.git
   cd universidad/Java/Jaque4Caballos
   ```

2. Abre el proyecto en NetBeans

## Cómo ejecutar

1. Abre el proyecto en NetBeans
2. La clase principal es `Ajedrez.java` ubicada en `src/jaque4caballos/`
3. Ejecuta el proyecto (F6 o botón de ejecutar)

## Uso

1. Al ejecutar, ingresa las posiciones iniciales de las piezas:
   ```java
   Caballo C1 = new Caballo(1, 3, "C1");
   Caballo C2 = new Caballo(2, 1, "C2");
   Caballo C3 = new Caballo(1, 4, "C3");
   Caballo C4 = new Caballo(3, 1, "C4");
   Rey R = new Rey(8, 4);
   ```

2. El programa mostrará en consola todos los movimientos realizados
3. Se abrirán dos ventanas:
   - Una mostrando la posición inicial de las piezas
   - Otra mostrando la posición final (jaque mate)

## Lógica del Programa

### 1. Espacio de Estados
- **Variables de estado**: Posición de los 4 caballos (c1, c2, c3, c4) respecto al rey
- **Estructuras de datos**: Listas abiertas y cerradas para el algoritmo de búsqueda
- **Estado inicial**: Depende de la posición inicial de los caballos respecto al rey
- **Estado objetivo**: Cuando los caballos logran dar jaque mate al rey (valor heurístico = 1000)

### 2. Operadores (Movimientos del caballo)

El programa implementa los 8 posibles movimientos del caballo en ajedrez, validando que cada movimiento sea válido dentro del tablero:

1. **Movimiento en L hacia arriba-izquierda**: 2 casillas arriba, 1 a la izquierda
2. **Movimiento en L hacia arriba-derecha**: 2 casillas arriba, 1 a la derecha
3. **Movimiento en L hacia izquierda-arriba**: 2 casillas a la izquierda, 1 arriba
4. **Movimiento en L hacia izquierda-abajo**: 2 casillas a la izquierda, 1 abajo
5. **Movimiento en L hacia abajo-izquierda**: 2 casillas abajo, 1 a la izquierda
6. **Movimiento en L hacia abajo-derecha**: 2 casillas abajo, 1 a la derecha
7. **Movimiento en L hacia derecha-arriba**: 2 casillas a la derecha, 1 arriba
8. **Movimiento en L hacia derecha-abajo**: 2 casillas a la derecha, 1 abajo

### 3. Función Heurística

La función heurística evalúa cada estado del tablero asignando puntuaciones:

- **1000 puntos**: Jaque mate al rey (estado objetivo)
- **500 puntos**: Jaque al rey (pero no es jaque mate)
- **100 puntos**: El rey está amenazado (algún caballo puede dar jaque en el siguiente movimiento)
- **10 puntos**: El rey no está en jaque ni amenazado


## Ejemplo de Salida

1. La consola mostrará los movimientos realizados y la evaluación heurística en cada paso
2. Se abrirá una ventana con el tablero inicial mostrando las posiciones de inicio
3. Se abrirá una segunda ventana mostrando la posición final de jaque mate
4. En consola se mostrará la secuencia completa de movimientos hasta alcanzar el objetivo

## Reglas de movimiento

- **Sistema de coordenadas**:
  - Filas: 1 (inferior) a 8 (superior)
  - Columnas: 1 (izquierda) a 8 (derecha)
- **Reglas de movimiento**:
  - Los caballos se mueven en forma de "L" (2 casillas en una dirección y 1 en perpendicular)
  - No pueden salirse del tablero
  - No pueden ocupar la misma casilla que otro caballo

## Desarrollado por
Steven Guerrero - Ingeniero de sistemas