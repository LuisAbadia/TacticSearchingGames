/*Universidad del Valle de Guatemala
*Luis Abadía
*Carnet 13300
* Clase Metodos
*Descripcion: en esta clase se hace la referencia al directorio de neo4j y ademas se establece la coneccion,
*ademas, contiene metodos para insertar y buscar nodos.
*/

package Clases;

import java.io.File;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 *
 * @author LuisEstuardo
 */
public class Metodos {

    //Atributos
    public static final String MainPath = "C:\\Users\\LuisEstuardo\\Documents\\Neo4j\\default.graphdb";//Directorio de mi base de datos
    private static GraphDatabaseService graphDatabaseService; //Objeto de Servicio del grafo
    private Node user; // nodo usuario, para poder comparar mi usuario actual
    private Node user2;//nodo usuario2
    private Node nodo1;
    private String nombre;
    private String edad;
    private String username;//variable para guardar nombre
    private String password;//variable para guardar contraseña
    private String username2;//variable para guardar nuevo usuario
    private boolean exists = false;
    
    /*
    *Constructor
    */
    public Metodos(String username, String password){//, String nombre, String edad){
        this.username = username;//agrego mis parametros enviados desde vista2 y los guardo en las variables locales
        this.password = password;//lo mismo de arriba
        this.nombre = nombre;
        this.edad = edad;
        this.graphDatabaseService = new GraphDatabaseFactory().newEmbeddedDatabase(new File (MainPath));
    }
    
    /*
    *Constructor2
    */
    public Metodos(){}
    
//******************************************************************************
    /*
    *Creo mis tipos de nodos y mis relaciones
    *Tipo de Nodos
    */
    private static enum NodeType implements Label{
        USER,Juego,TIPO_JUEGO;
    }
    
    /*
    *Creo mis tipos de nodos y mis relaciones
    *Tipo de Relaciones
    */
    private static enum RelType implements RelationshipType{
        ES_TIPO,Play, INTERES;
    }
    
    
//******************************************************************************
    
    /**
     * Metodo para abrir base de datos existente
     * @param mode modo del metodo (0. Busqueda de usuarios,1. Ingreso de nuevo usuario,2.Agregar relacion conocido
     */
    public void openDatabase(int mode){
        boolean state = false;
        boolean found = false;
        Node user = null;
        boolean unregistered = true;
        
        try (Transaction tx = graphDatabaseService.beginTx()){
        
        //Verificar usuario y contraseña
        if (mode == 0){
            //Buscar todos los usuarios
            ResourceIterator<Node> users = this.graphDatabaseService.findNodes(NodeType.USER);
            while(users.hasNext()){
                user = users.next();
                if (user.getProperty("Username").equals(this.username)){
                    state = true;
                    break;
                }
            }
            //Si se encontro el usuario
            if (state){
                if (!user.getProperty("Password").equals(this.password)){
                    JOptionPane.showMessageDialog(null, "Password incorrecto");
                    this.user = null;
                } else {
                    this.user = user;
                    found = true;
                }
                unregistered = true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no registrado");
                unregistered = false;
                this.user = null;
            }
        } else if (mode == 1){
            //Ingresar nuevo usuario, creo el nodo
            user = graphDatabaseService.createNode(NodeType.USER);
            user.setProperty("Username", this.username);
            user.setProperty("Password", this.password);
            //user.setProperty("Name", this.nombre);
            //user.setProperty("Age", this.edad);
            
            this.user = user;
        } 
        /*else if (mode == 2){
            boolean state2 = false;
            //Buscar todos los usuarios
            ResourceIterator<Node> users2 = this.graphDatabaseService.findNodes(NodeType.USER);
            while(users2.hasNext()){
                user = users2.next();
                if (user.getProperty("Username").equals(this.username2)){
                    state2 = true;
                    break;
                }
            }
        
            //Si se encontro el usuario
            if (state2){
                this.user2 = user;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no existe");
                this.user2 = null;
            }
        }
        */
        tx.success();
        if (!unregistered){
            tx.close();
            this.graphDatabaseService.shutdown();
        }
        }
    }
    
    /*
    *Metodo para eliminar los nodos y las relaciones
    *Lo agregue porque antes eliminaba la base cada vez que iniciaba
    */
    public static void removeData(){

        GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase(new File(MainPath));

        try (Transaction tx = db.beginTx()){

            for (Node nodo:db.getAllNodes()){

                //Eliminar relaciones

                for (Relationship relation:nodo.getRelationships()){

                    relation.delete();

                }

                //Eliminar nodo

                nodo.delete();

            }

            tx.success();

            System.out.println("Se ha reiniciado la base de datos");

        }

    }
    


    /**
     * Metodo para cerrar base de datos
     */
    public void shutdown(){
        //Cerrar base de datos
        this.graphDatabaseService.shutdown();
        System.out.println("Se ha cerrado la base de datos");
    }

    
    
    

    /**
     * Metodo para establecer relacion con Tipo de juego y el usuario
     * @param user1 usuario principal
     * @param tipo tipo de juego
     */
    public void Relacionar(Node user1, String tipo){

        GraphDatabaseService db = new GraphDatabaseFactory().newEmbeddedDatabase(new File(MainPath));
        try (Transaction tx = db.beginTx()){
            Node node1 = db.findNode(NodeType.USER, "Username", user1);
            Node node2 = db.findNode(NodeType.TIPO_JUEGO, "TIPO_JUEGO", tipo);
            node1.createRelationshipTo(node2, RelType.INTERES);

            tx.success();
        }
        db.shutdown();
    }

    
//REVISAR***********************************---------------------------------
    /**
     * Metodo de busqueda de personas 
     * @param user usuario principal
     * @return 
     */
//REVISAR***********************************---------------------------------
    public Vector<Node> searchFriends(Node user){
        Vector<Node> friends = new Vector(); // creo la variable amigos
        try (Transaction tx = this.graphDatabaseService.beginTx()){ //empiezo mi database
            for (Relationship friendship: user.getRelationships(RelType.INTERES)){//Aca deberia ser con el mismo interes
                Node friend = friendship.getOtherNode(user);//Tomo el otro o los otros con el mismo interes
                friends.add(friend);//
            }
            tx.success();

        } catch (Exception eq){ 
        }
        return friends;

    } 
    
    
    /*
    *Establecer relacion entre los 2 nodos, pero devolviendo relacion
    */
    public Relationship Relacion(Node user1, Node user2){

        Relationship relationship = null;//inicializo mi objeto en null
        Transaction tx = this.graphDatabaseService.beginTx();

        try {
            relationship = user1.createRelationshipTo(user2, RelType.INTERES);//le agrego mi nueva relacion 
            tx.success();
        } finally {
            tx.close();
        }
        return relationship;//devuelvo la relacion
    }
    
    
    
//***************************Metodos Set y GET**********************************    
    /**
     * @return the user
     */
    public Node getUser() {
        return user;
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param user the user to set
     */
    public void setUser(Node user) {
        this.user = user;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the graphDatabaseService
     */
    public GraphDatabaseService getGraphDatabaseService() {
        return graphDatabaseService;
    }
    /**
     * @param graphDatabaseService the graphDatabaseService to set
     */
    public void setGraphDatabaseService(GraphDatabaseService graphDatabaseService) {
        this.graphDatabaseService = graphDatabaseService;
    }
    /**
     * @return the user2
     */
    public Node getUser2() {
        return user2;
    }
    /**
     * @param user2 the user2 to set
     */
    public void setUser2(Node user2) {
        this.user2 = user2;
    }
    /**
     * @return the username2
     */
    public String getUsername2() {
        return username2;
    }
    /**
     * @param username2 the username2 to set
     */
    public void setUsername2(String username2) {
        this.username2 = username2;
    }
}
