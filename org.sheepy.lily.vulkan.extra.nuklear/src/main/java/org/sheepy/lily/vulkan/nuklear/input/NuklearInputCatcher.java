package org.sheepy.lily.vulkan.nuklear.input;

import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkMouse;
import org.lwjgl.nuklear.NkVec2;
import org.sheepy.lily.core.api.input.event.*;
import org.sheepy.lily.core.model.types.EKeyState;
import org.sheepy.lily.vulkan.api.input.IInputCatcher;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.lily.vulkan.nuklear.logic.LayoutManager;

import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.nuklear.Nuklear.*;

public final class NuklearInputCatcher implements IInputCatcher
{
	private static final NkVec2 scroll = NkVec2.create();

	private final NkContext nkContext;
	private final Window window;
	private final LayoutManager layoutManager;

	private boolean clicked = false;
	private boolean caught = false;

	public NuklearInputCatcher(final NkContext nkContext, final Window window, final LayoutManager layoutManager)
	{
		this.nkContext = nkContext;
		this.window = window;
		this.layoutManager = layoutManager;
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
			case GLFW_KEY_DELETE -> nk_input_key(nkContext, NK_KEY_DEL, press);
			case GLFW_KEY_ENTER -> nk_input_key(nkContext, NK_KEY_ENTER, press);
			case GLFW_KEY_TAB -> nk_input_key(nkContext, NK_KEY_TAB, press);
			case GLFW_KEY_BACKSPACE -> nk_input_key(nkContext, NK_KEY_BACKSPACE, press);
			case GLFW_KEY_UP -> nk_input_key(nkContext, NK_KEY_UP, press);
			case GLFW_KEY_DOWN -> nk_input_key(nkContext, NK_KEY_DOWN, press);
			case GLFW_KEY_HOME ->
			{
				nk_input_key(nkContext, NK_KEY_TEXT_START, press);
				nk_input_key(nkContext, NK_KEY_SCROLL_START, press);
			}
			case GLFW_KEY_END ->
			{
				nk_input_key(nkContext, NK_KEY_TEXT_END, press);
				nk_input_key(nkContext, NK_KEY_SCROLL_END, press);
			}
			case GLFW_KEY_PAGE_DOWN -> nk_input_key(nkContext, NK_KEY_SCROLL_DOWN, press);
			case GLFW_KEY_PAGE_UP -> nk_input_key(nkContext, NK_KEY_SCROLL_UP, press);
			case GLFW_KEY_LEFT_SHIFT, GLFW_KEY_RIGHT_SHIFT -> nk_input_key(nkContext, NK_KEY_SHIFT, press);
			case GLFW_KEY_LEFT_CONTROL, GLFW_KEY_RIGHT_CONTROL ->
			{
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
			}
		}
		caught = true;
	}

	private void onMouseClickEvent(MouseClickEvent event)
	{
		final int x = (int) event.mouseLocation.x();
		final int y = (int) event.mouseLocation.y();

		final int nkButton = switch (event.button)
				{
					case RIGHT -> NK_BUTTON_RIGHT;
					case MIDDLE -> NK_BUTTON_MIDDLE;
					case LEFT -> NK_BUTTON_LEFT;
					default -> -1;
				};

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
		layoutManager.requestLayout(caught);
	}

	@Override
	public boolean isCursorThere()
	{
		// nk_window_is_any_hovered(nkContext)
		return layoutManager.getHoveredPanel() != null;
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
			final var prev = mouse.prev();
			final var current = mouse.pos();
			glfwSetCursorPos(windowId, prev.x(), prev.y());
			current.set(prev);
			res = true;
		}
		else if (mouse.ungrab())
		{
			glfwSetInputMode(windowId, GLFW_CURSOR, GLFW_CURSOR_NORMAL);
			res = true;
		}

		if (clicked)
		{
			final var panel = layoutManager.getHoveredPanel();
			if (panel != null)
			{
				res |= panel.isCatchInputs();
			}
		}

		clicked = false;
		return res;
	}
}
