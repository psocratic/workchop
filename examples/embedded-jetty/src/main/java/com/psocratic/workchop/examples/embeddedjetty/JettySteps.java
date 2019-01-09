package com.psocratic.workchop.examples.embeddedjetty;

import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.step.StepExecutionException;
import com.psocratic.workchop.util.kit.Kit2;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

import javax.servlet.ServletException;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;

class JettySteps {
    private JettySteps() {}

    private static class AttachServletHandler implements Step<Kit2<Server, ServletContextHandler>, Server> {
        @Override
        public Server execute(Kit2<Server, ServletContextHandler> input) throws StepExecutionException {
            Server server = input.one();
            ServletContextHandler servletHandler = input.two();
            server.setHandler(servletHandler);
            return server;
        }
    }

    private static class CreateServer implements Step<Configuration, Server> {
        @Override
        public Server execute(Configuration configuration) {
            return new Server(configuration.getPort());
        }
    }

    private static class CreateServletHandler implements Step<Configuration, ServletContextHandler> {
        @Override
        public ServletContextHandler execute(Configuration configuration) {
            ServletContextHandler servletHandler = new ServletContextHandler(SESSIONS);
            servletHandler.setContextPath(configuration.getPath());
            servletHandler.addServlet(DefaultServlet.class, "/");
            return servletHandler;
        }
    }

    private static class InitializeWebSocketContainer implements Step<ServletContextHandler, ServletContextHandler> {
        @Override
        public ServletContextHandler execute(ServletContextHandler context) throws StepExecutionException {
            try {
                WebSocketServerContainerInitializer.configureContext(context);
                return context;
            } catch (ServletException e) {
                throw new StepExecutionException("Failed to initialize web socket server container", e);
            }
        }
    }

    static Step<Kit2<Server, ServletContextHandler>, Server> attachServletHandler() {
        return new AttachServletHandler();
    }

    static Step<ServletContextHandler, ServletContextHandler> initializeWebSocketContainer() {
        return new InitializeWebSocketContainer();
    }

    static Step<Configuration, Server> newServer() {
        return new CreateServer();
    }

    static Step<Configuration, ServletContextHandler> newServletHandler() {
        return new CreateServletHandler();
    }
}
