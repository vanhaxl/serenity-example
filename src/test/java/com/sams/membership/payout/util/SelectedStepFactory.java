package com.sams.membership.payout.util;

import java.util.List;

import org.jbehave.core.configuration.Configuration;

import net.serenitybdd.jbehave.SerenityStepFactory;

public class SelectedStepFactory extends SerenityStepFactory {

    List<Class> mappedSteps;

    public SelectedStepFactory(Configuration configuration, String rootPackage, ClassLoader classLoader, List<Class> mappedSteps) {
        super(configuration, rootPackage, classLoader);
        this.mappedSteps = mappedSteps;
    }

    protected List<Class> getCandidateClasses() {
        return mappedSteps;
    }

}
