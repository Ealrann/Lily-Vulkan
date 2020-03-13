package org.sheepy.lily.vulkan.nuklear.input;

import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkMouse;
import org.lwjgl.nuklear.NkVec2;
import org.sheepy.lily.core.api.input.event.*;
import org.sheepy.lily.core.model.types.EKeyState;
import org.sheepy.lily.vulkan.api.input.IInputCatcher;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.lily.vulkan.nuklear.pipeline.NuklearLayoutTaskAdapter;

import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nuklear.Nuklear.*;

public final class NuklearInputCatcher implements IInputCatcher
{
	public static final NuklearInputCatcher INSTANCE = new NuklearInputCatcher();

	private static final NkVec2 scroll = NkVec2.create();

	private NkContext nkContext;
	private Window window;
	private NuklearLayoutTaskAdapter layoutAdapter;
	private boolean clicked = false;
	private boolean caught = false;

	private NuklearInputCatcher()
	{
	}

	public void configure(NkContext nkContext, Window window, NuklearLayoutTaskAdapter layoutAdapter)
	{
		this.nkContext = nkContext;
		this.window = window;
		this.layoutAdapter = layoutAdapter;
	}

	private void onCharEvent(CharEvent event)
	{
		nk_input_unicode(nkContext, event.codepoint);
		caught = true;
	}

	private void onKeyEvent(KeyEvent event)
	{
		final long windowId = window.getPtr();
		final boolean press = event.state == EKeyState.PRESSED;
		switch (event.key)
		{
			case GLFW_KEY_ESCAPE:
				break;
			case GLFW_KEY_DELETE:
				nk_input_key(nkContext, NK_KEY_DEL, press);
				break;
			case GLFW_KEY_ENTER:
				nk_input_key(nkContext, NK_KEY_ENTER, press);
				break;
			case GLFW_KEY_TAB:
				nk_input_key(nkContext, NK_KEY_TAB, press);
				break;
			case GLFW_KEY_BACKSPACE:
				nk_input_key(nkContext, NK_KEY_BACKSPACE, press);
				break;
			case GLFW_KEY_UP:
				nk_input_key(nkContext, NK_KEY_UP, press);
				break;
			case GLFW_KEY_DOWN:
				nk_input_key(nkContext, NK_KEY_DOWN, press);
				break;
			case GLFW_KEY_HOME:
				nk_input_key(nkContext, NK_KEY_TEXT_START, press);
				nk_input_key(nkContext, NK_KEY_SCROLL_START, press);
				break;
			case GLFW_KEY_END:
				nk_input_key(nkContext, NK_KEY_TEXT_END, press);
				nk_input_key(nkContext, NK_KEY_SCROLL_END, press);
				break;
			case GLFW_KEY_PAGE_DOWN:
				nk_input_key(nkContext, NK_KEY_SCROLL_DOWN, press);
				break;
			case GLFW_KEY_PAGE_UP:
				nk_input_key(nkContext, NK_KEY_SCROLL_UP, press);
				break;
			case GLFW_KEY_LEFT_SHIFT:
			case GLFW_KEY_RIGHT_SHIFT:
				nk_input_key(nkContext, NK_KEY_SHIFT, press);
				break;
			case GLFW_KEY_LEFT_CONTROL:
			case GLFW_KEY_RIGHT_CONTROL:
				if (press)
				{
					nk_input_key(nkContext, NK_KEY_COPY, glfwGetKey(windowId, GLFW_KEY_C) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_PASTE, glfwGetKey(windowId, GLFW_KEY_P) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_CUT, glfwGetKey(windowId, GLFW_KEY_X) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_TEXT_UNDO, glfwGetKey(windowId, GLFW_KEY_Z) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_TEXT_REDO, glfwGetKey(windowId, GLFW_KEY_R) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_TEXT_WORD_LEFT, glfwGetKey(windowId, GLFW_KEY_LEFT) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_TEXT_WORD_RIGHT, glfwGetKey(windowId, GLFW_KEY_RIGHT) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_TEXT_LINE_START, glfwGetKey(windowId, GLFW_KEY_B) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_TEXT_LINE_END, glfwGetKey(windowId, GLFW_KEY_E) == GLFW_PRESS);
				}
				else
				{
					nk_input_key(nkContext, NK_KEY_LEFT, glfwGetKey(windowId, GLFW_KEY_LEFT) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_RIGHT, glfwGetKey(windowId, GLFW_KEY_RIGHT) == GLFW_PRESS);
					nk_input_key(nkContext, NK_KEY_COPY, false);
					nk_input_key(nkContext, NK_KEY_PASTE, false);
					nk_input_key(nkContext, NK_KEY_CUT, false);
					nk_input_key(nkContext, NK_KEY_SHIFT, false);
				}
				break;
		}
		caught = true;
	}

	private void onMouseClickEvent(MouseClickEvent event)
	{
		final int x = (int) event.mouseLocation.x();
		final int y = (int) event.mouseLocation.y();

		final int nkButton;
		switch (event.button)
		{
			case RIGHT:
				nkButton = NK_BUTTON_RIGHT;
				break;
			case MIDDLE:
				nkButton = NK_BUTTON_MIDDLE;
				break;
			case LEFT:
				nkButton = NK_BUTTON_LEFT;
				break;
			default:
				nkButton = -1;
		}

		if (nkButton != -1)
		{
			if (event.pressed == true) clicked = true;
			nk_input_button(nkContext, nkButton, x, y, event.pressed);
		}
		caught = true;
	}

	private void onCursorLocationEvent(CursorLocationEvent event)
	{
		nk_input_motion(nkContext, (int) event.x, (int) event.y);
		caught = true;
	}

	private void onScrollEvent(ScrollEvent event)
	{
		scroll.x(event.xOffset);
		scroll.y(event.yOffset);
		nk_input_scroll(nkContext, scroll);
		caught = true;
	}

	@Override
	public void update(final List<InputEvent<?>> events)
	{
		caught = false;
		nk_input_begin(nkContext);

		for (int i = 0; i < events.size(); i++)
		{
			final var event = events.get(i);

			if (event instanceof CharEvent)
			{
				onCharEvent((CharEvent) event);
			}
			else if (event instanceof KeyEvent)
			{
				onKeyEvent((KeyEvent) event);
			}
			else if (event instanceof MouseClickEvent)
			{
				onMouseClickEvent((MouseClickEvent) event);
			}
			else if (event instanceof CursorLocationEvent)
			{
				onCursorLocationEvent((CursorLocationEvent) event);
			}
			else if (event instanceof ScrollEvent)
			{
				onScrollEvent((ScrollEvent) event);
			}
		}

		nk_input_end(nkContext);
		layoutAdapter.requestLayout(caught);
	}

	@Override
	public boolean isCursorThere()
	{
		return nk_window_is_any_hovered(nkContext);
	}

	@Override
	public boolean hasCaughtInputs()
	{
		boolean res = false;
		final long windowId = window.getPtr();
		final NkMouse mouse = nkContext.input().mouse();

		if (mouse.grab())
		{
			glfwSetInputMode(windowId, GLFW_CURSOR, GLFW_CURSOR_HIDDEN);
			res = true;
		}
		else if (mouse.grabbed())
		{
			final float prevX = mouse.prev().x();
			final float prevY = mouse.prev().y();
			glfwSetCursorPos(windowId, prevX, prevY);
			mouse.pos().x(prevX);
			mouse.pos().y(prevY);
			res = true;
		}
		else if (mouse.ungrab())
		{
			glfwSetInputMode(windowId, GLFW_CURSOR, GLFW_CURSOR_NORMAL);
			res = true;
		}

		if (clicked)
		{
			final var panel = layoutAdapter.getHoveredPanel();
			if (panel != null)
			{
				res |= panel.isCatchInputs();
			}
		}

		clicked = false;
		return res;
	}
}
