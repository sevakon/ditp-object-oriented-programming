package main.engine.exception;

import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Cast;

public class StackDoesNotHaveCastException extends Exception {
    public StackDoesNotHaveCastException(BattleUnitsStack stack, Cast cast) {
        super(stack.getUnit().getType() + " stack does not have " + cast + " cast");
    }
}
