package demoPlayground;

import engine.common.models.GameObject;
import engine.common.units.Point2;
import engine.graphic.Window;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static demoPlayground.Input.keyCallbackConfig;
import static engine.TemporaryConfig.windowHeight;
import static engine.common.models.Player.initializePlayer;
import static engine.common.models.Player.renderPlayer;
import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;

public class Game {
    // The window
    private long windowId;

    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        loop();
    }

    public void init() {
        // Setup an error callback. The default implementation will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Create the window
        windowId = new Window().getWindowId();

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        keyCallbackConfig(windowId);

        // Make the OpenGL context current
        glfwMakeContextCurrent(windowId);

        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(windowId);
    }

    public void cleanup() {
        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(windowId);
        glfwDestroyWindow(windowId);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detacts the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Set the clear color, black without that
        glClearColor(0.5f, 0.0f, 0.0f, 0.5f);


        //GameObject object = new GameObject(new Point2(0, 0));
        initializePlayer();

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        int frames = 0;
        long startTime = System.currentTimeMillis();
        while ( !glfwWindowShouldClose(windowId) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
            glViewport(0,0, windowHeight, windowHeight);


            renderPlayer();


            // swap the color buffers
            glfwSwapBuffers(windowId);

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();;
        }
    }
}
