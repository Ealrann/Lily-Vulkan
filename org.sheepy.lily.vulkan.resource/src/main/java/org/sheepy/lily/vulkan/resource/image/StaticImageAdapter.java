package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.model.resource.StaticImage;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImageDescriptor;
import org.sheepy.vulkan.resource.image.VkImageView;

@Statefull
@Adapter(scope = StaticImage.class)
public class StaticImageAdapter implements IImageAdapter
{
	private final StaticImage image;

	private VkImage imageBackend;
	private VkImageView imageView;

	private IImageLoader loader = null;
	private IExecutionContext executionContext;

	private List<IVkDescriptor> descriptors = null;

	public StaticImageAdapter(StaticImage image)
	{
		this.image = image;
	}

	public void setLoader(IImageLoader loader)
	{
		this.loader = loader;
	}

	@Override
	public void allocate(IExecutionContext context)
	{
		this.executionContext = context;
		final var logicalDevice = executionContext.getLogicalDevice();
		final var builder = new VkImage.VkImageBuilder(image);
		builder.fillWith(image.getFillWith());

		imageBackend = builder.build();
		imageBackend.allocate(context);

		if (image.getInitialLayout() != null)
		{
			initialTransition();
		}

		imageView = new VkImageView(logicalDevice.getVkDevice());
		imageView.allocate(imageBackend.getPtr(), 1, imageBackend.format,
				VK_IMAGE_ASPECT_COLOR_BIT);

		load();
	}

	private void initialTransition()
	{
		executionContext.execute((context2, commandBuffer) ->
		{
			final var initialLayout = image.getInitialLayout();
			final var stage = initialLayout.getStage();
			final var trgAccess = new ArrayList<>(initialLayout.getAccessMask());
			if (trgAccess.isEmpty())
			{
				trgAccess.add(EAccess.SHADER_READ_BIT);
			}
			imageBackend.transitionImageLayout(context2.stack(), commandBuffer,
					EPipelineStage.BOTTOM_OF_PIPE_BIT, stage, EImageLayout.UNDEFINED,
					initialLayout.getLayout(), Collections.emptyList(), trgAccess);
		});
	}

	public void load()
	{
		if (loader != null)
		{
			loader.load(executionContext, imageBackend);
		}
	}

	@Override
	public void free(IExecutionContext context)
	{
		imageView.free();
		imageView = null;

		imageBackend.free(context);
		imageBackend = null;
	}

	@Override
	public List<IVkDescriptor> getDescriptors()
	{
		if (descriptors == null)
		{
			final var descriptor = image.getDescriptor();
			final var type = descriptor.getDescriptorType();
			final var stages = descriptor.getShaderStages();
			final var layout = EImageLayout.GENERAL;
			final long viewPtr = getViewPtr();

			final var vkImageDescriptor = new VkImageDescriptor(viewPtr, 0, layout, type, stages);
			descriptors = List.of(vkImageDescriptor);
		}

		return descriptors;
	}

	@Override
	public long getImagePtr()
	{
		return imageBackend.getPtr();
	}

	@Override
	public long getMemoryPtr()
	{
		return imageBackend.getMemoryPtr();
	}

	@Override
	public long getViewPtr()
	{
		return imageView.getPtr();
	}

	@Override
	public VkImage getVkImage()
	{
		return imageBackend;
	}

	public static interface IImageLoader
	{
		void load(IExecutionContext executionManager, VkImage backendBuffer);
	}

	public static StaticImageAdapter adapt(StaticImage image)
	{
		return IAdapterFactoryService.INSTANCE.adapt(image, StaticImageAdapter.class);
	}
}
