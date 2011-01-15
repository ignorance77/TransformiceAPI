package ee.ignorance.transformiceapi.event;

public abstract class MapXMLListener implements EventListener {

	@Override
	public boolean matches(Event e) {
		return e instanceof MapXMLEvent;
	}

}
