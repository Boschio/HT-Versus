package player.states;

import player.Fighter;

public class StateManager {
    public Fighter fighter;
    public IdleState idleState;
    public CrouchingState crouchingState;
    public WalkForwardState walkForwardState;
    public WalkBackwardState walkBackwardState;
    public JumpState jumpState;
    public AttackState attackState;

    public State currentState;

    public StateManager(Fighter fighter) {
        this.fighter = fighter;

        this.idleState = new IdleState(fighter);
        this.crouchingState = new CrouchingState(fighter);
        this.walkForwardState = new WalkForwardState(fighter);
        this.walkBackwardState = new WalkBackwardState(fighter);
        this.jumpState = new JumpState(fighter);
        this.attackState = new AttackState(fighter);

        this.currentState = idleState;

    }

    public void changeState(State newState) {
        currentState = newState;
        currentState.enter();
    }

    public void update(double deltaTime){
//        State newState = currentState.update(deltaTime);
//        if (newState != null) {
//            changeState(newState);
//        }

//        System.out.println("Current State: " + currentState.toString());
    }
}
