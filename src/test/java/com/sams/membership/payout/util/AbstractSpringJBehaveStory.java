package com.sams.membership.payout.util;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.junit.Rule;

import net.serenitybdd.jbehave.SerenityStory;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;
import net.thucydides.core.util.Inflector;

public abstract class AbstractSpringJBehaveStory extends SerenityStory {
    private static final String STORY_TIMEOUT = "300";

    @Rule
    public SpringIntegrationMethodRule springIntegrationMethodRule = new SpringIntegrationMethodRule();

    public AbstractSpringJBehaveStory() {
        Embedder embedder = new Embedder();
        embedder.useEmbedderControls(embedderControls());
        embedder.useMetaFilters(Arrays.asList("-skip"));
        useEmbedder(embedder);
    }

    private EmbedderControls embedderControls() {
        return new EmbedderControls()
                .doIgnoreFailureInView(true)
                .useStoryTimeouts(STORY_TIMEOUT);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        List<Class> mappedSteps = Arrays.asList(this.getClass().getAnnotation(AcceptanceTest.class).mappedSteps());
        return new SelectedStepFactory(this.configuration(), this.getRootPackage(), this.getClassLoader(), mappedSteps);
    }

    protected String storynamesDerivedFromClassName() {
        String storyName = Inflector.getInstance().of(this.getClass().getSimpleName()).withUnderscores().toString();
        return "**/" + storyName + ".story";
    }
}
