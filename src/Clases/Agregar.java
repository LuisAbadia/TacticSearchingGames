/*Universidad del Valle de Guatemala
*Luis Abadía
*Carnet 13300
* Clase Agregar
*Descripcion: en esta clase se se buscaba poder agregar usuarios desde la interfaz 
*/

package Clases;

import org.neo4j.graphdb.Node;
import static org.neo4j.kernel.impl.index.IndexEntityType.Node;
import static org.neo4j.server.rest.repr.ListRepresentation.string;

public class Agregar {
    
    Node nodo;
    
    public Agregar(){
    
    }
    
    public void setUsserName(String val){
        nodo.getProperty(val);
    }
    public Node getUsserName(){
        return nodo;
    }
    
}
