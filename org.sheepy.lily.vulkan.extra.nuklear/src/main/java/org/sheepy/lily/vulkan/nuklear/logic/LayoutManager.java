package org.sheepy.lily.vulkan.nuklear.logic;

import org.joml.Vector2ic;
import org.lwjgl.nuklear.NkContext;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.execution.IExecutionContext;
import org.sheepy.lily.vulkan.api.graphic.IPhysicalSurfaceAllocation;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearFontAdapter;
import org.sheepy.lily.vulkan.nuklear.resource.NuklearFontAllocation;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.lwjgl.nuklear.Nuklear.nk_clear;

public final class LayoutManager
{
	private final Consumer<Vector2ic> resizeListener = this::onResize;
	private final LayoutState layoutState;
	private final List<IPanelAdapter> panelAdapters = new ArrayList<>();
	private final IWindow window;
	private final NkContext nkContext;
	private final NuklearFont font;
	private final GraphicProcess process;

	private IExecutionContext context;
	private ELayoutRequest layoutRequested = ELayoutRequest.None;

	private enum ELayoutRequest
	{
		None,
		Force,
		IfNecessary
	}

	public LayoutManager(NkContext nkContext,
						 Subpass subpass,
						 IExecutionContext context,
						 final NuklearFont font,
						 IObservatoryBuilder observatory)
	{
		this.nkContext = nkContext;
		this.font = font;
		final var ui = (UI) subpass.getCompositor();
		process = (GraphicProcess) subpass.eContainer();
		layoutState = new LayoutState();

		observatory.focus(ui)
				   .explore(UiPackage.UI__CURRENT_UI_PAGE)
				   .explore(UiPackage.UI_PAGE__PANELS)
				   .adapt(IPanelAdapter.class)
				   .gatherAdaptation(this::addPanelAdapter, this::removePanelAdapter);

		this.context = context;
		window = context.getWindow();
		window.listen(resizeListener, IWindow.Features.Size);
		requestLayout(true);
	}

	private void addPanelAdapter(IPanelAdapter adapter)
	{
		panelAdapters.add(adapter);
		layoutRequested = ELayoutRequest.Force;
	}

	private void removePanelAdapter(IPanelAdapter adapter)
	{
		layoutRequested = ELayoutRequest.Force;
		panelAdapters.remove(adapter);
	}

	private void onResize(Vector2ic size)
	{
		layoutRequested = ELayoutRequest.Force;
	}

	public void free()
	{
		window.sulk(resizeListener, IWindow.Features.Size);
		this.context = null;
	}

	public void requestLayout(boolean full)
	{
		if (layoutRequested != ELayoutRequest.Force)
		{
			layoutRequested = (full ? ELayoutRequest.Force : ELayoutRequest.IfNecessary);
		}
	}

	public void update()
	{
		if (isLayoutNecessary())
		{
			layout();
			layoutRequested = ELayoutRequest.None;
		}
	}

	private void layout()
	{
		final var fontAdapter = font.adapt(NuklearFontAdapter.class);
		final var fontAllocation = font.adapt(NuklearFontAllocation.class);
		final var defaultFont = fontAdapter.defaultFont;
		final var fontMap = fontAllocation.fontMap;
		final var surface = process.getConfiguration().getSurface();
		final var surfaceAllocation = surface.adapt(IPhysicalSurfaceAllocation.class);
		final var extent = surfaceAllocation.getExtent();

		try (final var stack = MemoryStack.stackPush())
		{
			final var uiContext = new IPanelAdapter.UIContext(window, nkContext, fontMap, defaultFont, stack);
			layoutState.layout(panelAdapters, uiContext, extent);
		}

		assert layoutState.hasStartedFrame();
		nk_clear(nkContext);
		layoutState.setStartedFrame(false);
	}

	private boolean isLayoutNecessary()
	{
		return switch (layoutRequested)
				{
					case Force -> true;
					case IfNecessary -> doesPanelNeedLayout();
					case None -> false;
				};
	}

	public boolean doesPanelNeedLayout()
	{
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			if (panelAdapter.needLayout())
			{
				return true;
			}
		}
		return false;
	}

	public IPanel getHoveredPanel()
	{
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			if (panelAdapter.isHovered())
			{
				return panelAdapter.getPanel();
			}
		}
		return null;
	}

	public boolean isDirty()
	{
		return layoutState.isDirty();
	}

	public boolean isFrameStarted()
	{
		return layoutState.hasStartedFrame();
	}

	public Vector2ic getExtent()
	{
		return layoutState.getCurrentExtent();
	}
}
