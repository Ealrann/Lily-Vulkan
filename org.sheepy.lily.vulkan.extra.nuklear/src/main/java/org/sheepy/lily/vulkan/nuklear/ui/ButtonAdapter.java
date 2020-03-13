package org.sheepy.lily.vulkan.nuklear.ui;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.action.IActionAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.ui.Button;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

import java.nio.ByteBuffer;

import static org.lwjgl.nuklear.Nuklear.nk_button_label;

@Statefull
@Adapter(scope = Button.class)
public final class ButtonAdapter extends Notifier<ITextWidgetAdapter.Features> implements IUIElementAdapter,
																						  ITextWidgetAdapter
{
	private final ByteBuffer textBuffer;
	private final Button button;

	public ButtonAdapter(Button button)
	{
		super(Features.values().length);
		this.button = button;
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

	@Override
	public boolean needLayout()
	{
		return false;
	}

	@Override
	public String getText()
	{
		return button.getText();
	}

	@Override
	public Font getFont()
	{
		return null;
	}

	private static <T extends Action> void executeAction(T action)
	{
		final IActionAdapter<T> adapter = action.adaptGeneric(IActionAdapter.class);
		adapter.execute(action);
	}
}
