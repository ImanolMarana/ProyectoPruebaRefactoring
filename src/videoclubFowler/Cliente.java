package videoclubFowler;

import java.util.Iterator;
import java.util.Vector;

class Cliente {
    private String _nombre;
    private Vector _alquileres = new Vector();
    public Cliente (String nombre){
        _nombre = nombre;
    }
    public void addAlquiler(Alquiler arg) {
       _alquileres.addElement(arg);
    }
    public String getNombre (){
    	return _nombre;
    }
    public String extracto() {
        double cantidadTotal = 0;
        int puntosCliente = 0;
        Iterator alquileres = _alquileres.iterator();
        String result = "Registro Alquiler para " + getNombre() + "\n";
        while (alquileres.hasNext()) {
        	double unaCantidad = 0;
        	Alquiler elem = (Alquiler) alquileres.next();
        	//determinar cantidad para cada linea
        	switch (elem.getPelicula().getCodigoPrecio()) {
    			case Pelicula.NORMAL:
    				unaCantidad += 2;
    				if (elem.getDiasAlquiler() > 2)
    					unaCantidad += (elem.getDiasAlquiler()-2)*1.5;
    				break;
    			case Pelicula.ESTRENO:
    				unaCantidad += elem.getDiasAlquiler() * 3;
    				break;
    			case Pelicula.NINOS:
    				unaCantidad += 1.5;
    				if (elem.getDiasAlquiler() > 3)
    					unaCantidad += (elem.getDiasAlquiler()-3)*1.5;
    				break;
        	}
        	// a�adir puntos cliente asiduo
        	puntosCliente ++;
        	// a�adir bonus para un alquiler de un estreno para 2 d�as
        	if ((elem.getPelicula().getCodigoPrecio() == Pelicula.ESTRENO)
        			&& elem.getDiasAlquiler() > 1) puntosCliente ++;
        	//mostrar datos de este alquiler
        	result += "\t" + elem.getPelicula().getTitulo()+ "\t" +
        			String.valueOf(unaCantidad) + "\n";
        	cantidadTotal += unaCantidad;
       }
       //a�adir l�neas de p�e de extracto
       result += "Cantidad a pagar es " + String.valueOf(cantidadTotal) + "\n";
       result += "Has ganado " + String.valueOf(puntosCliente)
    		+ " puntos cliente asiduo";
       return result;
    }


}
