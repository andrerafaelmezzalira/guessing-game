package org.example.guessing.web;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration.ClassList;
import org.eclipse.jetty.webapp.WebAppContext;
import org.example.guessing.web.servlet.EndServlet;
import org.example.guessing.web.servlet.OkServlet;
import org.example.guessing.web.servlet.NoServlet;
import org.example.guessing.web.servlet.RegisterServlet;
import org.example.guessing.web.servlet.YesServlet;

public class MainWeb {

	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		server.setHandler(configureServerHandler());
		configureServer(server);
		server.start();
	}

	private static Handler configureServerHandler() {
		WebAppContext serverHandler = new WebAppContext();
		serverHandler.setResourceBase("web");
		serverHandler.addServlet(OkServlet.class, "/ok");
		serverHandler.addServlet(YesServlet.class, "/yes");
		serverHandler.addServlet(NoServlet.class, "/no");
		serverHandler.addServlet(RegisterServlet.class, "/register");
		serverHandler.addServlet(EndServlet.class, "/end");
		return serverHandler;
	}

	private static void configureServer(Server server) {
		ClassList classlist = ClassList.setServerDefault(server);
		classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration",
				"org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
		classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
				"org.eclipse.jetty.annotations.AnnotationConfiguration");
	}
}
