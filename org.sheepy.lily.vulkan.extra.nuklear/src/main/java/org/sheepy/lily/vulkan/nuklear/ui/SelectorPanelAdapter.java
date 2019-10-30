package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.joml.Vector2i;
import org.lwjgl.nuklear.NkImage;
import org.lwjgl.nuklear.NkRect;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.INotificationListener;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.vulkan.api.util.UIUtil;
import org.sheepy.lily.vulkan.extra.api.nuklear.IInputProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.lily.vulkan.nuklear.ui.internal.SelectorButtonDrawer;
import org.sheepy.vulkan.window.IWindowListener.ISizeListener;

@Statefull
@Adapter(scope = SelectorPanel.class)
public final class SelectorPanelAdapter implements IPanelAdapter
{
	private static final int MARGING_W = 5;

	private final INotificationListener layerListener = this::updateValue;
	private final ISizeListener listener = this::updateDataLocations;
	private final SelectorPanel panel;
	private final List<LineData> datas;
	private final int buttonSize;
	private final IVariableResolverAdapter<IVariableResolver> resolverAdapter;
	private final DirectVariableResolver resolver;
	private final IInputProviderAdapter inputProviderAdapter;
	private final SelectorButtonDrawer buttonDrawer;
	private final int width;
	private final int height;

	private boolean loaded = false;
	private boolean dirty = false;
	private Object selectedElement;

	public SelectorPanelAdapter(SelectorPanel panel)
	{
		if (panel.isPrintLabels() && panel.isVertical() == false)
		{
			throw new AssertionError("Panel horizontal with labels are not supported");
		}

		final var inputProvider = panel.getInputProvider();

		this.panel = panel;
		buttonSize = panel.getButtonSizePx();
		resolver = panel.getVariableResolver();
		resolverAdapter = resolver.adaptNotNullGeneric(IVariableResolverAdapter.class);
		inputProviderAdapter = inputProvider.adapt(IInputProviderAdapter.class);
		datas = List.copyOf(buildLineDatas(inputProviderAdapter.getElements(inputProvider)));
		buttonDrawer = new SelectorButtonDrawer(panel);

		final var printLabels = panel.isPrintLabels();
		if (panel.isVertical())
		{
			width = buttonSize + MARGING_W + (printLabels ? LineData.TEXT_WIDTH : 0);
			height = (buttonSize + MARGING_W) * datas.size();
		}
		else
		{
			height = buttonSize + MARGING_W + (printLabels ? LineData.TEXT_WIDTH : 0);
			width = (buttonSize + MARGING_W) * datas.size();
		}

		resolverAdapter.addListener(layerListener);
		selectedElement = resolverAdapter.getValue(resolver);
	}

	private void updateValue(Notification notification)
	{
		this.selectedElement = notification.getNewValue();
		dirty = true;
	}

	private List<LineData> buildLineDatas(List<? extends Object> elements)
	{
		final List<LineData> tmpDatas = new ArrayList<>();
		for (final var element : elements)
		{
			final var image = inputProviderAdapter.getImage(element);

			final var name = inputProviderAdapter.getName(element);

			tmpDatas.add(new LineData(element, name, image));
		}
		return tmpDatas;
	}

	@Dispose
	public void unsetTarget()
	{
		resolverAdapter.removeListener(layerListener);

		for (final LineData data : datas)
		{
			data.free();
		}
	}

	private void load(UIContext context)
	{
		final var surface = context.window.getSize();

		updateDataLocations(surface);
		context.window.addListener(listener);
	}

	public void updateDataLocations(Vector2i size)
	{
		int x = UIUtil.computeXRelative(size, panel, width);
		int y = UIUtil.computeYRelative(size, panel, height);
		for (final LineData data : datas)
		{
			data.updateRect(x, y, buttonSize + MARGING_W, panel.isPrintLabels());
			if (panel.isVertical()) y += buttonSize + MARGING_W;
			else x += buttonSize + MARGING_W;
		}
	}

	@Override
	public boolean layout(UIContext context)
	{
		final boolean res = dirty;
		// !! must remain here- vvv
		dirty = false;
		// -------------------- ^^^

		final var nkContext = context.nkContext;

		if (loaded == false)
		{
			load(context);
			loaded = true;
		}

		final var backgroundColor = nkContext.style().window().fixed_background().data().color();
		final byte defaultAlpha = backgroundColor.a();

		buttonDrawer.prepare(nkContext);

		backgroundColor.a((byte) 0);

		for (int i = 0; i < datas.size(); i++)
		{
			final LineData data = datas.get(i);
			final NkImage image = context.imageMap.get(data.image);
			final boolean isSelected = data.element == selectedElement;

			if (panel.isPrintLabels())
			{
				if (nk_begin(	nkContext,
								data.panelLabelId,
								data.rectLabel,
								NK_WINDOW_NO_SCROLLBAR | NK_WINDOW_BACKGROUND | NK_WINDOW_NO_INPUT))
				{
					nk_layout_row_dynamic(context.nkContext, buttonSize, 1);
					nk_label(nkContext, data.textBuffer, NK_TEXT_RIGHT);
				}
				nk_end(nkContext);
			}

			if (buttonDrawer.draw(	nkContext,
									isSelected,
									image,
									data.panelButton1Id,
									data.rectButton))
			{
				final var newSelection = (selectedElement == data.element) ? null : data.element;
				resolverAdapter.setValue(resolver, newSelection);
				dirty = true;
			}
		}

		buttonDrawer.finish();
		backgroundColor.a(defaultAlpha);
		return res;
	}

	@Override
	public void collectImages(List<PathResource> images)
	{
		for (int i = 0; i < datas.size(); i++)
		{
			final LineData data = datas.get(i);
			images.add(data.image);
		}
	}

	public static final class LineData
	{
		public static final int TEXT_WIDTH = 100;

		public final Object element;
		public final ByteBuffer textBuffer;
		public final NkRect rectLabel = NkRect.create();
		public final NkRect rectButton = NkRect.create();
		public final ByteBuffer panelLabelId;
		public final ByteBuffer panelButton1Id;
		private final PathResource image;

		public LineData(Object input, String name, PathResource image)
		{
			this.element = input;
			this.image = image;

			panelLabelId = MemoryUtil.memUTF8("Label" + name);
			panelButton1Id = MemoryUtil.memUTF8("Button" + name);
			textBuffer = MemoryUtil.memUTF8(name);
		}

		public void free()
		{
			MemoryUtil.memFree(panelLabelId);
			MemoryUtil.memFree(panelButton1Id);
			MemoryUtil.memFree(textBuffer);
		}

		public void updateRect(int x, int y, int buttonSize, boolean withText)
		{
			rectLabel.set(x, y, withText ? TEXT_WIDTH : 0, buttonSize);
			rectButton.set(x + (withText ? TEXT_WIDTH : 0), y, buttonSize, buttonSize);
		}
	}
}
