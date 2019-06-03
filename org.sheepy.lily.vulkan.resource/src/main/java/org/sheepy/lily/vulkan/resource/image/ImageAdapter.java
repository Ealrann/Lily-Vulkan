package org.sheepy.lily.vulkan.resource.image;

import static org.lwjgl.vulkan.VK10.VK_IMAGE_ASPECT_COLOR_BIT;

import java.util.Collections;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.vulkan.api.resource.IDescriptedResourceAdapter;
import org.sheepy.lily.vulkan.api.resource.IResourceAdapter;
import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.lily.vulkan.model.resource.ImageLayout;
import org.sheepy.vulkan.descriptor.IVkDescriptor;
import org.sheepy.vulkan.descriptor.VkImageDescriptor;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.resource.image.VkImage;
import org.sheepy.vulkan.resource.image.VkImageView;
import org.sheepy.vulkan.util.VkModelUtil;

@Statefull
@Adapter(scope = Image.class)
public class ImageAdapter implements IDescriptedResourceAdapter, IResourceAdapter
{
	private VkImage imageBackend;
	private final Image image;
	private VkImageView imageView;

	private IImageLoader loader = null;
	private IExecutionContext executionContext;

	private List<IVkDescriptor> descriptors = null;

	public ImageAdapter(Image image)
	{
		this.image = image;
	}

	public void setLoader(IImageLoader loader)
	{
		this.loader = loader;
	}

	@Override
	public void allocate(MemoryStack stack, IExecutionContext context)
	{
		this.executionContext = context;
		final var logicalDevice = executionContext.getLogicalDevice();
		final var builder = createBuilder(image);

		imageBackend = builder.build();
		imageBackend.allocate(stack, context);

		if (image.getInitialLayout() != null)
		{
			initialTransition(stack);
		}

		imageView = new VkImageView(logicalDevice.getVkDevice());
		imageView.allocate(imageBackend.getAddress(), 1, imageBackend.format,
				VK_IMAGE_ASPECT_COLOR_BIT);

		load();
	}

	private void initialTransition(MemoryStack stack)
	{
		executionContext.execute(stack, (stack2, commandBuffer) -> {
			final ImageLayout initialLayout = image.getInitialLayout();
			imageBackend.transitionImageLayout(stack2, commandBuffer,
					EPipelineStage.BOTTOM_OF_PIPE_BIT, initialLayout.getStage(),
					EImageLayout.UNDEFINED, initialLayout.getLayout(), Collections.emptyList(),
					initialLayout.getAccessMask());
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
			final long viewPtr = getViewAddress();

			final var vkImageDescriptor = new VkImageDescriptor(viewPtr, 0, layout, type, stages);
			descriptors = List.of(vkImageDescriptor);
		}

		return descriptors;
	}

	public long getAddress()
	{
		return imageBackend.getAddress();
	}

	public long getMemoryAddress()
	{
		return imageBackend.getMemoryAddress();
	}

	public long getViewAddress()
	{
		return imageView.getAddress();
	}

	public static interface IImageLoader
	{
		void load(IExecutionContext executionManager, VkImage backendBuffer);
	}

	public static ImageAdapter adapt(Image image)
	{
		return IAdapterFactoryService.INSTANCE.adapt(image, ImageAdapter.class);
	}

	private static VkImage.Builder createBuilder(Image image)
	{
		final int usages = VkModelUtil.getEnumeratedFlag(image.getUsages());
		final int format = image.getFormat().getValue();
		final int mipLevels = image.getMipLevels();
		final int height = image.getHeight();
		final int tiling = image.getTiling();
		final int width = image.getWidth();
		final int properties = image.getProperties();
		final boolean fillWithZero = image.isFillWithZero();

		final var res = VkImage.newBuilder(width, height, format);
		res.usage(usages);
		res.properties(properties);
		res.mipLevels(mipLevels);
		res.tiling(tiling);
		res.fillWithZero(fillWithZero);

		return res;
	}
}
