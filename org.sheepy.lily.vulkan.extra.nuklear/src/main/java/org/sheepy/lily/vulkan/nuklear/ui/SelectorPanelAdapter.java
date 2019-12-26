package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.joml.Vector2ic;
import org.joml.Vector3fc;
import org.lwjgl.nuklear.NkColor;
import org.lwjgl.nuklear.NkImage;
import org.lwjgl.nuklear.NkRect;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.vulkan.api.util.UIUtil;
import org.sheepy.lily.vulkan.extra.api.nuklear.ISelectorInputProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;
import org.sheepy.lily.vulkan.nuklear.ui.internal.SelectorButtonDrawer;
import org.sheepy.vulkan.window.IWindowListener.ISizeListener;

@Statefull
@Adapter(scope = SelectorPanel.class)
public final class SelectorPanelAdapter implements IPanelAdapter
{
	private static final int MARGING_W = 5;

	private final INotificationListener selectionListener = this::updateValue;
	private final ISizeListener listener = this::updateDataLocations;
	private final SelectorPanel panel;
	private final List<LineData> datas;
	private final int buttonSize;
	private final IVariableResolverAdapter<IVariableResolver> resolverAdapter;
	private final DirectVariableResolver resolver;
	private final ISelectorInputProviderAdapter inputProviderAdapter;
	private final SelectorButtonDrawer buttonDrawer;
	private final int width;
	private final int height;
	private final NkColor labelColor;

	private boolean showText = false;
	private boolean fading = false;
	private long fadingSince = 0;
	private boolean loaded = false;
	private boolean dirty = false;
	private Object selectedElement;

	private NkColor backgroundColor;

	public SelectorPanelAdapter(SelectorPanel panel)
	{
		if (panel.isPrintLabels() && panel.isVertical() == false)
		{
			throw new AssertionError("Horizontal panel with labels is not supported");
		}

		final var inputProvider = panel.getInputProvider();

		this.panel = panel;
		buttonSize = panel.getButtonSizePx();
		resolver = panel.getVariableResolver();
		resolverAdapter = resolver.adaptNotNullGeneric(IVariableResolverAdapter.class);
		inputProviderAdapter = inputProvider.adapt(ISelectorInputProviderAdapter.class);
		datas = List.copyOf(buildLineDatas(inputProviderAdapter.getElements(inputProvider)));
		buttonDrawer = new SelectorButtonDrawer(panel);
		labelColor = NkColor.malloc();
		labelColor.set((byte) 188, (byte) 188, (byte) 188, (byte) 255);

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

		resolverAdapter.addListener(selectionListener);
		selectedElement = resolverAdapter.getValue(resolver);
	}

	private void updateValue(Notification notification)
	{
		this.selectedElement = notification.getNewValue();
		dirty = true;
	}

	private List<LineData> buildLineDatas(List<? extends Object> elements)
	{
		final boolean right = panel.getHorizontalRelative() == EHorizontalRelative.RIGHT;
		final List<LineData> tmpDatas = new ArrayList<>();
		for (final var element : elements)
		{
			final var image = inputProviderAdapter.getImage(element);
			final var color = inputProviderAdapter.getColor(element);
			final var name = inputProviderAdapter.getName(element);

			tmpDatas.add(new LineData(element, name, panel.getName(), image, color, right));
		}
		return tmpDatas;
	}

	@Dispose
	public void unsetTarget()
	{
		resolverAdapter.removeListener(selectionListener);
		labelColor.free();
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
		backgroundColor = context.nkContext.style().window().fixed_background().data().color();
	}

	public void updateDataLocations(Vector2ic size)
	{
		int x = UIUtil.computeXRelative(size, panel, width);
		int y = UIUtil.computeYRelative(size, panel, height);
		if (panel.getHorizontalRelative() == EHorizontalRelative.LEFT)
		{
			x += MARGING_W;
		}

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
		boolean labelPanelHovered = false;
		boolean buttonPanelHovered = false;

		if (loaded == false)
		{
			load(context);
			loaded = true;
		}

		final byte defaultAlpha = backgroundColor.a();

		buttonDrawer.prepare(nkContext);

		backgroundColor.a((byte) 0);

		for (int i = 0; i < datas.size(); i++)
		{
			final LineData data = datas.get(i);
			final NkImage image = data.image != null ? context.imageMap.get(data.image) : null;
			final boolean isSelected = data.element == selectedElement;

			if (panel.isPrintLabels())
			{
				if (nk_begin(	nkContext,
								data.panelLabelId,
								data.rectLabel,
								NK_WINDOW_NO_SCROLLBAR | NK_WINDOW_BACKGROUND | NK_WINDOW_NO_INPUT))
				{
					if (showText || panel.isAutoHideLabels() == false)
					{
						nk_layout_row_dynamic(context.nkContext, buttonSize, 1);
						nk_label_colored(nkContext, data.textBuffer, NK_TEXT_RIGHT, labelColor);
					}

					labelPanelHovered |= nk_window_is_hovered(nkContext);
				}
				nk_end(nkContext);
			}

			if (buttonDrawer.draw(	nkContext,
									isSelected,
									image,
									data.color,
									data.panelButton1Id,
									data.rectButton))
			{
				final var newSelection = (selectedElement == data.element) ? null : data.element;
				resolverAdapter.setValue(resolver, newSelection);
				dirty = true;
			}

			buttonPanelHovered |= buttonDrawer.isHovered();
		}

		if (panel.isAutoHideLabels() && panel.isPrintLabels())
		{
			updateHoverStatus(labelPanelHovered || buttonPanelHovered);
		}

		buttonDrawer.finish();
		backgroundColor.a(defaultAlpha);

		return res;
	}

	private void updateHoverStatus(boolean hovered)
	{
		if (hovered)
		{
			if (showText == false)
			{
				showText = true;
				dirty = true;
			}
			if (fading)
			{
				fading = false;
				labelColor.a((byte) 255);
				dirty = true;
			}
		}
		else
		{
			if (showText == true && fading == false)
			{
				fading = true;
				fadingSince = System.currentTimeMillis();
				dirty = true;
			}
		}

		if (fading)
		{
			final long time = System.currentTimeMillis();
			final float fadeProgress = ((float) (time - fadingSince)) / panel.getFadeOutMs();
			if (fadeProgress > 1)
			{
				fading = false;
				labelColor.a((byte) 255);
				showText = false;
				dirty = true;
			}
			else
			{
				labelColor.a((byte) (255f * (1f - fadeProgress)));
				dirty = true;
			}
		}
	}

	@Override
	public void collectImages(List<FileResource> images)
	{
		for (int i = 0; i < datas.size(); i++)
		{
			final var data = datas.get(i);
			if (data.image != null)
			{
				images.add(data.image);
			}
		}
	}

	private static final class LineData
	{
		public static final int TEXT_WIDTH = 100;

		public final Object element;
		public final ByteBuffer textBuffer;
		public final NkRect rectLabel = NkRect.create();
		public final NkRect rectButton = NkRect.create();
		public final ByteBuffer panelLabelId;
		public final ByteBuffer panelButton1Id;
		public final FileResource image;
		public final NkColor color;
		public final boolean right;

		public LineData(Object input,
						String name,
						String panelName,
						FileResource image,
						Vector3fc color,
						boolean right)
		{
			this.element = input;
			this.image = image;
			this.right = right;

			panelLabelId = MemoryUtil.memUTF8("Label" + panelName + name);
			panelButton1Id = MemoryUtil.memUTF8("Button" + panelName + name);
			textBuffer = MemoryUtil.memUTF8(name);

			this.color = color != null ? allocColor(color) : null;
		}

		private static NkColor allocColor(Vector3fc color)
		{
			return NkColor	.calloc()
							.set((byte) color.x(), (byte) color.y(), (byte) color.z(), (byte) 255);
		}

		public void free()
		{
			MemoryUtil.memFree(panelLabelId);
			MemoryUtil.memFree(panelButton1Id);
			MemoryUtil.memFree(textBuffer);
			if (color != null) color.free();
		}

		public void updateRect(int x, int y, int buttonSize, boolean withText)
		{
			if (right)
			{
				rectLabel.set(x, y, withText ? TEXT_WIDTH : 0, buttonSize);
				rectButton.set(x + (withText ? TEXT_WIDTH : 0), y, buttonSize, buttonSize);
			}
			else
			{
				rectButton.set(x, y, buttonSize, buttonSize);
				rectLabel.set(x + buttonSize, y, withText ? TEXT_WIDTH : 0, buttonSize);
			}
		}
	}
}
