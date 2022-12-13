package poo;
import java.util.*;

public class Uso_Empleado {
    public static void main(String[] args) {

        Jefatura jefe_RRHH = new Jefatura("Juan", 55000, 2006, 9, 25);

        jefe_RRHH.establece_incentivo(2570);

        Empleado[] misEmpleados=new Empleado[6];

        misEmpleados[0]=new Empleado("Paco Gomez", 85000, 1990, 12, 17);
        misEmpleados[1]=new Empleado("Ana lopez", 95000, 1995, 06, 02);
        misEmpleados[2]=new Empleado("Maria Martin", 105000, 2002, 03, 15);
        misEmpleados[3]=new Empleado("Antonio Fernandez", 47500, 2009, 11, 9);
        misEmpleados[4]=jefe_RRHH; //Polimorfismo en accion. Principio de sustitucion
        misEmpleados[5]=new Jefatura("Maria", 95000, 1999, 05, 26);

        Jefatura jefa_finanzas=(Jefatura) misEmpleados[5];

        jefa_finanzas.establece_incentivo(55000);



        for(Empleado e: misEmpleados){
            e.subeSueldo(5);
        }

        for(Empleado e: misEmpleados){
            System.out.println("Nombre: " + e.dameNombre() + " Sueldo: " + e.dameSueldo() +
                    " Fecha de Alta: " + e.dameFechaContrato());
        }
    }

}


class Empleado{

    public Empleado(String nom, double sue, int agno, int mes, int dia ){

        nombre = nom;

        sueldo = sue;

        GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia);

        altaContrato=calendario.getTime();

        ++IdSiguiente;

        Id=IdSiguiente;
    }
    public Empleado(String nom){
        this(nom, 30000, 2000,01,01);
    }

    public String dameNombre(){ // Getter
        return nombre;
    }
    public double dameSueldo(){// Getter
        return sueldo;
    }
    public Date dameFechaContrato(){// getter
        return altaContrato;
    }
    public void subeSueldo(double porcentaje){// setter
        double aumento = sueldo*porcentaje/100;

        sueldo += aumento;
    }

    private String nombre;

    private double sueldo;

    private Date altaContrato;

    private static int IdSiguiente;

    private int Id;
}

class Jefatura extends Empleado {

    public Jefatura(String nom, double sue, int agno, int mes, int dia) {
        super(nom, sue, agno, mes, dia);
    }

    public void establece_incentivo(double b){ //setter
        incentivo = b;
    }

    public double dameSueldo(){

        double sueldoJefe =super.dameSueldo();

        return sueldoJefe + incentivo;
    }
    private double incentivo;
}