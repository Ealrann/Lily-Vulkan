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
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.core.model.ui.Button;

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
		Button button = (Button) control;

		if (nk_button_label(context.nkContext, textBuffer))
		{
			var application = (Application) EcoreUtil.getRootContainer(button.getExecutor());
			var cadencer = IApplicationAdapter.adapt(application).getCadencer();

			for (Action action : button.getActions())
			{
				ActionExecutionContext ec = new ActionExecutionContext(button.getExecutor(), action,
						null);
				cadencer.postAction(ec);
			}
			res = true;
		}

		return res;
	}
}
