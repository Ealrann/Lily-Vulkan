package org.sheepy.lily.vulkan.common.input;

import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.sheepy.lily.core.api.input.event.CharEvent;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.api.input.event.KeyEvent;
import org.sheepy.lily.core.api.input.event.MouseButtonEvent;
import org.sheepy.lily.core.api.input.event.MouseLocationEvent;
import org.sheepy.lily.core.api.input.event.ScrollEvent;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.types.EKeyState;
import org.sheepy.lily.core.model.types.EMouseButton;
import org.sheepy.lily.vulkan.api.input.IInputCatcher;
import org.sheepy.lily.vulkan.api.input.IVulkanInputManager;
import org.sheepy.vulkan.window.Window;

public class VulkanInputManager implements IVulkanInputManager
{
	private final Application application;
	private final Window window;

	private final double[] cursorPositionX = new double[1];
	private final double[] cursorPositionY = new double[1];

	private final List<IInputEvent> events = new ArrayList<>();

	private final List<IInputListener> listeners = new ArrayList<>();

	private IInputCatcher catcher;
	private Boolean inputsAreCaught = null;
	private Vector2fc cursorPosition = new Vector2f();

	private final GLFWCharCallback glfwSetCharCallback = new GLFWCharCallback()
	{
		@Override
		public void invoke(long window, int codepoint)
		{
			events.add(new CharEvent(codepoint));
		}
	};

	private final GLFWKeyCallback glfwSetKeyCallback = new GLFWKeyCallback()
	{
		@Override
		public void invoke(long window, int key, int scancode, int action, int mods)
		{
			EKeyState state = EKeyState.RELEASED;
			switch (action)
			{
			case GLFW_RELEASE:
				state = EKeyState.RELEASED;
				break;
			case GLFW_PRESS:
				state = EKeyState.PRESSED;
				break;
			case GLFW_REPEAT:
				state = EKeyState.REPEATED;
				break;
			}

			final var event = new KeyEvent(key, state, mods);
			events.add(event);
		}
	};
	private final GLFWCursorPosCallback glfwSetCursorPosCallback = new GLFWCursorPosCallback()
	{
		@Override
		public void invoke(long window, double xpos, double ypos)
		{
			events.add(new MouseLocationEvent((float) xpos, (float) ypos));
		}
	};
	private final GLFWMouseButtonCallback glfwSetMouseButtonCallback = new GLFWMouseButtonCallback()
	{
		@Override
		public void invoke(long windowPtr, int button, int action, int mods)
		{
			EMouseButton mouseButton = null;
			switch (button)
			{
			case GLFW_MOUSE_BUTTON_RIGHT:
				mouseButton = EMouseButton.RIGHT;
				break;
			case GLFW_MOUSE_BUTTON_MIDDLE:
				mouseButton = EMouseButton.MIDDLE;
				break;
			case GLFW_MOUSE_BUTTON_LEFT:
				mouseButton = EMouseButton.LEFT;
				break;
			case GLFW_MOUSE_BUTTON_4:
				mouseButton = EMouseButton._4;
				break;
			case GLFW_MOUSE_BUTTON_5:
				mouseButton = EMouseButton._5;
				break;
			case GLFW_MOUSE_BUTTON_6:
				mouseButton = EMouseButton._6;
				break;
			case GLFW_MOUSE_BUTTON_7:
				mouseButton = EMouseButton._7;
				break;
			case GLFW_MOUSE_BUTTON_8:
				mouseButton = EMouseButton._8;
				break;
			}
			events.add(new MouseButtonEvent(cursorPosition, mouseButton, action == GLFW_PRESS));
		}
	};

	private final GLFWScrollCallback glfwSetScrollCallback = new GLFWScrollCallback()
	{
		@Override
		public void invoke(long window, double xoffset, double yoffset)
		{
			events.add(new ScrollEvent((float) xoffset, (float) yoffset));
		}
	};

	public VulkanInputManager(Application application, Window window)
	{
		this.application = application;
		this.window = window;
	}

	public void load()
	{
		final var windowId = window.getId();
		glfwSetScrollCallback(windowId, glfwSetScrollCallback);
		glfwSetCharCallback(windowId, glfwSetCharCallback);
		glfwSetKeyCallback(windowId, glfwSetKeyCallback);
		glfwSetCursorPosCallback(windowId, glfwSetCursorPosCallback);
		glfwSetMouseButtonCallback(windowId, glfwSetMouseButtonCallback);
	}

	public void dispose()
	{
		glfwSetScrollCallback.free();
		glfwSetCharCallback.free();
		glfwSetKeyCallback.free();
		glfwSetCursorPosCallback.free();
		glfwSetMouseButtonCallback.free();
	}

	@Override
	public void pollInputs()
	{
		if (window.isOpenned())
		{
			if (catcher != null)
			{
				catcher.startCatch();
			}

			updateMouseLocation();

			glfwPollEvents();

			if (catcher != null)
			{
				for (int i = 0; i < events.size(); i++)
				{
					final var event = events.get(i);
					event.fireEvent(catcher);
				}

				if (catcher.hasCaughtInputs(events))
				{
					dropInputEvents();
				}

				if (catcher.isCursorThere())
				{
					if (inputsAreCaught == null || inputsAreCaught == false)
					{
						inputsAreCaught = true;
						fireInputCaught();
					}
				}
				else if (inputsAreCaught == null || inputsAreCaught == true)
				{
					inputsAreCaught = false;
					fireInputCaught();
				}
			}

			fireEvents();

			fireAfterPollInputs();

			if (window.shouldClose())
			{
				application.setRun(false);
			}
		}
	}

	private void updateMouseLocation()
	{
		// The elegance itself (nonono)
		glfwGetCursorPos(window.getId(), cursorPositionX, cursorPositionY);
		cursorPosition = new Vector2f((float) cursorPositionX[0], (float) cursorPositionY[0]);
	}

	@Override
	public void showCursor(boolean show)
	{
		final int flag = show ? GLFW_CURSOR_NORMAL : GLFW_CURSOR_HIDDEN;
		glfwSetInputMode(window.getId(), GLFW_CURSOR, flag);
	}

	@Override
	public Vector2fc getCursorPosition()
	{
		return cursorPosition;
	}

	@Override
	public void setCursorPosition(Vector2fc position)
	{
		glfwSetCursorPos(window.getId(), position.x(), position.y());
		cursorPosition = new Vector2f(position);
	}

	public void fireEvents()
	{
		for (int i = 0; i < events.size(); i++)
		{
			final IInputEvent event = events.get(i);
			fireEvent(event);
		}
		events.clear();
	}

	public void dropInputEvents()
	{
		events.clear();
	}

	@Override
	public void setInputCatcher(IInputCatcher catcher)
	{
		this.catcher = catcher;
	}

	private void fireEvent(IInputEvent event)
	{
		for (int i = 0; i < listeners.size(); i++)
		{
			final var listener = listeners.get(i);
			event.fireEvent(listener);
		}
	}

	private void fireAfterPollInputs()
	{
		for (int i = 0; i < listeners.size(); i++)
		{
			final var listener = listeners.get(i);
			listener.afterPollInputs();
		}
	}

	private void fireInputCaught()
	{
		for (final IInputListener listener : listeners)
		{
			listener.onMouseOverUI(inputsAreCaught);
		}
	}

	@Override
	public void addListener(IInputListener listener)
	{
		listeners.add(listener);
	}

	@Override
	public void removeListener(IInputListener listener)
	{
		listeners.remove(listener);
	}
}
