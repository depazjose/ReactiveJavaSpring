package mdt.desa.model.nomina;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmpleadoTest {

    @Test
    public void shouldCreateEmpleado(){
        assertThat(Empleado.builder().id("1000").nombre("jdepaz").apellido("depaz").build()).isNotNull();
    }

    @Test(expected = Exception.class)
    public void shouldFailCreateEmpleado() throws Exception {
        Empleado.createEmpleado("","Jhon","Doe");
    }
}
