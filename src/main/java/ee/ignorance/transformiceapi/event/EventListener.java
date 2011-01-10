package ee.ignorance.transformiceapi.event;

public interface  EventListener {

	public boolean matches(Event e);
	
	public void actionPerformed(Event e);
	
}
