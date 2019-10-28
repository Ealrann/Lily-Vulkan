package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.core.model.ui.Label;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

@Statefull
@Adapter(scope = Label.class)
public class LabelAdapter implements IUIElementAdapter
{
	private final ByteBuffer textBuffer;

	public LabelAdapter(Label label)
	{
		textBuffer = MemoryUtil.memASCII(label.getText());
	}

	@Dispose
	public void dispose()
	{
		MemoryUtil.memFree(textBuffer);
	}

	@Override
	public boolean layout(UIContext context, IUIElement control)
	{
		final Label label = (Label) control;

		int align = 0;
		switch (label.getHorizontalRelative())
		{
		case MIDDLE:
			align = NK_TEXT_CENTERED;
			break;
		case RIGHT:
			align = NK_TEXT_RIGHT;
			break;
		default:
			align = NK_TEXT_LEFT;
			break;
		}

		nk_label(context.nkContext, textBuffer, align);

		return false;
	}
}
