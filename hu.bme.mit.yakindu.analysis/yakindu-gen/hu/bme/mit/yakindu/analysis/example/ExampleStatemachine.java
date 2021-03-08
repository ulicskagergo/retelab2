/** Generated by YAKINDU Statechart Tools code generator. */
package hu.bme.mit.yakindu.analysis.example;

import hu.bme.mit.yakindu.analysis.ITimer;

public class ExampleStatemachine implements IExampleStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean start;
		
		public void raiseStart() {
			start = true;
		}
		
		private boolean feher;
		
		public void raiseFeher() {
			feher = true;
		}
		
		private boolean fekete;
		
		public void raiseFekete() {
			fekete = true;
		}
		
		private long feherIdo;
		
		public long getFeherIdo() {
			return feherIdo;
		}
		
		public void setFeherIdo(long value) {
			this.feherIdo = value;
		}
		
		private long feketeIdo;
		
		public long getFeketeIdo() {
			return feketeIdo;
		}
		
		public void setFeketeIdo(long value) {
			this.feketeIdo = value;
		}
		
		protected void clearEvents() {
			start = false;
			feher = false;
			fekete = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Inicializalas,
		main_region_Fekete,
		main_region_Feher,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[2];
	public ExampleStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setFeherIdo(60);
		
		sCInterface.setFeketeIdo(60);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
				"The state machine needs to be initialized first by calling the init() function."
			);
		}
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence_main_region_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_Inicializalas:
				main_region_Inicializalas_react(true);
				break;
			case main_region_Fekete:
				main_region_Fekete_react(true);
				break;
			case main_region_Feher:
				main_region_Feher_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
	public void exit() {
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCInterface.clearEvents();
		for (int i=0; i<timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case main_region_Inicializalas:
			return stateVector[0] == State.main_region_Inicializalas;
		case main_region_Fekete:
			return stateVector[0] == State.main_region_Fekete;
		case main_region_Feher:
			return stateVector[0] == State.main_region_Feher;
		default:
			return false;
		}
	}
	
	/**
	* Set the {@link ITimer} for the state machine. It must be set
	* externally on a timed state machine before a run cycle can be correctly
	* executed.
	* 
	* @param timer
	*/
	public void setTimer(ITimer timer) {
		this.timer = timer;
	}
	
	/**
	* Returns the currently used timer.
	* 
	* @return {@link ITimer}
	*/
	public ITimer getTimer() {
		return timer;
	}
	
	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseStart() {
		sCInterface.raiseStart();
	}
	
	public void raiseFeher() {
		sCInterface.raiseFeher();
	}
	
	public void raiseFekete() {
		sCInterface.raiseFekete();
	}
	
	public long getFeherIdo() {
		return sCInterface.getFeherIdo();
	}
	
	public void setFeherIdo(long value) {
		sCInterface.setFeherIdo(value);
	}
	
	public long getFeketeIdo() {
		return sCInterface.getFeketeIdo();
	}
	
	public void setFeketeIdo(long value) {
		sCInterface.setFeketeIdo(value);
	}
	
	/* Entry action for state 'Fekete'. */
	private void entryAction_main_region_Fekete() {
		timer.setTimer(this, 0, (1 * 1000), false);
	}
	
	/* Entry action for state 'Feher'. */
	private void entryAction_main_region_Feher() {
		timer.setTimer(this, 1, (1 * 1000), false);
	}
	
	/* Exit action for state 'Fekete'. */
	private void exitAction_main_region_Fekete() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'Feher'. */
	private void exitAction_main_region_Feher() {
		timer.unsetTimer(this, 1);
	}
	
	/* 'default' enter sequence for state Inicializalas */
	private void enterSequence_main_region_Inicializalas_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Inicializalas;
	}
	
	/* 'default' enter sequence for state Fekete */
	private void enterSequence_main_region_Fekete_default() {
		entryAction_main_region_Fekete();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Fekete;
	}
	
	/* 'default' enter sequence for state Feher */
	private void enterSequence_main_region_Feher_default() {
		entryAction_main_region_Feher();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Feher;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state Inicializalas */
	private void exitSequence_main_region_Inicializalas() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Fekete */
	private void exitSequence_main_region_Fekete() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Fekete();
	}
	
	/* Default exit sequence for state Feher */
	private void exitSequence_main_region_Feher() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Feher();
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Inicializalas:
			exitSequence_main_region_Inicializalas();
			break;
		case main_region_Fekete:
			exitSequence_main_region_Fekete();
			break;
		case main_region_Feher:
			exitSequence_main_region_Feher();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Inicializalas_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_Inicializalas_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (sCInterface.start) {
					exitSequence_main_region_Inicializalas();
					enterSequence_main_region_Feher_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Fekete_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (sCInterface.fekete) {
					exitSequence_main_region_Fekete();
					enterSequence_main_region_Feher_default();
				} else {
					if (timeEvents[0]) {
						exitSequence_main_region_Fekete();
						sCInterface.setFeketeIdo(sCInterface.getFeketeIdo() - 1);
						
						enterSequence_main_region_Fekete_default();
					} else {
						did_transition = false;
					}
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Feher_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (sCInterface.feher) {
					exitSequence_main_region_Feher();
					enterSequence_main_region_Fekete_default();
				} else {
					if (timeEvents[1]) {
						exitSequence_main_region_Feher();
						sCInterface.setFeherIdo(sCInterface.getFeherIdo() - 1);
						
						enterSequence_main_region_Feher_default();
					} else {
						did_transition = false;
					}
				}
			}
		}
		return did_transition;
	}
	
}
