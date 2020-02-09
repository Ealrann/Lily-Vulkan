package org.sheepy.lily.vulkan.nuklear.ui;

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
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.variable.DirectVariableResolver;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.game.api.window.IWindowListener;
import org.sheepy.lily.vulkan.api.util.UIUtil;
import org.sheepy.lily.vulkan.core.resource.IImageAdapter;
import org.sheepy.lily.vulkan.extra.api.nuklear.ISelectorInputProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;
import org.sheepy.lily.vulkan.nuklear.ui.internal.SelectorButtonDrawer;
import org.sheepy.lily.vulkan.nuklear.util.ProgressTimer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.lwjgl.nuklear.Nuklear.*;

@Statefull
@Adapter(scope = SelectorPanel.class)
public final class SelectorPanelAdapter extends Notifier implements IPanelAdapter, ITextWidgetAdapter
{
	private static final int MARGING_W = 5;

	private final INotificationListener selectionListener = this::updateValue;
	private final IWindowListener.ISizeListener listener = this::updateDataLocations;
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
	private final ProgressTimer fadeTimer;

	private boolean showText = false;
	private boolean loaded = false;
	private boolean dirty = false;
	private Object selectedElement;
	private boolean hovered = false;

	private NkColor backgroundColor;

	public SelectorPanelAdapter(SelectorPanel panel)
	{
		super(Features.values().length);
		if (panel.isPrintLabels() && panel.isVertical() == false)
		{
			throw new AssertionError("Horizontal panel with labels is not supported");
		}

		final var inputProvider = panel.getInputProvider();
		fadeTimer = new ProgressTimer(panel.getFadeOutMs(), TimeUnit.MILLISECONDS);

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

	private List<LineData> buildLineDatas(List<?> elements)
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
		for (final var data : datas)
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

		hovered = false;
		for (int i = 0; i < datas.size(); i++)
		{
			final LineData data = datas.get(i);
			final boolean isSelected = data.element == selectedElement;

			if (panel.isPrintLabels())
			{
				if (nk_begin(nkContext,
							 data.panelLabelId,
							 data.rectLabel,
							 NK_WINDOW_NO_SCROLLBAR | NK_WINDOW_BACKGROUND | NK_WINDOW_NO_INPUT))
				{
					if (panel.isDetectHoverOnLabels())
					{
						hovered |= nk_window_is_hovered(nkContext);
					}

					if (showText || panel.isAutoHideLabels() == false)
					{
						nk_layout_row_dynamic(context.nkContext, buttonSize, 1);
						nk_label_colored(nkContext, data.textBuffer, NK_TEXT_RIGHT, labelColor);
					}

					labelPanelHovered |= nk_window_is_hovered(nkContext);
				}
				nk_end(nkContext);
			}

			if (buttonDrawer.draw(nkContext,
								  isSelected,
								  data.getNkImage(),
								  data.color,
								  data.panelButton1Id,
								  data.rectButton))
			{
				var newSelection = data.element;
				if (panel.isUnsettable() && selectedElement == newSelection)
				{
					newSelection = null;
				}
				resolverAdapter.setValue(resolver, newSelection);
				dirty = true;
			}

			buttonPanelHovered |= buttonDrawer.isHovered();
			hovered |= buttonPanelHovered;
		}

		if (panel.isAutoHideLabels() && panel.isPrintLabels())
		{
			updateHoverStatus(labelPanelHovered || buttonPanelHovered);
		}

		buttonDrawer.finish();
		backgroundColor.a(defaultAlpha);

		return res;
	}

	@Override
	public boolean needLayout()
	{
		return dirty || fadeTimer.isRunning();
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
			if (fadeTimer.isRunning())
			{
				fadeTimer.stop();
				labelColor.a((byte) 255);
				dirty = true;
			}
		}
		else
		{
			if (showText == true && !fadeTimer.isRunning())
			{
				fadeTimer.start();
				dirty = true;
			}
		}

		if (fadeTimer.isRunning())
		{
			if (fadeTimer.isOverTime())
			{
				fadeTimer.stop();
				labelColor.a((byte) 255);
				showText = false;
			}
			else
			{
				final double fadeProgress = 1 - fadeTimer.progress();
				final byte fadeColor = (byte) Math.round(255 * fadeProgress);
				labelColor.a(fadeColor);
			}
			dirty = true;
		}
	}

	@Override
	public String getText()
	{
		if (panel.isPrintLabels())
		{
			final StringBuilder sb = new StringBuilder();
			for (final var line : datas)
			{
				sb.append(line.name);
			}
			return sb.toString();
		}
		else
		{
			return "";
		}
	}

	@Override
	public Font getFont()
	{
		return null;
	}

	@Override
	public boolean isHovered()
	{
		return hovered;
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
		public final IImage image;
		public final NkColor color;
		public final boolean right;
		public final String name;

		private final NkImage nkImage = NkImage.calloc();

		public LineData(Object input, String name, String panelName, IImage image, Vector3fc color, boolean right)
		{
			this.element = input;
			this.name = name;
			this.image = image;
			this.right = right;

			panelLabelId = MemoryUtil.memUTF8("Label" + panelName + name);
			panelButton1Id = MemoryUtil.memUTF8("Button" + panelName + name);
			textBuffer = MemoryUtil.memUTF8(name);

			this.color = color != null ? allocColor(color) : null;
		}

		private static NkColor allocColor(Vector3fc color)
		{
			return NkColor.calloc().set((byte) color.x(), (byte) color.y(), (byte) color.z(), (byte) 255);
		}

		public NkImage getNkImage()
		{
			if (image != null)
			{
				final var imageAdapter = image.adapt(IImageAdapter.class);
				nk_image_ptr(imageAdapter.getViewPtr(), nkImage);
				return nkImage;
			}
			else
			{
				return null;
			}
		}

		public void free()
		{
			nkImage.free();
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
