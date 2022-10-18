# Tienda de productos

## Tabla de contenido 📋
1. **Introducción**
   * ¿Qué es programación reactiva?
   * Manifiesto ágil
   * Diferencia entre paradigma imperativo y reactivo
2. **Mono y Flux**
3. **¿Qué son las lambdas?**
4. **Referencia a métodos**
5. **Operadores**
   * Operadores de trasnformación
   * Operadores de filtrado
   * Operadores de combinación
   * Manejo de errores
  ----------------------------------------------------
  ## Introducción 📌
  ### ¿Qué es programación reactiva?
  La programación reactiva es un paradigma enfocado en el trabajo con flujos de datos finitos o infinitos de manera asíncrona.
  Su concepción y evolución ha ido ligada a la publicación del manifiesto reactivo,del cual se explica un poco más adelante 
  ¿pero que significa asíncrona en programación reactiva? las tareas pueden ejecutarse o no secuencialmente, esto significa que
  podemos indicar que algunas tareas se pasen a segundo plano y se espere una respuesta sin detener el flujo.
  
  
  ### Manifiesto Agil
  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195433173-22e79e54-c914-475b-aaa7-2eeae9772789.jpeg">
  </p>
   
  
  
  ### Diferencia entre paradigma imperativo y reactivo
  Se dice que dentro de la programación **reactiva** lo que se plantea, es observar los cambios que se realizan en un **flujo de datos**, esto
  mediante una suscripción desde la vista, es decir, consiste en reaccionar a los cambios que ocurren dentro de los flujos de datos.
  
  De acuerdo a lo anterior se tiene entonces, que mientras el paradigma imperativo trabaja con **colecciones o listas**, el paradigma
  reactivo permite el trabajo con **flujos de datos**, algo similar al uso de Stream en Java, es decir, el mismo flujo indica en qué
  momento termina y este puede o no tener elementos e incluso devolver un error (de ello se habla más adelante).
  
  Otra diferencia que se observa es que el paradigma reactivo se implementa bajo programación **funcional**, basado en funciones **sin estado**,
  ya que el estado sólo depende de los datos de entrada, esto es, que dados siempre los mismos datos de entrada, se obtiene siempre
  los mismos resultados o los mismos datos de salida, lo que no pasa en el paradigma imperativo mediante el uso de Objetos, ya que es
  estos si se maneja el **cambio de estado** de los atributos en dichos objetos, es decir, el paradigma imperativo tiene una **alta cohesión**
  mientras que en el paradigma reactivo disminuye altamente dicha cohesión.
  
  ¿Pero qué se busca con esta **baja cohesión**?
  
  Lo que busca es poder paralelizar los flujos de datos si se tienen flujos complejos, busca
  procesar en paralelo , y dado que no tienen estado, el resultado siempre es el mismo.
  
  También se tiene que el paradigma reactivo se basa en un patrón **Observador** (Observer) o también llamado **Publicador** (Publisher), que permite el trabajo con
  elementos o flujos de manera **asíncrona**, mientras que el paradigma imperativo es síncrono, es decir, es **bloqueante**, detiene el proceso
  y hasta que un método no termine su proceso, este no devuelve el control, y como se mencionó anteriormente la programación reactiva
  busca tener una **baja cohesión** sin cambios de estado, por tanto debe ser completamente asíncrono en lo posible.
  
  ## Mono y Flux
Dentro de estos flujos de datos mencionados anteriormente se encuentran dos clases que son las más usadas 
y permiten agrupar todos los flujos de datos, estas clases son Mono y Flux que permite el trabajo de la siguiente manera:

### Mono<T>
Se maneja Mono cuando se tiene un solo dato dentro del flujo que puede cumplir o no con las condiciones indicadas, 
dentro de este método se tiene los siguientes casos:

* Que transforme el dato y luego se complete el flujo.
  <p align="center">
    <img src="https://user-images.githubusercontent.com/17349106/195451659-fde637dc-16b9-4898-a84b-88ec25223ec5.png"/>
  </p>
  
* Que solo se complete el flujo sin que éste tenga elementos. 
 <p align="center">
 <img src="https://user-images.githubusercontent.com/17349106/195451860-0f2a8382-007b-4238-ba07-dca81458c9e6.png"/>
 <p/>
 
* Que solo obtenga o se publique un error sin elementos. 
<p align="center">
 <img src="https://user-images.githubusercontent.com/17349106/195452036-f667f33f-963c-4f50-befa-ad9801ab509f.png"/>
 <p/>
 
* Que transforme el dato y obtenga un error y no se pueda completar el flujo. 
<p align="center">
 <img src="https://user-images.githubusercontent.com/17349106/195452073-a34e1d50-616f-4225-9e2f-8f242a17d158.png"/>
 <p/>
Es decir, permite el trabajo o flujo de forma asincrónica con cero o un elemento.

### Flux<T>
Se maneja Flux para un flujo con una cantidad indeterminada de elementos que son 
emitidos a lo largo del tiempo hasta completar la cantidad de elementos que se encuentran
dentro del flujo, de igual manera se pueden presentar los siguientes casos: 

* Usar un flujo con más de un elemento , el cual se puede completar cuando se a cumplido o emitido la cantidad total de elementos. 
  <p align="center">
   <img src="https://user-images.githubusercontent.com/17349106/195452435-2b20e0c6-3345-4478-b951-4c8048bc87bd.png"/>
  <p/>
  
* Usar un flujo vacío, el cual se puede completar sin tener en su estructura ningún elemento. 
<p align="center">
 <img src="https://user-images.githubusercontent.com/17349106/195452543-20fe97e5-e088-483b-a053-8e92d6ca65e0.png"/>
 <p/>
 
* También se puede encontrar casos en los cuales se trabaje con los elementos y no se complete, sino por el contrario arroje error. 
<p align="center">
 <img src="https://user-images.githubusercontent.com/17349106/195452648-0e75e773-0503-4f84-ae9c-3e18d62d3c24.png"/>
<p/>

* O  bien sea  que solo se emita un error en el flujo sin necesariamente tener elementos dentro del mismo y no se pueda completar. 
<p align="center">
 <img src="https://user-images.githubusercontent.com/17349106/195452770-d3e3c3b5-b358-4c86-9e2d-0785b741eee5.png"/>
<p/>
  
Estas clases mencionados anteriormente son métodos de tipo publicador (**Publisher**), es decir que puede emitir datos en cualquier 
momento del tiempo a lo largo del ciclo del flujo de datos con lo que se esté trabajando en el momento, son también conocidos como Observables

Una manera de obtener la información de este tipo de métodos y dado que son observables, es suscribirse para ser notificados de los cambios 
que realice el flujo de datos, por medio del método **Subscribe**, pero este método se debe evitar usar, ya que es un método bloqueante, es decir,
espera una respuesta y en este tiempo detiene todo el flujo, con lo que obstruye la cadena del publicador y por ende la reactividad y **el flujo 
pierde el asincronismo**.

La manera correcta de obtener esta información es suscribirse desde la vista para mostrar la información de manera asíncrona **sin bloquear el flujo** 
en el publicador sino que por el contrario esté siempre pendiente de los cambios ocurridos dentro del flujo y reaccione a ellos. 
(Ejemplo de quien puede suscribirse: Componente de Angular, entre otros).


## ¿Qué son las lambdas?
Una expresión Lambda es una función anónima, básicamente es un método abstracto es decir un método que sólo está definido en una interfaz pero no implementado,
y esa es la clave de la funciones lambda, al no estar implementado, el programador lo puede implementar dónde él crea conveniente sin haber heredado de la interfaz.

                                                          (parámetro)->{cuerpo-lamba}

El operador lambda (->) separa la declaración de parámetros de la declaración del cuerpo de la funcional, estas expresiones fueron incluidas en la versión 8 de java.

### Parámetro:
* Cuando se tiene un solo parámetro no es necesario utilizar paréntesis.
* Cuando no se tiene parámetros es necesario utilizar paréntesis.
### Cuerpo lambda:
* Cuando el cuerpo de la expresión lambda tiene una unica linea no es necesario utilizar las llaves y no necesita especificar la cláusula return.
* Cuando el cuerpo de la expresión lambda tiene más de una línea es necesario utilizar las llaves y especificar la cláusula return.

Ejemplos de lambda 
* () -> System.out.println(“Expresión lambda ”)
* (int num1 , int num2)->{return num1+num2}

 ## Referencia a metodos
Hay una característica importante relacionada con las expresiones lambda llamada Métodos de Referencia. Una referencia a métodos o métodos referenciados proporciona    una forma de referirse a un método sin ejecutarlo. Se relaciona con expresiones lambda  porque también requiere un contexto de tipo objetivo que consiste en una    interfaz funcional compatible. Cuando se evalúa, una referencia de método también crea una instancia de una interfaz funcional. Hay diferentes tipos de referencias de métodos
* Referencia a un método estático
* Referencia a un método de un objeto
* Referencia a un método de un objeto arbitrario
* Referencia a un constructor
 ``` 
 Ejemplo:
 Objeto::atributo
 System.out::println
 NombreClase::nombeMetodo

 ```


 ## Operadores 🛠️
 Los operadores son pensados principalmente para ayudar a modificar, filtrar, combinar y transformar los datos emitidos por 
 los observables o flujos de datos, para la implementación de estos operadores, se realiza la creación de un proyecto  con spring 
 boot y web flux el cual está basado en un tienda que consta de un documento de productos con el cual se realiza los ejemplos que
 se muestran en los siguientes operadores.
 ### Operadores de transformación
 * **Map:** El operador más utilizado en reactividad es el map, este operador permite la transformación de un flujo de datos, teniendo en cuenta que recibe un tipo de dato T y retorna un tipo de dato R donde T es cualquier tipo de dato de entrada y R es la salida de los datos ya transformados. 
  
  Ejemplo práctico del map con el proyecto planteado:
  
<p align="center">
  <img src="https://user-images.githubusercontent.com/90659322/195445782-f80c52df-8de3-4a9c-b11a-99bb9dc6a283.png"/>
</p>
  
  ```
  Como se observa en la imagen anterior, esta claro que el map hace una transformación uno a uno de los elementos
  del flujo de datos, en el caso del ejemplo práctico transforma el atributo "name" de cada uno de los productos
  en mayúsculas.
  ```
  Resultado esperado:

  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195445903-4f6e1e30-4a2b-4a70-bf66-e62ff822258c.png"/>
  </p>
  
 * **Flatmap:** El operador flatMap consta, lógicamente, de dos operaciones: map y flatten. La parte map del operador flatMap transforma cada elemento entrante en una secuencia, y la parte flatten fusiona todas las secuencias reactivas generadas en un nuevo flujo de datos que es el que se retorna con todos los elementos aplanados, es decir, en una única lista.

  Ejemplo práctico de este operador:
  
  <p align="center">
     <img src="https://user-images.githubusercontent.com/106001562/195634165-122d7e29-b7dc-4610-bb91-bb99af5ac137.png"/>
  </p>
  
  ```
  La imagen anterior muestra como, de entrada se reciben los en una estructura o método MONO<T> y al implementar el flatmap 
  se puede obtener cada uno los elementos que   se encuentran dentro del MONO<T> 
  ```
  
  Resultado esperado:
  
  <p align="center">
     <img src="https://user-images.githubusercontent.com/106001562/195635618-8a5f106d-2169-4924-b1f2-70bce5eaab0c.png"/>
  </p>


### Operadores de filtrado
   * **Filter:** A diferencia del operador de mapa, el filtro puede producir menos elementos de los que ha recibido. Sólo emite los elementos que han superado con éxito la prueba del predicado
   <p align="center">
     <img src="https://user-images.githubusercontent.com/90659322/195447161-fda5177e-238c-415e-a3ce-a508798d3d2f.png"/>
   </p>
  
  ```
  En este ejemplo se realiza un filtrado en el documento de productos, donde se indica en predicado que el  filtro se
  realiza por el atributo "name" del producto, donde la consulta contenga una secuencia de caracteres recibida como 
  parametro.
  ```
  
  Resultado esperado:
  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195447625-a4080f68-ca09-472c-a335-e67e4cab70f0.png"/>
  </p>
  
   * **Distic:** Este método usa los métodos hashCode() y equals() para obtener elementos distintos
   <p align="center">
     <img src="https://user-images.githubusercontent.com/90659322/195448203-1efef780-0cab-4c5d-bf47-db8dad719781.png"/>
  </p>
  
  ```
  En este ejemplo se aplica el método distinct para la obtener los productos sin colores duplicados este método funcional 
  entrega el siguiente resultado
  ```
  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195449032-8fef8e1a-96d5-4eb9-912f-33fcf7f5e874.png"/>
  </p>
  
   * **Take:** Toma n cantidad de elementos de un flux 
   <p align="center">
     <img src="https://user-images.githubusercontent.com/106001562/195640139-1a0cb669-211e-4e1f-8bfa-ccc827a294e4.png"/>
  </p>
  
  ```
  En este ejemplo lo realizaremos para 2 elementos,esto indica que de nuestra consulta solo obtendremos los dos primeros
  elementos de la misma, obteniendo como resultado lo siguiente:
  ```
  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195450212-557c8786-417e-4d5d-9924-f61879be4092.png"/>
  </p>
  
  * **Skip:**  se usa para ignorar un determinado numero de elementos de un flux 
   <p align="center">
     <img src="https://user-images.githubusercontent.com/106001562/195641546-7ed5f878-c697-48b8-8c1f-b2cc851eaaa0.png"/>
  </p>
  
  ```
  En este caso se implementa el método skip para ignorar los dos  primeros elementos de un flux y se obtiene
  el siguiente resultado:

  ```
  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195450928-54a8e07e-ab68-4254-9463-9c8e76f514a1.png"/>
  </p>
  
  
### Operadores de combinación 
Los operadores de comparación sirven para fusionar los elementos de n cantidad de listas, dentro de estos operadores los más comunes son: zip, zipwith, merge, mergewith
  
* **Zip:** El operador zip permite combinar dos listas tomando un elemento de cada lista en cada una de las iteraciones que realiza dependiendo el tamaño de estás listas y se puede realizar operaciones con cada uno de estos elementos.

  **Nota:** Las listas por lo general deben ser del mismo tamaño, de no ser así, el operador sólo tendrá en cuenta los elementos hasta que una de las dos listas se     quede sin elementos.
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195643418-2f8c89b3-26cb-4e3b-ba2a-18f8030bf76f.png"/>
  </p>
  
  ```
  En el ejemplo anterior se puede observar cómo a partir de dos flujos de datos de clase producto se realiza la 
  combinación de los elementos de forma intercalada ya que el operador usado toma uno por cada lista en cada iteración,
  la característica de filtrado es el color del producto y la respuesta es un listado de la combinación del dichos listas
  Obteniendo como resultado lo siguiente:
  ```
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195643844-3a6ce0fb-f185-4b9c-a516-18221709e09e.png"/>
  </p>
  
* **ZipWith:**  Este operador permite crear una combinación de dos listas, partiendo de una de ellas, tomando como inicial la lista de referencia y siguiente la lista con la que se quiere realizar la combinación, y el flujo se realiza igual al método anterior.
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195644260-081dbe4c-5725-4920-8df0-cd258a2e5248.png"/>
  </p>

  ```
  En el ejemplo anterior se puede observar cómo a partir un flujo del datos y mediante la implementación del operador 
  zipwith, se puede combinar con un segundo flujo de datos obteniendo como resultado una lista como los elementos 
  intercaladas, algo similar al ejemplo anterior, como se puede observar en la siguiente imagen:
  ```
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195645121-e9e5326e-846a-44dd-a2ba-cdb60048b2ef.png"/>
  </p>

 * **Merge:** El operador merge permite combinar dos listas tomando los elementos tal y como van saliendo de los flujos de datos con los que se esté realizando la combinación.
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195645439-05244363-d490-4428-af22-3c2657a182e4.png"/>
  </p>

  ```
  En el ejemplo anterior se puede observar cómo se crea un nuevo flujo a partir de dos flujos de datos ya predefinidos
  para el caso con el filtrado de los productos por un color en especifico, como se puede observar en la siguiente 
  imagen:
  ```
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195645974-09b2b66e-f7bd-47d6-98df-920a7526af3d.png"/>
  </p>
  
* **MergeWith:** Este operador permite crear una combinación de dos listas, partiendo de una de ellas, tomando como inicial la lista de referencia y siguiente la lista con la que se quiere realizar la combinación, ingresando al nuevo flujo tal y como sale de cada flujo inicial
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195646429-80aee9d2-a20e-4fc5-a9ff-42764b93b1b0.png"/>
  </p>
  
  ```
  En el ejemplo anterior se puede observar cómo a partir un flujo de datos se combina con otro flujo de datos, estos 
  datos son preestablecidos por dos filtros respecto a los colores de cada producto, como se observa enla imagen 
  anterior, obteniendo como resultado lo siguiente:
  ```
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195647056-afc30034-63fc-4ab4-8992-d8852b93a8d4.png"/>
  </p>
  

### Manejo de errores 
Cuando diseñamos una aplicación reactiva que se comunica mucho con servicios externos, tenemos que lidiar con todo tipo de situaciones excepcionales. Afortunadamente, la señal onError es una parte integral de la especificación del flujo reactivo, por lo que una excepción siempre debería tener una manera de propagarse al actor que puede manejarla. Sin embargo, si el suscriptor final no define un manejador para la señal onError, onError lanza un UnsupportedOperationException.
Además, la semántica de las secuencias reactivas define que onError es una operación terminal, tras la cual después de la cual la secuencia reactiva deja de ejecutarse. En ese momento, podemos reaccionar de otra manera aplicando una de las siguientes  estrategias:
  
* Por supuesto, debemos definir manejadores para la señal onError en el operador subscribe la secuencia reactiva.
  
* Podemos atrapar y sustituir un error por un valor estático por defecto o un valor calculado de la excepción aplicando el operador onErrorReturn.
  
  Ejemplo de implementación del operador errorReturn
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195710915-d9cfe8be-f5a5-4833-851d-e0eb2e1eb2ab.png"/>
  </p>
  
  Resutado: 
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195711130-ae0d3ef1-8758-4d7a-8bca-d8bb7dfa3253.png"/>
  </p>
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195711221-551750a2-33be-4e4c-9130-2029fd5dc762.png"/>
  </p>

* Podemos atrapar una excepción y ejecutar un flujo de trabajo alternativo aplicando el operador onErrorResume.
  
  Ejemplo de implementación del operador errorResume
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195711478-f3a3d139-b1c6-4b83-9bac-3b7b2fb963f8.png"/>
  </p>
  
  Resultado:
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195711586-719d965b-7c2c-4207-8a36-d16a7f2b6962.png"/>
  </p>
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195711699-b066bae0-d421-493b-8d73-db0d08491f91.png"/>
  </p>
  
* Podemos capturar y transformar una excepción en otra que represente mejor la situación representa la situación aplicando el operador onErrorMap.
  
  Ejemplo de implementación del operador errorMap
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195711894-c79dcd67-b3d3-432a-9541-53522418cd5f.png"/>
  </p>
  
  Resultado: 
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195712075-7603e1c4-4a60-4767-b69f-16996e8fa096.png"/>
  </p>
  
## Autores ✒️
* **Daniel Steven Gil Cruz** 
* **John Edward Acevedo Rojas** 
* **Diego Felipe Muñoz Mosquera** 
