# 🧠 Sesión 2: Tipos de Datos, Operadores, Condicionales y Ciclos en Java

## 📌 Tipos de Datos en Java y uso de `var`

### Tipos Primitivos
- `int`: Números enteros → `int edad = 30;`
- `double`: Decimales → `double precio = 199.99;`
- `boolean`: `true` o `false` → `boolean activo = true;`
- `char`: Carácter único → `char letra = 'J';`

### Inferencia con `var` (desde Java 10)
- El compilador infiere el tipo:  
  `var mensaje = "Hola";` → String  
  `var numero = 10;` → int  
  ⚠️ No puede cambiar de tipo después de su declaración.

### Conversión de Tipos (Casting)
- **Implícita**: `int x = 10; double y = x;`
- **Explícita**: `double z = 12.5; int w = (int) z;`

---

## 📌 Operadores y Expresiones

### Tipos de operadores
- **Aritméticos**: `+`, `-`, `*`, `/`, `%`
- **Relacionales**: `==`, `!=`, `>`, `<`, `>=`, `<=`
- **Lógicos**: `&&`, `||`, `!`
- **Asignación**: `=`, `+=`, `-=`, etc.
- **Incremento/Decremento**: `++`, `--`

### Ejemplo: Sistema de facturación con descuento
```java
double total = (45.5 * 2) + 80 + 20;
boolean aplicaDescuento = total > 150;
double descuento = aplicaDescuento ? total * 0.10 : 0;
double totalFinal = total - descuento;
```


### PEMDAS en Java
1. Paréntesis `()`
2. Multiplicación/División/Módulo
3. Suma/Resta
4. Relacionales
5. Lógicos
6. Asignación

---

## 📌 Sentencias Condicionales

### if / else if / else
```java
if (tipo.equals("pequeño")) costo = 49.99;
else if (tipo.equals("mediano")) costo = 89.99;
else System.out.println("Tipo no válido");
```

### switch moderno (Java 14+)
```java
double costo = switch (tipo) {
    case "pequeño" -> 49.99;
    case "mediano" -> 89.99;
    case "grande" -> 149.99;
    default -> {
        System.out.println("Tipo no válido");
        yield 0.0;
    }
};
```
- `yield` se usa cuando el bloque `case` tiene varias líneas.

---

## 📌 Ciclos y Estructuras de Control

### `while` → Cuando no sabes cuántas repeticiones habrá
```java
while (intentos < 3) {
    if (input.equals(pass)) break;
    intentos++;
}
```

### `for` → Repeticiones con contador o índice
```java
for (int i = 0; i < productos.length; i++) {
    System.out.println(productos[i]);
}
```

### `for-each` → Recorre arrays sin índice
```java
for (String p : productos) {
    if (p.equals("Teclado")) continue;
    if (p.equals("Pantalla")) break;
    System.out.println(p);
}
```

### `break` y `continue`
- `break`: Sale del ciclo actual.
- `continue`: Salta a la siguiente iteración.

---

## ✅ Buenas Prácticas

- Evita `var` con tipos ambiguos.
- Usa `for-each` si no necesitas el índice.
- Agrupa operaciones con paréntesis para evitar errores de precedencia.
- Evita abusar de `break` y `continue`.

