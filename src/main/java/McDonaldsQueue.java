package main.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class McDonaldsQueue<T> {
	private static final int MAX_SIZE = 10;
	private Queue<T> msgQueue;
	private long maxSize;
	
	// Semaforos para contabilizar quantos estão dormindo
	private int countConsumer = 0;
	private int countProducer = 0;
	
	/**
	 * Cria uma fila e um monitor para ela com limite de tamanho
	 * 
	 * @param maxSize o tamanho máximo da fila
	 */
	public McDonaldsQueue(long maxSize) {
		this.msgQueue = new LinkedList<T>();
		this.maxSize = maxSize;
	}
	
	/**
	 * Cria uma fila e um monitor para ela
	 */
	public McDonaldsQueue() {
		this.msgQueue = new LinkedList<T>();
		this.maxSize = MAX_SIZE;
	}

	/**
	 * Insere um novo item na fila e notifica quem aguardava para consumir
	 * 
	 * @param obj o objeto a ser inserido
	 */
	public synchronized void insert(T obj) {
		// dorme se não ha espaco no buffer
		checkSleepProducer();
		
		// adiciona o item no buffer
		msgQueue.add(obj);
		
		// acorda um consumidor se necessario
		if (hasWakupConsumer())
			notify();
	}
	
	/**
	 * Insere varios itens na fila e notifica quem aguardava para consumir somente apos inserir todos os objetos
	 * 
	 * @param objs os objetos a serem inseridos
	 */
	public synchronized void insert(List<T> objs) {
		if(objs == null || objs.size() == 0)
			return;
		
		// dorme se não ha espaco no buffer
		checkSleepProducer();
		
		// adiciona os itens no buffer
		msgQueue.addAll(objs);
		
		// acorda um consumidor se necessario
		if (hasWakupConsumer())
			notify();
	}

	/**
	 * Busca um novo item na fila e aguarda até que ele esteja disponível
	 * 
	 * @return o item da fila
	 */
	public synchronized T remove() {
		// dorme se não ha itens no buffer
		checkSleepConsumer();
		
		// remove item do buffer
		T obj = msgQueue.poll();
		
		// acorda um produtor se necessario
		if (hasWakupProducer())
			notify();
		
		return obj;
	}
	
	/**
	 * Retorna o proximo item da fila sem remove-lo
	 * 
	 * @return o item da fila
	 */
	public synchronized T peek() {
		checkSleepConsumer();
		
		return msgQueue.peek();
	}
	
	/**
	 * Informa o tamanho da fila
	 * 
	 * @return o tamanho da fila
	 */
	public synchronized int size() {
		return msgQueue.size();
	}

	/**
	 * Limpar a fila
	 */
	public synchronized void clean() {
		msgQueue.clear();
	}
	
	/**
	 * Retorna o tamanho máximo da fila
	 * 
	 * @return o tamanho máximo da fila
	 */
	public long getMaxSize() {
		return maxSize;
	}

	/**
	 * Ajusta o tamanho máximo da fila
	 * 
	 * @param maxSize o novo tamanho máximo da fila
	 */
	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}
	
	/**
	 * Aguarda disponibilidade
	 */
	private void goToSleep() {
		try{
			wait();
		} catch(InterruptedException exc) {}
	}

	/**
	 * Continua domindo enquanto não ha espaco no buffer
	 */
	private void checkSleepProducer() {
		countProducer++;
		while (size() == getMaxSize())
			goToSleep();
		countProducer--;
	}
	
	/**
	 * Continua dormindo até que haja itens para consumir
	 */
	private void checkSleepConsumer() {
		countConsumer++;
		while (size() == 0)
			goToSleep();
		countConsumer--;
	}

	/**
	 * Verifica se ha produtores dormindo
	 * @return
	 */
	private boolean hasWakupProducer() {
		return size() == getMaxSize() - 1 || countProducer > 1;
	}
	
	/**
	 * Verifica se ha consumidores dormindo
	 * @return
	 */
	private boolean hasWakupConsumer() {
		return size() == 1 || countConsumer > 1;
	}

	public int getCountConsumer() {
		return countConsumer;
	}

	public int getCountProducer() {
		return countProducer;
	}
}
