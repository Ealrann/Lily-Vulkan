package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.notification.impl.ObjectNotification;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.core.model.ui.Label;
import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

@Statefull
@Adapter(scope = Label.class)
public final class LabelAdapter extends Notifier implements IUIElementAdapter, ITextWidgetAdapter
{
	private final Label label;
	private final INotificationListener textListener = this::textChanged;

	private boolean dirty = true;
	private ByteBuffer textBuffer;

	private LabelAdapter(Label label)
	{
		super(Features.values().length);
		this.label = label;
	}

	@Load
	private void load()
	{
		reloadText();
		label.addListener(textListener, UiPackage.LABEL__TEXT);
	}

	@Dispose
	private void dispose()
	{
		label.removeListener(textListener, UiPackage.LABEL__TEXT);
		freeBuffer();
	}

	private void textChanged(Notification notification)
	{
		freeBuffer();
		reloadText();

		dirty = true;
	}

	private void reloadText()
	{
		assert textBuffer == null;

		final String text = label.getText();
		textBuffer = MemoryUtil.memUTF8(text);

		final var notification = new ObjectNotification(this, Features.Text, null, text);
		fireNotification(notification);
	}

	private void freeBuffer()
	{
		assert textBuffer != null;
		MemoryUtil.memFree(textBuffer);
		textBuffer = null;
	}

	@Override
	public boolean layout(UIContext context, IUIElement control)
	{
		final boolean res = dirty;
		dirty = false;
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

		context.setFont(label.getFont());

		if (label.isWrap())
		{
			nk_label_wrap(context.nkContext, textBuffer);
		}
		else
		{
			nk_label(context.nkContext, textBuffer, align);
		}

		return res;
	}

	@Override
	public String getText()
	{
		return label.getText();
	}

	@Override
	public Font getFont()
	{
		return label.getFont();
	}
}
