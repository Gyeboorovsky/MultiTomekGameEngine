package demoPlayground;

import static engine.common.models.Player.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwSetWindowShouldClose;

public class Input {
    public static void keyCallbackConfig(long windowId) {

        glfwSetKeyCallback(windowId, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop

            if (key == GLFW_KEY_LEFT && action == GLFW_PRESS) {
                playerMovingLeft();
            } else if (key == GLFW_KEY_RIGHT && action == GLFW_PRESS) {
                playerMovingRight();
            } else if (key == GLFW_KEY_UP && action == GLFW_PRESS) {
                playerMovingUp();
            } else if (key == GLFW_KEY_DOWN && action == GLFW_PRESS) {
                playerMovingDown();
            }

            if (key == GLFW_KEY_LEFT && action == GLFW_RELEASE) {
                playerStopMovingLeft();
            } else if (key == GLFW_KEY_RIGHT && action == GLFW_RELEASE) {
                playerStopMovingRight();
            } else if (key == GLFW_KEY_UP && action == GLFW_RELEASE) {
                playerStopMovingUp();
            } else if (key == GLFW_KEY_DOWN && action == GLFW_RELEASE) {
                playerStopMovingDown();
            }
        });
    }
}
