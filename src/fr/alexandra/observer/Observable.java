package fr.alexandra.observer;

public interface Observable {
	public void addObservateur(Observateur obs);
	public void dellObservateur();
	public void updateObservateur();

}
