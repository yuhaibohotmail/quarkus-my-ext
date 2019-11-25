package me.snowdrop.my.ext.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import me.snowdrop.my.ext.HelloWorldServlet;
import io.quarkus.undertow.deployment.ServletBuildItem;

class MyExtProcessor {

    private static final String FEATURE_NAME = "my-ext";

    @BuildStep
    ServletBuildItem createHelloWorldServlet() {
        System.out.println("MyExtProcessor.createHelloWorldServlet");
        ServletBuildItem servletBuildItem = ServletBuildItem.builder(FEATURE_NAME, HelloWorldServlet.class.getName())
                .addMapping(FEATURE_NAME)
                .build();
        return servletBuildItem;
    }

    @BuildStep
    FeatureBuildItem createFeatureItem() {
        System.out.println("MyExtProcessor.createFeatureItem");
        return new FeatureBuildItem(FEATURE_NAME);
    }

}
