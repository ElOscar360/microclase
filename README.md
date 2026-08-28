# Taller Builder

**Estudiante:** Oscar Santiago Montoya Amaya
**Código:** 20212020076

## 1. Preguntas sobre el patrón Builder

### ¿Qué problema resuelve y cuáles son las desventajas del constructor telescópico?

**Problema:**
Evita constructores gigantes con demasiados parámetros y combinaciones complejas.

**Desventajas:**
Dificulta la lectura del código, ya que no se sabe fácilmente qué representa cada parámetro o booleano. Además, obliga a crear múltiples constructores o pasar valores nulos o falsos que pueden resultar innecesarios.

### Roles clásicos del patrón Builder

* **Product:** Es el objeto complejo que se desea construir.
* **Builder:** Interfaz que define los pasos de construcción.
* **ConcreteBuilder:** Implementación concreta que arma el producto paso a paso.
* **Director:** Organiza el orden de los pasos según recetas predefinidas.

### ¿Por qué se suele omitir el Director?

Porque el cliente puede encadenar los métodos directamente en el Builder cuando no requiere estructuras fijas y reutilizables.

### Diferencia entre construcción y representación

La **construcción** es el proceso paso a paso, es decir, el algoritmo o secuencia utilizada para armar el objeto.

La **representación** es la estructura del objeto final que se genera.

---

## 2. Refactorización

En este punto se realizó la refactorización utilizando el patrón **Builder** para facilitar la construcción de objetos `Pizza` con diferentes configuraciones.

El código correspondiente se encuentra **subido al repositorio de GitHub**, en el archivo:

```text
pizza
```

El archivo contiene la implementación de la clase `Pizza` y su `Builder`, permitiendo configurar atributos como:

* Masa
* Tamaño
* Salsa
* Queso
* Pepperoni
* Champiñones
* Piña

---

## 3. Identificar los roles

Los roles del patrón Builder en el ejercicio son:

| Clase / Interfaz        | Rol             |
| ----------------------- | --------------- |
| `CarroBuilder`          | Builder         |
| `CarroDeportivoBuilder` | ConcreteBuilder |
| `CarroDirector`         | Director        |
| `Carro`                 | Product         |

---

## 4. Encontrar el error

### Problema

Se reutiliza el mismo objeto instanciado. Si se llama a `build()` dos veces o se continúa utilizando el Builder, se pueden modificar o sobrescribir las propiedades del primer objeto.

### Solución

Reinstanciar la variable en el método `build()` o asignarla directamente en la llamada.

---

## 5. Casos favorables y no favorables

### Favorables

1. Crear objetos con múltiples configuraciones opcionales, por ejemplo, un generador de peticiones HTTP con headers, parámetros y timeout.
2. Construir documentos estructurados en varios formatos como PDF, HTML o Plain Text utilizando el mismo proceso.

### No favorables

1. Construcción de objetos simples con uno o dos parámetros fijos, ya que añadiría clases innecesarias.
2. Entidades donde todos los campos son obligatorios y no cambia su representación.

---

## 6. Práctica RPG

En este ejercicio se implementó el patrón **Builder** para construir personajes de un RPG con diferentes atributos y configuraciones.

El código correspondiente se encuentra **subido al repositorio de GitHub**, en el archivo:

```text
main
```

La implementación permite crear personajes configurando atributos como:

* Nombre
* Raza
* Clase
* Arma
* Armadura
* Mascota
* Nivel
* Habilidades

También se implementó un `PersonajeDirector` con plantillas prediseñadas para crear personajes como un guerrero o un mago.

### Ejemplos utilizados

* **Aragorn:** personaje bien equipado con arma, armadura, mascota, nivel y habilidades.
* **Gimli:** personaje con atributos mínimos.
* **Gandalf:** personaje creado mediante una plantilla prediseñada del `PersonajeDirector`.

---

## Conclusión

El patrón **Builder** permite separar el proceso de construcción de un objeto de su representación final, facilitando la creación de objetos complejos con múltiples configuraciones. En los ejercicios realizados se aplicó el patrón tanto para la construcción de pizzas como para la creación de personajes de un RPG.
