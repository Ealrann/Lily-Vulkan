package org.sheepy.lily.vulkan.nuklear.util;

import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.presentation.IUIView;
import org.sheepy.lily.core.model.presentation.UIPage;

public final class NkUtil
{
	public static UIPage resolveUIPage(Application application)
	{
		final var view = application.getCurrentView();
		if (view != null && view instanceof IUIView)
		{
			final var uiView = (IUIView) view;
			final var uiPage = uiView.getCurrentUIPage();
			if (uiPage != null)
			{
				return uiPage;
			}
		}

		return null;
	}
}
