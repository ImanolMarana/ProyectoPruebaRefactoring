package videoclubFowler;

class Alquiler {
    private Pelicula _pelicula;
    private int _diasAlquiler;
    public Alquiler(Pelicula pelicula, int diasAlquiler) {
       _pelicula = pelicula;
      _diasAlquiler = diasAlquiler;
    } 
    public int getDiasAlquiler() {
       return _diasAlquiler;
    }
    public Pelicula getPelicula() {
       return _pelicula;
    }
}
