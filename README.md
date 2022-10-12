# Tienda de productos
aqui una explicacion
## Tabla de contenido 📋
1. **Introducción**
   * ¿Qué es programación reactiva?
   * Manifiesto ágil
   * Diferencia entre paradigma imperativo y reactivo
2. **Mono y Flux**
3. **¿Qué son las lambdas?**
4. **Referencia a metodos**
5. **Operadores**
   * Operadores de trasnformación
   * Operadores de filtrado
   * Operadores de combinación
   * Manejo de errores
  ----------------------------------------------------
  ## Introducción 📌
  ### ¿Qué es programación reactiva?
  ```
  La programación reactiva es un paradigma enfocado en el trabajo con flujos de datos finitos o infinitos de manera asíncrona.
  Su concepción y evolución ha ido ligada   a la publicación del manifiesto reactivo,del cual hablaremos un poco más adelante 
  ¿pero que significa asíncrona en programación reactiva? las tareas pueden ejecutarse secuencialmente, esto significa que
  podemos indicar que algunas tareas se pasen a segundo plano y esperen a su turno para ser reanudadas y ejecutadas
  ```
  
  ### Manifiesto Agil
  ![Manifiesto](https://user-images.githubusercontent.com/90659322/195433173-22e79e54-c914-475b-aaa7-2eeae9772789.jpeg)
  ### Diferencia entre el paradigma reactivo
  ```
  Se dice que dentro de la programación reactiva lo que se hace es observar los cambios que se realizan en un flujo de datos, esto
  mediante una suscripción desde la vista, es decir, consiste en reaccionar a los cambios que ocurren dentro de los flujos de datos.
  De acuerdo a lo anterior se tiene entonces que mientras que el paradigma imperativo trabaja con colecciones o listas, el paradigma
  reactivo permite el trabajo con flujos de datos, algo similar al uso de Stream en Java, es decir, el mismo flujo indica en qué
  momento termina y este puede o no tener elemento e incluso devolver un error (de ello se habla más adelante).
  Otra diferencia que se observa es que el paradigma reactivo se maneja bajo  programación funcional, basado en funciones sin estado,
  ya que el estado sólo depende de los datos de entrada, esto es, que dados siempre los mismos datos de entrada, se obtiene siempre
  los mismos resultados o los mismos datos de salida, lo que no pasa en el paradigma imperativo mediante el uso de Objetos, ya que es
  estos si se maneja el cambio de estado los atributos en dichos objetos es decir, el paradigma    imperativo tiene una alta cohesión
  mientras que en el paradigma reactivo disminuye altamente dicha cohesión.
  Pero que se busca con esta baja cohesión? Lo que busca es poder paralelizar los flujos de datos si se tienen flujos complejos, busca
  procesar en paralelo , y dado que no tienen estado, el resultado siempre es el mismo.
  Y también se tiene que el paradigma reactivo se basa en un patrón Observador o también llamado Publicador, que permite el trabajo con
  elementos o flujos de manera asíncrona, mientras que el paradigma imperativo es síncrono, es decir, es bloqueante, detiene el proceso
  y hasta que un método no termine su proceso, este no devuelve el control, y como se mencionaba anteriormente la programación reactiva
  busca tener una baja cohesión sin cambios de estado, por tanto debe ser completamente asíncrono en lo posible.
  ```
  
## Autores ✒️
* **Daniel Steven Gil Cruz** 
* **John Edward Acevedo Rojas** 
* **Diego Felipe Muñoz Mosquera** 
