package videoclubFowler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	Cliente cliente1;
	Cliente cliente2;
	Pelicula peliculaNinos;
	Pelicula peliculaEstreno;
	Pelicula peliculaNormal;
	@Before
	public void setUp() throws Exception {
		 cliente1 = new Cliente("David");
		 cliente2 = new Cliente("Julia");
		 peliculaNinos = new Pelicula("Madagascar", Pelicula.NINOS);
		 peliculaEstreno = new Pelicula("Star Wars", Pelicula.ESTRENO);
		 peliculaNormal = new Pelicula("Gone with the Wind", Pelicula.NORMAL);
	}

	@Test
	public void testCliente() {
		assertNotNull(cliente1);	
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("David", cliente1.getNombre());
	}

	@Test
	public void testAddAlquiler() {
		Alquiler alquiler1 = new Alquiler(peliculaNormal, 3); // 3 d�as de alquiler
		cliente2.addAlquiler(alquiler1);
	}

	@Test
	public void testExtractoPeliculaNormal() {
		Alquiler alquiler1 = new Alquiler(peliculaNormal, 3); // 3 d�as de alquiler
		cliente2.addAlquiler(alquiler1);
		String expected = "Registro Alquiler para Julia\n" +
							"\tGone with the Wind\t3.5\n" +
							"Cantidad a pagar es 3.5\n" +
							"Has ganado 1 puntos cliente asiduo";
		String extracto = cliente2.extracto();
		assertEquals(expected, extracto);
	}
	
	@Test
	public void testExtractoPeliculaEstreno() {
		Alquiler alquiler1 = new Alquiler(peliculaEstreno, 3); // 3 d�as de alquiler
		cliente2.addAlquiler(alquiler1);
		String expected = "Registro Alquiler para Julia\n" +
							"\tStar Wars\t9.0\n" +
							"Cantidad a pagar es 9.0\n" +
							"Has ganado 2 puntos cliente asiduo";
		String extracto = cliente2.extracto();
		assertEquals(expected, extracto);
	}
	
	@Test
	public void testExtractoPeliculaNinos() {
		Alquiler alquiler1 = new Alquiler(peliculaNinos, 3); // 3 d�as de alquiler
		cliente2.addAlquiler(alquiler1);
		String expected = "Registro Alquiler para Julia\n" +
							"\tMadagascar\t1.5\n" +
							"Cantidad a pagar es 1.5\n" +
							"Has ganado 1 puntos cliente asiduo";
		String extracto = cliente2.extracto();
		assertEquals(expected, extracto);
	}
	
	@Test
	public void testExtractoForManyPeliculas() {
		Alquiler alquiler1 = new Alquiler(peliculaNinos, 6); // 6 d�as de alquiler
		Alquiler alquiler2 = new Alquiler(peliculaEstreno, 2); // 2 d�as de alquiler
		Alquiler alquiler3 = new Alquiler(peliculaNormal, 8); // 8 d�as de alquiler
		cliente1.addAlquiler(alquiler1);
		cliente1.addAlquiler(alquiler2);
		cliente1.addAlquiler(alquiler3);
		String expected = "Registro Alquiler para David\n" +
							"\tMadagascar\t6.0\n" +
							"\tStar Wars\t6.0\n" +
							"\tGone with the Wind\t11.0\n" +
							"Cantidad a pagar es 23.0\n" +
							"Has ganado 4 puntos cliente asiduo";
		String extracto = cliente1.extracto();
		assertEquals(expected, extracto);
	}
}
