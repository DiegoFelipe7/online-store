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
  La programación reactiva es un paradigma enfocado en el trabajo con flujos de datos finitos o infinitos de manera asíncrona.
  Su concepción y evolución ha ido ligada   a la publicación del manifiesto reactivo,del cual hablaremos un poco más adelante 
  ¿pero que significa asíncrona en programación reactiva? las tareas pueden ejecutarse secuencialmente, esto significa que
  podemos indicar que algunas tareas se pasen a segundo plano y esperen a su turno para ser reanudadas y ejecutadas
  
  
  ### Manifiesto Agil
  ![Manifiesto](https://user-images.githubusercontent.com/90659322/195433173-22e79e54-c914-475b-aaa7-2eeae9772789.jpeg)
  ### Diferencia entre el paradigma reactivo
 
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
 ## Operadores 🛠️
 Para la utilización de estos operadores de transformación,se realizó la creación de un proyecto  con spring boot y web flux el cual está
 basado en un tienda que consta de un documento de productos.
 ### Operadores de transformación
 * **Map:** Sin duda, el operador más utilizado en RxJava es map, que tiene la siguiente firma:<R> Observable<R> map(Func1<T, R> func)La declaración 
  del método anterior significa que la función func puede transformar el objeto T al tipo de objeto R, y la aplicación de map transforma Observable<T> en
Observable<R>. Sin embargo, una firma no siempre describe bien el comportamiento del operador especialmente si el operador realiza una transformación compleja. Para estos propósitos, se inventaron los diagramas de mármol. Los diagramas de mármol presentan visualmente las transformaciones del flujo.Un ejemplo práctico del map con el ejemplo de la tienda seria:
  
<p align="center">
 ![image](https://user-images.githubusercontent.com/90659322/195445782-f80c52df-8de3-4a9c-b11a-99bb9dc6a283.png)
</p>
  
```
  Mirando la imagen anterior, debería estar claro que el map hace una transformación de uno a uno uno a uno, en este caso del 
  ejemplo práctico lo que nos transforma es  el nombre de cada uno de los productos al devolvernos su nombre en mayúsculas.
  Un ejemplo del resultado esperado sería
```
  <p align="center">
  ![image](https://user-images.githubusercontent.com/90659322/195445903-4f6e1e30-4a2b-4a70-bf66-e62ff822258c.png)
  </p>
  
 * **Flatmap:** El operador flatMap consta, lógicamente, de dos operaciones: map y flatten (en términos de Reactor, flatten es similar al operador merge). La parte map del operador flatMap transforma cada elemento entrante en una secuencia reactiva      (T -> Flux<R>), y la parte flatten fusiona todas las secuencias reactivas generadas en una nueva secuencia reactiva, por la que pasa los elementos de tipo R. 
Según la dinámica que venimos trabajando de la tienda con los productos un ejemplo de este sería:

### Operadores de filtrado
   * **Filter:** A diferencia del operador de mapa, el filtro puede producir menos elementos de los que ha recibido. Sólo emite los elementos que han superado con éxito    la prueba del predicado
   <p align="center">
    ![image](https://user-images.githubusercontent.com/90659322/195447161-fda5177e-238c-415e-a3ce-a508798d3d2f.png)
   </p>
  
  ```
  En este ejemplo se está realizando un filtrado en el documento de productos, donde indicamos en predicado que el  filtro se
  realizará por el nombre del producto donde la consulta contenga una secuencia de caracteres.
  ```
  <p align="center">
  ![image](https://user-images.githubusercontent.com/90659322/195447625-a4080f68-ca09-472c-a335-e67e4cab70f0.png)
  </p>
  
   * **Distic:** Este método usa los métodos hashCode() y equals() para obtener elementos distintos
   <p align="center">
  ![image](https://user-images.githubusercontent.com/90659322/195448203-1efef780-0cab-4c5d-bf47-db8dad719781.png)
  </p>
  
  ```
  En este ejemplo se aplica el método distinct para la obtener los productos sin colores duplicados este método funcional 
  nos entrega el siguiente resultado
  ```
  <p align="center">
    ![image](https://user-images.githubusercontent.com/90659322/195449032-8fef8e1a-96d5-4eb9-912f-33fcf7f5e874.png)
  </p>
  
   * **Take:** Toma n cantidad de elementos de un flux 
   <p align="center">
  ![image](https://user-images.githubusercontent.com/90659322/195448203-1efef780-0cab-4c5d-bf47-db8dad719781.png)
  </p>
  
  ```
  Especificar mejor el texto

  ```
  <p align="center">
   ![image](https://user-images.githubusercontent.com/90659322/195450212-557c8786-417e-4d5d-9924-f61879be4092.png)
  </p>
  
  * **Skip:**  se usa para ignorar un determinado numero de elementos de un flux 
   <p align="center">
  ![image](https://user-images.githubusercontent.com/90659322/195448203-1efef780-0cab-4c5d-bf47-db8dad719781.png)
  </p>
  
  ```
  En este caso estamos utilizando el método skip para ignorar los dos  primeros elementos de un flux y se obtiene
  el siguiente resultado

  ```
  <p align="center">
    ![image](https://user-images.githubusercontent.com/90659322/195450928-54a8e07e-ab68-4254-9463-9c8e76f514a1.png)
  </p>
  
  
  
## Autores ✒️
* **Daniel Steven Gil Cruz** 
* **John Edward Acevedo Rojas** 
* **Diego Felipe Muñoz Mosquera** 
