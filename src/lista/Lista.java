package lista;

public class Lista {
	private int n; // número de elementos en la lista
	private int max; // capacidad de la lista
	private int[] lista; // lista
	
	public Lista(){
		n = 0;
		max = 0;
		lista = null;
	}
	
	public Lista(int max){
		n = 0;
		this.max = max;
		lista = new int[max];
	}
	
	public Lista(int [] l){
		n = l.length;
		max = l.length;
		lista = (int[])l.clone();
	}
	
	public void anyadirElem(int e){
		if (n < max){
			lista[n] = e;
			n++;
		}
	}
	
	public int[] corte(int i, int j){
		Lista sublista = new Lista(max);
		int[] resultado;
		
		if (i<0 && j>n){
			i=0;
			j=n;
		}
		
		if (i<=j){
			for (int pos=i; pos<j; pos+=1)
				sublista.anyadirElem(lista[pos]);
		}
		
		resultado = new int[sublista.n];
		System.arraycopy( sublista.lista, 0, resultado, 0, sublista.n );
		return resultado;
	}
	
	public void mostrarLista(){
		System.out.println("Lista actualizada ...");
		for (int i = 0; i<n; i++)
			System.out.println(lista[i]);
	}
	
}