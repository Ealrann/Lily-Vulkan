package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.nk_button_label;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.action.IActionAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.ui.Button;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

@Statefull
@Adapter(scope = Button.class)
public final class ButtonAdapter implements IUIElementAdapter
{
	private final ByteBuffer textBuffer;

	public ButtonAdapter(Button button)
	{
		textBuffer = MemoryUtil.memASCII(button.getText());
	}

	@Override
	public boolean layout(UIContext context, IUIElement control)
	{
		boolean res = false;
		final var button = (Button) control;

		context.setFont(button.getFont());
		if (nk_button_label(context.nkContext, textBuffer))
		{
			for (final var action : button.getActions())
			{
				executeAction(action);
			}
			res = true;
		}

		return res;
	}

	private static <T extends Action> void executeAction(T action)
	{
		final IActionAdapter<T> adapter = action.adaptGeneric(IActionAdapter.class);
		adapter.execute(action);
	}
}
