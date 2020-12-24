package org.sheepy.lily.vulkan.nuklear.ui;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.core.model.ui.Label;
import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;
import org.sheepy.lily.vulkan.nuklear.util.ProgressTimer;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.lwjgl.nuklear.Nuklear.*;

@ModelExtender(scope = Label.class)
@Adapter
public final class LabelAdapter extends Notifier<ITextWidgetAdapter.Features> implements IUIElementAdapter,
																						 ITextWidgetAdapter
{
	private final Label label;
	private final Runnable textListener = this::textChanged;

	private boolean dirty = true;
	private ByteBuffer textBuffer;
	private ProgressTimer narrationTimer = null;

	private LabelAdapter(Label label)
	{
		super(List.of(Features.Text));
		this.label = label;
	}

	@Load
	private void load()
	{
		reloadText();
		label.listenNoParam(textListener, UiPackage.LABEL__TEXT);
	}

	@Dispose
	private void dispose()
	{
		label.sulkNoParam(textListener, UiPackage.LABEL__TEXT);
		freeBuffer();
	}

	private void textChanged()
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

		notify(Features.Text, text);

		if (label.isNarrator())
		{
			final int length = text.length();
			final float durationToDisplaySeconds = (float) length / label.getNarrationSpeed();
			final int durationTiDisplayMs = (int) (durationToDisplaySeconds * 1000f);

			narrationTimer = new ProgressTimer(durationTiDisplayMs, TimeUnit.MILLISECONDS);
			narrationTimer.start();
		}
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
		boolean res = dirty;
		dirty = false;
		final Label label = (Label) control;

		final int align = switch (label.getHorizontalRelative())
				{
					case MIDDLE -> NK_TEXT_CENTERED;
					case RIGHT -> NK_TEXT_RIGHT;
					default -> NK_TEXT_LEFT;
				};

		context.setFont(label.getFont());

		res |= narrate(label);

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

	private boolean narrate(Label label)
	{
		final String text = label.getText();
		if (narrationTimer != null && narrationTimer.isRunning() && !text.isEmpty())
		{
			if (narrationTimer.isOverTime())
			{
				narrationTimer.stop();
				narrationTimer = null;
				MemoryUtil.memUTF8(text, true, textBuffer);
			}
			else
			{
				final double progress = narrationTimer.progress();
				final int charCount = text.length();
				final int charCountToDisplay = (int) (charCount * progress);
				final String textToDisplay = text.substring(0, charCountToDisplay);
				MemoryUtil.memUTF8(textToDisplay, true, textBuffer);
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean needLayout()
	{
		return narrationTimer != null && narrationTimer.isRunning();
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
