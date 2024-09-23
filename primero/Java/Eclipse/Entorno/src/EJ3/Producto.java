package EJ3;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadDisponible;

    public Producto(String nombre, double precio, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

   
    public void reducirCantidad(int cantidad) {
        cantidadMayorACero(cantidad);
        if (cantidad > cantidadDisponible) {
            System.out.println("Error: No hay suficiente stock disponible");
            return;
        }
        cantidadDisponible -= cantidad;
    }


	private void cantidadMayorACero(int cantidad) {
		if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser mayor que cero");
            return;
        }
	}

    public void aumentarCantidad(int cantidad) {
        cantidadMayorACero(cantidad);
        cantidadDisponible += cantidad;
    }

    public double calcularTotal(int cantidad) {
    	if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser mayor que cero");
            return 0;
        }
        return precio * cantidad;
    }


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidadDisponible() {
		return cantidadDisponible;
	}


	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
    
    
}

