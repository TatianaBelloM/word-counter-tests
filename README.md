# Word Counter — Automatización de Pruebas

Proyecto de automatización de pruebas funcionales sobre la herramienta **[WordCounter](https://wordcounter.net/)**, desarrollado con **Serenity BDD**, **Cucumber** y el patrón **Screenplay**.

---

## Tecnologías utilizadas

| Herramienta           | Versión  |
|-----------------------|----------|
| Java                  | 17       |
| Maven                 | 3.x      |
| Serenity BDD          | 5.3.8    |
| Cucumber              | 7.34.2   |
| Selenium WebDriver    | (incluido en Serenity) |
| Navegador             | Google Chrome |

---

## Prerrequisitos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java 17**
- **Maven**
- **Google Chrome**

Para verificar que están configurados correctamente:

```bash
java -version
mvn -version
```

---

## Cómo ejecutar el proyecto

Desde la raíz del proyecto, ejecuta:

```bash
mvn clean verify
```

> El proyecto corre en modo **headless** (sin abrir una ventana visible del navegador).
> El navegador se reinicia entre cada escenario para garantizar el aislamiento de las pruebas.

Si prefieres ver el navegador abrirse durante la ejecución, cambia el siguiente parámetro en `src/test/resources/serenity.conf`:

```
headless.mode = false
```

---

## Cómo visualizar el reporte

Al finalizar la ejecución, Serenity genera automáticamente un reporte HTML en:

```
target/site/serenity/index.html
```

Ábrelo directamente en tu navegador. El reporte incluye:

- Resumen general de escenarios (pasados, fallidos, pendientes)
- Detalle paso a paso de cada escenario ejecutado
- Capturas de pantalla automáticas en caso de fallo

---

## Consideraciones del proyecto

### Comportamiento del contador de palabras

Las siguientes reglas definen cómo WordCounter interpreta el texto ingresado:

1. **Palabras con guión** — Expresiones como `well-known` se cuentan como **una sola palabra**.
2. **Contracciones con apóstrofe** — Palabras como `it's` se cuentan como **una sola palabra**.
3. **Números** — Se cuentan como palabras y aparecen en la sección de *Keyword Density*.
4. **Signos de apertura `¿` y `¡`** — No se cuentan como palabras independientes.
5. **Espacios y saltos de línea** — Cuentan como **caracteres** y funcionan como **separadores de palabras**.
6. **Palabras conectoras** — Palabras como `and`, `or`, `then` no aparecen en la sección de *Keyword Density*.

---

### Regla APA 7 — Escritura de números

Según el Manual de Estilo APA 7.ª edición, la forma de escribir un número afecta directamente el conteo de palabras:

| Rango | Formato APA | Ejemplo | Palabras contadas |
|---|---|---|---|
| 0 al 9 | Se escriben con letras | _tres experimentos_ | tantas palabras como letras uses |
| 10 en adelante | Se escriben con cifras | _48 perros_ | 1 palabra por número |

> Esta distinción es relevante al diseñar casos de prueba con textos académicos: el mismo valor numérico puede sumar diferente cantidad de palabras dependiendo de cómo se redacte.

---

## Estructura del proyecto

```
src/
├── test/
│   ├── java/starter/
│   │   ├── screenplay/
│   │   │   ├── questions/      # Preguntas: conteo de palabras, caracteres y densidad
│   │   │   ├── tasks/          # Tareas: navegar a la página e ingresar texto
│   │   │   └── ui/             # Page Objects: localizadores de la página
│   │   └── stepdefinitions/    # Definiciones de pasos Cucumber
│   └── resources/
│       └── features/           # Escenarios Gherkin (.feature)
```

---

## Autora

**Tatiana Bello M.**