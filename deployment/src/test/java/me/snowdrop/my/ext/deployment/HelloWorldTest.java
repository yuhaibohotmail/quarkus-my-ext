package me.snowdrop.my.ext.deployment;

import io.quarkus.test.QuarkusUnitTest;
import io.restassured.RestAssured;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.hamcrest.core.Is.is;

public class HelloWorldTest {

    @RegisterExtension
    static QuarkusUnitTest runner = new QuarkusUnitTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                    .addClasses(HelloWorldServlet.class));

    @Test
    public void testHelloWorldServlet() {
        RestAssured.when().get("/mapped").then()
                .statusCode(200)
                .body(is("web xml servlet"));
    }
}
