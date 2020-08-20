package org.sheepy.lily.vulkan.nuklear.resource;

import org.lwjgl.nuklear.NkContext;
import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.input.IVulkanInputManager;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.nuklear.dataprovider.NuklearIndexProviderAdapter;
import org.sheepy.lily.vulkan.nuklear.dataprovider.NuklearVertexProviderAdapter;
import org.sheepy.lily.vulkan.nuklear.input.NuklearInputCatcher;
import org.sheepy.lily.vulkan.nuklear.logic.DrawTaskMaintainer;
import org.sheepy.lily.vulkan.nuklear.logic.LayoutManager;
import org.sheepy.lily.vulkan.nuklear.logic.NuklearState;
import org.sheepy.lily.vulkan.nuklear.logic.NuklearVertexBaker;

@ModelExtender(scope = NuklearContext.class)
@Allocation(context = ExecutionContext.class)
@AllocationDependency(features = NuklearPackage.NUKLEAR_CONTEXT__FONT, type = NuklearFontAllocation.class)
public final class NuklearContextAllocation implements IExtender
{
	public static final int FONT_TEXTURE_DESCRIPTOR_INDEX = 1;

	private final NuklearContext nuklearContext;
	private final LayoutManager layoutManager;
	private final DrawTaskMaintainer drawTaskMaintainer;
	private final NuklearVertexBaker vertexBaker;
	private final NuklearState state;
	private final Window window;

	private NuklearContextAllocation(NuklearContext nuklearContext,
									 ExecutionContext context,
									 IObservatoryBuilder observatory,
									 @InjectDependency(index = 0) NuklearFontAllocation fontAllocation)
	{
		this.nuklearContext = nuklearContext;

		final var nulkearFontAdapter = nuklearContext.getFont().adapt(NuklearFontAdapter.class);
		final var defaultFont = nulkearFontAdapter.defaultFont;
		final var application = ModelUtil.getApplication(nuklearContext);
		final var inputManager = (IVulkanInputManager) application.adapt(IInputManager.class);
		final var defaultNkFont = fontAllocation.fontMap.get(defaultFont);

		final var vertexBuffer = nuklearContext.getVertexBufferMemory();
		final var drawTask = nuklearContext.getCompositeDrawTask();
		drawTaskMaintainer = new DrawTaskMaintainer(drawTask, vertexBuffer);

		window = context.getWindow();
		state = NuklearState.build(defaultNkFont, window);

		vertexBaker = new NuklearVertexBaker(state);

		final var subpass = ModelUtil.findParent(nuklearContext, Subpass.class);
		this.layoutManager = new LayoutManager(state.nkContext(),
											   subpass,
											   window,
											   nuklearContext.getFont(),
											   observatory);
		final var inputCatcher = new NuklearInputCatcher(state.nkContext(), window, layoutManager);
		inputManager.setInputCatcher(inputCatcher);

		layout();
	}

	@Free
	public void free()
	{
		state.free();
	}

	@Tick(priority = -10)
	private void layout()
	{
		if (layoutManager.update())
		{
			final var indexProvider = nuklearContext.getIndexDataProvider();
			final var vertexProvider = nuklearContext.getVertexDataProvider();
			final var vertexProviderAdapter = vertexProvider.adapt(NuklearVertexProviderAdapter.class);
			final var indexProviderAdapter = indexProvider.adapt(NuklearIndexProviderAdapter.class);

			final long vbufPtr = state.vbuf().address();
			final long ebufPtr = state.ebuf().address();

			vertexProviderAdapter.requestUpdate(vbufPtr);
			indexProviderAdapter.requestUpdate(ebufPtr, () -> {
				final var drawCommands = vertexBaker.bakeAndBuildDrawCommands();
				drawTaskMaintainer.reloadTasks(drawCommands, window.getSize());
				layoutManager.clean();
			});
		}
		else
		{
			layoutManager.clean();
		}
	}

	public NkContext getNkContext()
	{
		return state.nkContext();
	}
}
