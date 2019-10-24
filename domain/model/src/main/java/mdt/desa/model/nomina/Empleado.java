package mdt.desa.model.nomina;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Empleado {
    private final String id;
    private final String nombre;
    private final String apellido;

    public static Empleado createEmpleado(String id, String nombre, String apellido) throws Exception {
        if (id.isEmpty()){
            throw new Exception("Incomplete data to create Empleado");
        }
        return new Empleado(id,nombre,apellido);
    }
}
