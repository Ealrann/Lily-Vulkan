package org.sheepy.lily.vulkan.process.graphic.renderpass;

import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.allocation.IAllocable;
import org.sheepy.lily.core.api.allocation.IAllocationConfigurator;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.AllocationChildrenRegistry;
import org.sheepy.lily.vulkan.core.graphic.ClearInfo;
import org.sheepy.lily.vulkan.core.graphic.IRenderPass;
import org.sheepy.lily.vulkan.core.resource.attachment.IExtraAttachmentAdapter;
import org.sheepy.lily.vulkan.model.process.graphic.*;
import org.sheepy.lily.vulkan.process.graphic.process.GraphicContext;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.vulkan.VK10.vkDestroyRenderPass;

public class RenderPass implements IRenderPass, IAllocable<GraphicContext>
{
	private final AllocationChildrenRegistry attachmentsRegistry = new AllocationChildrenRegistry(List.of(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES,
																										  GraphicPackage.Literals.SUBPASS__ATTACHMANT_REF_PKG,
																										  GraphicPackage.Literals.ATTACHMENT_REF_PKG__ATTACHMENT_REFS,
																										  GraphicPackage.Literals.ATTACHMENT_REF__ATTACHMENT),
																								  true);

	private final GraphicProcess process;
	private final List<ExtraAttachment> extraAttachments = new ArrayList<>();
	private final IObservatory observatory;
	private long renderPass = 0;
	private List<ClearInfo> clearInfos = null;
	private boolean listeningAttachments = false;

	public RenderPass(GraphicProcess process)
	{
		this.process = process;

		final var observatory = IObservatoryBuilder.newObservatoryBuilder(process);
		observatory.explore(GraphicPackage.Literals.GRAPHIC_PROCESS__SUBPASSES)
				   .explore(GraphicPackage.Literals.SUBPASS__ATTACHMANT_REF_PKG)
				   .explore(GraphicPackage.Literals.ATTACHMENT_REF_PKG__ATTACHMENT_REFS)
				   .explore(GraphicPackage.Literals.ATTACHMENT_REF__ATTACHMENT, Attachment.class)
				   .gather(this::addAttachment, this::removeAttachment);
		this.observatory = observatory.build();
	}

	private void addAttachment(Attachment attachment)
	{
		if (attachment instanceof ExtraAttachment)
		{
			final var extraAttachment = (ExtraAttachment) attachment;
			if (extraAttachments.contains(extraAttachment) == false)
			{
				extraAttachments.add(extraAttachment);
			}
		}
	}

	private void removeAttachment(Attachment attachment)
	{
		if (attachment instanceof ExtraAttachment)
		{
			final var extraAttachment = (ExtraAttachment) attachment;
			extraAttachments.remove(extraAttachment);
		}
	}

	@Override
	public void configureAllocation(IAllocationConfigurator config, GraphicContext context)
	{
		final var swapChainManager = context.getSwapChainManager();
		config.addDependencies(List.of(swapChainManager));

		if (listeningAttachments == true)
		{
			attachmentsRegistry.stopRegister(process);
		}
		attachmentsRegistry.startRegister(process, config);
		listeningAttachments = true;
	}

	@Dispose
	private void dispose()
	{
		if (listeningAttachments == true)
		{
			attachmentsRegistry.stopRegister(process);
			listeningAttachments = false;
		}
	}

	@Override
	public void allocate(GraphicContext context)
	{
		observatory.observe(process);

		final var stack = context.stack();
		final var format = context.getSurfaceManager().getColorDomain().getFormat();

		final var configuration = context.getConfiguration().getFramebufferConfiguration();
		fillClearInfos(extraAttachments, configuration);

		final var renderPassAllocator = new VkRenderPassAllocator(extraAttachments, context.getVkDevice(), format);
		renderPass = renderPassAllocator.allocate(stack, process);
	}

	@Override
	public void free(GraphicContext context)
	{
		vkDestroyRenderPass(context.getVkDevice(), renderPass, null);
		renderPass = 0;
		observatory.shut(process);
	}

	private void fillClearInfos(List<ExtraAttachment> attachments, FramebufferConfiguration configuration)
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

	public List<ExtraAttachment> getUsedExtraAttachments()
	{
		return extraAttachments;
	}
}
