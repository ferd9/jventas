package elaprendiz.core;
import java.sql.ResultSet;

/**
 *
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
public interface JController {    
    public ResultSet getRegistros(String nombreTabla, String[] campos, String[] columnaId, Object[] id);
    public int actualizarRegistro(String nomTabla,String[] cnls,String columnaId,Object id);
    public int agregarRegistro(String nombreTabla,String[] campos,Object[] valores);
}
