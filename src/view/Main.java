package view;

import controller.*;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		final int COZIMENTO_SIMULTANEOS = 5;
		final int ENTREGAS_POR_VEZ = 1;

		Thread1[] threads = new Thread1[21];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread1(i + 1, semaforo);

			threads[i].start();
		}
		Semaphore semaforoCozimento = new Semaphore(COZIMENTO_SIMULTANEOS);
		Semaphore semaforoEntrega = new Semaphore(ENTREGAS_POR_VEZ);

		Thread2[] pratos = new Thread2[10];
		for (int i = 0; i < pratos.length; i++) {
			pratos[i] = new Thread2(i, semaforoCozimento, semaforoEntrega);
			pratos[i].start();
		}
	}

}
