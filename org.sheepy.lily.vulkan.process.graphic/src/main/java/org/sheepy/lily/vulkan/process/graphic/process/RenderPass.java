package org.sheepy.lily.vulkan.process.graphic.process;

import static org.lwjgl.vulkan.VK10.vkDestroyRenderPass;

import java.util.ArrayList;
import java.util.List;

import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.util.AllocationChildrenRegistry;
import org.sheepy.lily.vulkan.api.graphic.ClearInfo;
import org.sheepy.lily.vulkan.api.graphic.IGraphicContext;
import org.sheepy.lily.vulkan.api.graphic.IRenderPass;
import org.sheepy.lily.vulkan.api.resource.attachment.IExtraAttachmentAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;
import org.sheepy.lily.vulkan.process.graphic.renderpass.VkRenderPassAllocator;

public class RenderPass implements IRenderPass
{
	private final AllocationChildrenRegistry attachmentsRegistry = new AllocationChildrenRegistry(	List.of(GraphicPackage.Literals.RENDER_PASS_INFO__EXTRA_ATTACHMENTS),
																									true);

	private final RenderPassInfo info;
	private long renderPass = 0;
	private List<ClearInfo> clearInfos = null;
	private boolean listeningAttachments = false;

	public RenderPass(RenderPassInfo info)
	{
		this.info = info;
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, IGraphicContext context)
	{
		final var swapChainManager = context.getSwapChainManager();
		config.addDependencies(List.of(swapChainManager));

		if (listeningAttachments == true)
		{
			attachmentsRegistry.stopRegister(info);
		}
		attachmentsRegistry.startRegister(info, config);
		listeningAttachments = true;
	}

	@Dispose
	private void dispose()
	{
		if (listeningAttachments == true)
		{
			attachmentsRegistry.stopRegister(info);
			listeningAttachments = false;
		}
	}

	@Override
	public void allocate(IGraphicContext context)
	{
		final var stack = context.stack();
		final var format = context.getSurfaceManager().getColorDomain().getFormat();

		final var configuration = context.getConfiguration().getFramebufferConfiguration();
		final var renderPassInfo = context.getGraphicProcess().getRenderPassInfo();
		final var attachments = renderPassInfo.getExtraAttachments();
		fillClearInfos(attachments, configuration);

		final var renderPassAllocator = new VkRenderPassAllocator(context.getVkDevice(), format);
		renderPass = renderPassAllocator.allocate(stack, info);
	}

	@Override
	public void free(IGraphicContext context)
	{
		vkDestroyRenderPass(context.getVkDevice(), renderPass, null);
		renderPass = 0;
	}

	private void fillClearInfos(List<ExtraAttachment> attachments,
								FramebufferConfiguration configuration)
	{
		clearInfos = new ArrayList<>();
		clearInfos.add(new ClearInfo(false, configuration.getClearValue()));

		for (final var attachment : attachments)
		{
			final var adapter = attachment.adaptNotNull(IExtraAttachmentAdapter.class);
			clearInfos.add(adapter.getClearInfos());
		}

		clearInfos = List.copyOf(clearInfos);
	}

	@Override
	public long getPtr()
	{
		return renderPass;
	}

	@Override
	public List<ClearInfo> getClearInfos()
	{
		return clearInfos;
	}
}
