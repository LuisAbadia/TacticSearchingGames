/*Universidad del Valle de Guatemala
*Luis Abadía
*Carnet 13300
* Clase Usuario
*Descripcion: en esta clase se esperaba poder modificar los datos del usuario,
*tomando el nodo, modificandolo con datos nuevos y actualizar el nodo, sin embargo se cambio de metodo para hacer esto
*Esta clase no es vital para el funcionamiento
*/
package Clases;

//Se importan librerias
import org.neo4j.graphdb.Node;


/**
 *
 * @author LuisEstuardo
 */


public class Usuario {
    
    //Se crea un objeto de tipo Node
   private Node nodo;
   
   //Se crea una variable
   String nombre1;
   
   public Usuario(){
       nombre1 ="PEDRO";
   }
   
   
   //Se crea el metodo Set
   public void setNodo1(String nom){                       //REVISAAAR
       nombre1 = nom;
   }
   //Se crea el metodo Get
   public Object getNodo1(){
       return nombre1;
   }
}