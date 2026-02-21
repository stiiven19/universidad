![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

# ✈️ Sistema de Gestión de Avión

Este proyecto implementa un sistema completo para la gestión de reservas y asignación de sillas en un avión, diferenciando entre clases ejecutivas y económicas, y gestionando la información de pasajeros.

## 🚀 Características Principales

- **Gestión de sillas**: Control completo sobre sillas ejecutivas y económicas
- **Asignación de pasajeros**: Sistema de asignación y desasignación de sillas
- **Búsqueda avanzada**: Localización de pasajeros y disponibilidad de sillas
- **Clasificación por ubicación**: Ventana, central o pasillo
- **Validación de datos**: Sistema robusto de validación de entrada
- **Menú interactivo**: Interfaz de consola intuitiva para todas las operaciones


## 🛠️ Requisitos

- Java JDK 8 o superior
- NetBeans IDE (recomendado)
- Consola/terminal para ejecución

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/stiiven19/universidad.git
   cd universidad/Java/Talleres/avion
   ```

2. Abre el proyecto en NetBeans

## 🎯 Uso Básico

### Ejecutar el programa
```bash
java avion.AppAvion
```

### Menú Principal

El sistema ofrece las siguientes opciones:

1. **Asignar Silla a un Pasajero**
   - Ingresa nombre y cédula del pasajero
   - Selecciona clase (Ejecutiva/Económica)
   - Elige ubicación (Ventana/Central/Pasillo)

2. **Desasignar Silla**
   - Libera una silla previamente asignada
   - Mantiene el historial de pasajeros

3. **Buscar Pasajero**
   - Localiza pasajeros por cédula
   - Muestra información de la silla asignada

4. **Buscar Disponibilidad de Silla**
   - Consulta sillas disponibles por clase y ubicación
   - Visualización en tiempo real del estado del avión

5. **Consultar Sillas Ocupadas**
   - Lista completa de sillas asignadas
   - Información detallada de cada pasajero

6. **Consultar Sillas Disponibles**
   - Visualización de sillas libres
   - Filtros por clase y ubicación

## 📚 Documentación Técnica

### Clases Principales

#### Avion
- **Atributos**: 8 sillas ejecutivas, 42 sillas económicas
- **Métodos clave**: 
  - `asignarSilla()`: Asigna una silla a un pasajero
  - `desasignarSilla()`: Libera una silla asignada
  - `buscarPasajero()`: Localiza pasajeros por cédula
  - `contarSillasLibres()`: Cuenta sillas disponibles

#### Silla
- **Enum Clase**: EJECUTIVA, ECONOMICA
- **Enum Ubicacion**: VENTANA, CENTRAL, PASILLO
- **Atributos**: número, clase, ubicación, pasajero asignado

#### pasajero
- **Atributos**: cédula (única), nombre
- **Métodos**: `darCedula()`, `darNombre()`, `igualA()`

### Configuración del Avión

- **Capacidad total**: 50 sillas
- **Clase Ejecutiva**: 8 sillas (4 ventana, 2 central, 2 pasillo)
- **Clase Económica**: 42 sillas (distribuidas en 7 filas de 6)

### Validaciones Implementadas

- Verificación de cédula única por pasajero
- Validación de disponibilidad de sillas
- Control de asignación múltiple
- Manejo de excepciones de entrada

## 🔧 Características Técnicas

- **Manejo de enums**: Para clasificación robusta de sillas
- **Arrays estáticos**: Gestión eficiente de memoria
- **Validación de entrada**: Protección contra datos inválidos
- **Menú recursivo**: Navegación intuitiva entre opciones
- **Persistencia en memoria**: Estado mantenido durante ejecución

## Desarrollado por
Steven Guerrero - Ingeniero de sistemas
