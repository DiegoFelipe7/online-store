# Tienda de productos

## Tabla de contenido 馃搵
1. **Introducci贸n**
   * 驴Qu茅 es programaci贸n reactiva?
   * Manifiesto 谩gil
   * Diferencia entre paradigma imperativo y reactivo
2. **Mono y Flux**
3. **驴Qu茅 son las lambdas?**
4. **Referencia a m茅todos**
5. **Operadores**
   * Operadores de trasnformaci贸n
   * Operadores de filtrado
   * Operadores de combinaci贸n
   * Manejo de errores
  ----------------------------------------------------
  ## Introducci贸n 馃搶
  ### 驴Qu茅 es programaci贸n reactiva?
  La programaci贸n reactiva es un paradigma enfocado en el trabajo con flujos de datos finitos o infinitos de manera as铆ncrona.
  Su concepci贸n y evoluci贸n ha ido ligada a la publicaci贸n del manifiesto reactivo,del cual se explica un poco m谩s adelante 
  驴pero que significa as铆ncrona en programaci贸n reactiva? las tareas pueden ejecutarse o no secuencialmente, esto significa que
  podemos indicar que algunas tareas se pasen a segundo plano y se espere una respuesta sin detener el flujo.
  
  
  ### Manifiesto Agil
  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195433173-22e79e54-c914-475b-aaa7-2eeae9772789.jpeg">
  </p>
   
  
  
  ### Diferencia entre paradigma imperativo y reactivo
  Se dice que dentro de la programaci贸n **reactiva** lo que se plantea, es observar los cambios que se realizan en un **flujo de datos**, esto
  mediante una suscripci贸n desde la vista, es decir, consiste en reaccionar a los cambios que ocurren dentro de los flujos de datos.
  
  De acuerdo a lo anterior se tiene entonces, que mientras el paradigma imperativo trabaja con **colecciones o listas**, el paradigma
  reactivo permite el trabajo con **flujos de datos**, algo similar al uso de Stream en Java, es decir, el mismo flujo indica en qu茅
  momento termina y este puede o no tener elementos e incluso devolver un error (de ello se habla m谩s adelante).
  
  Otra diferencia que se observa es que el paradigma reactivo se implementa bajo programaci贸n **funcional**, basado en funciones **sin estado**,
  ya que el estado s贸lo depende de los datos de entrada, esto es, que dados siempre los mismos datos de entrada, se obtiene siempre
  los mismos resultados o los mismos datos de salida, lo que no pasa en el paradigma imperativo mediante el uso de Objetos, ya que es
  estos si se maneja el **cambio de estado** de los atributos en dichos objetos, es decir, el paradigma imperativo tiene una **alta cohesi贸n**
  mientras que en el paradigma reactivo disminuye altamente dicha cohesi贸n.
  
  驴Pero qu茅 se busca con esta **baja cohesi贸n**?
  
  Lo que busca es poder paralelizar los flujos de datos si se tienen flujos complejos, busca
  procesar en paralelo , y dado que no tienen estado, el resultado siempre es el mismo.
  
  Tambi茅n se tiene que el paradigma reactivo se basa en un patr贸n **Observador** (Observer) o tambi茅n llamado **Publicador** (Publisher), que permite el trabajo con
  elementos o flujos de manera **as铆ncrona**, mientras que el paradigma imperativo es s铆ncrono, es decir, es **bloqueante**, detiene el proceso
  y hasta que un m茅todo no termine su proceso, este no devuelve el control, y como se mencion贸 anteriormente la programaci贸n reactiva
  busca tener una **baja cohesi贸n** sin cambios de estado, por tanto debe ser completamente as铆ncrono en lo posible.
  
  ## Mono y Flux
Dentro de estos flujos de datos mencionados anteriormente se encuentran dos clases que son las m谩s usadas 
y permiten agrupar todos los flujos de datos, estas clases son Mono y Flux que permite el trabajo de la siguiente manera:

### Mono<T>
Se maneja Mono cuando se tiene un solo dato dentro del flujo que puede cumplir o no con las condiciones indicadas, 
dentro de este m茅todo se tiene los siguientes casos:

* Que transforme el dato y luego se complete el flujo.
  <p align="center">
    <img src="https://user-images.githubusercontent.com/17349106/195451659-fde637dc-16b9-4898-a84b-88ec25223ec5.png"/>
  </p>
  
* Que solo se complete el flujo sin que 茅ste tenga elementos. 
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
Es decir, permite el trabajo o flujo de forma asincr贸nica con cero o un elemento.

### Flux<T>
Se maneja Flux para un flujo con una cantidad indeterminada de elementos que son 
emitidos a lo largo del tiempo hasta completar la cantidad de elementos que se encuentran
dentro del flujo, de igual manera se pueden presentar los siguientes casos: 

* Usar un flujo con m谩s de un elemento , el cual se puede completar cuando se a cumplido o emitido la cantidad total de elementos. 
  <p align="center">
   <img src="https://user-images.githubusercontent.com/17349106/195452435-2b20e0c6-3345-4478-b951-4c8048bc87bd.png"/>
  <p/>
  
* Usar un flujo vac铆o, el cual se puede completar sin tener en su estructura ning煤n elemento. 
<p align="center">
 <img src="https://user-images.githubusercontent.com/17349106/195452543-20fe97e5-e088-483b-a053-8e92d6ca65e0.png"/>
 <p/>
 
* Tambi茅n se puede encontrar casos en los cuales se trabaje con los elementos y no se complete, sino por el contrario arroje error. 
<p align="center">
 <img src="https://user-images.githubusercontent.com/17349106/195452648-0e75e773-0503-4f84-ae9c-3e18d62d3c24.png"/>
<p/>

* O  bien sea  que solo se emita un error en el flujo sin necesariamente tener elementos dentro del mismo y no se pueda completar. 
<p align="center">
 <img src="https://user-images.githubusercontent.com/17349106/195452770-d3e3c3b5-b358-4c86-9e2d-0785b741eee5.png"/>
<p/>
  
Estas clases mencionados anteriormente son m茅todos de tipo publicador (**Publisher**), es decir que puede emitir datos en cualquier 
momento del tiempo a lo largo del ciclo del flujo de datos con lo que se est茅 trabajando en el momento, son tambi茅n conocidos como Observables

Una manera de obtener la informaci贸n de este tipo de m茅todos y dado que son observables, es suscribirse para ser notificados de los cambios 
que realice el flujo de datos, por medio del m茅todo **Subscribe**, pero este m茅todo se debe evitar usar, ya que es un m茅todo bloqueante, es decir,
espera una respuesta y en este tiempo detiene todo el flujo, con lo que obstruye la cadena del publicador y por ende la reactividad y **el flujo 
pierde el asincronismo**.

La manera correcta de obtener esta informaci贸n es suscribirse desde la vista para mostrar la informaci贸n de manera as铆ncrona **sin bloquear el flujo** 
en el publicador sino que por el contrario est茅 siempre pendiente de los cambios ocurridos dentro del flujo y reaccione a ellos. 
(Ejemplo de quien puede suscribirse: Componente de Angular, entre otros).


## 驴Qu茅 son las lambdas?
Una expresi贸n Lambda es una funci贸n an贸nima, b谩sicamente es un m茅todo abstracto es decir un m茅todo que s贸lo est谩 definido en una interfaz pero no implementado,
y esa es la clave de la funciones lambda, al no estar implementado, el programador lo puede implementar d贸nde 茅l crea conveniente sin haber heredado de la interfaz.

                                                          (par谩metro)->{cuerpo-lamba}

El operador lambda (->) separa la declaraci贸n de par谩metros de la declaraci贸n del cuerpo de la funcional, estas expresiones fueron incluidas en la versi贸n 8 de java.

### Par谩metro:
* Cuando se tiene un solo par谩metro no es necesario utilizar par茅ntesis.
* Cuando no se tiene par谩metros es necesario utilizar par茅ntesis.
### Cuerpo lambda:
* Cuando el cuerpo de la expresi贸n lambda tiene una unica linea no es necesario utilizar las llaves y no necesita especificar la cl谩usula return.
* Cuando el cuerpo de la expresi贸n lambda tiene m谩s de una l铆nea es necesario utilizar las llaves y especificar la cl谩usula return.

Ejemplos de lambda 
* () -> System.out.println(鈥淓xpresi贸n lambda 鈥?)
* (int num1 , int num2)->{return num1+num2}

 ## Referencia a metodos
Hay una caracter铆stica importante relacionada con las expresiones lambda llamada M茅todos de Referencia. Una referencia a m茅todos o m茅todos referenciados proporciona    una forma de referirse a un m茅todo sin ejecutarlo. Se relaciona con expresiones lambda  porque tambi茅n requiere un contexto de tipo objetivo que consiste en una    interfaz funcional compatible. Cuando se eval煤a, una referencia de m茅todo tambi茅n crea una instancia de una interfaz funcional. Hay diferentes tipos de referencias de m茅todos
* Referencia a un m茅todo est谩tico
* Referencia a un m茅todo de un objeto
* Referencia a un m茅todo de un objeto arbitrario
* Referencia a un constructor
 ``` 
 Ejemplo:
 Objeto::atributo
 System.out::println
 NombreClase::nombeMetodo

 ```


 ## Operadores 馃洜锔?
 Los operadores son pensados principalmente para ayudar a modificar, filtrar, combinar y transformar los datos emitidos por 
 los observables o flujos de datos, para la implementaci贸n de estos operadores, se realiza la creaci贸n de un proyecto  con spring 
 boot y web flux el cual est谩 basado en un tienda que consta de un documento de productos con el cual se realiza los ejemplos que
 se muestran en los siguientes operadores.
 ### Operadores de transformaci贸n
 * **Map:** El operador m谩s utilizado en reactividad es el map, este operador permite la transformaci贸n de un flujo de datos, teniendo en cuenta que recibe un tipo de dato T y retorna un tipo de dato R donde T es cualquier tipo de dato de entrada y R es la salida de los datos ya transformados. 
  
  Ejemplo pr谩ctico del map con el proyecto planteado:
  
<p align="center">
  <img src="https://user-images.githubusercontent.com/90659322/195445782-f80c52df-8de3-4a9c-b11a-99bb9dc6a283.png"/>
</p>
  
  ```
  Como se observa en la imagen anterior, esta claro que el map hace una transformaci贸n uno a uno de los elementos
  del flujo de datos, en el caso del ejemplo pr谩ctico transforma el atributo "name" de cada uno de los productos
  en may煤sculas.
  ```
  Resultado esperado:

  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195445903-4f6e1e30-4a2b-4a70-bf66-e62ff822258c.png"/>
  </p>
  
 * **Flatmap:** El operador flatMap consta, l贸gicamente, de dos operaciones: map y flatten. La parte map del operador flatMap transforma cada elemento entrante en una secuencia, y la parte flatten fusiona todas las secuencias reactivas generadas en un nuevo flujo de datos que es el que se retorna con todos los elementos aplanados, es decir, en una 煤nica lista.

  Ejemplo pr谩ctico de este operador:
  
  <p align="center">
     <img src="https://user-images.githubusercontent.com/106001562/195634165-122d7e29-b7dc-4610-bb91-bb99af5ac137.png"/>
  </p>
  
  ```
  La imagen anterior muestra como, de entrada se reciben los en una estructura o m茅todo MONO<T> y al implementar el flatmap 
  se puede obtener cada uno los elementos que   se encuentran dentro del MONO<T> 
  ```
  
  Resultado esperado:
  
  <p align="center">
     <img src="https://user-images.githubusercontent.com/106001562/195635618-8a5f106d-2169-4924-b1f2-70bce5eaab0c.png"/>
  </p>
  
 * **Reduce:** El opererador reduce permimete la conversi贸n de una lista de elementos de tipo **X** a un resultado de tipo **Y**
 <p align="center">
   <img src="https://user-images.githubusercontent.com/90659322/196718853-d52ec4f2-187b-4b04-98de-221c072e5679.png"/>
  </p>
  
  ```
  En este ejemplo se puede observar como de entrada, el m茅todo reduce recibe una lista de precios de los productos y como resultado
  entrega la sumatoria total de la lista de precios. 
  ```
  Resultado esperado:
  <p align="center">
   <img src="https://user-images.githubusercontent.com/90659322/196723136-65cd68c4-67a2-42a9-ba84-465b5ca697aa.png"/>
  </p>


### Operadores de filtrado
   * **Filter:** A diferencia del operador de mapa, el filtro puede producir menos elementos de los que ha recibido. S贸lo emite los elementos que han superado con 茅xito la prueba del predicado
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
  
   * **Distic:** Este m茅todo usa los m茅todos hashCode() y equals() para obtener elementos distintos
   <p align="center">
     <img src="https://user-images.githubusercontent.com/90659322/195448203-1efef780-0cab-4c5d-bf47-db8dad719781.png"/>
  </p>
  
  ```
  En este ejemplo se aplica el m茅todo distinct para la obtener los productos sin colores duplicados este m茅todo funcional 
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
  En este caso se implementa el m茅todo skip para ignorar los dos  primeros elementos de un flux y se obtiene
  el siguiente resultado:

  ```
  <p align="center">
    <img src="https://user-images.githubusercontent.com/90659322/195450928-54a8e07e-ab68-4254-9463-9c8e76f514a1.png"/>
  </p>
  
  
### Operadores de combinaci贸n 
Los operadores de comparaci贸n sirven para fusionar los elementos de n cantidad de listas, dentro de estos operadores los m谩s comunes son: zip, zipwith, merge, mergewith
  
* **Zip:** El operador zip permite combinar dos listas tomando un elemento de cada lista en cada una de las iteraciones que realiza dependiendo el tama帽o de est谩s listas y se puede realizar operaciones con cada uno de estos elementos.

  **Nota:** Las listas por lo general deben ser del mismo tama帽o, de no ser as铆, el operador s贸lo tendr谩 en cuenta los elementos hasta que una de las dos listas se     quede sin elementos.
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195643418-2f8c89b3-26cb-4e3b-ba2a-18f8030bf76f.png"/>
  </p>
  
  ```
  En el ejemplo anterior se puede observar c贸mo a partir de dos flujos de datos de clase producto se realiza la 
  combinaci贸n de los elementos de forma intercalada ya que el operador usado toma uno por cada lista en cada iteraci贸n,
  la caracter铆stica de filtrado es el color del producto y la respuesta es un listado de la combinaci贸n del dichos listas
  Obteniendo como resultado lo siguiente:
  ```
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195643844-3a6ce0fb-f185-4b9c-a516-18221709e09e.png"/>
  </p>
  
* **ZipWith:**  Este operador permite crear una combinaci贸n de dos listas, partiendo de una de ellas, tomando como inicial la lista de referencia y siguiente la lista con la que se quiere realizar la combinaci贸n, y el flujo se realiza igual al m茅todo anterior.
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195644260-081dbe4c-5725-4920-8df0-cd258a2e5248.png"/>
  </p>

  ```
  En el ejemplo anterior se puede observar c贸mo a partir un flujo del datos y mediante la implementaci贸n del operador 
  zipwith, se puede combinar con un segundo flujo de datos obteniendo como resultado una lista como los elementos 
  intercaladas, algo similar al ejemplo anterior, como se puede observar en la siguiente imagen:
  ```
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195645121-e9e5326e-846a-44dd-a2ba-cdb60048b2ef.png"/>
  </p>

 * **Merge:** El operador merge permite combinar dos listas tomando los elementos tal y como van saliendo de los flujos de datos con los que se est茅 realizando la combinaci贸n.
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195645439-05244363-d490-4428-af22-3c2657a182e4.png"/>
  </p>

  ```
  En el ejemplo anterior se puede observar c贸mo se crea un nuevo flujo a partir de dos flujos de datos ya predefinidos
  para el caso con el filtrado de los productos por un color en especifico, como se puede observar en la siguiente 
  imagen:
  ```
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195645974-09b2b66e-f7bd-47d6-98df-920a7526af3d.png"/>
  </p>
  
* **MergeWith:** Este operador permite crear una combinaci贸n de dos listas, partiendo de una de ellas, tomando como inicial la lista de referencia y siguiente la lista con la que se quiere realizar la combinaci贸n, ingresando al nuevo flujo tal y como sale de cada flujo inicial
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195646429-80aee9d2-a20e-4fc5-a9ff-42764b93b1b0.png"/>
  </p>
  
  ```
  En el ejemplo anterior se puede observar c贸mo a partir un flujo de datos se combina con otro flujo de datos, estos 
  datos son preestablecidos por dos filtros respecto a los colores de cada producto, como se observa enla imagen 
  anterior, obteniendo como resultado lo siguiente:
  ```
  
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195647056-afc30034-63fc-4ab4-8992-d8852b93a8d4.png"/>
  </p>
  

### Manejo de errores 
Cuando dise帽amos una aplicaci贸n reactiva que se comunica mucho con servicios externos, tenemos que lidiar con todo tipo de situaciones excepcionales. Afortunadamente, la se帽al onError es una parte integral de la especificaci贸n del flujo reactivo, por lo que una excepci贸n siempre deber铆a tener una manera de propagarse al actor que puede manejarla. Sin embargo, si el suscriptor final no define un manejador para la se帽al onError, onError lanza un UnsupportedOperationException.
Adem谩s, la sem谩ntica de las secuencias reactivas define que onError es una operaci贸n terminal, tras la cual despu茅s de la cual la secuencia reactiva deja de ejecutarse. En ese momento, podemos reaccionar de otra manera aplicando una de las siguientes  estrategias:
  
* Por supuesto, debemos definir manejadores para la se帽al onError en el operador subscribe la secuencia reactiva.
  
* Podemos atrapar y sustituir un error por un valor est谩tico por defecto o un valor calculado de la excepci贸n aplicando el operador onErrorReturn.
  
  Ejemplo de implementaci贸n del operador errorReturn
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

* Podemos atrapar una excepci贸n y ejecutar un flujo de trabajo alternativo aplicando el operador onErrorResume.
  
  Ejemplo de implementaci贸n del operador errorResume
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
  
* Podemos capturar y transformar una excepci贸n en otra que represente mejor la situaci贸n representa la situaci贸n aplicando el operador onErrorMap.
  
  Ejemplo de implementaci贸n del operador errorMap
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195711894-c79dcd67-b3d3-432a-9541-53522418cd5f.png"/>
  </p>
  
  Resultado: 
  <p align="center">
    <img src="https://user-images.githubusercontent.com/106001562/195712075-7603e1c4-4a60-4767-b69f-16996e8fa096.png"/>
  </p>
  
## Autores 鉁掞笍
* **Daniel Steven Gil Cruz** 
* **John Edward Acevedo Rojas** 
* **Diego Felipe Mu帽oz Mosquera** 
