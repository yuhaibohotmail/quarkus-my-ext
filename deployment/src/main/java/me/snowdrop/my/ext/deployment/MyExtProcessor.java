package me.snowdrop.my.ext.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import me.snowdrop.my.ext.HelloWorldServlet;
import io.quarkus.undertow.deployment.ServletBuildItem;

class MyExtProcessor {

    private static final String FEATURE_NAME = "my-ext";
    private static final String HELLO_SERVLET_NAME = "HelloServlet";

    @BuildStep
    FeatureBuildItem createFeatureItem() {
        System.out.println("MyExtProcessor.createFeatureItem");
        return new FeatureBuildItem(FEATURE_NAME);
    }

    @BuildStep
    ServletBuildItem createHelloWorldServlet() {
        System.out.println("MyExtProcessor.createHelloWorldServlet");
        ServletBuildItem servletBuildItem = ServletBuildItem.builder(HELLO_SERVLET_NAME, HelloWorldServlet.class.getName())
                .addMapping(newServlet().URL_PATTERN)
                .setLoadOnStartup(1)
                .build();
        return servletBuildItem;
    }

    private static HelloWorldServlet newServlet() {
        return new HelloWorldServlet();
    }

}
