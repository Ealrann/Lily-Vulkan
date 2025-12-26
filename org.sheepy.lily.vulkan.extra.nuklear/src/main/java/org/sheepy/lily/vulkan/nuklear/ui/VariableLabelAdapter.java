package org.sheepy.lily.vulkan.nuklear.ui;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.Notifier;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.core.model.ui.VariableLabel;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.Consumer;

import static org.lwjgl.nuklear.Nuklear.*;

@ModelExtender(scope = VariableLabel.class)
@Adapter
public class VariableLabelAdapter extends Notifier<ITextWidgetAdapter.Features> implements IUIElementAdapter,
																						   ITextWidgetAdapter
{
	private final Consumer<Object> listener = this::updateText;
	private final VariableLabel label;
	private final IVariableResolverAdapter<IVariableResolver> resolver;

	private String text = "";
	private ByteBuffer textBuffer = null;

	private boolean dirty = true;

	public VariableLabelAdapter(VariableLabel label)
	{
		super(List.of(Features.Text));
		this.label = label;
		final var variableResolver = label.variableResolver();
		resolver = variableResolver.adaptNotNullGeneric(IVariableResolverAdapter.class);

		updateText(resolver.getValue(variableResolver));

		resolver.listen(listener);
	}

	@Dispose
	public void unsetTarget()
	{
		resolver.sulk(listener);
		MemoryUtil.memFree(textBuffer);
	}

	@Override
	public boolean layout(UIContext context, IUIElement control)
	{
		final boolean res = dirty;
		final var label = (VariableLabel) control;
		final int align = switch (label.horizontalRelative())
		{
			case MIDDLE -> NK_TEXT_CENTERED;
			case RIGHT -> NK_TEXT_RIGHT;
			default -> NK_TEXT_LEFT;
		};

		context.setFont(label.font());
		nk_label(context.nkContext, textBuffer, align);

		dirty = false;
		return res;
	}

	@Override
	public boolean needLayout()
	{
		return dirty;
	}

	private void updateText(Object val)
	{
		final var format = label.format();
		final String value = (format != null && !format.isBlank()) ? String.format(format, val) : String.valueOf(val);
		final String labelText = label.text();
		final String resultString;

		if (label.showName() == false) resultString = String.format("%s", value);
		else if (labelText.isBlank()) resultString = String.format("%s%s", labelText, value);
		else resultString = String.format("%s: %s", labelText, value);

		if (resultString.equals(text) == false)
		{
			MemoryUtil.memFree(textBuffer);
			text = resultString;
			textBuffer = MemoryUtil.memASCII(text);
		}
		dirty = true;
		notify(Features.Text, text);
	}

	@Override
	public String getText()
	{
		return text;
	}

	@Override
	public Font getFont()
	{
		return label.font();
	}
}
