# Proyecto Club

Este es uno de los primeros proyectos hechos completamente por mi, desde la parte del BackEnd con Java + sus herramientas más usadas, hasta la parte del FrontEnd con el Framework Flutter.

Es un proyecto asignado por parte de mi docente de construcción de software en mi carrera profesional de ingeniería de software, en este pude consolidar los conocimientos que ya tenía de Java y sus herramientas, además de aprender mucho más en el camino. 

## Proceso de desarrollo del proyecto

Se busco que desde el inicio se hiciera un analisis lo más profundo posible para que al pasar a la implementación ya se tuviera más claro lo que se iba a hacer, aclaro que el analisis no lo hice solo, tuve ayuda de dos grandes compañeros a los cuales les agradezco mucho por ello. 

Luego de ver el panorama general de lo que se iba a construir, se llego a la conclusión de que el paso a paso que sería más conveniente seguir, sería el siguiente:

* Generar el proyecto con la estructura que siguiera la arquitectura MVC y con maven para gestionar las dependencias.

* Crear las clases necesarias para la parte del modelo básico.

* Crear las interfaces que definieran las operaciones que se debían hacer (Controladores).

* Crear las clases que implementarán las interfaces y funciones definidas en las estas (ControladoresImp).

* Construir la clase principal que se encargará de llamar a los métodos según sea requerido.

* Agregar Spring Framework al proyecto a través de maven, luego se implementaron los beans para así lograr y entender la inversión de control (IoC por sus siglas en inglés invercion of control) e inyección de dependencias (DI por sus siglas en inglés dependency inyection), además de los siguientes patrones de diseño:
  
  * Singleton.
  
  * Prototype

* Luego de implementar y entender los conceptos anteriores, fue tiempo de pasar a las @annotations que hacen que el flujo de trabajo sea más sencillo, pero sin modificar demasiado, la estructura general permanecía igual.

* Pasar el proyecto de Spring Framework a Spring Boot, este cambio hizo que se simplificará gran parte del código, ya que Spring Boot nos ayuda con parte del trabajo que normalmente se hace manual.

## Descarga del proyecto

Si quieres clonar el proyecto y navegar entre versiones de este mismo, esta guia te puede ser útil, probablemente para muchas personas sea algo simple, pero es algo que a mi me hubiera gustado ver en otros proyectos y que me hubiera facilitado mucho las cosas.

//Instrucciones para descargar el proyecto

## Navegar entre versiones

Una manera "Simple" de navegar entre versiones de un proyecto puede ser usar el comando git checkout y el hash del commit al que se quiere ir, de esta manera git hará el trabajo de llevarlo a un entorno donde podrá ver cómo estaba el proyecto en ese momento, pero sin la posibilidad de realizar cambios, para evitar posibles errores. Se hace de la siguiente manera:

```git
git checkout <hash del commit>
```

En caso de que solo quiera copiar y pegar los comandos, a continuación pondré los detalles de cada versión y el comando exacto para ir a ella.

Proyecto bajo la arquitectua MVC, con java puro: 

```git
git checkout <hash del commit>
```
