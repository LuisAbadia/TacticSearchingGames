
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