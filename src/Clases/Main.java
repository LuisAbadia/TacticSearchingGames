/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.util.Scanner;
import org.neo4j.cypher.internal.ExecutionEngine;
import org.neo4j.cypher.internal.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import static org.neo4j.graphdb.Label.label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import static org.neo4j.kernel.impl.index.IndexEntityType.Relationship;

/**
 *
 * @author LuisEstuardo
 */
public class Main {
    
    public Main(){
    }
    
    //Creo los tipos de nodo y realciones que se implementaran
    public enum NodeType implements Label//Nodos
    {
        persona, TipoJuego, Juego;
    }
    public enum RelationType implements RelationshipType//Relaciones
    {
        Le_Gusta, Juega, Tiene, esTipo;
    }    
    //******************************************************************************
    
    public static void main(String args[]) {
        
    //******************************************************************************        
            //Aca Agrego la Base de datos
    //******************************************************************************

    //*********************esto es para utilizar neo4j y hace el enlaze
            GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
            File direccion = new File("C:\\Users\\LuisEstuardo\\Documents\\Neo4j\\default.graphdb");//Direccion a la base de datos
            GraphDatabaseService graphDb = dbFactory.newEmbeddedDatabase(direccion);//creo el objeto para poder mandar datos a la base de datos


    //*************Borro la base de datos para que no me repita los nodos cada vez que ejecute el programa
            //graphDb.execute("MATCH (n)\n" + "OPTIONAL MATCH (n)-[r]-()\n" + "DELETE n,r");    
        
    
    
    
    /*
    //Creo Onjetos de tipo Usuario, para agregar a los nodos sus respectivos atributos
    Usuario u1 = new Usuario();

    Vista vista = new Vista();
    vista.setVisible(true);
        */  
        
    

            

            //aca se crean los nodos y las relaciones
            try(Transaction tx = graphDb.beginTx()){
                
               
/*
    //*****************creamos las propiedades de cada nodo

//*******************************PERSSONAS**************************************
                //Creo el nodo de la primera persona
                Node per1= graphDb.createNode(NodeType.persona);
                per1.setProperty("nombre", "Rose");
                per1.setProperty("Edad", 20);
                per1.setProperty("UsserName", "Killer");
                //per1.setProperty("Cambio", u1.getNodo1());
                
                
                Node per2 = graphDb.createNode(NodeType.persona);
                per2.setProperty("nombre", "Nick");
                per2.setProperty("Edad", 22);
                per2.setProperty("UsserName", "Vegetta");
                
                Node per3 = graphDb.createNode(NodeType.persona);
                per3.setProperty("nombre", "Isaac");
                per3.setProperty("Edad", 15);
                per3.setProperty("UsserName", "Last shadow");
                
//************************Nodos de Juegos***************************************
                Node juego1 = graphDb.createNode(NodeType.Juego);
                juego1.setProperty("Nombre", "Fifa" );
                
                Node juego2 = graphDb.createNode(NodeType.Juego);
                juego2.setProperty("Nombre", "Call of Duty");
                
//************************Tipos de Juegos***************************************
                Node tipJuego1 = graphDb.createNode(NodeType.TipoJuego);
                tipJuego1.setProperty("Tipo", "Deportes");
                
                Node tipJuego2 = graphDb.createNode(NodeType.TipoJuego);
                tipJuego2.setProperty("Tipo", "Shooter");
                
                
//*****************************Relaciones***************************************
                
                //persona1Relacion
                Relationship relper1 = per1.createRelationshipTo(juego2, RelationType.Juega);
                relper1.setProperty("Stars", 5);
                relper1 = per1.createRelationshipTo(tipJuego2, RelationType.Le_Gusta);
                relper1.setProperty("Favorito", "si");
                
                //persona2Relacion
                Relationship relper2 = per2.createRelationshipTo(juego2, RelationType.Juega);
                relper2.setProperty("Stars", 4);
                relper2 = per2.createRelationshipTo(juego1, RelationType.Juega);
                relper2.setProperty("Stars", 1);
                relper2 = per2.createRelationshipTo(tipJuego2, RelationType.Le_Gusta);
                relper2.setProperty("Favorito", "si");
                relper2 = per2.createRelationshipTo(tipJuego1, RelationType.Le_Gusta);
                relper2.setProperty("Favorito", "no");

                //persona3Relacion
                Relationship relper3 = per3.createRelationshipTo(juego1, RelationType.Juega);
                relper3.setProperty("Stars", 5);
                relper3 = per3.createRelationshipTo(juego2, RelationType.Juega);
                relper3.setProperty("Stars", 2);
                relper3 = per3.createRelationshipTo(tipJuego1, RelationType.Le_Gusta);
                relper3.setProperty("Favorito", "si");
                relper3 = per3.createRelationshipTo(tipJuego2, RelationType.Le_Gusta);
                relper3.setProperty("Favorito", "no");
                
                
                
                

                
*/
                //terminamos
                tx.success();
            }
    Scanner teclado = new Scanner(System.in); //Variable para leer los datos ingresados por el usuario
    int op = 0;
    
    System.out.print("Bienvenido al programa" + "*********************************\n" + 

            "1. Ver Nodos\n" );


        op = (int)teclado.nextDouble();

        

        switch(op){

            

            case 0:

                System.out.print("Menu\n" + "*********************************\n" + 

            "1. Nodos\n");

                break;

                

            case 1:
                
                
                //ExecutionEngine execEngine = new ExecutionEngine(graphDb);
                //ExecutionResult execResult = execEngine.execute("MATCH (java:JAVA) RETURN java");
                Result results = graphDb.execute("MATCH (n) RETURN n");
                System.out.println(results);
   

                
        }
            
            
            
            //apagamos la base de datos
            graphDb.shutdown();
    
    }
    

}
