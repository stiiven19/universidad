![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)
![GTK](https://img.shields.io/badge/GTK-404137?style=for-the-badge&logo=gnome&logoColor=white)

# Estructuras de Datos y Proyectos Python

Este repositorio contiene implementaciones de estructuras de datos clásicas en Python y dos aplicaciones con interfaz gráfica:
- **grafos_app**: Manipulación y visualización de grafos, incluye algoritmos de caminos mínimos (Floyd).
- **colegio_app**: Gestión de estudiantes y datos escolares.

## Estructuras de datos incluidas

- **Listas enlazadas**: simple (sll), doble (dll), circular (cll)
- **Pilas y colas**: Stack, Queue, Priority Queue
- **Árboles**: Árbol binario, Árbol binario de búsqueda
- **Grafos**: Representación y algoritmos básicos

Las implementaciones se encuentran en la carpeta `adt/`.

## Funcionamiento general

- **Listas enlazadas**: Métodos de inserción, borrado, búsqueda y recorrido.
- **Pilas (Stack)**: Estructura LIFO.
- **Colas (Queue)**: Estructura FIFO.
- **Árboles**: Inserción, búsqueda, recorrido, altura, nodos internos y hojas.
- **Grafos**: Inserción de nodos/aristas, búsqueda de caminos mínimos (Floyd).

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/stiiven19/universidad.git
   cd universidad/python/ds
   ```

2. Abre el proyecto en tu IDE preferido

## Proyectos con interfaz gráfica

### grafos_app

- **grafos.py**: Aplicación GTK para crear y manipular grafos. Permite agregar/eliminar nodos/aristas y encontrar caminos mínimos (algoritmo de Floyd).
- **class_grafo.py**: Visualización de grafos con Tkinter.
- **test_graph.py**: Pruebas unitarias de grafos.
- **crear_nodos_aristas.py**: App GTK para crear los nodos y aristar en el grafo, sin necesidar de agregar manualmente con la interfaz gráfica (puedes eliminar si no usas).

### grafos_app

Aplicación para manipulación y visualización de grafos.

#### Archivos principales:
- **grafos.py**: Aplicación GTK principal
- **class_grafo.py**: Visualización de grafos
- **test_graph.py**: Pruebas unitarias

#### Cómo ejecutar grafos_app

1. Instala las dependencias:
   - GTK 3 y PyGObject para Python:
     - En Linux: `sudo apt install python3-gi python3-gi-cairo gir1.2-gtk-3.0`
     - En Windows: usar MSYS2 y ejecutar `pacman -S mingw-w64-x86_64-python-gobject mingw-w64-x86_64-gtk3`
   - Tkinter (ya viene con la mayoría de instalaciones de Python)
   - Archivo `grafos.glade` en la carpeta `grafos_app/`

2. Para ejecutar la aplicación principal (desde la carpeta `ds`):
   ```bash
   python -m grafos_app.grafos
   ```

3. Para ejecutar las pruebas unitarias (desde la carpeta `ds`):
   ```bash
   python -m grafos_app.test_graph
   ```

### colegio_app

Aplicación GTK para gestión de estudiantes y datos escolares.

#### Archivos principales:
- **colegio.py**: Clases base del sistema
- **app_colegio.py**: Aplicación de consola
- **colegio_gtk.py**: Interfaz gráfica simple
- **estudiante_glade.py**: Interfaz gráfica avanzada (requiere archivo .glade)

#### Cómo ejecutar colegio_app

1. Asegúrate de tener instaladas las dependencias:
   - GTK 3 y PyGObject (ver arriba)
   - Archivo `ventana_estudiantes.glade` en la carpeta `colegio_app/`

2. Para ejecutar la interfaz gráfica avanzada (desde la carpeta `ds`):
   ```bash
   python -m colegio_app.estudiante_glade
   ```

3. Para la interfaz gráfica simple (desde la carpeta `ds`):
   ```bash
   python -m colegio_app.colegio_gtk
   ```

4. Para la versión de consola (desde la carpeta `ds`):
   ```bash
   python -m colegio_app.app_colegio
   ```
2. Ejecuta: `python app_colegio.py`

## Tests

- Los archivos `test_*.py` permiten probar las estructuras de datos de forma independiente.

## Estructura del repositorio

```
ads/
  adt/           # Estructuras de datos
  grafos_app/    # Proyecto de grafos
  colegio_app/   # Proyecto de colegio
  tests/         # Pruebas unitarias
```

## Requisitos generales
- Python 3.7+
- Para interfaces gráficas: GTK 3 + PyGObject y/o Tkinter

## Desarrollado por
Steven Guerrero - Ingeniero de sistemas