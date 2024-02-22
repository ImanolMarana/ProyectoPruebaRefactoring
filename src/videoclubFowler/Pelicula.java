package videoclubFowler;

public class Pelicula {
    public static final int NINOS = 2;
    public static final int NORMAL = 0;
    public static final int ESTRENO = 1;
    private String _titulo;
    private int _codigoPrecio;
    public Pelicula(String titulo, int codigoPrecio) {
       _titulo = titulo;
       _codigoPrecio = codigoPrecio;
    }
    public int getCodigoPrecio() {
       return _codigoPrecio;
    }
    public void setCodigoPrecio(int arg) {
       _codigoPrecio = arg;
    }
    public String getTitulo (){
	return _titulo;
    }
}
