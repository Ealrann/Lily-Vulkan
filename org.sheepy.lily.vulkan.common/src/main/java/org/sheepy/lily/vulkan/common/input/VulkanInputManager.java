package org.sheepy.lily.vulkan.common.input;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFWCharCallback;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWScrollCallback;
import org.lwjgl.system.MemoryStack;
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

	private final Vector2f cursorPosition = new Vector2f();
	private final double[] cursorPositionX = new double[1];
	private final double[] cursorPositionY = new double[1];

	private final List<IInputEvent> events = new ArrayList<>();

	private final List<IInputListener> listeners = new ArrayList<>();

	private IInputCatcher catcher;

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
		public void invoke(long window, int button, int action, int mods)
		{
			try (MemoryStack stack = MemoryStack.stackPush())
			{
				final DoubleBuffer cx = stack.mallocDouble(1);
				final DoubleBuffer cy = stack.mallocDouble(1);

				glfwGetCursorPos(window, cx, cy);

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
				events.add(new MouseButtonEvent(mouseButton, action == GLFW_PRESS));
			}
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
	public void showCursor(boolean show)
	{
		final int flag = show ? GLFW_CURSOR_NORMAL : GLFW_CURSOR_HIDDEN;
		glfwSetInputMode(window.getId(), GLFW_CURSOR, flag);
	}

	@Override
	public Vector2f getCursorPosition()
	{
		return cursorPosition;
	}

	@Override
	public void setCursorPosition(Vector2f position)
	{
		glfwSetCursorPos(window.getId(), position.x, position.y);
		cursorPosition.set(position);
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

			glfwPollEvents();

			// The elegance itself (nonono)
			glfwGetCursorPos(window.getId(), cursorPositionX, cursorPositionY);
			cursorPosition.x = (float) cursorPositionX[0];
			cursorPosition.y = (float) cursorPositionY[0];

			if (catcher != null)
			{
				for (final IInputEvent event : events)
				{
					fireEvent(event, catcher);
				}

				if (catcher.hasCaughtInputs(events))
				{
					dropInputEvents();
				}
			}

			fireEvents();

			if (window.shouldClose())
			{
				application.setRun(false);
			}
		}
	}

	public void fireEvents()
	{
		for (final IInputEvent event : events)
		{
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
		for (final IInputListener listener : listeners)
		{
			fireEvent(event, listener);
		}
	}

	private void fireEvent(IInputEvent event, IInputListener listener)
	{
		if (event instanceof CharEvent)
		{
			listener.onCharEvent((CharEvent) event);
		}
		else if (event instanceof KeyEvent)
		{
			listener.onKeyEvent((KeyEvent) event);
		}
		else if (event instanceof MouseButtonEvent)
		{
			listener.onMouseClickEvent(getCursorPosition(), (MouseButtonEvent) event);
		}
		else if (event instanceof MouseLocationEvent)
		{
			listener.onMouseLocationEvent((MouseLocationEvent) event);
		}
		else if (event instanceof ScrollEvent)
		{
			listener.onScrollEvent((ScrollEvent) event);
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
