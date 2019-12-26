package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.nk_button_label;

import java.nio.ByteBuffer;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.action.context.ActionExecutionContext;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.application.IApplicationAdapter;
import org.sheepy.lily.core.model.action.Action;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.ui.Button;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

@Statefull
@Adapter(scope = Button.class)
public class ButtonAdapter implements IUIElementAdapter
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
			final var executor = button.getExecutor();
			final var application = (Application) EcoreUtil.getRootContainer(executor);
			final var cadencer = application.adaptNotNull(IApplicationAdapter.class).getCadencer();

			for (final Action action : button.getActions())
			{
				final var ec = new ActionExecutionContext(executor, action, null);
				cadencer.postAction(ec);
			}
			res = true;
		}

		return res;
	}
}
