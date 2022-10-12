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
  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195433173-22e79e54-c914-475b-aaa7-2eeae9772789.jpeg">
  </p>
   
  
  
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
  
  ## Mono y Flux
Dentro de estos flujos de datos mencionados anteriormente se encuentran dos clases que son las más usadas 
y permiten agrupar todos los flujos de datos, estas clases son Mono y Flux que permite el trabajo de la siguiente manera:

### Mono<T>
Se maneja Mono cuando se tiene un solo dato dentro del flujo que puede cumplir o no con las condiciones indicadas, 
dentro de este método se tiene los siguientes casos:

* Que transforme el dato y luego se complete el flujo.
  
 ![image](https://user-images.githubusercontent.com/17349106/195451659-fde637dc-16b9-4898-a84b-88ec25223ec5.png)

* Que solo se complete el flujo sin que éste tenga elementos. 

 ![image](https://user-images.githubusercontent.com/17349106/195451860-0f2a8382-007b-4238-ba07-dca81458c9e6.png)

* Que solo obtenga o se publique un error sin elementos. 

 ![image](https://user-images.githubusercontent.com/17349106/195452036-f667f33f-963c-4f50-befa-ad9801ab509f.png)

* Que transforme el dato y obtenga un error y no se pueda completar el flujo. 

 ![image](https://user-images.githubusercontent.com/17349106/195452073-a34e1d50-616f-4225-9e2f-8f242a17d158.png)

Es decir, permite el trabajo o flujo de forma asincrónica con cero o un elemento.

### Flux<T>
Se maneja Flux para un flujo con una cantidad indeterminada de elementos que son 
emitidos a lo largo del tiempo hasta completar la cantidad de elementos que se encuentran
dentro del flujo, de igual manera se pueden presentar los siguientes casos: 

* Usar un flujo con más de un elemento , el cual se puede completar cuando se a cumplido o emitido la cantidad total de elementos. 

 ![image](https://user-images.githubusercontent.com/17349106/195452435-2b20e0c6-3345-4478-b951-4c8048bc87bd.png)


* Usar un flujo vacío, el cual se puede completar sin tener en su estructura ningún elemento. 

 ![image](https://user-images.githubusercontent.com/17349106/195452543-20fe97e5-e088-483b-a053-8e92d6ca65e0.png)


* También se puede encontrar casos en los cuales se trabaje con los elementos y no se complete sino por el contrario arroje error. 

 ![image](https://user-images.githubusercontent.com/17349106/195452648-0e75e773-0503-4f84-ae9c-3e18d62d3c24.png)


* O  bien sea  que solo se emita un error en el flujo sin necesariamente tener elementos dentro del mismo y no se pueda completar. 

![image](https://user-images.githubusercontent.com/17349106/195452770-d3e3c3b5-b358-4c86-9e2d-0785b741eee5.png)
 

Estas clases mencionados anteriormente son métodos de tipo publicador (**Publisher**), es decir que puede emitir datos en cualquier 
momento del tiempo a lo largo del ciclo del flujo de datos con lo que se esté trabajando en el momento, son también conocidos como Observables

Una manera de obtener la información de este tipo de métodos y dado que son observables, es suscribirse para ser notificados de los cambios 
que realice el flujo de datos, por medio del método **Subscribe**, pero este método se debe evitar usar, ya que es un método bloqueante, es decir,
espera una respuesta y en este tiempo detiene todo el flujo, con lo que obstruye la cadena del publicador y por ende la reactividad y **el flujo 
pierde el asincronismo**.
La manera correcta de obtener esta información es suscribirse desde la vista para mostrar la información de manera asíncrona **sin bloquear el flujo** 
en el publicador sino que por el contrario este siempre pendiente de los cambios ocurridos dentro del flujo y reaccione a ellos. 
(Ejemplo de quien puede suscribirse: Componente de Angular, entre otros).


## ¿Qué son las lambdas?
Una expresión Lambda es una función anónima, básicamente es un método abstracto es decir un método que sólo está definido en una interfaz pero no implementado,
y esa es la clave de la funciones lambda, al no estar implementado, el programador lo puede implementar dónde él crea conveniente sin haber heredado de la interfaz.

                                                          (parámetro)->{cuerpo-lamba}

El operador lambda (->) separa la declaración de parámetros de la declaración del cuerpo de la funcional estas expresiones fueron incluidas en la versión 8 de java.

### Parámetro:
* Cuando se tiene un solo parámetro no es necesario utilizar paréntesis.
* Cuando no se tiene parámetros en necesario utilizar paréntesis.
### Cuerpo lambda:
* Cuando el cuerpo de la expresión lambda tiene una unica linea no es necesario utilizar las llaves y no necesita especificar la cláusula return.
* Cuando el cuerpo de la expresión lambda tiene más de una línea es necesario utilizar las llaves y especificar la cláusula return.

Ejemplos de lambda 
* () -> System.out.println(“Expresión lambda ”)
* (int num1 , int num2)->{return num1+num2}

  
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
