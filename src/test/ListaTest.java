package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//import org.junit.runners.parameterized.*;

import lista.Lista;

@RunWith(Parameterized.class)
public class ListaTest {
	private int i;
	private int j;
	
	private static Lista lista;
	private static int[] listaSalida;
	
	//private double error; <- con el m�todo assertArrayEquals no hace falta, con assertEquals s�
	
	public ListaTest(int i, int j, Lista lista, int[] listaSalida) {
		this.i = i;
		this.j = j;
		this.lista = lista;
		this.listaSalida = listaSalida;
	}
	
	/* Estos elementos tendr�n diferentes valores para cada vez que se compruebe la funci�n
	 * corte(i,j) de la clase Lista (diferentes tests), se intentar� cubrir diferentes escenarios 
	 * cada vez que se ejecute la funci�n con los datos proporcionados
	 * 
	 * Cada l�nea crea un test
	 * **mal explicado pero yo me entiendo
	 */
	@Parameters
	public static Collection<Object[]> datos(){
		return Arrays.asList(new Object[][] {
			//i, j, lista, listaSalida 
			{0,		2,		new Lista(new int[] {3,4}), 					new int[] {3,4}		 },
			{-1, 	3, 		new Lista(new int[] {5,2}), 					new int[] {5,2}		 },
			{0,		1, 		new Lista(new int[] {7}), 						new int[] {7}		 },
			{1,		1, 		new Lista(new int[] {}), 						new int[] {}		 },
			{-5, 	-5, 	new Lista(new int[] {1,2,3,4,5,6,7}), 			new int[] {}		 },
			{-5, 	2, 		new Lista(new int[] {1,2,3,4,5,6,7}), 				new int[] {1,2}	 }, //a�adida posteriormente
			{2, 	11, 	new Lista(new int[] {1,2,3,4,5,6,7}), 			new int[] {3,4,5,6,7}}, //a�adida posteriormente
			{0,		1, 		new Lista(new int[] {}), 						new int[] {}		 },
			{0,		1, 		null, 											null				 },
			{-1,	5, 		new Lista(new int[] {5,4,3,2}), 				new int[] {5,4,3,2}	 }, //�sta no har�a falta realmente
			{2,		5, 		new Lista(new int[] {9,1,4,2,6,5,9,4,36,15}), 	new int[] {4,2,6}	 },
			{5,		4, 		new Lista(new int[] {9,1,4}), 					new int[] {}		 },
			{4,		3, 		null, 											null				 }
			
			/* Nota: la columna error no se a�ade porque no hace falta para el m�todo assertArrayEquals(...,...)
			 * 		 pero en caso de a�adirse, como queremos que no haya margen de error y d� una salida
			 * 		 en concreto, habr�a que poner 0.0
			 */
			
		});
	}
	
	
	@BeforeClass
	public static void iniListaOpCorte() { //�en realidad har�a falta?
		lista = new Lista();
	}
	
	@AfterClass
	public static void delListaOpCorte() {
		lista = null;
	}
	
	@Test
	public void testCorte() {
		assertArrayEquals(listaSalida, lista.corte(i, j));
		//assertEquals(listaSalida, lista.corte(i,j), error)
	}

}
