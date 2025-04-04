public abstract class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }
    public abstract double calcularPago();
}

class Gerente extends Empleado {
    public Gerente(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularPago() {
        return salario + 1000;
    }
}

class Desarrollador extends Empleado {
    public Desarrollador(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularPago() {
        return salario;
    }
}

class Practicante extends Empleado {
    public Practicante(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularPago() {
        return salario * 0.5;
    }
}
class RepositorioEmpleado {
    public void guardar(Empleado empleado) {
        System.out.println("Guardando empleado " + empleado.getNombre() + " en la base de datos...");
    }
}

class GeneradorReporte {
    public void generar(Empleado empleado) {
        System.out.println("Generando reporte para el empleado " + empleado.getNombre() + "...");
    }
}

class SistemaGestionEmpleados {
    private RepositorioEmpleado repositorio;
    private GeneradorReporte generador;

    public SistemaGestionEmpleados(RepositorioEmpleado repositorio, GeneradorReporte generador) {
        this.repositorio = repositorio;
        this.generador = generador;
    }

    public void procesarEmpleado(Empleado empleado) {
        double pago = empleado.calcularPago();
        System.out.println("Pago calculado para " + empleado.getNombre() + ": " + pago);
        repositorio.guardar(empleado);
        generador.generar(empleado);
    }
}
public class Main {
    public static void main(String[] args) {
        Empleado gerente = new Gerente("Juan", 5000);
        Empleado desarrollador = new Desarrollador("Ana", 3000);
        Empleado practicante = new Practicante("Luis", 1000);

        RepositorioEmpleado repo = new RepositorioEmpleado();
        GeneradorReporte reporte = new GeneradorReporte();
        SistemaGestionEmpleados sistema = new SistemaGestionEmpleados(repo, reporte);

        sistema.procesarEmpleado(gerente);
        sistema.procesarEmpleado(desarrollador);
        sistema.procesarEmpleado(practicante);
    }
}
