package com.example.workflow;

import org.camunda.bpm.dmn.feel.impl.juel.FeelEngineFactoryImpl;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.*;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.LongValue;
import org.camunda.commons.utils.StringUtil;

import jakarta.inject.Named;
import org.camunda.feel.FeelEngine;
import org.joda.time.DateTime;
import org.joda.time.ReadablePeriod;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Named
public class ReserveSeatOnBoat implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object my = delegateExecution.getVariable("my");
        Object my2 = delegateExecution.getVariable("my2");
        String msg = (String) delegateExecution.getVariable("message");
        System.out.println(msg);
        String ticketType = "Coach";

        LongValue money = delegateExecution.getVariableTyped("money");
        Long moneyDouble = money.getValue();
        if (moneyDouble >= 10000) {
            ticketType = "First Class";
        } else if (moneyDouble >= 5000) {
            ticketType = "Business Class";
        } else if (moneyDouble <= 10) {
            ticketType = "Stoway class";
            throw new BpmnError("FALL_OVERBOAARD", "you overboard");
        }

        delegateExecution.setVariable("ticketType", ticketType);
    }
}