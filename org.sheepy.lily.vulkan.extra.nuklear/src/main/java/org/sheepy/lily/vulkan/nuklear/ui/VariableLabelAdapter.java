package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.ByteBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.impl.ObjectNotification;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.core.model.ui.VariableLabel;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

@Statefull
@Adapter(scope = VariableLabel.class)
public class VariableLabelAdapter extends Notifier implements IUIElementAdapter, ITextWidgetAdapter
{
	private final INotificationListener listener = n -> updateText(n.getNewValue());
	private final VariableLabel label;
	private final IVariableResolverAdapter<IVariableResolver> resolver;

	private String text = "";
	private ByteBuffer textBuffer = null;

	private boolean dirty = true;

	@SuppressWarnings("unchecked")
	public VariableLabelAdapter(VariableLabel label)
	{
		super(Features.values().length);
		this.label = label;
		final var variableResolver = label.getVariableResolver();
		resolver = variableResolver.adaptNotNull(IVariableResolverAdapter.class);

		updateText(resolver.getValue(variableResolver));

		resolver.addListener(listener);
	}

	@Dispose
	public void unsetTarget()
	{
		resolver.removeListener(listener);
		MemoryUtil.memFree(textBuffer);
	}

	@Override
	public boolean layout(UIContext context, IUIElement control)
	{
		final boolean res = dirty;
		final var label = (VariableLabel) control;

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

		context.setFont(label.getFont());
		nk_label(context.nkContext, textBuffer, align);

		dirty = false;
		return res;
	}

	private void updateText(Object val)
	{
		final var oldText = text;
		final var format = label.getFormat();
		final String value = (format != null && !format.isBlank())
				? String.format(format, val)
				: String.valueOf(val);
		final String labelText = label.getText();
		String resultString = "";

		if (label.isShowName() == false) resultString = String.format("%s", value);
		else if (labelText.isBlank()) resultString = String.format("%s%s", labelText, value);
		else resultString = String.format("%s: %s", labelText, value);

		if (resultString.equals(text) == false)
		{
			MemoryUtil.memFree(textBuffer);
			text = resultString;
			textBuffer = MemoryUtil.memASCII(text);
		}
		dirty = true;
		fireNotification(new ObjectNotification(this, Features.Text, oldText, text));
	}

	@Override
	public String getText()
	{
		return text;
	}

	@Override
	public Font getFont()
	{
		return label.getFont();
	}
}
