package com.psocratic.workchop.examples.embeddedjetty;

import com.psocratic.workchop.Workchop;
import com.psocratic.workchop.line.Line;
import com.psocratic.workchop.line.LineFactory;
import com.psocratic.workchop.line.LineFactoryException;
import com.psocratic.workchop.line.LineResult;
import com.psocratic.workchop.spec.ExtensibleSpecs;
import com.psocratic.workchop.spec.Spec;
import com.psocratic.workchop.spec.StepSpecs;
import org.eclipse.jetty.server.Server;

import java.util.Arrays;
import java.util.List;

import static com.psocratic.workchop.examples.embeddedjetty.ConfigurationSteps.*;
import static com.psocratic.workchop.examples.embeddedjetty.JettySteps.*;

public class Main {
    public static void main(String[] args) throws Exception {
        LineFactory lineFactory = Workchop.lineFactory();

        Spec<List<String>, Configuration> configurationSpec
                = ExtensibleSpecs.<List<String>>intake()
                    .inParallel(
                            StepSpecs.create(extractPath()),
                            ExtensibleSpecs.<List<String>>intake()
                                .inSeries(extractPort())
                    )
                    .inSeries(createConfiguration());

        Line<List<String>, Configuration> configurationLine
                = lineFactory.create(configurationSpec);

        LineResult<Configuration> configurationResult
                = configurationLine.execute(Arrays.asList(args));

        if(!configurationResult.succeeded())
            System.exit(1);

        Spec<Configuration, Server> serverSpec
                = ExtensibleSpecs.<Configuration>intake()
                    .inParallel(
                        StepSpecs.create(newServer()),
                        ExtensibleSpecs.<Configuration>intake()
                            .inSeries(newServletHandler())
                            .inSeries(initializeWebSocketContainer())
                    ).inSeries(attachServletHandler());

        Line<Configuration, Server> line = lineFactory.create(serverSpec);

        LineResult<Server> serverResult = line.execute(configurationResult.getValue());

        if(!serverResult.succeeded())
            System.exit(1);

        serverResult.getValue().start();
    }
}
