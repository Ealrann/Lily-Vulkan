package org.sheepy.lily.vulkan.core.input;

import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.lwjgl.glfw.*;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.input.event.*;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.types.EKeyState;
import org.sheepy.lily.core.model.types.EMouseButton;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.input.IInputCatcher;
import org.sheepy.lily.vulkan.api.input.IVulkanInputManager;
import org.sheepy.lily.vulkan.core.window.Window;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;

@ModelExtender(scope = Application.class, inherited = true)
@Adapter
public final class VulkanInputManager extends Notifier<IInputManager.Features> implements IVulkanInputManager
{
	private final Application application;

	private final double[] cursorPositionX = new double[1];
	private final double[] cursorPositionY = new double[1];

	private final List<InputEvent<?>> events = new ArrayList<>();
	private final Runnable load = this::load;

	private Window window = null;
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
			final EKeyState state = switch (action)
					{
						case GLFW_PRESS -> EKeyState.PRESSED;
						case GLFW_REPEAT -> EKeyState.REPEATED;
						default -> EKeyState.RELEASED;
					};

			final var event = new KeyEvent(key, state, mods);
			events.add(event);
		}
	};

	private final GLFWCursorPosCallback glfwSetCursorPosCallback = new GLFWCursorPosCallback()
	{
		@Override
		public void invoke(long window, double xpos, double ypos)
		{
			events.add(new CursorLocationEvent((float) xpos, (float) ypos));
		}
	};

	private final GLFWMouseButtonCallback glfwSetMouseButtonCallback = new GLFWMouseButtonCallback()
	{
		@Override
		public void invoke(long windowPtr, int button, int action, int mods)
		{
			final EMouseButton mouseButton = switch (button)
					{
						case GLFW_MOUSE_BUTTON_RIGHT -> EMouseButton.RIGHT;
						case GLFW_MOUSE_BUTTON_MIDDLE -> EMouseButton.MIDDLE;
						case GLFW_MOUSE_BUTTON_LEFT -> EMouseButton.LEFT;
						case GLFW_MOUSE_BUTTON_4 -> EMouseButton._4;
						case GLFW_MOUSE_BUTTON_5 -> EMouseButton._5;
						case GLFW_MOUSE_BUTTON_6 -> EMouseButton._6;
						case GLFW_MOUSE_BUTTON_7 -> EMouseButton._7;
						case GLFW_MOUSE_BUTTON_8 -> EMouseButton._8;
						default -> null;
					};
			events.add(new MouseClickEvent(cursorPosition, mouseButton, action == GLFW_PRESS));
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

	private VulkanInputManager(Application application)
	{
		super(List.of(Features.CharEvent,
					  Features.KeyEvent,
					  Features.MouseClickEvent,
					  Features.CursorLocationEvent,
					  Features.ScrollEvent,
					  Features.MouseOverUIEvent,
					  Features.AfterPollInputs));
		this.application = application;
	}

	public void connect(Window window)
	{
		this.window = window;
		if (window.isOpenned())
		{
			load();
		}
		window.listenNoParam(load, IWindow.Features.Open);
	}

	public void disconnect()
	{
		if (window != null)
		{
			window.sulkNoParam(load, IWindow.Features.Open);
			dispose();
			this.window = null;
		}
	}

	private void load()
	{
		final var windowPtr = window.getPtr();
		glfwSetScrollCallback(windowPtr, glfwSetScrollCallback);
		glfwSetCharCallback(windowPtr, glfwSetCharCallback);
		glfwSetKeyCallback(windowPtr, glfwSetKeyCallback);
		glfwSetCursorPosCallback(windowPtr, glfwSetCursorPosCallback);
		glfwSetMouseButtonCallback(windowPtr, glfwSetMouseButtonCallback);
	}

	private void dispose()
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
		if (window != null && window.isOpenned())
		{
			updateMouseLocation();
			glfwPollEvents();

			if (catcher != null)
			{
				catcher.update(events);

				if (catcher.hasCaughtInputs())
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
			dropInputEvents();
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
		glfwGetCursorPos(window.getPtr(), cursorPositionX, cursorPositionY);
		cursorPosition = new Vector2f((float) cursorPositionX[0], (float) cursorPositionY[0]);
	}

	@Override
	public void showCursor(boolean show)
	{
		if (window != null)
		{
			window.showCursor(show);
		}
	}

	@Override
	public Vector2fc getCursorPosition()
	{
		return cursorPosition;
	}

	@Override
	public void setCursorPosition(Vector2fc position)
	{
		if (window != null)
		{
			glfwSetCursorPos(window.getPtr(), position.x(), position.y());
			cursorPosition = new Vector2f(position);
		}
	}

	private void fireEvents()
	{
		for (int i = 0; i < events.size(); i++)
		{
			final var event = events.get(i);
			event.notify(this);
		}
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

	private void fireAfterPollInputs()
	{
		notify(IInputManager.Features.AfterPollInputs);
	}

	private void fireInputCaught()
	{
		notify(IInputManager.Features.MouseOverUIEvent, inputsAreCaught);
	}

	@Override
	public boolean isMouseOnUI()
	{
		return inputsAreCaught != null ? inputsAreCaught : false;
	}
}
