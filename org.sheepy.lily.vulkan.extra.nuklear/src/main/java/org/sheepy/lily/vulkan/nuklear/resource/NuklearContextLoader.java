package org.sheepy.lily.vulkan.nuklear.resource;

import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.ui.UI;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.resource.VulkanResourceFactory;
import org.sheepy.lily.vulkan.nuklear.ui.IImageWidgetAdapter;

import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = NuklearContext.class)
@Adapter(singleton = true, lazy = false)
public final class NuklearContextLoader implements IAdapter
{
	@Load
	private static void updateImageDescriptorArray(final NuklearContext nuklearContext)
	{
		final var subpass = ModelUtil.findParent(nuklearContext, Subpass.class);
		final var ui = (UI) subpass.getCompositor();
		final var imageDescriptor = nuklearContext.getImageArrayDescriptor();
		final var pipeline = ModelUtil.findParent(nuklearContext, GraphicsPipeline.class);
		if (imageDescriptor != null)
		{
			imageDescriptor.getImages().clear();
			if (ui.getCurrentUIPage() != null)
			{
				final List<IImage> images = new ArrayList<>();
				for (var panel : ui.getCurrentUIPage().getPanels())
				{
					final var adapter = panel.adapt(IImageWidgetAdapter.class);
					if (adapter != null)
					{
						images.addAll(adapter.getImages());
					}
				}

				imageDescriptor.getImages().addAll(images);

				final int imageCount = images.size();

				final var specializationBuffer = BufferUtils.createByteBuffer(4);
				specializationBuffer.putInt(imageCount);
				specializationBuffer.flip();

				final var constantBuffer = VulkanResourceFactory.eINSTANCE.createConstantBuffer();
				constantBuffer.setData(specializationBuffer);

				pipeline.getResourcePkg().getResources().add(constantBuffer);
				pipeline.setSpecializationData(constantBuffer);
			}
		}
	}
}
