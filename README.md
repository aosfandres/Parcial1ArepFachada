# Parcial1ArepFachada
1 Construir un servicio WEB (puede usar Spark o Sockets) que reciba un número y una cadena de tres caracteres. La cadena puede ser una de tres opciones: "cos", "sin", "tan". El servicio asume que el número que recibe está en radianes y retorna una estructura JSON con el valor de la función trigonométrica correspondiente. 

2 Construya otro servicio Web (puede usar Spark o Sockets) que sea una fachada del servicios construido en el primer punto. Es decir, este servicio recibe los mismos parámetros y regresa el mismo resultado, pero para hacer el cálculo debe invocar via http al servicio web que se constuyó en el primer punto.

3 Su diseño debe soportar la composición de nuevas operaciones para modificar servicios existentes o componer nuevos servicios. Por ejemplo, piense que en el futuro podemos solicitar que se creen nuevos servicios sobre  el API web, es decir,  debe ser fácilmente extensible.

4 El diseño de los servicios WEB debe tener en cuenta buenas prácticas de diseño OO.

5 Despliegue los servicios en Heroku en dynos separados.

6 Construya un cliente JAVA para probar los dos servicios.

7 El cliente y los servicios debe entregarlos en dos proyectos estructurado con Maven. El primero con el servicio fachada y el cliente. Y el segundo con el servicio web concreto.

8 El cliente debe traer "quemada" en el código fuente la url de su aplicación desplegada en Heroku.

# REQUISITOS
- Java 
- Maven 

# DESPLIEGUE

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://lit-crag-29952.herokuapp.com/)

# USO

PARA USO LOCAL:
- clonar el repositorio
- contruir el proyecto (mvn package)
- ejecutar con java -cp target/classes:target/dependency/* edu.escuelaing.arep.app.App o java -cp target/classes:target/dependency/* edu.escuelaing.arep.app.Cliente para usar el cliente
- visitar http://localhost:4567/ y seguir las intrucciones

PARA USO WEB:
- visitar https://lit-crag-29952.herokuapp.com/ y seguir intrucciones

# AUTOR
ANDRES ORLANDO SOTELO FAJARDO
